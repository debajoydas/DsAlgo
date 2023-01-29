/**
 * 
 */
package com.debajoy.algo.algorithm.dp.practice;

/**
 * @author Debajoy
 *
 */
public class BuySellStockTwoTransaction {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] price = {30,40,43,50,45,20,26,40,80,50,30,15,10,20,40,45,71,50,55};
		System.out.println("Mximum profit earned with only Two Valid (B1->S1->B2->S2) Transaction :=> "+getMaxProfit(price));
		System.out.println("Mximum profit earned with only Two Valid (B1->S1->B2->S2) Transaction :=> "+getMaxProfitRevision1(price));
	}

	private static int getMaxProfit(int[] price) {
		// TODO Auto-generated method stub
		int n = price.length;
		int maxProfit = 0;
		if(n <= 0){
			return maxProfit;
		}
		int lowest = price[0];
		int highest = price[n-1];
		int[] dp = new int[n];
		int[] rdp = new int[n];
		dp[0] = 0; rdp[n-1] = 0;
		for(int i = 1; i < n; i++){
			dp[i] = Math.max(dp[i-1], price[i]-lowest);
			if(lowest > price[i]){
				lowest = price[i];
			}
		}
		for(int i = n-2; i >= 0; i--){
			rdp[i] = Math.max(rdp[i+1], highest-price[i]);
			if(highest < price[i]){
				highest = price[i];
			}
		}
		for(int i = 0; i < n ; i++){
			dp[i] += rdp[i];
			maxProfit = Math.max(maxProfit, dp[i]);
		}
		return maxProfit;
	}
	
	private static int getMaxProfitRevision1(int[] price) {
		int n = price.length;
		int maxProfit = 0;
		int[] dp = new int[n]; 
		dp[0] = 0;
		int[] rdp = new int [n];
		rdp[0] = 0;
		int lowest = price[0];
		for(int i = 1; i < n; i++){
			dp[i] = Math.max(dp[i-1], price[i]-lowest);
			lowest = Math.min(lowest, price[i]);
		}
		int highest = price[n-1];
		for(int i = n-2; i>=0; i--){
			rdp[i] = Math.max(rdp[i+1], highest-price[i]);
			highest = Math.max(highest, price[i]);
			maxProfit = Math.max(maxProfit, dp[i]+rdp[i]);
		}
		return maxProfit;
	}

}
