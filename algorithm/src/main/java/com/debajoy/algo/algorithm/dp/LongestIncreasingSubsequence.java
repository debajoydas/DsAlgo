/**
 * 
 */
package com.debajoy.algo.algorithm.dp;

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
		
		int arr1[] = {10, 22, 9, 33, 21, 50, 41, 60, 80};
		int n1 = arr1.length;
		System.out.println(findLIS(arr1,n1));
	}

	private static int findLIS(int[] arr, int n) {
		// TODO Auto-generated method stub
		if(arr == null){
			return 0;
		}
		int[] LIS = new int[n];
		LIS[0] = 1;
		for(int i=1; i< n; i++){
			LIS[i] = 1;
			for(int j = 0; j< i; j++){
				if(arr[j] <= arr[i] && LIS[i] < 1+ LIS[j]){
					LIS[i] = 1+LIS[j];
				}
			}
		}
		return LIS[n-1];
	}

}
