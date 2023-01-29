/**
 * 
 */
package com.debajoy.algo.algorithm.sorting;

/**
 * @author Debajoy
 *
 */
public class SelectionSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {64, 34, 25, 12, 22, 11, 90}; 
		int n = arr.length;
        selectionSort(arr, n); 
        System.out.println("Sorted array"); 
        printArray(arr); 
	}
	
	private static void selectionSort(int[] arr, int n) {
		// TODO Auto-generated method stub
		if(arr == null){
			return;
		}
		for(int i = 0; i < n; i++){
			int min = n+3;
			for(int j = i; j < n; j++){
				if(min > n){
					min = j;
				}else if(arr[j] < arr[min]){
					min = j;
				}
			}
			if(i != min){
				arr[i] = arr[i]+arr[min];
				arr[min] = arr[i]-arr[min];
				arr[i] = arr[i]-arr[min];
			}
		}
		
	}

	private static void printArray(int[] arr) {
		// TODO Auto-generated method stub
		 int n = arr.length; 
	        for (int i=0; i<n; ++i) 
	            System.out.print(arr[i]+" "); 
	        System.out.println(); 
	}

}
