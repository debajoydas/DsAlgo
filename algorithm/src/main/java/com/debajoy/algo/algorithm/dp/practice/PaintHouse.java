/**
 * 
 */
package com.debajoy.algo.algorithm.dp.practice;

/**
 * @author Debajoy
 *
 */
public class PaintHouse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = { {1,5,7},
						{5,8,4},
						{3,2,9},
						{1,2,4}
					  };
		int[][] arr1 = { {1,5,3,1},
						 {5,8,2,2},
						 {7,4,9,4}};
		System.out.println(minimumCostNotAdjacent(arr));
		System.out.println(minimumCostNotAdjacentDifferentInput(arr1));

	}
	
	private static int minimumCostNotAdjacent(int[][] arr){
		int[][] dp = new int[arr[0].length][arr.length];
		dp[0][0] = arr[0][0];
		dp[1][0] = arr[0][1];
		dp[2][0] = arr[0][2];
		
		for(int j = 1; j < arr.length; j++){
			for(int i = 0; i < arr[0].length; i++){
				if(i == 0){
					dp[i][j] = Math.min(dp[i+1][j-1], dp[i+2][j-1]) + arr[j][i];	
				}else if(i == 1){
					dp[i][j] = Math.min(dp[i-1][j-1], dp[i+1][j-1]) + arr[j][i];
				}else if(i == 2){
					dp[i][j] = Math.min(dp[i-1][j-1], dp[i-2][j-1]) + arr[j][i];
				}
			}
		}
		return Math.min(dp[0][arr.length-1], Math.min(dp[1][arr.length-1], dp[2][arr.length-1]));
	}

	private static int minimumCostNotAdjacentDifferentInput(int[][] arr){
		int[][] dp = new int[arr.length][arr[0].length];
		dp[0][0] = arr[0][0];
		dp[1][0] = arr[1][0];
		dp[2][0] = arr[2][0];
		for(int i = 1; i < arr[0].length; i++){
			dp[0][i] = arr[0][i]+Math.min(dp[1][i-1], dp[2][i-1]);
			dp[1][i] = arr[1][i]+Math.min(dp[0][i-1], dp[2][i-1]);
			dp[2][i] = arr[2][i]+Math.min(dp[1][i-1], dp[0][i-1]);
		}
		return Math.min(dp[0][dp[0].length-1], Math.min(dp[1][dp[0].length-1], dp[2][dp[0].length-1]));
	}
}
