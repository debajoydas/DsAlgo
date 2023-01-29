/**
 * 
 */
package com.debajoy.algo.algorithm.recursion;

/**
 * @author Debajoy
 *
 */
public class HouseThief {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[] wealth = {2, 5, 1, 3, 6, 2, 4};
		 System.out.println(findMaxSteal(wealth));
		 wealth = new int[]{2, 10, 14, 8, 1};
		 System.out.println(findMaxSteal(wealth));
	}

	private static int findMaxSteal(int[] wealth) {
		// TODO Auto-generated method stub
		if(wealth == null || (wealth != null && wealth.equals(""))){
			return 0;
		}
		return Math.max(findMaxStealRecursion(wealth, 0), findMaxStealRecursion(wealth, 1));
	}

	private static int findMaxStealRecursion(int[] wealth, int index) {
		// TODO Auto-generated method stub
		if(index >= wealth.length){
			return 0;
		}
		return Math.max(wealth[index] + findMaxStealRecursion(wealth, index+2), wealth[index] + findMaxStealRecursion(wealth, index+3));
	}

}
