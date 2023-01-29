/**
 * 
 */
package com.debajoy.algo.algorithm.dp;

/**
 * @author Debajoy
 *
 */
public class StairCase {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    System.out.println(countWays(3));
	    System.out.println(countWays(4));
	    System.out.println(countWays(5));

	}

	private static int countWays(int n) {
		// TODO Auto-generated method stub
		int[] dp = new int[n+1];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		for(int i = 3; i<= n; i++){
			dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
		}
		return dp[n];
	}

}
