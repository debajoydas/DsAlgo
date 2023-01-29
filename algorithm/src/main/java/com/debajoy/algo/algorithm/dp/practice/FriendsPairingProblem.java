/**
 * 
 */
package com.debajoy.algo.algorithm.dp.practice;

/**
 * @author Debajoy
 *
 */
public class FriendsPairingProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		System.out.println(getNoOfWaysFriendsPairing(n));
	}

	private static int getNoOfWaysFriendsPairing(int n) {
		// TODO Auto-generated method stub
		int[] dp = new int[n+1];
		dp[1] = 1; dp[2] = 2;
		for(int i = 3; i<= n; i++){
			dp[i] = dp[i-1] + (i-1)*dp[i-2];
		}
		return dp[n];
	}

}
