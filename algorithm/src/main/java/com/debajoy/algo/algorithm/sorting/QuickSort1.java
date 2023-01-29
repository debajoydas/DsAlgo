/**
 * 
 */
package com.debajoy.algo.algorithm.sorting;

/**
 * @author Debajoy
 *
 */
public class QuickSort1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub1
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

	private static void quickSort(int[] arr, int lb, int ub) {
		// TODO Auto-generated method stub
		if(arr == null){
			return;
		}
		if(lb < ub){
			int partition = partitionUtil(arr, lb, ub);
			quickSort(arr, lb, partition-1);
			quickSort(arr, partition+1, ub);
		}
	}

	private static int partitionUtil(int[] arr, int lb, int ub) {
		// TODO Auto-generated method stub
		int start = lb;
		int end = ub;
		int pivot = arr[lb];
		while(arr[start] <= pivot){
			if(start == end){
				start--;
				break;
			}
			start++;
		}
		while(arr[end] > pivot){
			if(end == start){
				end++;
				break;
			}
			end--;
		}
		if(start < end){
			arr[start] = arr[start]+arr[end];
			arr[end] = arr[start]-arr[end];
			arr[start] = arr[start]-arr[end];
		}	
		arr[lb] = arr[lb]+arr[end];
		arr[end] = arr[lb]-arr[end];
		arr[lb] = arr[lb]-arr[end];
		return end;
	}
}
