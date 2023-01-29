/**
 * 
 */
package com.debajoy.ds.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Debajoy
 *
 */
public class FindKPairWithSmallestSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {1,7,11};
		int[] nums2= {2,4,6};
		int k = 3;
		List<List<Integer>> out = kSmallestPairs(nums1, nums2, k);
		for(List<Integer> list : out){
			System.out.println(list.get(0)+" : "+list.get(1));	
		}
		System.out.println("----------------------");
		List<List<Integer>> out1 = kSmallestPairsOptimized(nums1, nums2, k);
		for(List<Integer> list : out1){
			System.out.println(list.get(0)+" : "+list.get(1));	
		}

	}
	
	public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<List<Integer>> output= new ArrayList<List<Integer>>();
		PriorityQueue<Pair> minHeap = new PriorityQueue<Pair>(new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				// TODO Auto-generated method stub
				return Integer.valueOf(o1.sum).compareTo(Integer.valueOf(o2.sum));
			}
		});
		for(int i = 0; i < nums1.length; i++){
			for(int j =0; j< nums2.length; j++){
				Pair pair= new Pair(nums1[i], nums2[j]);
				minHeap.add(pair);
			}
		}
		if(k > minHeap.size()){
			k = minHeap.size();
		}
		while(k > 0){
			Pair pair= minHeap.poll();
			List<Integer> listUV = new ArrayList<Integer>();
			listUV.add(pair.num1);
			listUV.add(pair.num2);
			output.add(listUV);
			k--;
		}
		return output;
    }
	
	public static List<List<Integer>> kSmallestPairsOptimized(int[] nums1, int[] nums2, int k) {
		
		List<List<Integer>> output= new ArrayList<List<Integer>>();
		
		if(nums1.length < 1 && nums2.length < 1){
			return output;
		}else if(nums1.length == 1 && nums2.length == 1){
			if(k <= 0){
				return output;
			}
			else{
				List<Integer> list = new ArrayList<Integer>();
				list.add(nums1[0]);
				list.add(nums2[0]);
				output.add(list);
				return output;
			}
		}else if(nums1.length == 2 && nums2.length == 1){
			List<Integer> list = new ArrayList<Integer>();
			list.add(nums1[0]);
			list.add(nums2[0]);
			output.add(list);
			List<Integer> list1 = new ArrayList<Integer>();
			list.add(nums1[1]);
			list.add(nums2[0]);
			output.add(list);
			return output;
		}else if(nums1.length == 1 && nums2.length == 2){
			List<Integer> list = new ArrayList<Integer>();
			list.add(nums1[0]);
			list.add(nums2[0]);
			output.add(list);
			List<Integer> list1 = new ArrayList<Integer>();
			list.add(nums1[0]);
			list.add(nums2[1]);
			output.add(list);
			return output;
		}else{
			List<Integer> listFirst = new ArrayList<Integer>();
			listFirst.add(nums1[0]);
			listFirst.add(nums2[0]);
			output.add(listFirst);
			k--;
			
			int num1Index = 0;
			int num2Index = 0;
			int num1Var = 1;
			int num2Var = 1;
			
			while(k > 0){
				if(num1Index == nums1.length && num2Index == nums2.length){
					break;
				}else if(num1Index < nums1.length && num2Index == nums2.length){
					while(num2Var < nums2.length){
						List<Integer> list = new ArrayList<Integer>();
						list.add(nums1[num1Index]);
						list.add(nums2[num2Var]);
						output.add(list);
						k--;
						num2Var++;
					}
					break;
				}else if(num1Index == nums1.length && num2Index < nums2.length){
					while(num1Var < nums1.length){
						k--;
						List<Integer> list = new ArrayList<Integer>();
						list.add(nums1[num1Var]);
						list.add(nums2[num2Index]);
						output.add(list);
						num1Var++;
					}
					break;
				}else{
					if((num1Index == num1Var) && (num2Index == num2Var)){
						num1Var += 1;
						if(num1Var == nums1.length){
							num1Var = 0;
							num2Index += 1;
						}
					}
					if(nums1[num1Index]+nums2[num2Var] <= nums2[num2Index]+nums1[num1Var]){
						List<Integer> list = new ArrayList<Integer>();
						list.add(nums1[num1Index]);
						list.add(nums2[num2Var]);
						output.add(list);
						num2Var++;
						if(num2Var == nums2.length){
							num2Var = 0;
							num1Index += 1;
						}
						k--;
					}else{
						List<Integer> list = new ArrayList<Integer>();
						list.add(nums1[num1Var]);
						list.add(nums2[num2Index]);
						output.add(list);
						num1Var++;
						if(num1Var == nums1.length){
							num1Var = 0;
							num2Index += 1;
						}
						k--;
					}
				}
				
			}
		}

		return output;
	}

}
 class Pair{
	 public Pair(int num1, int num2) {
		super();
		this.num1 = num1;
		this.num2 = num2;
		this.sum = this.num1+this.num2;
	}
	int num1;
	 int num2;
	 int sum;
 }