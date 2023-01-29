/**
 * 
 */
package com.debajoy.algo.algorithm.dp.rev1;

/**
 * @author Debajoy
 *
 */
public class UnBoundedKnapsack01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int wt[] = new int[] {2,5,1,3,4,3,5,6,7,8,4}; 
        int val[] = new int[] {15,14,10,45,30,45,68,90,23,60,90}; 
        int C = 7; 
        int n = val.length; 
        System.out.println(knapSack(C, wt, val, n)); 
        System.out.println(knapSackRevision1(C, wt, val, n)); 
	
	}

	private static int knapSack(int C, int[] wt, int[] val, int n) {
		int[] dp = new int[C+1];
		dp[0] = 0;
		for(int c = 1; c <= C; c++){
			int max = 0;
			for(int i = 0; i < n; i++){
				if(c >= wt[i]){
					int value = dp[c-wt[i]] + val[i];
					max = Math.max(max, value);
				}
			}
			dp[c] = max;
		}
		return dp[C];
	}
	
	private static int knapSackRevision1(int C, int[] wt, int[] val, int n) {
		int[] dp = new int[C+1];
		for(int i = 0; i < dp.length; i++){
			for(int j = 0; j < n ; j++){
				if(i >= wt[j]){
					dp[i] = Math.max(dp[i], dp[i-wt[j]]+val[j]);
				}			
			}
		}
		return dp[C];
	}
}
