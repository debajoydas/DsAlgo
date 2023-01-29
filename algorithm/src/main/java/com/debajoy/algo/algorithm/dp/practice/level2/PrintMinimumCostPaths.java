/**
 * 
 */
package com.debajoy.algo.algorithm.dp.practice.level2;

import java.util.ArrayDeque;

/**
 * @author Debajoy
 *
 */
public class PrintMinimumCostPaths {

	public static final String SEPERATOR = "->";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][] = { 
					{2, 8, 4, 1, 6, 4, 2}, 
                	{6, 0, 9, 5, 3, 8, 5}, 
                	{1, 4, 3, 4, 0, 6, 5}, 
                	{6, 4, 7, 2, 4, 6, 1},
                	{1, 0, 3, 7, 1, 2, 7},
                	{1, 5, 3, 2, 3, 0, 9},
                	{2, 2, 5, 1, 9, 8, 2}}; 
  
		int R = arr.length; int C = arr.length;  	
        printAllMinCostPaths(arr,R,C);
	}

	private static void printAllMinCostPaths(int[][] arr, int R, int C) {
		// TODO Auto-generated method stub
		System.out.println("Print All Paths with minimum Cost (ij)-> :- ");
		int[][] dp = minCostPath(arr, R, C);
		ArrayDeque<CostPath> queue = new ArrayDeque<CostPath>();
		queue.add(new CostPath(0, 0, String.valueOf(0)+String.valueOf(0)+SEPERATOR));
		
		while(queue.size() > 0){
			CostPath costPath = queue.poll();
			int i = costPath.i;
			int j = costPath.j;
			String path = costPath.path;
			
			if(i == (R-1) && j == (C-1)){
				System.out.println(path);
			}
			
			if(i == (R-1)){
				queue.add(new CostPath(i, (j+1), path+SEPERATOR+String.valueOf(i)+String.valueOf(j+1)));
			}else if( j == (C-1)){
				queue.add(new CostPath(i+1, (j), path+SEPERATOR+String.valueOf(i+1)+String.valueOf(j)));
			}else if( i < (R-1) && j < (C-1)){
				if(dp[i+1][j] < dp[i][j+1]){
					queue.add(new CostPath(i+1, (j), path+SEPERATOR+String.valueOf(i+1)+String.valueOf(j)));
				}else if(dp[i+1][j] > dp[i][j+1]){
					queue.add(new CostPath(i, (j+1), path+SEPERATOR+String.valueOf(i)+String.valueOf(j+1)));
				}else{
					queue.add(new CostPath(i+1, (j), path+SEPERATOR+String.valueOf(i+1)+String.valueOf(j)));
					queue.add(new CostPath(i, (j+1), path+SEPERATOR+String.valueOf(i)+String.valueOf(j+1)));
				}
			}
		}
	}

	private static int[][] minCostPath(int[][] arr, int R, int C) {
		// TODO Auto-generated method stub
		int[][] dp = new int[R][C];
		for(int i = C-1; i >= 0; i--){
			if(i+1 < C){
				dp[R-1][i] = dp[R-1][i+1]+arr[R-1][i]; 
			}else{
				dp[R-1][i] = arr[R-1][i];
			}
		}
		for(int i = R-1; i >= 0; i--){
			if(i+1 < C){
				dp[i][C-1] = dp[i+1][C-1]+arr[i][C-1];
			}else{
				dp[i][C-1] = arr[i][C-1];
			}
		}
		for(int i = R-2; i >= 0; i--){
			for(int j = C-2; j >= 0; j--){
				dp[i][j] = Math.min(dp[i+1][j], dp[i][j+1]) + arr[i][j];
			}
		}
		return dp;
	}
}

class CostPath{
	public CostPath(int i, int j, String path) {
		super();
		this.i = i;
		this.j = j;
		this.path = path;
	}
	int i;
	int j;
	String path;
}