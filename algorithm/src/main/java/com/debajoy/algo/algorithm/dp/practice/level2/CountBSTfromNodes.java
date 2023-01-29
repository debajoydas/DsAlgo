/**
 * 
 */
package com.debajoy.algo.algorithm.dp.practice.level2;

/**
 * @author Debajoy
 *
 */
public class CountBSTfromNodes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numberOFNodes = 5;
		System.out.println(getCountOfBSTs(numberOFNodes));
	}

	private static int getCountOfBSTs(int n) {
		// TODO Auto-generated method stub
		int[] dp = new int[n+1];
		dp[0] = 1; dp[1] = 1;
		
		for(int i = 2; i <= n ; i++){
			
			int l = 0; 
			int r = i-1;
			
			while(l <= (i-1)){
				dp[i] += dp[l]*dp[r];
				l++;r--;
			}
		}
		return dp[n];
	}

}
