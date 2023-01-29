/**
 * 
 */
package com.debajoy.algo.algorithm.dp.practice;

/**
 * @author Debajoy
 *
 */
public class PathWithMaxGold {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][] = { 
					{0,1,4,2,8,2}, 
                	{4,3,6,5,0,4}, 
                	{1,2,4,1,4,6}, 
                	{2,0,7,3,2,2},
                	{3,1,5,9,2,4},
                	{3,7,0,8,5,1}
                	}; 
  
		int R = arr.length; int C = arr[0].length;  	
		System.out.println("Maximum Gold Min is := "+getMaxGoldMine(arr,R,C));
	}

	private static int getMaxGoldMine(int[][] arr, int r, int c) {
		// TODO Auto-generated method stub
		int[][] dp = new int[r][c];
		for(int j = c-1; j >= 0; j--){
			for(int i = 0 ; i < r; i++){
				if(j == c-1){
					dp[i][j] = arr[i][j];
				}else if(i == 0){
					dp[i][j] = arr[i][j] + Math.max(dp[i][j+1], dp[i+1][j+1]);
				}else if(i == r-1){
					dp[i][j] = arr[i][j] + Math.max(dp[i][j+1], dp[i-1][j+1]);
				}else{
					dp[i][j] = arr[i][j] + Math.max(dp[i][j+1], Math.max(dp[i+1][j+1], dp[i-1][j+1]));
				}
			}
		}
		int max = 0;
		for(int i = 0; i < r; i++){
			max = Math.max(dp[i][0], max);
		}
		printAllPath(arr, 0, 0, dp, max, "");
		return max;
	}
	
	private static void printAllPath(int[][] arr, int r, int c, int[][] dp, int max, String path){
		if(c >= arr.length){
			System.out.println("Path is :=> "+path);
			return;
		}
		for(int i = 0; i < arr.length; i++){
			if((dp[i][c] == max && r-1 <= i && i <= r+1 && c != 0) || (dp[i][c] == max && c == 0)){
				printAllPath(arr, i, c+1, dp, max-arr[i][c], path+"row("+i+")col("+c+")"+"->");
			}
		}
	}

}
