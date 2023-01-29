/**
 * 
 */
package com.debajoy.algo.algorithm.recursion;

/**
 * @author Debajoy
 *
 */
public class StairCase {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    System.out.println(countWays(3));
	    System.out.println(countWays(4));
	    System.out.println(countWays(5));
	}

	private static int countWays(int n) {
		// TODO Auto-generated method stub
		if(n == 0){
			return 0;
		}
		Integer[] dp = new Integer[n];
		int sum = 0;
		return countWaysRecursion(dp, n, sum);
	}

	private static int countWaysRecursion(Integer[] dp, int n, int sum) {
		// TODO Auto-generated method stub
		if(sum == n){
			return 1;
		}
		if(sum > n){
			return 0;
		}
		if(dp[sum] == null){
			int count1 = countWaysRecursion(dp, n, sum+1);
			int count2 = countWaysRecursion(dp, n, sum+2);
			int count3 = countWaysRecursion(dp, n, sum+3);
			dp[sum] = (count1+count2+count3);
		}
		return dp[sum];
	}

}
