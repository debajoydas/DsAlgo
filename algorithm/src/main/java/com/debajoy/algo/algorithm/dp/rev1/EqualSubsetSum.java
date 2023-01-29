/**
 * 
 */
package com.debajoy.algo.algorithm.dp.rev1;

import java.util.Arrays;
import java.util.stream.IntStream;

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
		int[] num = {1, 10, 18, 3, 4};
		int n = num.length;
		System.out.println(findEqualSubsetSum(num, n));
	
	}

	private static boolean findEqualSubsetSum(int[] num, int n) {
		// TODO Auto-generated method stub
		if(num == null || (num != null && num.length < 1)){
			return false;
		}else{
			int sum = (IntStream.of(num).sum())/2;
			boolean[][] dp = new boolean[n][sum+1];
			for(int i = 0; i< n; i++){
				dp[i][0] = true;
			}
			for(int i = 1; i <= sum; i++){
				if(num[0] == sum){
					dp[0][i] = true;
				}
			}
			for(int i = 1; i < n; i++){
				for(int j = 1; j<= sum ; j++){
					if(dp[i-1][j]){
						dp[i][j] = true;
					}else if(sum >= num[i]){
						dp[i][j] = dp[i-1][sum - num[i]];
					}
				}
			}
			return dp[n-1][sum];
		}
	}

}
