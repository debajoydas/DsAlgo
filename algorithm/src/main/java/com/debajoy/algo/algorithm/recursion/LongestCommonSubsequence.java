/**
 * 
 */
package com.debajoy.algo.algorithm.recursion;

/**
 * @author Debajoy
 *
 */
public class LongestCommonSubsequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findLCSLength("abdca", "cbda"));
	    System.out.println(findLCSLength("passport", "ppsspt"));
	    System.out.println(findLCSLength("abdca", "cbdca"));
	}

	private static int findLCSLength(String s1, String s2) {
		// TODO Auto-generated method stub
		if(s1 == null || s2 == null){
			return 0;
		}
		int indexS1 = 0;
		int indexS2 = 0;
		return findLCSLengthRecursion(s1,s2,indexS1,indexS2);
	}

	private static int findLCSLengthRecursion(String s1, String s2, int indexS1, int indexS2) {
		// TODO Auto-generated method stub
		
		if(indexS1 >= s1.length() || indexS2 >= s2.length()){
			return 0;
		}
		
		if(s1.charAt(indexS1) == s2.charAt(indexS2)){
			return 1 + findLCSLengthRecursion(s1, s2, indexS1+1, indexS2+1);
		}else{
			return Math.max(findLCSLengthRecursion(s1, s2, indexS1+1, indexS2), findLCSLengthRecursion(s1, s2, indexS1, indexS2+1));
		}
	
	}

}
