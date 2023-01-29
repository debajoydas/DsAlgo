/**
 * 
 */
package com.debajoy.algo.algorithm.sorting;

/**
 * @author Debajoy
 *
 */
public class QuickSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {10, 7, 8, 9, 1, 5}; 
        int n = arr.length; 
        quickSort(arr, 0, n-1); 
        System.out.println("sorted array"); 
        printArray(arr); 
	}

	private static void printArray(int[] arr) {
		// TODO Auto-generated method stub
		 int n = arr.length; 
	        for (int i=0; i<n; ++i) 
	            System.out.print(arr[i]+" "); 
	        System.out.println(); 
	}

	private static void quickSort(int[] arr, int low, int high) {
		// TODO Auto-generated method stub
		if(low < high){
			int position = partition(arr,low,high);
			quickSort(arr, low, position);
			quickSort(arr, position+1, high);
			
		}
		
	}

	private static int partition(int[] arr, int low, int high) {
		// TODO Auto-generated method stub
		int pivot = arr[low];
		int i  = low-1;
		int j = high;
		
		while(i < j){
			do{
				i++;
				
			}while(arr[i] <= pivot);
			
			do{
				j--;
			}while(arr[j] >= pivot);
			
			if(i < j){
				arr[i] = arr[i] + arr[j];
				arr[j] = arr[i] - arr[j];
				arr[i] = arr[i] - arr[j];	
			}
		}
		arr[low] = arr[low] + arr[j];
		arr[j] = arr[low] - arr[j];
		arr[low] = arr[low] - arr[j];
		
		return j;
	}

}
