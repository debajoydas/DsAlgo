/**
 * 
 */
package com.debajoy.algo.algorithm.sorting;

/**
 * @author Debajoy
 *
 */
public class MergeSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {10, 7, 8, 9, 1, 5}; 
        int n = arr.length; 
        mergeSort(arr, n); 
        System.out.println("sorted array"); 
        printArray(arr); 
	}
	
	private static void mergeSort(int[] arr, int n) {
		// TODO Auto-generated method stub
		int l = 0;
		int r = n-1;
		if(l < r){
			mergeSortUtil(arr,l,r);
		}
	}

	private static void mergeSortUtil(int[] arr, int l, int r) {
		// TODO Auto-generated method stub
		if(l < r){
			int mid = (l+r)/2;
			mergeSortUtil(arr, l, mid);
			mergeSortUtil(arr, mid+1, r);
			merging(arr,l,mid,r);
		}
	}

	private static void merging(int[] arr, int l, int m, int r) {
		// TODO Auto-generated method stub
		int index1 = l;
		int index2 = m+1;
		int[] arrTemp = new int[r-l+1];
		int temp = 0;
		
		while(index1 <= m && index2 <= r){
			if(arr[index1] <= arr[index2]){
				arrTemp[temp] = arr[index1];
				temp++;index1++;
			}else{
				arrTemp[temp] = arr[index2];
				temp++;index2++;
			}
		}
		if(index1 <= m){
			while(index1 <= m){
				arrTemp[temp] = arr[index1];
				temp++;index1++;
			}
		}
		if(index2 <= r){
			while(index2 <= 2){
				arrTemp[temp] = arr[index2];
				temp++;index2++;
			}
		}
		int iNew = l;
		temp = 0;
		while(iNew <= r){
			arr[iNew] = arrTemp[temp];
			iNew++;temp++;
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
