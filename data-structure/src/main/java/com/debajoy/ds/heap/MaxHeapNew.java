/**
 * 
 */
package com.debajoy.ds.heap;

/**
 * @author Debajoy
 *
 */
public class MaxHeapNew {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17};
        Integer n = arr.length;
        System.out.println("Before Heap Creation :=>");
        printArray(arr);
        createMaxHeap(arr,n);
        System.out.println("After Heap Creation :=>");
        printArray(arr);
        heapSort(arr, n);
        System.out.println("After Heap Sorting :=>");
        printArray(arr);

	}
	
	private static void heapSort(int[] arr, int n){
		for(int i = 0; i < n; i++){
			deleteRoot(arr, n-i);
		}
	}
	
	private static void deleteRoot(int[] arr, int n){
		int temp = arr[0];
		arr[0] = arr[n-1];
		arr[n-1] = temp;
		n = n-1;
		heapifyTopDown(0, n, arr);
		
	}
	
	private static void createMaxHeap(int[] arr, Integer n) {
		// TODO Auto-generated method stub
		int lastNonLeaf = (n-2)/2;
		for(int i = lastNonLeaf; i >= 0; i--){
			heapifyTopDown(i, n, arr);
		}
		
	}

	private static void heapifyTopDown(int i, int n, int[] arr){
		int l = 2*i+1;
		int r = 2*i+2;
		int largest = i;
		if(l < n && arr[largest] < arr[l]){
			largest = l;
		}
		if(r < n && arr[largest] < arr[r]){
			largest = r;
		}
		if(largest != i){
			int temp = arr[largest];
			arr[largest] = arr[i];
			arr[i] = temp;
			heapifyTopDown(largest, n, arr);
		}
	}
	
	private static void printArray(int[] arr) {
		// TODO Auto-generated method stub
		for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
	}

}
