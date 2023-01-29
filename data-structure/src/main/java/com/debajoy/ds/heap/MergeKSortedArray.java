/**
 * 
 */
package com.debajoy.ds.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Debajoy
 *
 */
public class MergeKSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arrays = {{1, 2, 3, 4},
					   {2, 2, 3, 4 },
					   {5, 5, 6, 6 },
					   {7, 8, 9, 9}};
		int k = 4;
		System.out.println(mergeKArrays(arrays, k));

	}
	public static ArrayList<Integer> mergeKArrays(int[][] arrays,int k) {
		
		if(arrays == null){
			return null;
		}
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < k; i++){
        	for(int j = 0; j< k ; j++){
        		queue.add(arrays[i][j]);
        	}
        }
        while(queue.size() > 0){
        	list.add(queue.poll());
        }
        return (ArrayList<Integer>) list;     
        
    }
}
