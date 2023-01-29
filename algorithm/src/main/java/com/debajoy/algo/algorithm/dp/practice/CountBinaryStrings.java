/**
 * 
 */
package com.debajoy.algo.algorithm.dp.practice;

/**
 * @author Debajoy
 *
 */
public class CountBinaryStrings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int length = 6;
		System.out.println(countBinaryStrings(length));
	}
	
	private static int countBinaryStrings(int n){
		int[] dp0 = new int[n+1];
		int[] dp1 = new int[n+1];
		dp0[1] = 1;dp1[1] = 1;
		for(int i = 2; i<= n; i++){
			dp1[i] = dp0[i-1]+dp1[i-1];
			dp0[i] = dp1[i-1];
		}
		return dp0[n]+dp1[n];
	}

}
