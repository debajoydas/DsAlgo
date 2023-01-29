/**
 * 
 */
package com.debajoy.algo.algorithm.recursion;

/**
 * @author Debajoy
 *
 */
public class LongestRepeatingSubsequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findLRSLength("tomorrow"));
	    System.out.println(findLRSLength("aabdbcec"));
	    System.out.println(findLRSLength("fmff"));
	}

	private static int findLRSLength(String input) {
		// TODO Auto-generated method stub
		if(input == null || (input != null & input.equals(""))){
			return 0;
		}
		int index1 = 0;
		int index2 = 0;
		return findLRSLengthRecursion(input,index1,index2);
	}

	private static int findLRSLengthRecursion(String input, int index1, int index2) {
		// TODO Auto-generated method stub
		
		if(index1 == input.length() || index2 == input.length()){
			return 0;
		}
		if(index1 != index2 && input.charAt(index1) == input.charAt(index2)){
			return 1 + findLRSLengthRecursion(input, index1+1, index2+1);
		}else{
			return Math.max(findLRSLengthRecursion(input, index1+1, index2), findLRSLengthRecursion(input, index1, index2+1));
		}
		
	}

}
