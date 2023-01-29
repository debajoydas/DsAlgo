/**
 * 
 */
package com.debajoy.algo.algorithm.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Debajoy
 *
 */
public class MinInsertionDeletionReq {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    findMDI("abc", "fbc");
	    findMDI("abdca", "cbda");
	    findMDI("passport", "ppsspt");
	}

	private static void findMDI(String s1, String s2) {
		// TODO Auto-generated method stub
		if((s1 == null || s1.equalsIgnoreCase("")) && (s2 == null || s2.equalsIgnoreCase(""))){
			System.out.println("Minimum Insertion : " +"0" + " & Deletion : "+"0");
		}else if((s1 == null || s1.equalsIgnoreCase("")) && s2 != null && s2.length() > 0){
			System.out.println("Minimum Insertion : " +s2.length() + " & Deletion : "+"0");
		}else if((s2 == null || s2.equalsIgnoreCase("")) && s1 != null && s1.length() > 0){
			System.out.println("Minimum Insertion : " +"0" + " & Deletion : "+s1.length());
		}
		int lcs = findLCSLength(s1,s2);
		System.out.println("Minimum Insertion : " +(s2.length()-lcs) + " & Deletion : "+(s1.length()-lcs));
	}

	private static int findLCSLength(String str1, String str2) {

		int[][] dp = new int[str2.length()+1][str1.length()+1];
		for(int i = 0; i <= str1.length(); i++){
			dp[0][i] = 0;
		}
		for(int i = 0; i <= str2.length(); i++){
			dp[i][0] = 0;
		}
		for(int i=1; i <= str2.length(); i++){
			for(int j = 1; j <= str1.length(); j++){
				if(str1.charAt(j-1) == str2.charAt(i-1)){
					dp[i][j] = 1+dp[i-1][j-1];
				}else{
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
				}
			}
		}
		int startCol = 0;
		int startRow = 0;
		List<Character> list = new ArrayList<Character>();
		for(int i = startCol;i < str1.length(); i++){
			for(int j = startRow; j<= str2.length(); j++){
				if(dp[j][i+1] - dp[j][i] == 1){
					startCol = i+1;
					startRow = j;
					list.add(str2.charAt(j-1));
					break;
				}
			}
		}
		return dp[str2.length()][str1.length()];
	
	}

}
