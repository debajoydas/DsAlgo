/**
 * 
 */
package com.debajoy.ds.heap;

import java.util.Arrays;
import java.util.Locale.LanguageRange;
import java.util.stream.Stream;

/**
 * @author Debajoy
 *
 */
public class MinHeaps {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
        // Array representation of Max-Heap
        //     10
        //    /  \
        //   20   15
        //  / \	  / \
        // 30 28 16  17
		//
		// delete node - 30
  /*      int arr[] = { 10, 20, 15, 30, 28, 16, 17 };
        Integer n = arr.length;
        int deleteNode = 30;
        int length = deleteNode(arr,n, deleteNode);
        printArray(arr,length);
        
        */
	}
	
	private static void printArray(int[] arr, int length) {
		// TODO Auto-generated method stub
		for (int i = 0; i < length; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
	}

	private static Integer deleteNode(int[] arr, Integer n, int deleteNode) {
		// TODO Auto-generated method stub
		if(arr == null){
			return null;
		}
		Integer position = Arrays.binarySearch(arr,deleteNode);
		if(position == null){
			return null;
		}
		arr[position] = Integer.MIN_VALUE;
		int index = position;
		while(index > 0){
			int prev = index;
			index = (index - 1)/2;
			int temp = arr[prev];
			arr[prev] = arr[index];
			arr[index] = temp;		
		}
		arr[0] = arr[n-1];
		n = n-1;
		heapify(arr, n , 0);
		return n;
	}
	
	private static Integer deleteRoot(int[] arr, int n) {
		// TODO Auto-generated method stub
		if(arr == null){
			return null;
		}
		int smallest = arr[n-1];
		arr[0] = smallest;
		n = n-1;
		heapify(arr, n, 0);
		return smallest;
	}

	private static void heapify(int[] arr, Integer n, int i) {
		
		int smallest = i;
		int left = 2*i+1;
		int right = 2*i+2;
		
		if(left < n && arr[left] < arr[smallest]){
			smallest = left;
		}
		if(right < n && arr[right] < arr[smallest]){
			smallest = right;
		}
		if(smallest != i){
			int temp = arr[i];
			arr[i] = arr[smallest];
			arr[smallest] = temp;
			heapify(arr, n, smallest);		
		}
	}

	
	private static void heapifyTopDown(int arr[], int n, int i)  {
	      // Your Code Here
		int parent = i;
		int left = 2*i+1;
		int right = 2*i+2;
		if(left >= n && right >= n){
			return;
		}
		if(left < n && arr[left] < arr[parent]){
			int temp = arr[parent];
			arr[parent] = arr[left];
			arr[left] = temp;
			heapifyTopDown(arr, left, n);
		}
		if(right < n && arr[right] < arr[parent]){
			int temp = arr[parent];
			arr[parent] = arr[right];
			arr[right] = temp;
			heapifyTopDown(arr, right, n);
		}
		if(left < n && arr[left] > arr[parent] && right < n && arr[right] > arr[parent]){
			return;
		}
	}

}
