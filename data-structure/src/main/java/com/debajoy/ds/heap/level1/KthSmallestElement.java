/**
 * 
 */
package com.debajoy.ds.heap.level1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Debajoy
 *
 */
public class KthSmallestElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
		int k = 6;
		System.out.println(kthSmallest(matrix, k));
	}
	
	public static int kthSmallest(int[][] matrix, int k) {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				queue.add(matrix[i][j]);
			}
		}
		while(k > 1 && queue.size() > 0){
			queue.poll();
			k--;
		}
		if(queue.size() > 0){
			return queue.peek();
		}else{
			return 0;
		}
	}

}

class MaxValue{

	public MaxValue(int max, int i, int j) {
		super();
		this.max = max;
		this.i = i;
		this.j = j;
	}
	int max;
	int i;
	int j;
}