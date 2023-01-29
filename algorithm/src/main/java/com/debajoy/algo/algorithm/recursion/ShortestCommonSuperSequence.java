/**
 * 
 */
package com.debajoy.algo.algorithm.recursion;

/**
 * @author Debajoy
 *
 */
public class ShortestCommonSuperSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findSCSLength("abcf", "bdcf"));
	    System.out.println(findSCSLength("dynamic", "programming"));
	}

	private static int findSCSLength(String s1, String s2) {
		// TODO Auto-generated method stub
		int indexS1 = 0;
		int indexS2 = 0;
		return findSCSLengthRecursion(s1,s2,indexS1,indexS2);
	}

	private static int findSCSLengthRecursion(String s1, String s2, int indexS1, int indexS2) {
		if(indexS1 >= s1.length()){
			return s2.length()-indexS2;
		}
		if(indexS2 >= s2.length()){
			return s1.length()-indexS1;
		}
		// TODO Auto-generated method stub
		if(s1.charAt(indexS1) == s2.charAt(indexS2)){
			return 1+findSCSLengthRecursion(s1, s2, indexS1+1, indexS2+1);
		}else{
			return Math.min(1+findSCSLengthRecursion(s1, s2, indexS1+1, indexS2), 1+findSCSLengthRecursion(s1, s2, indexS1, indexS2+1));
		}
	}

}
