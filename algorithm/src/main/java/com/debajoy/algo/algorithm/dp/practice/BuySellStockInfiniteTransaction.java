/**
 * 
 */
package com.debajoy.algo.algorithm.dp.practice;

/**
 * @author Debajoy
 *
 */
public class BuySellStockInfiniteTransaction {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] price = {1,3,5,4,1,2,1,4};
		System.out.println("Mximum profit earned with Infinite Valid (B1->S1->B2->S2) Transaction :=> "+getMaxProfit(price));
		System.out.println("Mximum profit earned with Infinite Valid (B1->S1->B2->S2) Transaction :=> "+getMaxProfitRevison1(price));
	}
	
	public static int getMaxProfit(int[] price){
		int buy = 0;
		int sell = 0;
		int profit = 0;
		for(int i = 1; i < price.length; i++){
			if(price[i] >= price[i-1]){
				sell = i;
			}else{
				profit += price[sell] - price[buy];
				buy = sell = i;
			}
		}
		profit += price[sell] - price[buy];
		return profit;
	}

	public static int getMaxProfitRevison1(int[] price){
		int buyday = 0; 
		int sellday = 0;
		int profit = 0;
		for(int i = 1; i < price.length; i++){
			if(price[i] >= price[i-1]){
				sellday = i;
			}else{
				profit += price[sellday] - price[buyday];
				buyday = sellday = i;
			}
		}
		//VVIP Point
		profit += price[sellday] - price[buyday];
		return profit;
	}
}
