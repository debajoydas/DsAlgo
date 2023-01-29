/**
 * 
 */
package com.debajoy.ds.heap;

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
	     arr = buildMinHeap(arr, n);
	     arr = heapSort(arr, n);
	     for(int i = arr.length-1; i >= 0; i--){
	    	 System.out.print(arr[i]+" -> ");
	     }
	     
	}

	private static int[] heapSort(int[] arr, Integer n) {
		while( n > 1){
			arr = deleteRoot(arr, n);
			n = n-1;
		}
		return arr;
	}
	
	private static int[] deleteRoot(int[] arr, int n) {
		
		int temp = arr[n-1];
		arr[n-1] = arr[0];
		arr[0] = temp;
		n = n-1;
		return heapifyTopDown(arr, n, 0);
	}

	private static int[] heapifyTopDown(int[] arr, int n, int i) {
		
		while(i < n){
			
			int left = 2*i+1;
			int right = 2*i+2;
			int smallest = i;
			
			if(n == 2){
				if(i < n && left < n && arr[smallest] > arr[left]){
					int temp = arr[left];
					arr[left] = arr[smallest];
					arr[smallest] = temp;
					break;
				}else{
					break;
				}
			}
			
			if(right >= n && left >= n){
				break;
			}
			
			if(i < n && left < n && arr[smallest] < arr[left] && right < n && arr[smallest] < arr[right]){
				break;
			}
			
			if(i < n && left < n && arr[smallest] > arr[left]){
				int temp = arr[left];
				arr[left] = arr[smallest];
				arr[smallest] = temp;
				i = left;			
			}
			if(i < n && right < n && arr[smallest] > arr[right]){
				int temp = arr[right];
				arr[right] = arr[smallest];
				arr[smallest] = temp;
				i = right;	
			}

		}
		
		return arr;
	}

	private static int[] buildMinHeap(int[] arr, Integer n) {
		if(arr == null){
			return null;
		}
		int firstNonLeafElement = ((n-1)-1)/2;
		for(int i = firstNonLeafElement; i >= 0; i--){
			arr = heapifyTopDown(arr, n, i);
		}
		return arr;
	}


}
