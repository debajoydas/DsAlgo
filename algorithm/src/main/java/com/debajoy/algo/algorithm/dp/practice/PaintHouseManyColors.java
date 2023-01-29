/**
 * 
 */
package com.debajoy.algo.algorithm.dp.practice;

/**
 * @author Debajoy
 *
 */
public class PaintHouseManyColors {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = { {1,5,7,2,3,4},
						{5,8,4,3,6,1},
						{3,2,9,7,2,3},
						{1,2,4,9,1,7}
					  };
		System.out.println(minimumCostNotAdjacent(arr));
		System.out.println(minimumCostNotAdjacentOptimized(arr));

	}

	private static int minimumCostNotAdjacent(int[][] arr) {
		// TODO Auto-generated method stub
		int[][] dp = new int[arr.length][arr[0].length];
		int ans = Integer.MAX_VALUE;
		for(int i = 0; i < arr[0].length; i++){
			dp[0][i] = arr[0][i];
		}
		for(int i = 1; i < arr.length; i++){
			for(int j = 0 ; j < arr[i].length; j++){
				int min = Integer.MAX_VALUE;
				for(int k = 0; k < arr[i-1].length; k++){
					if(k != j){
						min = Math.min(min, dp[i-1][k]);
					}
				}
				dp[i][j] = min + arr[i][j];	
			}
		}
		for(int i = 0; i < arr[0].length; i++){
			ans = Math.min(ans, dp[dp.length-1][i]);
		}
		return ans;
	}

	private static int minimumCostNotAdjacentOptimized(int[][] arr) {
		// TODO Auto-generated method stub
		int[][] dp = new int[arr.length][arr[0].length];
		int ans = Integer.MAX_VALUE;
		int last = Integer.MAX_VALUE;
		int secondLast = Integer.MAX_VALUE;
		for(int i = 0; i < arr[0].length; i++){
			dp[0][i] = arr[0][i];
			if(dp[0][i] <= last){
				secondLast = last;
				last = dp[0][i];
			}else if(dp[0][i] <= secondLast){
				secondLast = dp[0][i];
			}
		}
		for(int i = 1; i < arr.length; i++){
			int lastNew = Integer.MAX_VALUE;
			int secondLastNew = Integer.MAX_VALUE;
			for(int j = 0 ; j < arr[i].length; j++){
				if(last != dp[i-1][j]){
					dp[i][j] = last + arr[i][j];
				}else{
					dp[i][j] = secondLast + arr[i][j];
				}
				if(dp[i][j] <= lastNew){
					secondLastNew = lastNew;
					lastNew = dp[i][j];
				}else if(dp[i][j] <= secondLastNew){
					secondLastNew = dp[i][j];
				}
			}
			last = lastNew;
			secondLast = secondLastNew;
		}
		for(int i = 0; i < arr[0].length; i++){
			ans = Math.min(ans, dp[dp.length-1][i]);
		}
		return ans;
	}

}
