/**
 * 
 */
package com.debajoy.ds.heap;

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
        n = deleteRoot(arr,n);
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
		if(arr == null){
			return null;
		}
		int lastNonLeaf = ((n-1)-1)/2;
		for(int i = lastNonLeaf; i >= 0; i--){
			int parent = i;
			heapifyTopDown(arr,i, n);
		}
		return arr;
	}

	private static void heapifyTopDown(int[] arr, int i, int n) {
		int parent = i;
		int left = 2*i+1;
		int right = 2*i+2;
		if(left >= n && right >= n){
			return;
		}
		if(left < n && arr[left] > arr[parent]){
			int temp = arr[parent];
			arr[parent] = arr[left];
			arr[left] = temp;
			heapifyTopDown(arr, left, n);
		}
		if(right < n && arr[right] > arr[parent]){
			int temp = arr[parent];
			arr[parent] = arr[right];
			arr[right] = temp;
			heapifyTopDown(arr, right, n);
		}
		if(left < n && arr[left] < arr[parent] && right < n && arr[right] < arr[parent]){
			return;
		}
		
	}

	private static void printArray(int[] arr) {
		// TODO Auto-generated method stub
		for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
	}

	private static Integer deleteRoot(int[] arr, int n) {
		// TODO Auto-generated method stub
		if(arr == null){
			return null;
		}
		int largest = arr[n-1];
		arr[0] = largest;
		n = n-1;
		heapify(arr, n, 0);
		return n;
	}
	
	/*
	 * Delete non-root elements
	 */
	private static Integer deleteNonRootElement(int[] arr, int n) {
		return n;
	}

	private static void heapify(int[] arr, int n, int i) {
		// TODO Auto-generated method stub
		int largest = i;
		int left = 2*i + 1;
		int right = 2*i + 2;
		
		if(left < n && arr[left] > arr[i]){
			largest = left;
		}
		if(right < n && arr[right] > arr[i]){
			largest = right;
		}
		if(largest != i){
			int temp  = arr[largest];
			arr[largest] = arr[i];
			arr[i] = temp;
			heapify(arr, n, largest);
		}
	}
	
	public static int[] insert(int[] arr, int n, int element){
		if(arr == null){
			return null;
		}
		n += 1;
		int[] arrNew = resizeArray(arr);
		arrNew[n-1] = element;
		return heapifyBottomsUp(arrNew, n, n-1);
	}

	private static int[] resizeArray(int[] arr) {
		// TODO Auto-generated method stub
		return Arrays.copyOf(arr, arr.length+1);
	}

	private static int[] heapifyBottomsUp(int[] arr, int n, int i) {
		// TODO Auto-generated method stub
		int largest = i;
		int parent = (i-1)/2;
		if(parent <= 0){
			if(arr[largest] > arr[parent]){
				int temp  = arr[largest];
				arr[largest] = arr[parent];
				arr[parent] = temp;
				return arr;
			}else{
				return arr;
			}
		}
		else{
			if(arr[largest] > arr[parent]){
				int temp  = arr[largest];
				arr[largest] = arr[parent];
				arr[parent] = temp;
				heapifyBottomsUp(arr, n, parent);
			}else{
				return arr;
			}
		}
		return arr;
	}

}
