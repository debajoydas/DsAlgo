/**
 * 
 */
package com.debajoy.algo.algorithm.combination;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Debajoy
 *
 */
public class SubSequenceCombination {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {1, 2 , 3, 4 };
		int size = arr.length;
		int count = 0;
		List<Integer> list = new ArrayList<Integer>();
		List<Integer> listResult = computeAllCombination(arr,size, list, count);
		listResult.forEach(value -> System.out.println(value));
		System.out.println("total count of subsequence combination is : "+listResult.size());
	}

	private static List<Integer> computeAllCombination(int[] arr, int n, List<Integer> list, int count) {
		// TODO Auto-generated method stub
		if( n == 0){
			return list;
		}
		List<Integer> tempList  = new ArrayList<Integer>();
		tempList.add(arr[n-1]);
		if(list != null && list.size() > 0){
			for(int item: list){
				tempList.add(Integer.parseInt(String.valueOf(arr[n-1])+String.valueOf(item)));
				tempList.add(item);
			}
		}
		count += tempList.size();
		return computeAllCombination(arr, n-1, tempList, count);
	}
}
