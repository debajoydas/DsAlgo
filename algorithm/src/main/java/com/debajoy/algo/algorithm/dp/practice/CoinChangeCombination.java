/**
 * 
 */
package com.debajoy.algo.algorithm.dp.practice;

/**
 * @author Debajoy
 *
 */
public class CoinChangeCombination {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[] {4,2,7,1,3}; 
        int n = arr.length; 
        int target = 10;
        System.out.println(getTotdalCombination(arr, n, target));
	}

	private static int getTotdalCombination(int[] arr, int n, int target) {
		// TODO Auto-generated method stub
		int[] dp = new int[n+1];
		dp[0] = 1;
		for(int i = 0; i < arr.length; i++){
			for(int j = arr[i]; j < dp.length; j++){
				dp[j] += dp[j-arr[i]];
			}
		}
		return dp[n];
	}

}
