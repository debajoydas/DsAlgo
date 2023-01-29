/**
 * 
 */
package com.debajoy.algo.algorithm.recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Debajoy
 *
 */
public class MinimumNoJump {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		int n = arr.length;
		System.out.println(getMinimumNoOfJump(arr,n));
		
		int arr1[] = {1, 2, 3, 1, 4, 2, 1, 2, 1, 2, 1, 2, 1, 1, 1, 2};
		int n1 = arr1.length;
		System.out.println(getMinimumNoOfJump(arr1,n1));
		
		int arr2[] = {1, 3, 6, 3, 2, 3, 6, 8, 9, 5};
		int n2 = arr2.length;
		System.out.println(getMinimumNoOfJump(arr2,n2));
		
		int arr3[] = {1, 2, 1, 1, 1, 2, 1, 1, 1, 4, 1, 1, 9, 1, 2, 1, 1, 1};
		int n3 = arr3.length;
		System.out.println(getMinimumNoOfJump(arr3,n3));

	}
	

	private static int getMinimumNoOfJump(int[] arr, int n) {
		// TODO Auto-generated method stub
		List<Integer> results = new ArrayList<Integer>();
		if(arr == null){
			return 0;
		}
		if(arr != null && arr.length == 1){
			return 0;
		}else if(arr != null && arr.length == 2){
			return 1;
		}
		List<Integer> list = new ArrayList<Integer>();
		list.add(arr[0]);
		getMinimumNoOfJumpRec(arr,list, 0, results);
		results.forEach(s -> System.out.print(s+"->"));
		System.out.println();
		return results.size()-1>=0?results.size()-1:0;
	}


	private static void getMinimumNoOfJumpRec(int[] arr, List<Integer> list, int index, List<Integer> results) {
		// TODO Auto-generated method stub
		if(index >= arr.length-1){
			list.add(arr[arr.length-1]);
			if(results.size() > 0){
				if(results.size() >= list.size()){
					results.clear();
					results.addAll(list);
				}
			}else{
				if(list.size() > 0){
					results.addAll(list);
				}			
			}
		}else{
				if(index > 0){
					list.add(arr[index]);
				}	
				LinkedList<Integer>[] arrayOffList = new LinkedList[arr[index]];
				for(int i = 0; i< arr[index]; i++){
					arrayOffList[i] = new LinkedList<>(list);
				}
				for(int i = 0; i< arr[index]; i++){				
					getMinimumNoOfJumpRec(arr, arrayOffList[i], index+i+1, results);
				}
		}
	}

}
