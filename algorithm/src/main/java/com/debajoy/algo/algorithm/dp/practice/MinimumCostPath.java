/**
 * 
 */
package com.debajoy.algo.algorithm.dp.practice;

/**
 * @author Debajoy
 *
 */
public class MinimumCostPath {

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
        System.out.println(minCostPath(arr,R,C)); 
        System.out.println(minCostPathAlt(arr,R,C)); 
	}

	private static int minCostPath(int[][] arr, int R, int C) {
		// TODO Auto-generated method stub
		int[][] dp = new int[R][C];
		for(int i = C-1; i >= 0; i--){
			if(i+1 < C){
				dp[R-1][i] = dp[R-1][i+1]+arr[R-1][i]; 
			}else{
				dp[R-1][i] = arr[R-1][i];
			}
		}
		for(int i = R-1; i >= 0; i--){
			if(i+1 < C){
				dp[i][C-1] = dp[i+1][C-1]+arr[i][C-1];
			}else{
				dp[i][C-1] = arr[i][C-1];
			}
		}
		for(int i = R-2; i >= 0; i--){
			for(int j = C-2; j >= 0; j--){
				dp[i][j] = Math.min(dp[i+1][j], dp[i][j+1]) + arr[i][j];
			}
		}
		return dp[0][0];
	}
	
	private static int minCostPathAlt(int[][] arr, int R, int C) {
		int[][] dp = new int[R][C];
		for(int i = 0; i< R; i++){
			for(int j = 0; j< C; j++){
				if(i == 0 && j == 0){
					dp[i][j] = arr[i][j];
				}else if(i == 0){
					dp[i][j] = dp[i][j-1]+arr[i][j];
				}else if(j == 0){
					dp[i][j] = dp[i-1][j]+arr[i][j];
				}else{
					dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + arr[i][j];
				}
			}
		}
		return dp[R-1][C-1];
	}

}
