/**
 * 
 */
package com.debajoy.algo.algorithm.sorting;

/**
 * @author Debajoy
 *
 */
public class SelectionSortNew {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {64, 34, 25, 12, 22, 11, 5, 34, 64, 90}; 
		int n = arr.length;
        selectionSort(arr, n); 
        System.out.println("Sorted array"); 
        printArray(arr); 
	}
	
	private static void selectionSort(int[] arr, int n) {
		// TODO Auto-generated method stub
		int remaining_index = 0;
		int min = 0;
		int min_Index = 0;
		while(remaining_index < (n-1)){
			 min = arr[remaining_index];
			 min_Index = remaining_index;
			 for(int i = remaining_index+1; i < n; i++){
				 if(arr[i] < arr[min_Index]){
					 min_Index = i;
					 min = arr[i];
				 }
			 }
			 if(min_Index != remaining_index){
				 arr[min_Index] = arr[min_Index] + arr[remaining_index];
				 arr[remaining_index] = arr[min_Index] - arr[remaining_index];   
				 arr[min_Index] = arr[min_Index] - arr[remaining_index];
			 }
			 remaining_index++;
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
