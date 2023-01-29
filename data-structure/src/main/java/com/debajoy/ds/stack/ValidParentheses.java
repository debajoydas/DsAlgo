/**
 * 
 */
package com.debajoy.ds.stack;

import java.util.Stack;

/**
 * @author Debajoy
 *
 */
public class ValidParentheses {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(isValid(")(){}"));
	}
	
    public static boolean isValid(String s) {
    	char endBrac1 = ')';
    	char endBrac2 = '}';
    	char endBrac3 = ']';
    	char startBrac1 = '(';
    	char startBrac2 = '{';
    	char startBrac3 = '[';
    	Stack<Character> stack = new Stack<>();
    	if(s == null || (s != null && s.length() <= 0)){
    		return true;
    	}else if(s != null && s.length() == 1){
    		return false;
    	}
    	else{
    		for(int i = 0; i< s.length(); i++){
    			if(s.charAt(i) != endBrac1 && s.charAt(i) != endBrac2 && s.charAt(i) != endBrac3){
    				stack.push(s.charAt(i));
    			}else{
    				if(stack.size() > 0){
        				char popped = stack.pop();
        				if(popped == startBrac1 && s.charAt(i) != endBrac1){
        					return false;
        				}else if(popped == startBrac2 && s.charAt(i) != endBrac2){
        					return false;
        				}else if(popped == startBrac3 && s.charAt(i) != endBrac3){
        					return false;
        				}
    				}else{
    					return false;
    				}
    			}
    		}
    		if(stack.size() > 0){
    			return false;
    		}
    	}
		return true; 
    }

}
