/**
 * 
 */
package com.debajoy.algo.algorithm.recursion;

import java.util.Arrays;

/**
 * @author Debajoy
 *
 */
public class EqualSubsetSumWithoutExtraSpace {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] num = {1, 2, 3, 4, 19};
		int n = num.length;
		System.out.println(findEqualSubsetSum(num, n));
	
	}

	private static boolean findEqualSubsetSum(int[] num, int n) {
		// TODO Auto-generated method stub
		int index = 0;
		int subSetSum =  (Arrays.stream(num).sum())/2;
		return findEqualSubsetSumRec(index, subSetSum,num);
	}

	private static boolean findEqualSubsetSumRec(int index, int subSetSum, int[] num) {
		// TODO Auto-generated method stub
		if(subSetSum == 0){
			return true;
		}
		if(index >= num.length){
			return false;
		}
		if(num[index] <= subSetSum){
			if(findEqualSubsetSumRec(index+1, subSetSum - num[index], num)){
				return true;
			}
		}
		return findEqualSubsetSumRec(index+1, subSetSum, num);
	}

}
