/**
 * 
 */
package com.debajoy.algo.algorithm.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Debajoy
 *
 */
public class LongestIncreasingSubsequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = {3, 10, 2, 1, 20};
		int n = arr.length;
		System.out.println(findLIS(arr,n));
		System.out.println(findLIS(arr,n).size());
		
		int arr1[] = {10, 22, 9, 33, 21, 50, 41, 60, 80};
		int n1 = arr1.length;
		System.out.println(findLIS(arr1,n1));
		System.out.println(findLIS(arr1,n1).size());
	}

	private static List<Integer> findLIS(int[] arr, int n) {
		// TODO Auto-generated method stub
		List<Integer> subListNew = new ArrayList<Integer>();
		for(int i=0; i< n; i++){
			List<Integer> subSets = new ArrayList<Integer>();
			findLISRec(i,arr,n,subSets);
			if(subListNew.size() > 0){
				if(subSets.size() > subListNew.size()){
					subListNew.clear();
					subListNew = new ArrayList<>(subSets);
				}
			}else{
				subListNew = new ArrayList<>(subSets);
			}					
		}
		return subListNew;
	}

	private static List<Integer> findLISRec(int i, int[] arr, int n, List<Integer> subSets) {
		// TODO Auto-generated method stub
		if(i > (n-1)){
			return subSets;
		}else{
			
			if(subSets.size() > 0){
				if(subSets.get(subSets.size()-1) <= arr[i]){
					subSets.add(arr[i]);
				}
			}else{
				subSets.add(arr[i]);
			}
			return findLISRec(i+1, arr, n, subSets);
		}	
	}

}
