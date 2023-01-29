/**
 * 
 */
package com.debajoy.algo.algorithm.dp;

/**
 * @author Debajoy
 *
 */
public class MaxJumpWithFee {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] fee = {1,2,5,2,1,2};
	    System.out.println(findMinFee(fee));
	    fee = new int[]{2,3,4,5};
	    System.out.println(findMinFee(fee));
	}

	private static int findMinFee(int[] fee) {
		// TODO Auto-generated method stub
		int[] dp = new int[fee.length];
		dp[0] = 0;
		dp[1] = fee[0];
		dp[2] = fee[0];
		for(int i = 3; i< fee.length; i++){
				dp[i] = Math.min(dp[i-1]+fee[i-1],dp[i-2]+fee[i-2]);
				dp[i] = Math.min(dp[i],dp[i-3]+fee[i-3]);
		}
		return dp[fee.length-1];
	}

}
