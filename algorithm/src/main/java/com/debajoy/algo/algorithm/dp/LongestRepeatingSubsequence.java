/**
 * 
 */
package com.debajoy.algo.algorithm.dp;

/**
 * @author Debajoy
 *
 */
public class LongestRepeatingSubsequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findLRSLength("tomorrow"));
	    System.out.println(findLRSLength("aabdbcec"));
	    System.out.println(findLRSLength("fmff"));
	}

	private static int findLRSLength(String input) {
		// TODO Auto-generated method stub
		if(input == null || (input != null & input.equals(""))){
			return 0;
		} 
		int[][] dp = new int[input.length()+1][input.length()+1];
		for(int i = 1; i<= input.length(); i++){
			for(int j = 1; j<= input.length(); j++){
				if(i != j && input.charAt(i-1) == input.charAt(j-1)){
					dp[i][j] = 1 + dp[i-1][j-1];
				}else{
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		return dp[input.length()][input.length()];
	}

}
