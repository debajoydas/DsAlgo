/**
 * 
 */
package com.debajoy.algo.algorithm.dp.practice;

/**
 * @author Debajoy
 *
 */
public class BuySellStockInfiniteTransactionWithCoolDown {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {10,15,17,20,16,18,22,20,22,20,23,25};
		System.out.println(getMaxProfit(arr));
	}
	
	public static int getMaxProfit(int[] arr){
		int n = arr.length;
		int[] bs = new int[n];
		int[] ss = new int[n];
		int[] cs = new int[n];
		bs[0] = 0-arr[0];
		bs[1] = Math.max(bs[0], ss[0]-arr[1]);
		cs[1] = 0;
		for(int i = 2; i < n; i++){
			bs[i] = Math.max(bs[i-1], cs[i-1]-arr[i]);
			ss[i] = Math.max(ss[i-1], bs[i-1]+arr[i]);
			cs[i] = Math.max(cs[i-1], ss[i-1]);
		}
		return ss[n-1];
	}

}
