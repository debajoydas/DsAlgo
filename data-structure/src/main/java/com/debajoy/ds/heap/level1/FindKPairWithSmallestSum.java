/**
 * 
 */
package com.debajoy.ds.heap.level1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
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
		int[] nums1 = {1,1,2};
		int[] nums2= {1,2,3};
		int k = 2;
		List<List<Integer>> out = kSmallestPairs(nums1, nums2, k);
		for(List<Integer> list : out){
			System.out.println(list.get(0)+" : "+list.get(1));	
		}
	}
	
	public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<List<Integer>> output= new ArrayList<List<Integer>>();
		ArrPointer[] num1Arr = new ArrPointer[nums1.length];
		ArrPointer[] num2Arr = new ArrPointer[nums2.length];
		for(int i = 0; i < nums1.length; i++){
			num1Arr[i] = new ArrPointer(nums1[i], 0);
		}
		for(int i = 0; i < nums2.length; i++){
			num2Arr[i] = new ArrPointer(nums2[i], 0);
		}
		int pointer1 = 0; 
		int pointer2 = 0;
		HashMap<String,Boolean> map = new HashMap<>();
		while(k > 0){
			if(num1Arr[pointer1].data + num2Arr[num1Arr[pointer1].next].data <= num2Arr[pointer2].data+num1Arr[num2Arr[pointer2].next].data){
				List<Integer> list = new ArrayList<Integer>();
				if(map.get(String.valueOf(pointer1)+String.valueOf(num1Arr[pointer1].next)) == null){
					list.add(num1Arr[pointer1].data);
					list.add(num2Arr[num1Arr[pointer1].next].data);
					output.add(list);
					k--;
					map.put(String.valueOf(pointer1)+String.valueOf(num1Arr[pointer1].next), true);
				}
				if(num1Arr[pointer1].next >= (num2Arr.length-1)){
					pointer1 += 1;
				}else{
					num1Arr[pointer1].next += 1;
				}
			}else{
				List<Integer> list = new ArrayList<Integer>();
				if(map.get(String.valueOf(num2Arr[pointer2].next)+String.valueOf(pointer2)) == null){
					list.add(num2Arr[pointer2].data);
					list.add(num1Arr[num2Arr[pointer2].next].data);
					output.add(list);
					k--;
					map.put(String.valueOf(num2Arr[pointer2].next)+String.valueOf(pointer2),true);
				}
				if(num2Arr[pointer2].next >= (num1Arr.length-1)){
					pointer2 += 1;
				}else{
					num2Arr[pointer2].next += 1;
				}			
			}
		}	
		return output;
    }
}
 class ArrPointer{
	int data;
	int next;
	public ArrPointer(int data, int next) {
		super();
		this.data = data;
		this.next = next;
	}
 }