/**
 * 
 */
package com.debajoy.algo.algorithm.dp.practice;

/**
 * @author Debajoy
 *
 */
public class CoinChangePermutation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[] {2,3,5,6}; 
        int n = arr.length; 
        int target = 10;
        System.out.println(getTotdalPermutations(arr, n, target));
	}

	private static int getTotdalPermutations(int[] arr, int n, int target) {
		// TODO Auto-generated method stub
		int[] dp = new int[target+1];
		dp[0] = 1;
		for(int i = 0; i < dp.length; i++){
			for(int j = 0; j < arr.length; j++){
				if(i >= arr[j]){
					dp[i] += dp[i-arr[j]];
				}
			}
		}
		return dp[target];
	}

}
