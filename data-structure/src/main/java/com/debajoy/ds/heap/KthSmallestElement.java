/**
 * 
 */
package com.debajoy.ds.heap;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
		int k = 8;
		System.out.println(kthSmallest(matrix, k));
	}
	
	public static int kthSmallest(int[][] matrix, int k) {
		int r = matrix.length;
		int c = matrix[0].length;
		int i = r-1; int j = c-1;
		LinkedList<MaxValue> queue = new LinkedList<>();
		MaxValue max = new MaxValue(matrix[i][j], i, j);
		queue.add(max);
		
		
		while(i >= 0 && j >= 0){
			int size = queue.size();
			if(k <= 1){
				MaxValue polled = queue.poll();
				if(polled != null){
					return polled.max;
				}
			}
			while (size > 0){
				MaxValue polled = queue.poll();
				if(polled.i-1 >= 0 && polled.j-1 >= 0){
					if(matrix[polled.i-1][polled.j] < matrix[polled.i][polled.j-1]){
						j = polled.j-1;
						queue.add(new MaxValue(matrix[polled.i][polled.j-1], polled.i, polled.j-1));
					}else if(matrix[polled.i-1][polled.j] < matrix[polled.i][polled.j-1]){
						i = polled.i-1;
						queue.add(new MaxValue(matrix[polled.i-1][polled.j], polled.i-1, polled.j));
					}else{
						i = polled.i-1;j = polled.j-1;;
						queue.add(new MaxValue(matrix[polled.i][polled.j-1], polled.i, polled.j-1));
						queue.add(new MaxValue(matrix[polled.i-1][polled.j], polled.i-1, polled.j));
					}
				}else if(polled.i-1 >= 0 && polled.j <= 0){
					i = polled.i-1;
					queue.add(new MaxValue(matrix[polled.i-1][polled.j], polled.i-1, polled.j));
				}else if(polled.j-1 >= 0 && polled.i <= 0){
					j = polled.j-1;
					queue.add(new MaxValue(matrix[polled.i][polled.j-1], polled.i, polled.j-1));
				}
				size--;
			}
			k--;
		}

		return 0;
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