/**
 * 
 */
package com.debajoy.algo.algorithm.dp.practice;

/**
 * @author Debajoy
 *
 */
public class ClimbingStairVariableJump {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr1[] = new int[] { 3,3,0,2,2,3 }; 
		int arr[] = new int[] { 2,3,3,0,4,1,4,5,3,5,6,4 }; 
        int n = arr.length; 
        System.out.println(maxPossiblePaths(arr, n)); 
        System.out.println(maxPossiblePathsRevision1(arr, n));

	}

	private static int maxPossiblePaths(int[] arr, int n) {
		// TODO Auto-generated method stub
		int[] dp = new int[n+1];
		dp[n] = 1;
		for(int i = n-1; i >= 0; i--){
			for(int j = 1; j <= arr[i]; j++){
				if((i+j) <= n){
					dp[i] += dp[i+j];	
				}
			}
		}
		return dp[0];
	}
	
	private static int maxPossiblePathsRevision1(int[] arr, int n) {
		int[] dp = new int[n+1];
		dp[n] = 1;
		for(int i = n-1; i >= 0; i--){
			int _total_Possible_path = 0;
			for(int j = i+1; j <= i+arr[i]; j++){
				if(j <= n){
					_total_Possible_path += dp[j];
				}
			}
			dp[i] = _total_Possible_path;
		}
		return dp[0];
	}

}
