/**
 * 
 */
package com.debajoy.algo.algorithm.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Debajoy
 *
 */
public class EqualSubsetSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1, 2, 3, 4, 10};
		int n = num.length;
		System.out.println(findEqualSubsetSum(num, n));
	}

	private static boolean findEqualSubsetSum(int[] num, int n) {
		// TODO Auto-generated method stub
		List<Integer> subset = new ArrayList<Integer>();
		int subsetSum = (Arrays.stream(num).sum())/2;
		int index = -1;
		return findEqualSubsetSumRecursion(index,subset,subsetSum,num);
	}

	private static boolean findEqualSubsetSumRecursion(int index, List<Integer> subset, int subsetSum, int[] num) {
		// TODO Auto-generated method stub
		
		if(subset.stream().mapToInt(Integer::intValue).sum() == subsetSum){
			return true;
		}
		
		if(index >= num.length-1){
			return false;
		}else{
			index += 1;
			List<Integer> subset1 = new ArrayList<>(subset);
			List<Integer> subset2 = new ArrayList<>(subset);
			boolean b1 = findEqualSubsetSumRecursion(index, subset1, subsetSum, num);
			subset2.add(num[index]);
			boolean b2 = findEqualSubsetSumRecursion(index, subset2, subsetSum, num);
			if(b1 || b2){
				return true;
			}else{
				return false;
			}
		}
	}	

}
