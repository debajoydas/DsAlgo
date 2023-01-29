/**
 * 
 */
package com.debajoy.algo.algorithm.dp.practice;

/**
 * @author Debajoy
 *
 */
public class ClimbingStairs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String MEMORIZATION ="by Memorization formula :=";
		String TABULATION ="by tabulation formula :=";
		int n = 6;
		System.out.println("Number of Path with 1/2/3 possible jumps "+MEMORIZATION+getNoOfPathClimingStairsMem(n));
		System.out.println("Number of Path with 1/2/3 possible jumps "+TABULATION+getNoOfPathClimingStairs(n));
	}
	
	
	// tabulations
	public static int getNoOfPathClimingStairs(int n){
		int[] dp = new int[n+1];
		dp[0] = 1;
		for(int i =1; i <= n; i++){
			if(i == 1){
				dp[i] = dp[i-1];
			}else if(i == 2){
				dp[i] = dp[i-1]+dp[i-2];
			}else{
				dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
			}
		 }
		return dp[n];
	}
	
	//memorizations
	public static int getNoOfPathClimingStairsMem(int n){
		int[] dp = new int[n+1];
		return getNoOfPathClimingStairsMemRec(n, dp);
	}
	
	private static int getNoOfPathClimingStairsMemRec(int n, int[] dp){
		if(n == 0){
			return 1;
		}else if(n < 0){
			return 0;
		}
		if(dp[n] > 0){
			return dp[n];
		}
		dp[n] = getNoOfPathClimingStairsMemRec(n-1, dp) + getNoOfPathClimingStairsMemRec(n-2, dp) + getNoOfPathClimingStairsMemRec(n-3, dp);
		return dp[n];
	}

}
