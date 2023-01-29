/**
 * 
 */
package com.debajoy.algo.algorithm.dp.practice.level2;

import java.util.ArrayDeque;

/**
 * @author Debajoy
 *
 */
public class PrintSubsetsTargetSum {
	
	public static final String SEPERATOR = " && ";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[] {4,2,7,1,3}; 
        int n = arr.length; 
        int target = 10;
        printTargetSumSubSet(arr,n,target);
	}

	private static void printTargetSumSubSet(int[] arr, int n, int target) {
		// TODO Auto-generated method stub
		System.out.println("Print Target Sum-Set :-> ");
		boolean[][] dp = targetSumSubset(arr, n, target);		
		ArrayDeque<TargetSum> queue = new ArrayDeque<TargetSum>();
		queue.add(new TargetSum(dp.length-1, dp[0].length-1, ""));
		
		while(queue.size() > 0){
			TargetSum targetSum = queue.poll();
			int i = targetSum.i;
			int j = targetSum.j;
			String path = targetSum.path;
			
			if(i == 0){
				System.out.println(path);
			}
			
			if(i > 0){
				if(dp[i-1][j]){
					queue.add(new TargetSum(i-1, j, path));
				}
				if(j-arr[i-1] >= 0){
					if(dp[i-1][j-arr[i-1]]){
						queue.add(new TargetSum(i-1, j-arr[i-1], path+String.valueOf(arr[i-1])+SEPERATOR));
					}
				}
			}
		}
		
	}

	private static boolean[][] targetSumSubset(int[] arr, int n, int target) {
		// TODO Auto-generated method stub
		boolean[][] dp = new boolean[n+1][target+1];
		for(int i = 0; i < dp.length; i++){
			for(int j = 0; j < dp[i].length; j++){
				if(i == 0 && j == 0){
					dp[i][j] = true;
				}else if(i == 0){
					dp[i][j] = false;
				}else if(j == 0){
					dp[i][j] = true;
				}else{
					if(dp[i-1][j]){
						dp[i][j] = true;
					}else{
						if(arr[i-1] <= j && dp[i-1][j-arr[i-1]]){
							dp[i][j] = true;
						}else{
							dp[i][j] = false;
						}
					}
				}
			}
		}
		return dp;
	}
}

class TargetSum{
	int i;
	int j;
	String path;
	public TargetSum(int i, int j, String path) {
		super();
		this.i = i;
		this.j = j;
		this.path = path;
	}
}