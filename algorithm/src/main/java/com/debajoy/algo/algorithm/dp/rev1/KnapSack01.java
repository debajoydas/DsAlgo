/**
 * 
 */
package com.debajoy.algo.algorithm.dp.rev1;

/**
 * @author Debajoy
 *
 */
public class KnapSack01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int val[] = new int[] { 60, 100, 120 }; 
        int wt[] = new int[] { 10, 20, 30 }; 
        int W = 50; 
        int n = val.length; 
        System.out.println(knapSack(W, wt, val, n)); 
	
	}

	private static int knapSack(int w, int[] wt, int[] val, int n) {
		// TODO Auto-generated method stub
		int[][] dp = new int[wt.length][w+1];
		for(int i=0; i<wt.length; i++){
			dp[i][0] = 0;
		}
		for(int c = 0; c <= w; c++){
			if(c >= wt[0]){
				dp[0][c] = val[0];
			}	
		}
		for(int i=1; i<wt.length; i++){
			for(int c = 1; c <= w; c++){
				if(c - wt[i] >= 0){
					dp[i][c] = Math.max(dp[i-1][c], val[i] + dp[i-1][c-wt[i]]);
				}else{
					dp[i][c] = dp[i-1][c];
				}
			}
		}
		return dp[n-1][w];
	}

}
