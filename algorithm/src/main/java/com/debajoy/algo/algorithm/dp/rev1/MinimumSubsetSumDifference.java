/**
 * 
 */
package com.debajoy.algo.algorithm.dp.rev1;

import java.util.stream.IntStream;

/**
 * @author Debajoy
 *
 */
public class MinimumSubsetSumDifference {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumSubsetSumDifference ps = new MinimumSubsetSumDifference();
	    int[] num = {1, 2, 3, 9};
	    System.out.println(ps.canPartition(num));
	    num = new int[]{1, 2, 7, 1, 5};
	    System.out.println(ps.canPartition(num));
	    num = new int[]{1, 3, 100, 4};
	    System.out.println(ps.canPartition(num));
	}

	private int canPartition(int[] num) {
		// TODO Auto-generated method stub
		if(num == null || (num != null && num.length < 1)){
			return 0;
		}else{
			int n = num.length;
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
			
			for(int i = sum; i >= 0; i--){
				if(dp[n-1][i]){
					return i;
				}
			}
		}
		return 0;
	}

}
