/**
 * 
 */
package com.debajoy.algo.algorithm.dp;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author Debajoy
 *
 */
public class HouseThief {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] wealth = {2, 5, 1, 3, 6, 2, 4};
	    System.out.println(findMaxSteal(wealth));
	    System.out.println(findMaxStealOptimized(wealth));
	    
	    wealth = new int[]{2, 10, 14, 8, 1};
	    System.out.println(findMaxSteal(wealth));
	    System.out.println(findMaxStealOptimized(wealth));
	}

	private static int findMaxSteal(int[] wealth) {
		// TODO Auto-generated method stub
		if(wealth == null){
			return 0;
		}
		int n = wealth.length;
		int dp[][] = new int[2][n];
		dp[0][0] = wealth[0];
		dp[0][1] = 0;
		dp[1][0] = 0;
		dp[1][1] = wealth[1];
		for(int i = 0; i < 2 ; i++){
			for(int j = 2; j < n; j++){
				PriorityQueue<Integer> queue =  new PriorityQueue<Integer>(Collections.reverseOrder());
				for(int k = 0; k<= (j-2); k++){
					queue.add(dp[i][k]);
				}
				dp[i][j] = Math.max(queue.poll() + wealth[j], dp[i][j-1]);
			}
		}
		return Math.max(dp[0][n-1],dp[1][n-1]);
	}
	
	private static int findMaxStealOptimized(int[] wealth) {
		int[] dp = new int[wealth.length];
		dp[0] = wealth[0];
		dp[1] = wealth[1];
		for(int i = 2; i< wealth.length; i++){
			dp[i] = Integer.MIN_VALUE;
		}
		for(int i = 0 ; i < 2; i++){

			for(int j = i+2; j< wealth.length; j++){
				dp[j] = Math.max(wealth[j]+dp[j-2], dp[j-1]);
			}
		}
		return dp[wealth.length-1];	
	}

}
