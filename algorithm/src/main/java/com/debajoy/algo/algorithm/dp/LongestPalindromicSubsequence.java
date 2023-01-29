/**
 * 
 */
package com.debajoy.algo.algorithm.dp;

/**
 * @author Debajoy
 *
 */
public class LongestPalindromicSubsequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		String input = "abdbca";
		System.out.println(getLongestPalindromicSubSequence(input));

	}

	private static int getLongestPalindromicSubSequence(String input) {
		// TODO Auto-generated method stub
		if(input == null){
			return 0;
		}
		int n = input.length();
		int[][] dp = new int[n][n];
		for(int i = 0 ; i < n; i++){
			for(int j = 0; j< n; j++){
				if(i != j){
					dp[i][j] = 0;
				}else{
					dp[i][j] = 1;
				}
			}	
		}
		for(int startIndex = (n-2); startIndex >= 0 ; startIndex--){
			for(int endIndex= startIndex+1; endIndex < n; endIndex++){
				if(input.charAt(startIndex) == input.charAt(endIndex)){
					dp[startIndex][endIndex] = 2+dp[startIndex+1][endIndex-1];
				}else{
					dp[startIndex][endIndex] = Math.max(dp[startIndex+1][endIndex],dp[startIndex][endIndex-1]);
				}
			}
		}
		return dp[0][n-1];
	}

}
