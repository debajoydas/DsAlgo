/**
 * 
 */
package com.debajoy.algo.algorithm.dp;

/**
 * @author Debajoy
 *
 */
public class NumberFactors {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 System.out.println(getCountWays(4));
		 System.out.println(getCountWays(5));
		 System.out.println(getCountWays(6));
	}

	private static int getCountWays(int n) {
		// TODO Auto-generated method stub
		int[] dp = new int[n+1];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 2;
		for(int i = 4; i <= n; i++){
			dp[i] = dp[i-1] + dp[i-3] +dp[i-4];
		}
		return dp[n];
	}

}
