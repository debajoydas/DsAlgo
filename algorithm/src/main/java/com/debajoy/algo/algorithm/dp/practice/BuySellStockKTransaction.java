/**
 * 
 */
package com.debajoy.algo.algorithm.dp.practice;

/**
 * @author Debajoy
 *
 */
public class BuySellStockKTransaction {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] price = {30,40,43,50,45,20,26,40,80,50,30,15,10,20,40,45,71,50,55};
		int[] price1 = {9,6,7,6,3,8};
		int k = 4;
		System.out.println("Mximum profit earned with("+ k  +") Valid (B1->S1->B2->S2->..) Unique Transactions :=> "+getMaxProfit(price,k));
		System.out.println("Optimized Way -- Mximum profit earned with("+ k  +") Valid (B1->S1->B2->S2->..) Unique Transactions :=> "+getMaxProfitOptiized(price,k));
	}
	public static int getMaxProfit(int[] price, int k) {
		int n = price.length;
		int m = k+1;
		int[][] dp = new int[m][n];
		for(int i = 1; i < m; i++){
			for(int j=1; j < n; j++){
				int max = 0;
				for(int t = 0; t < j; t++){
					max = Math.max(max, dp[i-1][t]+price[j]-price[t]);
				}
				dp[i][j] = Math.max(max, dp[i][j-1]);
			}
		}
		return dp[m-1][n-1];
	}
	
	public static int getMaxProfitOptiized(int[] price, int k) {
		int n = price.length;
		int m = k+1;
		int[][] dp = new int[m][n];
		for(int i = 0; i < m; i++){
			int max = Integer.MIN_VALUE;
			for(int j=0; j < n; j++){
				if(i == 0 || j == 0){
					dp[i][j] = 0;
				}else{
					dp[i][j] =  Math.max(max+price[j], dp[i][j-1]);
				}
				if(i > 0){
					max = Math.max(max, dp[i-1][j]-price[j]);
				}
			}
		}
		return dp[m-1][n-1];
	}
}
