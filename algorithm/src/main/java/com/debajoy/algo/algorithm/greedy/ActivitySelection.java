/**
 * 
 */
package com.debajoy.algo.algorithm.greedy;

import java.util.Arrays;

import com.debajoy.algo.algorithm.comparator.ArrayIndexComparator;

/**
 * @author Debajoy
 *
 */
public class ActivitySelection {

	/**
	 * @param args
	 * 
	 * 
	 * Problem: You are given N activities with their start and finish times. Select the maximum number of activities that can be performed by a single person, assuming that a person can only work on a single activity at a time.
Example 1: Consider the following 3 activities sorted by
finish time.
     start[]  =  {10, 12, 20};
     finish[] =  {20, 25, 30};
     
     
A person can perform at most two activities. The 
maximum set of activities that can be executed 
is {0, 2} [ These are indexes in start[] and 
finish[] ]



Example 2: Consider the following 6 activities 
sorted by finish time.
     start[]  =  {1, 3, 0, 5, 8, 5};
     finish[] =  {2, 4, 6, 7, 9, 9};
A person can perform at most four activities. The 
maximum set of activities that can be executed 
is {0, 1, 3, 4} [ These are indexes in start[] and 
finish[] ]



	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Integer[] start = {1, 3, 0, 5, 8, 5};
		Integer[] end = {2, 4, 6, 7, 9, 9};
		System.out.println(getMaxNoOfActivitiesAtaTime(start, end));
	}

	public static int getMaxNoOfActivitiesAtaTime(Integer[] start, Integer[] end){
		if(start == null || end == null){
			return 0;
		}
		
		int resultCount = 0;
		int prevFinish = -999;
		
		ArrayIndexComparator comparator = new ArrayIndexComparator(end);
		Integer[] indexBefore = comparator.createIndexArray();
		Arrays.sort(indexBefore, comparator);
		Arrays.sort(end);
		Integer[] startNew = new Integer[start.length];
		
		for(int i = 0; i< start.length; i++){
			startNew[i] = start[indexBefore[i]];
		}
		
		for(int i = 0; i< end.length; i++){
			if(i == 0){
				resultCount++;
				prevFinish = end[i];
			}else{
				if(prevFinish <= start[i]){
					resultCount++;
					prevFinish = end[i];
				}
			}
		}
		return resultCount;
		
	}
}
