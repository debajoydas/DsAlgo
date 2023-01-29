/**
 * 
 */
package com.debajoy.algo.algorithm.dp.practice;

/**
 * @author Debajoy
 *
 */
public class Knapsack01 {
	
	public static final String SEPERATOR = "->";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int val[] = new int[] { 15, 14, 10, 45, 30 }; 
        int wt[] = new int[] { 2, 5, 1, 3, 4 }; 
        int Capacity = 7; 
        int n = val.length; 
        System.out.println(knapSack(Capacity, wt, val, n));
        System.out.println(knapSackNew(Capacity, wt, val, n));
        printKnapSackDP(Capacity, wt, val, n);
	}
	
	private static void printKnapSackDP(int Capacity, int[] wt, int[] val, int n) {
		System.out.println("Print the Weights of Knapsack Bag ->");
		int[][] dp = knapSackDP(Capacity, wt, val, n);
		int maxVal = knapSack(Capacity, wt, val, n);
		int sum = 0;
		StringBuilder path = new StringBuilder("");
		
		int i = n-1; int j = Capacity;
		while(i > 0){
			if(dp[i][j] != dp[i-1][j]){
				j -= wt[i];
				sum += val[i];
				path.append(wt[i]).append(SEPERATOR);
			}
			i--;
		}
		if(maxVal > sum){
			path.append(wt[0]).append(SEPERATOR);
		}
		System.out.println(path);
	}
	
	private static int[][] knapSackDP(int Capacity, int[] wt, int[] val, int n) {
		// TODO Auto-generated method stub
		int[][] dp = new int[n][Capacity+1];
		for(int i = 0; i < n; i++){
			for(int j = 0; j <= Capacity; j++){
				if(i == 0){
					if(j >= wt[i]){
						dp[i][j] = val[i];
					}		
				}else if(j == 0){
					dp[i][j] = 0;
				}else{
					if(j-wt[i] >= 0){
						dp[i][j] = Math.max(dp[i-1][j], val[i] + dp[i-1][j-wt[i]]);	
					}else{
						dp[i][j] = dp[i-1][j];						
					}
				}					
			}
		}
		return dp;
	}

	private static int knapSack(int Capacity, int[] wt, int[] val, int n) {
		// TODO Auto-generated method stub
		int[][] dp = new int[n][Capacity+1];
		for(int i = 0; i < n; i++){
			for(int j = 0; j <= Capacity; j++){
				if(i == 0){
					if(j >= wt[i]){
						dp[i][j] = val[i];
					}		
				}else if(j == 0){
					dp[i][j] = 0;
				}else{
					if(j-wt[i] >= 0){
						dp[i][j] = Math.max(dp[i-1][j], val[i] + dp[i-1][j-wt[i]]);	
					}else{
						dp[i][j] = dp[i-1][j];						
					}
				}					
			}
		}
		return dp[n-1][Capacity];
	}
	
	public static int knapSackNew(int Capacity, int[] wt, int[] val, int n) {
		// TODO Auto-generated method stub
		int[][] dp = new int[n+1][Capacity+1];
		for(int i = 0; i <= n; i++){
			for(int j = 0; j <= Capacity; j++){
				if(i == 0 || j == 0){
					dp[i][j] = 0;
				}else{
					if(j-wt[i-1] >= 0){
						dp[i][j] = Math.max(dp[i-1][j], val[i-1] + dp[i-1][j-wt[i-1]]);	
					}else{
						dp[i][j] = dp[i-1][j];						
					}
				}					
			}
		}
		return dp[n][Capacity];
	}
 
}
