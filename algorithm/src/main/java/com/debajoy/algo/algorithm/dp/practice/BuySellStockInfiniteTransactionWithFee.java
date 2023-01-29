/**
 * 
 */
package com.debajoy.algo.algorithm.dp.practice;

/**
 * @author Debajoy
 *
 */
public class BuySellStockInfiniteTransactionWithFee {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] price = {10,15,17,20,16,18,22,20,22,20,23,25};
		int fees = 3;
		System.out.println("Mximum profit earned with Infinite Valid (B1->S1->B2->S2) Transaction :=> "+getMaxProfit(price,fees));
	}

	private static int getMaxProfit(int[] price, int fees) {
		// TODO Auto-generated method stub
		int n = price.length;
		int[] buyState = new int[n];
		int[] sellState = new int[n];
		buyState[0] = 0-price[0];
		sellState[0] = 0;
		for(int i = 1; i < n; i++){
			buyState[i] = Math.max(buyState[i-1], sellState[i-1]-price[i]);
			sellState[i] = Math.max(sellState[i-1], buyState[i-1]+price[i]-fees);
		}
		return sellState[n-1];
	}

}
