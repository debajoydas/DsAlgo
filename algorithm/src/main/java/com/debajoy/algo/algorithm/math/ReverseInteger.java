/**
 * 
 */
package com.debajoy.algo.algorithm.math;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Debajoy
 *
 */
public class ReverseInteger {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*		System.out.println(reverse(-1230));
    	System.out.println(reverse(230));
		System.out.println(reverse(123012));
		System.out.println(reverse(1534236469));
		System.out.println(reverse(30012301));*/
		
		System.out.println(reverse(1563847412));
	}
	
    public static int reverse(int x) {
    	Integer temp = Math.abs(x);
    	Double BIG_VALUE = Math.pow(2, 31);
    	BigInteger BIG = BigInteger.valueOf(BIG_VALUE.longValue());
    	if(Double.valueOf(temp) > Math.pow(2, 31)){
    		return 0;
    	}
    	BigInteger output = BigInteger.ZERO;
    	while(temp > 0){
    		int pow = (int) Math.pow(10, getIntLength(temp)-1);
    		int frac = temp%10;
    		BigInteger mutiply = BigInteger.valueOf(pow).multiply(BigInteger.valueOf(frac));
    		output = output.add(mutiply);
    		if(output.compareTo(BIG) > 0){
    			return 0;
    		}
    		temp = temp/10;		
    	}
    	return (x >= 0 ? output.intValue():(BigInteger.ZERO.subtract(output)).intValue());
    }
    
    private static int getIntLength(int num){
    	return Integer.toString(num).length();
    }

}
