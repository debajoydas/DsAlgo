/**
 * 
 */
package com.debajoy.algo.algorithm.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Debajoy
 *
 */
public class LongestSubStringWithoutRepeatingChar {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String str = "geeksforgeeks"; 
	        System.out.println("The input string is " + str); 
	        int len = longestUniqueSubsttr(str); 
	        System.out.println("The length of "
	                           + "the longest non repeating character is " + len); 
	}

	private static int longestUniqueSubsttr(String str) {
		
		Set<Character> set = new HashSet<Character>();
		int maxLength = 0;
		int left = 0;
		int right = 0;
		
		while(right < str.length()){
			if(!set.contains(str.charAt(right))){
				set.add(str.charAt(right));
				right++;
				maxLength = Math.max(maxLength, right-left);
			}else{
				set.remove(str.charAt(left));
				left++;
			}
		}
		return maxLength;
		
	}

}

