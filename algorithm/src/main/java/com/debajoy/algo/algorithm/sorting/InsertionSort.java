/**
 * 
 */
package com.debajoy.algo.algorithm.sorting;

import java.util.Arrays;

/**
 * @author Debajoy
 *
 */
public class InsertionSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {15,14,12,10,7,6,5,4,3,2,1};
		int n = arr.length;
		insertionSort(arr, n);
		print(arr);
		System.out.println();
		int arr1[] = {15,14,12,10,7,6,5,4,3,2,1};
		int n1 = arr1.length;
		insertionSortOptimized(arr1, n1);
		print(arr1);
	}

	private static void print(int[] arr) {
		// TODO Auto-generated method stub
		for(int i : arr){
			System.out.print(i+" -> ");
		}
		
	}

	private static void insertionSort(int[] arr, int n) {
		// TODO Auto-generated method stub
		int count = 0;
		for(int i = 1; i < n; i++){
			int key = arr[i];
			for(int j = 0; j < i; j++){
				if(key < arr[j]){
					for(int k = i; k > j; k--){
						arr[k] = arr[k-1];
						count++;
					}
					arr[j] = key;
					break;
				}
			}
		}
		System.out.println(count);
	}
	
	private static void insertionSortOptimized(int[] arr, int n) {
		int count = 0;
		for(int i = 1; i < n; i++){
			for(int j = i-1; j >=0; j--){
				if(arr[j+1] < arr[j]){
					int temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
					count++;
				}else{
					break;
				}
			}
		}
		System.out.println(count);
	}

}
