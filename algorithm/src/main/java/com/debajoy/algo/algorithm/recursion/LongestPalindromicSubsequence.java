/**
 * 
 */
package com.debajoy.algo.algorithm.recursion;

/**
 * @author Debajoy
 *
 */
public class LongestPalindromicSubsequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "abdbca";
		System.out.println(getLongestPalindromicSubSequence(input));

	}

	private static int getLongestPalindromicSubSequence(String input) {
		// TODO Auto-generated method stub
		if(input == null){
			return 0;
		}
		int start = 0;
		int end = input.length()-1;
		return getLongestPalindromicSubSequenceRecursion(input,start,end);
	}

	private static int getLongestPalindromicSubSequenceRecursion(String input, int start, int end) {
		// TODO Auto-generated method stub
		if(start > end){
			return 0;
		}else if(start == end){
			return 1;
		}else{
			if(input.charAt(start) == input.charAt(end)){
				return 2 + getLongestPalindromicSubSequenceRecursion(input, start+1, end-1);
			}else{
				return Math.max(getLongestPalindromicSubSequenceRecursion(input, start, end-1), getLongestPalindromicSubSequenceRecursion(input, start+1, end));
			}
		}
	}

}
