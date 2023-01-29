/**
 * 
 */
package com.debajoy.algo.algorithm.dp.practice.level2;

import java.util.ArrayDeque;

/**
 * @author Debajoy
 *
 */
public class PrintPathsMaxGold {
	
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
        printMaxGoldMine(arr,R,C); 
	}

	private static void printMaxGoldMine(int[][] arr, int R, int C) {
		// TODO Auto-generated method stub
		System.out.println("Print All the paths of Max GoldMine :-> ");
		int[][] dp = maxGoldMine(arr, R, C);
		int maxVal = getMaxGoldMine(arr, R, C);
		ArrayDeque<GoldMinePath> queue = new ArrayDeque<GoldMinePath>();
		
		for(int i = 0; i < dp.length; i++){
			if(dp[i][0] == maxVal){
				queue.add(new GoldMinePath(i, 0, String.valueOf(i)+String.valueOf(0)+SEPERATOR));
			}
		}
		
		while(queue.size() > 0){
			GoldMinePath goldmine = queue.poll();
			int i  = goldmine.i;
			int j = goldmine.j;
			String path = goldmine.path;
			
			if(j == C-1){
				System.out.println(path);
			}
			
			if(j < (C-1)){
				if(i == 0){
					if(dp[i][j+1] < dp[i+1][j+1]){
						queue.add(new GoldMinePath(i+1, j+1, path+String.valueOf(i+1)+String.valueOf(j+1)+SEPERATOR));
					}else if(dp[i][j+1] > dp[i+1][j+1]){
						queue.add(new GoldMinePath(i, j+1, path+String.valueOf(i)+String.valueOf(j+1)+SEPERATOR));
					}else{
						queue.add(new GoldMinePath(i+1, j+1, path+String.valueOf(i+1)+String.valueOf(j+1)+SEPERATOR));
						queue.add(new GoldMinePath(i, j+1, path+String.valueOf(i)+String.valueOf(j+1)+SEPERATOR));
					}
				}else if(i == R-1){
					if(dp[i][j+1] < dp[i-1][j+1]){
						queue.add(new GoldMinePath(i-1, j+1, path+String.valueOf(i-1)+String.valueOf(j+1)+SEPERATOR));
					}else if(dp[i][j+1] > dp[i-1][j+1]){
						queue.add(new GoldMinePath(i, j+1, path+String.valueOf(i)+String.valueOf(j+1)+SEPERATOR));
					}else{
						queue.add(new GoldMinePath(i-1, j+1, path+String.valueOf(i-1)+String.valueOf(j+1)+SEPERATOR));
						queue.add(new GoldMinePath(i, j+1, path+String.valueOf(i)+String.valueOf(j+1)+SEPERATOR));
					}
				}else{
					int max = Integer.MIN_VALUE;
					max = Math.max(dp[i][j+1], Math.max(dp[i+1][j+1], dp[i-1][j+1]));
					if(dp[i][j+1] == max){
						queue.add(new GoldMinePath(i, j+1, path+String.valueOf(i)+String.valueOf(j+1)+SEPERATOR));
					}
					if(dp[i+1][j+1] == max){
						queue.add(new GoldMinePath(i+1, j+1, path+String.valueOf(i+1)+String.valueOf(j+1)+SEPERATOR));
					}
					if(dp[i-1][j+1] == max){
						queue.add(new GoldMinePath(i-1, j+1, path+String.valueOf(i-1)+String.valueOf(j+1)+SEPERATOR));
					}
				}
			}
		}
	}

	private static int getMaxGoldMine(int[][] arr, int R, int C) {
		// TODO Auto-generated method stub
		int[][] dp = new int[R][C];
		int max = Integer.MIN_VALUE;
		for(int i = R-1; i >= 0; i--){
			dp[i][C-1] = arr[i][C-1];
		}
		for(int j = C-1; j >= 0; j--){
			for(int i = R-1; i >= 0; i--){
				if(j == C-1){
					dp[i][j] = arr[i][j];
				}else if(i == R-1){
					dp[i][j] = Math.max(dp[i][j+1],dp[i-1][j+1]) + arr[i][j];
				}else if(i == 0){
					dp[i][j] = Math.max(dp[i][j+1],dp[i+1][j+1]) + arr[i][j];
				}else{
					dp[i][j] = Math.max(dp[i][j+1], Math.max(dp[i+1][j+1], dp[i-1][j+1])) + arr[i][j];
				}
			}
		}
		for(int i = 0; i < R; i++){
			max = Math.max(max, dp[i][0]);
		}
		return max;
	}

	private static int[][] maxGoldMine(int[][] arr, int R, int C) {
		// TODO Auto-generated method stub
		int[][] dp = new int[R][C];
		int max = Integer.MIN_VALUE;
		for(int i = R-1; i >= 0; i--){
			dp[i][C-1] = arr[i][C-1];
		}
		for(int j = C-1; j >= 0; j--){
			for(int i = R-1; i >= 0; i--){
				if(j == C-1){
					dp[i][j] = arr[i][j];
				}else if(i == R-1){
					dp[i][j] = Math.max(dp[i][j+1],dp[i-1][j+1]) + arr[i][j];
				}else if(i == 0){
					dp[i][j] = Math.max(dp[i][j+1],dp[i+1][j+1]) + arr[i][j];
				}else{
					dp[i][j] = Math.max(dp[i][j+1], Math.max(dp[i+1][j+1], dp[i-1][j+1])) + arr[i][j];
				}
			}
		}
		for(int i = 0; i < R; i++){
			max = Math.max(max, dp[i][0]);
		}
		return dp;
	}

}

class GoldMinePath{
	public GoldMinePath(int i, int j, String path) {
		super();
		this.i = i;
		this.j = j;
		this.path = path;
	}
	int i;
	int j;
	String path;
}