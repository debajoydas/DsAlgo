/**
 * 
 */
package com.debajoy.algo.algorithm.dp.rev1;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author Debajoy
 *
 */
public class LongestCommonSubSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "ABCDGHE";
		String str2 = "AEDFHR";
		System.out.println(getLCS(str1, str2));	
	}

	private static int getLCS(String str1, String str2) {
		// TODO Auto-generated method stub
		int n1 = str1.length();
		int n2 = str2.length();
		int[][] dp = new int[n2+1][n1+1];
			for(int i = 1; i<= n2; i++){
				for(int j = 1; j<= n1; j++){
					if(str1.charAt(j-1) == str2.charAt(i-1)){
						dp[i][j] = 1 + dp[i-1][j-1];
					}else{
						dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
					}
				}
			}
			
			int row = n2;
			int col = n1;
			Stack<Character> stack = new Stack<Character>();
			while(row > 0 && col > 0){
				if(str1.charAt(col-1) == str2.charAt(row-1)){
					stack.push(str1.charAt(col-1));
					row--;col--;
				}else if(dp[row-1][col] > dp[row][col-1]){
					row--;
				}else{
					col--;
				}
			}
			while(!stack.isEmpty()){
				System.out.print(stack.pop()+"-");
			}
			System.out.println();
		return dp[n2][n1];
	}

}
