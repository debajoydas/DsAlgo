/**
 * 
 */
package com.debajoy.algo.algorithm.dp.practice;

/**
 * @author Debajoy
 *
 */
public class TargetSumSubSet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[] {4,2,7,1,3}; 
        int n = arr.length; 
        int target = 10;
        System.out.println(targetSumSubset(arr, n, target));
        System.out.println(targetSumSubsetAlt(arr, n, target));
        System.out.println(targetSumSubsetRevision1(arr, n, target));
	}

	private static boolean targetSumSubset(int[] arr, int n, int target) {
		// TODO Auto-generated method stub
		boolean[][] dp = new boolean[n+1][target+1];
		for(int i = 0; i < dp.length; i++){
			for(int j = 0; j < dp[i].length; j++){
				if(i == 0 && j == 0){
					dp[i][j] = true;
				}else if(i == 0){
					dp[i][j] = false;
				}else if(j == 0){
					dp[i][j] = true;
				}else{
					if(dp[i-1][j]){
						dp[i][j] = true;
					}else{
						if(arr[i-1] <= j && dp[i-1][j-arr[i-1]]){
							dp[i][j] = true;
						}else{
							dp[i][j] = false;
						}
					}
				}
			}
		}
		print2D(dp);
		return dp[n][target];
	}
	
	private static boolean targetSumSubsetAlt(int[] arr, int n, int target) {
		boolean[][] dp = new boolean[n+1][target+1];
		for(int i = 0; i < dp.length; i++){
			for(int j = 0; j < dp[i].length; j++){
				if(j == 0){
					dp[i][j] = true;
				}else if(i == 0){
					dp[i][j] = false;
				}else if(i == 1){
					if(arr[i-1] == j){
						dp[i][j] = true;
					}else{
						dp[i][j] = false;
					}
				}else{
					if(j >= arr[i-1]){
						dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
					}else{
						dp[i][j] = dp[i-1][j];
					}
				}
			}
		}	
		print2D(dp);
		return dp[n][target];
	}

	public static void print2D(boolean mat[][]){
        for (boolean[] row : mat){
        	for (boolean x : row){
        		if(x){
        			System.out.print("["+x+"]" + "  ");	
        		}else{
        			System.out.print("["+x+"]" + " ");
        		}
        	}
        	System.out.println();
        }
    }
	
	private static boolean targetSumSubsetRevision1(int[] arr, int n, int target) {
		boolean[][] dp = new boolean[n+1][target+1];
		dp[0][0] = true;
		for(int i = 1; i < dp[0].length; i++){
			dp[0][i] = false;
		}
		for(int i = 1; i < dp.length; i++){
			dp[i][0] = false;
		}
		for(int i = 1; i < dp.length; i++){
			for(int j = 1; j < dp[i].length; j++){
				if(j >= arr[i-1]){
					dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
				}else{
					dp[i][j] = dp[i-1][j];
				}			
			}
		}
		return dp[n][target];
	}
}
