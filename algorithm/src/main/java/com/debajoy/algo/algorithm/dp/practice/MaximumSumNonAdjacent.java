/**
 * 
 */
package com.debajoy.algo.algorithm.dp.practice;

/**
 * @author Debajoy
 *
 */
public class MaximumSumNonAdjacent {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {5,10,10,100,5,6};
		int n = arr.length;
		System.out.println(getMaxSumNonAdjacent(arr, n));
	}

	private static int getMaxSumNonAdjacent(int[] arr, int n){
		int[][] dp = new int[2][n];
		dp[0][0] = arr[0]; dp[1][0] = 0;
		for(int i = 1; i < n; i++){
			dp[0][i] = dp[1][i-1]+arr[i];
			dp[1][i] = Math.max(dp[0][i-1], dp[1][i-1]);
		}
		return Math.max(dp[0][n-1], dp[1][n-1]);
	}
}
