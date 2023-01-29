/**
 * 
 */
package com.debajoy.algo.algorithm.sorting;

/**
 * @author Debajoy
 *
 */
public class InsertionSortNew {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {64, 34, 25, 12, 22, 11, 5, 34, 64, 90};
		int n = arr.length;
		insertionSort(arr, n);
		print(arr);
	}
	
	private static void insertionSort(int[] arr, int n) {
		// TODO Auto-generated method stub
		int ce = arr[0];
		int ceIdx = 0;
		int rIdx = 0;
		for(int i = 1; i< n ; i++){
			ce = arr[i];
			ceIdx = i;
			rIdx = i;
			for(int j = 0; j<i; j++){
				if(arr[j] > arr[i]){
					ce = arr[i];
					ceIdx = i;
					rIdx = j;
					break;
				}
			}
			if(ceIdx != rIdx){
				for(int k = ceIdx ; k > rIdx; k--){
					arr[k] = arr[k-1];
				}
				arr[rIdx] = ce;
			}
		}
	}

	private static void print(int[] arr) {
		// TODO Auto-generated method stub
		for(int i : arr){
			System.out.print(i+" -> ");
		}	
	}

}
