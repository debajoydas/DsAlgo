/**
 * 
 */
package com.debajoy.algo.algorithm.dp.practice.level2;

/**
 * @author Debajoy
 *
 */
public class LargestSquareSubMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = {
						{0,1,0,1,0,1},
						{1,0,1,0,1,0},
						{0,1,1,1,1,0},
						{0,0,1,1,1,0},
						{1,1,1,1,1,1},
					  };
		int[][] arr1 = {
				{0,1,0,1,0,1},
				{1,1,1,1,1,0},
				{0,1,1,1,1,0},
				{0,1,1,1,1,0},
				{1,1,1,1,1,1},
			  };
		System.out.println(getLargestSquareSubMatrixSide(arr1));

	}
	
	private static int getLargestSquareSubMatrixSide(int[][] arr){
		int n = arr.length;
		int m = arr[0].length;
		int[][] dp = new int[n][m];
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i< n; i++){
			for(int j = 0; j< m; j++){
				if(i == 0 || j == 0){
					dp[i][j] = arr[i][j];
				}else if(i != 0 && j != 0){
					if(arr[i][j] == 1 && arr[i-1][j] == 1 && arr[i-1][j-1] == 1 && arr[i][j-1] == 1){
						dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1])); 
						max = Math.max(max, dp[i][j]);
					}else if(arr[i][j] == 1){
						dp[i][j] = 1;
					}
				}
			}
		}
		return max;
	}

}
