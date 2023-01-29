/**
 * 
 */
package com.debajoy.ds.heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Stream;

/**
 * @author Debajoy
 *
 */
public class DistantBarCodes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1,1,1,1,2,2,3,3};
		int[] barcodesArray = rearrangeBarcodes(array);
		for(int i : barcodesArray){
			System.out.print(i+" -> ");
		}
	}
	
	 public static int[] rearrangeBarcodes(int[] barcodes) {
	        if(barcodes == null){
	        	return null;
	        }
	        int lengthOfBar = barcodes.length;
	        int[] result = new int[lengthOfBar];
	        PriorityQueue<Integer> originalQueue = new PriorityQueue<Integer>();
	        PriorityQueue<Integer> mutatedQueue = new PriorityQueue<Integer>();
	        for(int i : barcodes){
	        	originalQueue.add(i);
	        }
	        int prev = Integer.MIN_VALUE;
	        int index = 0;
	        boolean isFirstTime = true;
	        
	        while(isFirstTime || mutatedQueue.size() > 0){
	        	if(!isFirstTime){
	        		originalQueue = new PriorityQueue<Integer>(mutatedQueue);
	        	}
	        	
	        	mutatedQueue = new PriorityQueue<Integer>();
		        while(originalQueue.size() > 0){
		        	Integer s = originalQueue.poll();
					if(prev != s){
		        		result[index] = s;
		        		index++;
		        		prev = s;
		        	}else{
		        		isFirstTime = false;
		        		mutatedQueue.add(s);
		        	}
		        }
	        }    
	        return result;
	  }

}
