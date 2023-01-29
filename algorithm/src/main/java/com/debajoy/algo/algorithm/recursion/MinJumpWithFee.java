/**
 * 
 */
package com.debajoy.algo.algorithm.recursion;

/**
 * @author Debajoy
 *
 */
public class MinJumpWithFee {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] fee = {1,2,5,2,1,2};
	    System.out.println(findMinFee(fee));
	    fee = new int[]{2,3,4,5};
	    System.out.println(findMinFee(fee));
	}

	private static int findMinFee(int[] fee) {
		// TODO Auto-generated method stub
		if(fee == null || (fee != null && fee.length <= 0)){
			return 0;
		}else if(fee != null && fee.length ==1){
			return 0;
		}
		int index = 0;
		return findMinFeeRecursion(fee, index);
	}

	private static int findMinFeeRecursion(int[] fee, int index) {
		// TODO Auto-generated method stub
		if(index > (fee.length-1)){
			return 0;
		}
		int c1 = fee[index]+findMinFeeRecursion(fee, index+1);
		int c2 = fee[index]+findMinFeeRecursion(fee, index+2);
		int c3 = fee[index]+findMinFeeRecursion(fee, index+3);
		int c = Math.min(c1, c2);
		return Math.min(c, c3);
	}

}
