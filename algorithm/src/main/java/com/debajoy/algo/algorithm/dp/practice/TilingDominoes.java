/**
 * 
 */
package com.debajoy.algo.algorithm.dp.practice;

/**
 * @author Debajoy
 *
 */
public class TilingDominoes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int floorLength = 4;
		int m = 2; int tileL = 1;
		System.out.println(getNoOfWays(floorLength,m,tileL));
		
		int floorLength1 = 4;
		int m1 = 2; int tileL1 = 1;
		System.out.println(getNoOfWaysMCrossN(floorLength1,m1,tileL1));

	}

	private static int getNoOfWays(int floorLength, int m, int tileL) {
		// TODO Auto-generated method stub
		int[] dp = new int[floorLength+1];
		dp[1] = 1; dp[2] = 2;
		for(int i = 3; i <= floorLength; i++){
			dp[i] = dp[i-1]+dp[i-2];
		}
		return dp[floorLength];
	}
	
	private static int getNoOfWaysMCrossN(int floorLength, int m, int tileL) {
		// TODO Auto-generated method stub
		int[] dp = new int[floorLength+1];
		for(int i = 1; i <= floorLength; i++){
			if(i > m){
				dp[i] = dp[i-1]+dp[i-m];
			}else if(i == m){
				dp[i] = 2;
			}else{
				dp[i] = 1;
			}
		}
		return dp[floorLength];
	}

}
