/**
 * 
 */
package com.debajoy.algo.algorithm.dp.practice;

/**
 * @author Debajoy
 *
 */
public class PaintFence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5; 
		int k = 3;
		System.out.println(getNoOfWayPaintFence(n,k));
	}

	public static int getNoOfWayPaintFence(int n, int k) {
		// TODO Auto-generated method stub
		int[][] dp = new int[3][n+1];
		dp[0][1] = dp[1][1] = dp[2][1] = 1;
		dp[0][2] = k;
		dp[1][2] = k*(k-1);
		dp[2][2] = dp[0][2]+dp[1][2];
		for(int j = 3; j <= n; j++){
			dp[0][j] = dp[1][j-1];
			dp[1][j] = (k-1)*dp[2][j-1]; 
			dp[2][j] =  dp[0][j]+dp[1][j];
		}
		return dp[2][n];
	}

}
