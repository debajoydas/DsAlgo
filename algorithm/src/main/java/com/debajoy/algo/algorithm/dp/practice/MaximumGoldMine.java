/**
 * 
 */
package com.debajoy.algo.algorithm.dp.practice;

/**
 * @author Debajoy
 *
 */
public class MaximumGoldMine {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][] = { 
					{2, 8, 4, 1, 6, 4, 2}, 
                	{6, 0, 9, 5, 3, 8, 5}, 
                	{1, 4, 3, 4, 0, 6, 5}, 
                	{6, 4, 7, 2, 4, 6, 1},
                	{1, 0, 3, 7, 1, 2, 7},
                	{1, 5, 3, 2, 3, 0, 9},
                	{2, 2, 5, 1, 9, 8, 2}}; 
  
		int R = arr.length; int C = arr.length;  	
        System.out.println(maxGoldMine(arr,R,C)); 
        System.out.println(maxGoldMineRevision1(arr,R,C)); 
	}

	private static int maxGoldMine(int[][] arr, int R, int C) {
		// TODO Auto-generated method stub
		int[][] dp = new int[R][C];
		int max = Integer.MIN_VALUE;
		for(int i = R-1; i >= 0; i--){
			dp[i][C-1] = arr[i][C-1];
		}
		for(int j = C-1; j >= 0; j--){
			for(int i = R-1; i >= 0; i--){
				if(j == C-1){
					dp[i][j] = arr[i][j];
				}else if(i == R-1){
					dp[i][j] = Math.max(dp[i][j+1],dp[i-1][j+1]) + arr[i][j];
				}else if(i == 0){
					dp[i][j] = Math.max(dp[i][j+1],dp[i+1][j+1]) + arr[i][j];
				}else{
					dp[i][j] = Math.max(dp[i][j+1], Math.max(dp[i+1][j+1], dp[i-1][j+1])) + arr[i][j];
				}
			}
		}
		for(int i = 0; i < R; i++){
			max = Math.max(max, dp[i][0]);
		}
		return max;
	}

	private static int maxGoldMineRevision1(int[][] arr, int R, int C) {
		// TODO Auto-generated method stub
		int[][] dp = new int[R][C];
		int max = Integer.MIN_VALUE;
		for(int i = R-1; i >= 0; i--){
			dp[i][C-1] = arr[i][C-1];
		}
		for(int j = C-2; j >= 0; j--){
			for(int i = R-1; i >= 0; i--){
				if(i == R-1){
					dp[i][j] = Math.max(dp[i][j+1],dp[i-1][j+1]) + arr[i][j];
				}else if(i == 0){
					dp[i][j] = Math.max(dp[i][j+1],dp[i+1][j+1]) + arr[i][j];
				}else{
					dp[i][j] = Math.max(dp[i][j+1], Math.max(dp[i+1][j+1], dp[i-1][j+1])) + arr[i][j];
				}
				if(j == 0){
					max = Math.max(max, dp[i][j]);
				}
			}
		}
		return max;
	}
}
