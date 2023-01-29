/**
 * 
 */
package com.debajoy.algo.algorithm.sorting;

/**
 * @author Debajoy
 *
 */
public class BubbleSortNew {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {64, 34, 25, 12, 22, 11, 5, 34, 64, 90}; 
		int n = arr.length;
        bubbleSort(arr, n); 
        System.out.println("Sorted array"); 
        printArray(arr); 
	}
	
	private static void bubbleSort(int[] arr, int n) {
		// TODO Auto-generated method stub
		int scan_index = (n-1);
		while(scan_index > 1){
			for(int i = 0; i < scan_index; i++){
				if(arr[i] > arr[i+1]){
					arr[i] = arr[i] + arr[i+1];
					arr[i+1] = arr[i] - arr[i+1];
					arr[i] = arr[i] - arr[i+1];
				}
			}
			scan_index--;
		}
	}

	private static void printArray(int[] arr) {
		// TODO Auto-generated method stub
		for(int i : arr){
			System.out.print(i+" -> ");
		}
		
	}

}
