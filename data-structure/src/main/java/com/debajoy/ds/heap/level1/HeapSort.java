/**
 * 
 */
package com.debajoy.ds.heap.level1;

import java.util.Arrays;

/**
 * @author Debajoy
 *
 */
public class HeapSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int arr[] = { 17, 10, 13, 8, 5, 20, 12};
	     Integer n = arr.length;
	     heapSort(arr,n);	

//		 int arr[] = {100,60,70,40,15,30,10};
//	     Integer n = arr.length;
//	     int element = 45;
//	     for(int i : arr){
//	    	 System.out.print(i+"->");
//	     }
//	     int[] arrN = insert(arr, n, element);
//	     System.out.println("After inserting element : "+element);
//	     for(int i : arrN){
//	    	 System.out.print(i+"->");
//	     }
	}

	private static void printArray(int[] arr) {
		// TODO Auto-generated method stub
		for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
	}
	
	private static void heapSort(int[] arr, Integer n) {
		System.out.println("Heap Sort-----------");
		// TODO Auto-generated method stub
		int[] maxHeap = buildMaxHeap(arr,n);
		while(n >= 1){
			int temp = maxHeap[n-1];
			maxHeap[n-1] = maxHeap[0];
			maxHeap[0] = temp;
			n = n-1;
			heapify(maxHeap, n, 0);
		}	
		printArray(maxHeap);
	}
	
	private static void deleteRoot(int[] arr, int n){
		int last = arr[0];
		arr[0] = arr[n-1];
		arr[n-1] = last;
		heapify(arr, n-1, 0);
	}
	
	private static int[] buildMaxHeap(int[] arr, int n){
		int lastNonLeaf = (n-2)/2;
		for(int i = lastNonLeaf; i>= 0; i--){
			heapify(arr, n, i);
		}
		return arr;
	}
	
	private static void heapify(int[] arr, int n, int i){
		int largest = i;
		int l = (i*2)+1;
		int r = (i*2)+2;
		
		if(l < n && arr[l] > arr[largest]){
			largest = l;
		}
		if(r < n && arr[r] > arr[largest]){
			largest = r;
		}
		if(largest != i){
			int swap = arr[largest];
			arr[largest] = arr[i];
			arr[i] = swap;
			heapify(arr, n, largest);
		}
	}
	
	private static int[] insert(int[] arr, int n, int element){

		int[] arrNew = resizeArray(arr, element);
		arrNew[n] = element;
		heapifyBottomsUp(arrNew, n+1, n);
		return arrNew;
	}
	
	private static int[] resizeArray(int[] arr, int n){
		// TODO Auto-generated method stub
		return Arrays.copyOf(arr, arr.length+1);
	}
	
	private static void heapifyBottomsUp(int[] arr, int n, int i){
		int p = (i-1)/2;
		if(p >= 0){
			if(arr[p] < arr[i]){
				int temp = arr[i];
				arr[i] = arr[p];
				arr[p] = temp;
				heapifyBottomsUp(arr, n, p);
			}
		}
	}

}
