/**
 * 
 */
package com.debajoy.algo.algorithm.dp.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Debajoy
 *
 */
public class CountEncoding {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer,Character> encodeMap = new HashMap<Integer,Character>();
		Map<String,Character> encodeMapString = new HashMap<String,Character>();
		prepareEncodeMap(encodeMap);
		prepareEncodeMapString(encodeMapString);
		int[] arr = {1,2,5,1,7,3,2,6};
		int[] arr1 = {2,1,1,2,3};
		int n = arr1.length;
		System.out.println(getCountEncoding(arr1,n,encodeMap));
		System.out.println(getCountEncodingOptimized(arr1,n,encodeMapString));
	}

	public static int getCountEncodingOptimized(int[] arr, int n, Map<String, Character> encodeMapString) {
		int[] dp = new int[n+1];
		dp[0] = 0;
		if(encodeMapString.get(String.valueOf(arr[0])) != null){
			dp[1] = 1;
		}
		for(int i = 2; i <= n ; i++){
			String oneDigit = String.valueOf(arr[i-1]);
			String twoDigit = String.valueOf(arr[i-2])+String.valueOf(arr[i-1]);
			if(encodeMapString.get(oneDigit) == null && encodeMapString.get(twoDigit) == null){
				dp[i] = 0;
			}else if(encodeMapString.get(oneDigit) != null && encodeMapString.get(twoDigit) == null){
				dp[i] = i != 2 ?  dp[i-1] : 1;
			}else if(encodeMapString.get(oneDigit) == null && encodeMapString.get(twoDigit) != null){
				dp[i] =  i != 2 ? dp[i-2] : 1;
			}else{
				dp[i] =  i != 2 ? dp[i-1]+dp[i-2] : 2;
			}
		}
		return dp[n];	
	}
	
	private static int getCountEncoding(int[] arr, int n, Map<Integer, Character> encodeMap) {
		// TODO Auto-generated method stub
		int[] dp = new int[n+1];
		dp[0] = 0;
		if(encodeMap.get(arr[1]) != null){
			dp[1] = 1;
		}
		dp[2] = 2;
		for(int i = 3; i<= n; i++){
			dp[i] = getCountDoubleDigit(i-1, i, encodeMap, dp, arr) + getCountSingleDigit(i, encodeMap, dp, arr);
		}
		return dp[n];
	}

	private static int getCountDoubleDigit(int prev, int current, Map<Integer, Character> encodeMap, int[] dp, int[] arr) {
		// TODO Auto-generated method stub
		if((current-2) == 0){
			if(encodeMap.get(Integer.valueOf(String.valueOf(arr[prev-1])+String.valueOf(arr[current-1]))) != null){
				return 1;
			}else{
				return 0;
			}
		}else{
			if(encodeMap.get(Integer.valueOf(String.valueOf(arr[prev-1])+String.valueOf(arr[current-1]))) != null){
				return dp[current-2];
			}else{
				return 0;
			}
		}
	}

	private static int getCountSingleDigit(int current, Map<Integer, Character> encodeMap, int[] dp, int[] arr) {
		// TODO Auto-generated method stub
		if((current-1) == 0){
			if(encodeMap.get(arr[current-1]) != null){
				return 1;
			}else{
				return 0;
			}
		}else{
			if(encodeMap.get(arr[current-1]) != null){
				return dp[current-1];
			}else{
				return 0;
			}
		}
	}

	private static void prepareEncodeMap(Map<Integer, Character> encodeMap) {
		// TODO Auto-generated method stub
		for(int i = 1; i<= 26; i++){
			encodeMap.put(i, Character.valueOf((char) (i+96)));
		}
	}
	
	private static void prepareEncodeMapString(Map<String, Character> encodeMap) {
		// TODO Auto-generated method stub
		for(int i = 1; i<= 26; i++){
			encodeMap.put(String.valueOf(i), Character.valueOf((char) (i+96)));
		}
	}

}
