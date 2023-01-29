/**
 * 
 */
package com.debajoy.algo.algorithm.dp.practice;

/**
 * @author Debajoy
 *
 */
public class ClimbingStairsMinimumMoves {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr1[] = new int[] { 3,3,0,2,2,3 }; 
		int arr[] = new int[] { 4,3,3,2,0,3,5,1,3,4,1,2,2,3,3,2,2,3 }; 
        int n = arr.length; 
        System.out.println(minMoves(arr, n)); 
        System.out.println(minMovesRevision1(arr, n)); 

	}

	private static int minMoves(int[] arr, int n) {
		// TODO Auto-generated method stub
		Integer[] dp = new Integer[n+1];
		dp[n] = 0;
		for(int i= n-1; i >= 0; i--){
			for(int j = 1; j <= arr[i]; j++){
				if((i+j) <= n && dp[i+j] != null){
					if(dp[i] != null){
						dp[i] = Math.min(dp[i], dp[i+j]);	
					}else{
						dp[i] = dp[i+j];
					}			
				}
			}
			if(dp[i] != null){
				dp[i] += 1;	
			}
		}
		return dp[0] != null?dp[0]:0;
	}
	
	private static int minMovesRevision1(int[] arr, int n) {
		Integer[] dp = new Integer[n+1];
		dp[n] = 0;
		for(int i = n-1; i >= 0; i--){
			int _min_moves = Integer.MAX_VALUE;
			if(arr[i] != 0){
				for(int j = i+1; j <= (i+arr[i]); j++){
					if(j <= n){
						if(dp[j] != null){
							_min_moves = Math.min(_min_moves, dp[j]);
						}
					}
				}
				dp[i] = _min_moves+1;
			}
		}
		return dp[0] != null ? dp[0] : -1;
	}

}
