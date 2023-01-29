/**
 * 
 */
package com.debajoy.algo.algorithm.dp;

/**
 * @author Debajoy
 *
 */
public class ShortestCommonSuperSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findSCSLength("abcf", "bdcf"));
	    System.out.println(findSCSLength("dynamic", "programming"));
	}

	private static int findSCSLength(String s1, String s2) {
		// TODO Auto-generated method stub
		int row = s1.length()+1;
		int col = s2.length()+1;
		int dp[][] = new int[row][col];
		for(int i = 0; i< col; i++){
			dp[0][i] = i;
		}
		for(int i = 0; i< row; i++){
			dp[i][0] = i;
		}
		for(int i = 1; i< row; i++){
			for(int j = 1; j< col; j++){
				if(s1.charAt(i-1) == s2.charAt(j-1)){
					dp[i][j] = 1 + dp[i-1][j-1];
				}else{
					dp[i][j] = Math.min(1+dp[i-1][j],1+dp[i][j-1]);
				}
			}
		}
		return dp[row-1][col-1];
	}

}
