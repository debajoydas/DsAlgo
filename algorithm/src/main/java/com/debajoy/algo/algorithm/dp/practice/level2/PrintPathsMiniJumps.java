/**
 * 
 */
package com.debajoy.algo.algorithm.dp.practice.level2;

import java.util.ArrayDeque;

/**
 * @author Debajoy
 *
 */
public class PrintPathsMiniJumps {
	
	public static final String SEPERATOR = "->";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3,3,0,2,1,2,4,2,0,0};
		printAllMinPath(arr, arr.length);
	}
	
	private static void printAllMinPath(int[] arr, int n){
		System.out.println("Print All Min Jum Paths :- ");
		Integer[] dp = getminJumpArray(arr, n);
		ArrayDeque<JumpPath> deque = new ArrayDeque<JumpPath>();
		deque.add(new JumpPath(0, String.valueOf(0)+SEPERATOR));
		
		while(deque.size() > 0){
			JumpPath path = deque.poll();
			int cur = path.index;
			int jumps = arr[cur];
			String pathStr = path.path;
			int valueToMatch = dp[cur]-1;
			
			if(dp[cur] != null && dp[cur] == 0){
				System.out.println(path.path);
			}
			
			for(int i = 1; i <= jumps && (cur+i) <= (n-1); i++){
				if(dp[cur+i] != null && dp[cur+i] == valueToMatch){
					deque.add(new JumpPath(cur+i, pathStr+String.valueOf(cur+i)+SEPERATOR));
				}
			}
		}
		
	}
	
	private static Integer[] getminJumpArray(int[] arr, int n){
		Integer[] dp = new Integer[n];
		dp[n-1] = 0;
		for(int i = n-2; i >= 0; i--){
			int jumps = arr[i];
			int min = Integer.MAX_VALUE;
			for(int j = 1; j <= jumps && (i+j) <= (n-1); j++){
				if(dp[i+j] != null){
					min = Math.min(min, dp[i+j]);
				}			
			}
			if(min != Integer.MAX_VALUE){
				dp[i] = min+1;
			}
		}
		return dp;
	}

}

class JumpPath{
	int index;
	String path;
	public JumpPath(int index, String path) {
		super();
		this.index = index;
		this.path = path;
	}
}