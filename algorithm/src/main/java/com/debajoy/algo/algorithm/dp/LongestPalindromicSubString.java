/**
 * 
 */
package com.debajoy.algo.algorithm.dp;

/**
 * @author Debajoy
 *
 */
public class LongestPalindromicSubString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findLPSLength("abdbca"));
	    System.out.println(findLPSLength("cddpd"));
	    System.out.println(findLPSLength("pqr"));
		System.out.println(findLPSLength("babad"));
	}

	private static int findLPSLength(String str) {
		if(str == null || (str != null && str.equals(""))){
			return 0;
		}
		if(str != null && str.length()==1){
			return 1;
		}
		int[][]dp = new int[str.length()][str.length()];
		for(int i = 0; i< str.length(); i++){
				dp[i][i] = 1;
		}
		int maxLength  = 1;
		for(int i = str.length()-2; i >= 0; i--){
			for(int j = i+1; j < str.length(); j++){
				if(str.charAt(i) == str.charAt(j)){
					if((j-i) == 1 || dp[i+1][j-1] == 1){
						dp[i][j] = 1;
						maxLength = Math.max(maxLength, (j-i+1));
					}
				}
			}
		}
		return maxLength;
	}

	private static String findLongestPalindromicSubString(String str) {
		if(str == null || (str != null && str.equals(""))){
			return "";
		}
		if(str != null && str.length()==1){
			return str;
		}
		int[][]dp = new int[str.length()][str.length()];
		for(int i = 0; i< str.length(); i++){
				dp[i][i] = 1;
		}
		int maxLength  = 1;
		int left = 0; int right = 0;
		
		for(int i = str.length()-2; i >= 0; i--){
			for(int j = i+1; j < str.length(); j++){
				if(str.charAt(i) == str.charAt(j)){
					if((j-i) == 1 || dp[i+1][j-1] == 1){
						dp[i][j] = 1;
						if(maxLength < (j-i+1)){
							maxLength = (j-i+1);
							left = i;
							right = j;		
						}					
					}
				}
			}
		}
		return str.substring(left,right+1);
	}
}
