/**
 * 
 */
package com.debajoy.ds.heap;

/**
 * @author Debajoy
 *
 */
public class SuperUglyNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number =  12;
		int[] primes = {2, 7, 13, 19};
		System.out.println(nthSuperUglyNumber(number,primes));
	}

	private static int nthSuperUglyNumber(int n, int[] primes) {
		// TODO Auto-generated method stub
		int[] uglys = new int[n];
		uglys[0] = 1;
		int[] pointers  = new int[primes.length];
		
		for(int i = 1; i < n; i++){
			int min = Integer.MAX_VALUE;
			for(int prime = 0; prime < primes.length; prime++){
				min = Integer.min(min, primes[prime]*uglys[pointers[prime]]);
			}
			uglys[i] = min;
			for(int prime = 0; prime < primes.length; prime++){
				if(primes[prime]*uglys[pointers[prime]] == min){
					pointers[prime] += 1;
				}
			}
		}
		return uglys[n-1];
	}

}
