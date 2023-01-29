/**
 * 
 */
package com.debajoy.algo.algorithm.math;

/**
 * @author Debajoy
 * Efficient program to print all prime factors of a given number
Difficulty Level : Easy
 Last Updated : 20 Aug, 2019
Given a number n, write an efficient function to print all prime factors of n. For example, if the input number is 12, then output should be “2 2 3”. And if the input number is 315, then output should be “3 3 5 7”.
 *
 */
public class PrimeFactor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 17; 
        primeFactors(n);
	}

	private static void primeFactors(int n) {
		// TODO Auto-generated method stub
		for(int i =2; i <= n; i++){
			if(n%i == 0){
				while(n%i == 0){
					n = n/i;
					System.out.println(i);
				}
			}
		}
	}

}
