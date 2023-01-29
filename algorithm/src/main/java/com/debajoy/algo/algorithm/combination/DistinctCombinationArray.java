/**
 * 
 */
package com.debajoy.algo.algorithm.combination;

/**
 * @author Debajoy
 *
 */
public class DistinctCombinationArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 2 , 3 , 4 , 5};
		int r = 3;
		computeAllCombination(arr,r);
	}

	private static void computeAllCombination(int[] arr, int r) {
		// TODO Auto-generated method stub
		int index = 0; int k = 0;
		int[] data = new int[r];
		recurCombination(arr,r,index,k,data);
	}

	private static void recurCombination(int[] arr, int r, int index, int k, int[] data) {
		
	}	

}
