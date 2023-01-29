/**
 * 
 */
package com.debajoy.algo.algorithm.dp.practice;

/**
 * @author Debajoy
 *
 */
public class BuySellStockOneTransaction {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] price = {3,1,2,3,4,6,8,4,2,3,5,6,6,9,11,7,9,14,2,12,13,14,12,13,14,19};
		System.out.println("Mximum profit earned with only One Valid (B1->S1) Transaction :=> "+getMaxProfit(price));
		System.out.println("Mximum profit earned with only One Valid (B1->S1) Transaction :=> "+getMaxProfitRevision1(price));
	}
	
	public static int getMaxProfit(int[] price){
		int profit = 0;
		int lowest = price[0];
		for(int i = 0; i < price.length; i++){
			int prof = price[i]-lowest;
			if(price[i] < lowest){
				lowest = price[i];
			}
			if(prof > profit){
				profit= prof;
			}
		}
		return profit;
	}
	
	public static int getMaxProfitRevision1(int[] price){
		int lowest = price[0];
		int maxProfit = 0;
		for(int i = 1; i < price.length; i++){
			if(price[i] > price[i-1]){
				maxProfit = Math.max(maxProfit, price[i]-lowest);
			}else{
				lowest = Math.min(lowest, price[i]);
			}		
		}
		return maxProfit;
	}

}
