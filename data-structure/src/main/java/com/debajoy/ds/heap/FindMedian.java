/**
 * 
 */
package com.debajoy.ds.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Debajoy
 *
 */
public class FindMedian {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		int[] arr = {5,15,1,3};
		int[] result = findMedian(arr,n);
		for(int i : result){
			System.out.println(i);
		}
	}

	private static int[] findMedian(int[] arr, int n) {
		// TODO Auto-generated method stub
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		int[] medianArray = new int[n];
		int median = 0;
		int sum = 0;
		for(int i = 0; i< n; i++){
			queue.add(arr[i]);
			sum += arr[i];
			if(queue.size()%2 == 0){
				medianArray[i] = sum/queue.size();
			}else{
				median = (queue.size()-1)/2;
				int index = 0;
				PriorityQueue<Integer> queTemp = new PriorityQueue<Integer>();
				while(index < median){
					queTemp.add(queue.poll());
					index++;
				}
				medianArray[i] = queue.poll();
				queTemp.add(medianArray[i]);
				queue.addAll(queTemp);		
			}
		}
		
		return medianArray;
	}

}
