/**
 * 
 */
package com.debajoy.algo.algorithm.math;

/**
 * @author Debajoy
 *
 */
public class LuckyNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 19;
        if( isLucky(x) )
            System.out.println(x+" is a lucky no.");
        else
            System.out.println(x+" is not a lucky no.");
	}

	private static boolean isLucky(int x) {
		// TODO Auto-generated method stub
		int i = 2;
		while(x >= i && x%i != 0){
			x -= x/i;
			i++;
		}
		if(x >= i && x%i ==0){
			return false;
		}
		return true;
	}

}
