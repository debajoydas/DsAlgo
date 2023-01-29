/**
 * 
 */
package com.debajoy.ds.heap.level1;

import java.util.Arrays;

/**
 * @author Debajoy
 *
 */
public class MaxHeaps {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // Array representation of Max-Heap
        //     10
        //    /  \
        //   5    3
        //  / \
        // 2   4
        int arr[] = { 10, 5, 3, 2, 4 };
        Integer n = arr.length;
        deleteRoot(arr,n);
        printArray(arr);
        
        
        int arr1[] = { 10, 5, 3, 2, 4 };
        Integer n1 = arr1.length;
        int[] arrayExtended = insert(arr1,n1,15);
        printArray(arrayExtended);
        
        int arr2[] = { 4, 10, 3, 5, 1 };
        Integer n2 = arr2.length;
        int[] maxHeap = createMaxHeap(arr2, n2);
        printArray(maxHeap);
        
        int arr3[] = {1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17};
        Integer n3 = arr3.length;
        int[] maxHeap1 = createMaxHeap(arr3, n3);
        printArray(maxHeap1);
	}
	
	private static int[] createMaxHeap(int[] arr, Integer n) {
		// TODO Auto-generated method stub
		int lastNonLeafIdx = (n-2)/2;
		for(int i = lastNonLeafIdx; i >= 0; i--){
			heapifyTopDown(arr, n, i);
		}
		return arr;
	}

	private static int[] insert(int[] arr, Integer n, int element) {
		// TODO Auto-generated method stub
		int[] arrNew = Arrays.copyOf(arr, n+1);
		n += 1;
		arrNew[n-1] = element;
		heapifyBottomsUp(arrNew,n,n-1);
		return arrNew;
	}

	private static void heapifyBottomsUp(int[] arr, Integer n, int i) {
		// TODO Auto-generated method stub
		int parent = (i-1)/2;
		if(parent >= 0){
			if(arr[i] > arr[parent]){
				int temp = arr[i];
				arr[i] = arr[parent];
				arr[parent] = temp;
				heapifyBottomsUp(arr, n, parent);
			}
		}	
	}

	private static void deleteRoot(int[] arr, Integer n) {
		// TODO Auto-generated method stub
		int temp = arr[0];
		arr[0] = arr[n-1];
		arr[n-1] = temp;
		n -= 1;
		heapifyTopDown(arr,n,0);
	}

	private static void heapifyTopDown(int[] arr, Integer n, int i) {
		// TODO Auto-generated method stub
		int largest = i;
		int l = 2*i+1;
		int r = 2*i+2;
		if(l < n && arr[l] > arr[largest]){
			largest = l;
		}
		if(r < n && arr[r] > arr[largest]){
			largest = r;
		}
		if(largest != i){
			int temp = arr[largest];
			arr[largest] = arr[i];
			arr[i] = temp;
			heapifyTopDown(arr, n, largest);
		}
	}

	private static void printArray(int[] arr) {
		// TODO Auto-generated method stub
		for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
	}

	

}
