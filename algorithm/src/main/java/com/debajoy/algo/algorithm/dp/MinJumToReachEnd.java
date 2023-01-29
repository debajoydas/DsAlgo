/**
 * 
 */
package com.debajoy.algo.algorithm.dp;

/**
 * @author Debajoy
 *
 */
public class MinJumToReachEnd {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] jumps = {2, 1, 1, 1, 4};
	    System.out.println(countMinJumps(jumps));
	    jumps = new int[]{1, 1, 3, 6, 9, 3, 0, 1, 3};
	    System.out.println(countMinJumpsOptimized(jumps));
	}

	private static int countMinJumps(int[] jumps) {
		// TODO Auto-generated method stub
		int[] dp = new int[jumps.length];
		for(int i = 1; i< jumps.length; i++){
			dp[i] = Integer.MAX_VALUE;
		}
		for(int i = 0; i< dp.length; i++){
			for(int j = 0; j < i; j++){
				if(jumps[j] + j >= i){
					dp[i] = Math.min(dp[i], dp[j]+1);
				}
			}
		}
		return dp[jumps.length-1];
	}
	
	private static int countMinJumpsOptimized(int[] jumps) {
		// TODO Auto-generated method stub
		int[] dp = new int[jumps.length];
		for(int i = 1; i< jumps.length; i++){
			dp[i] = Integer.MAX_VALUE;
		}
		for(int i = 0; i< dp.length-1; i++){
			for(int j = (i+1); j <= jumps[i]+i && j < jumps.length; j++){
				dp[j] = Math.min(dp[j], dp[i]+1); 
			}
		}
		return dp[jumps.length-1];
	}

}
