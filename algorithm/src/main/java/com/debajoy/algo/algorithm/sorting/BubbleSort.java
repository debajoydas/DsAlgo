/**
 * 
 */
package com.debajoy.algo.algorithm.sorting;

/**
 * @author Debajoy
 *
 */
public class BubbleSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {64, 34, 25, 12, 22, 11, 90}; 
		int n = arr.length;
        bubbleSort(arr, n); 
        System.out.println("Sorted array"); 
        printArray(arr); 
	}

	private static void printArray(int[] arr) {
		// TODO Auto-generated method stub
		for(int i : arr){
			System.out.print(i+" -> ");
		}
		
	}

	private static void bubbleSort(int[] arr, int n) {
		// TODO Auto-generated method stub
		if(arr == null){
			return;
		}
		for(int i = 0; i < (n-1); i++){
			for(int j = 0; j <(n-i-1); j++){
				if(arr[j] > arr[j+1]){
					arr[j] = arr[j]+arr[j+1];
					arr[j+1] = arr[j]-arr[j+1];
					arr[j] = arr[j]-arr[j+1];
				}
			}
		}
	}

}
