/**
 * 
 */
package com.debajoy.algo.algorithm.dp;

import java.util.Arrays;

/**
 * @author Debajoy
 *
 */
public class EqualSubsetSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1, 10, 29, 3, 4};
		int n = num.length;
		System.out.println(findEqualSubsetSum(num, n));
	}

	private static boolean findEqualSubsetSum(int[] num, int n) {
		// TODO Auto-generated method stub
		
		if(num == null){
			return false;
		}
		int subSetSum =  (Arrays.stream(num).sum())/2;
		boolean[][] dp = new boolean[n][subSetSum+1];
		
		for(int i = 0;  i<n; i++){
			dp[i][0] = true;
		}
		
		for(int i = 0; i <= subSetSum; i++){
			if(i == num[0] || i == 0){
				dp[0][i] = true;
			}else{
				dp[0][i] = false;
			}
		}
		
		for(int i = 1; i< n; i++){
			for(int s = 1; s<= subSetSum; s++){
				if(num[i] > s){
					dp[i][s] = dp[i-1][s];
				}else if(num[i] == s){
					dp[i][s] = true;
				}else if(num[i] < s){
					dp[i][s] = dp[i-1][s-num[i]];
				}
			}
		}
		return dp[n-1][subSetSum];
	}

}
