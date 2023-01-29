/**
 * 
 */
package com.debajoy.algo.algorithm.math;

/**
 * @author Debajoy
 *
 */
public class SquareRoot {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int n = 50;      
        System.out.printf("Square root of " + n + " is " + squareRoot(n));
	}

	private static float squareRoot(int n) {
		// TODO Auto-generated method stub
		float x = n;
		float y = x/n;
		// degree of accuracy level
		double e = 0.000001; 
		while(x-y > e){
			x = (x+y)/2;
			y = n/x;
		}
		return x;
	}

}
