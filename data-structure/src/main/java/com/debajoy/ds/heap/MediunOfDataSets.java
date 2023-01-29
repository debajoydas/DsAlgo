/**
 * 
 */
package com.debajoy.ds.heap;

import java.util.PriorityQueue;

/**
 * @author Debajoy
 *
 */
public class MediunOfDataSets {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3 ,5, 4, 2, 9, 6, 11, 22};
		int n = arr.length;
		System.out.println(getMediun(arr,n));
	}

	private static double getMediun(int[] arr, int n) {
		// TODO Auto-generated method stub
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		for(int i : arr){
			queue.add(i);
		}
		double med = 0;
		if(n%2 != 0){
			int pos = n/2;
			while(pos > 0){
				queue.poll();
				pos--;
			}
			med = queue.poll();
		}else{	
			int pos = n/2;
			while(pos > 1){
				queue.poll();
				pos--;
			}
			med = queue.poll();
			Integer medNew;
			if((medNew = queue.poll()) != null){
				med = (med+medNew)/2;
			}
		}
		return med;
	}

}
