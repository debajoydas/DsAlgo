/**
 * 
 */
package com.debajoy.algo.algorithm.twopointer;

import java.util.Stack;

/**
 * @author Debajoy
 *
 */
public class ReverseWordsInString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "a good   example";
		System.out.println(reverseWords(s));
	}
		  public static String reverseWords(String s) {
		        int length = s.length();
		        Stack<Character> stack = new Stack<Character>();
		        for(int i = length-1; i >= 0; i--){
		            if(s.charAt(i) == ' '){
		            	if(stack.size() > 0){
		                    while(stack.size() > 0){
			                    s = s + stack.pop();
			                }
		                    s += " ";
		            	}
		            }else{
		            	stack.push(s.charAt(i));
		            }
		        }
		        while(stack.size() > 0){
	                s = s + stack.pop();
	            }
		        return s.substring(length,s.length());
		    }
}
