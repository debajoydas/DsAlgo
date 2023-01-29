/**
 * 
 */
package com.debajoy.algo.algorithm.slidingwindow;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Debajoy
 *
 */
public class MovingStonesUntilConsecutive {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] stones = {1,2,5};
		numMovesStonesII(stones);
	}

	private static int[] numMovesStonesII(int[] stones) {
		
		boolean isPossible = false;
		Map<Integer,Boolean> map = new HashMap<Integer,Boolean>();
		PriorityQueue<Integer> minQueue = new PriorityQueue<Integer>();
		PriorityQueue<Integer> maxQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
		for(int i =0; i< stones.length; i++){
			minQueue.add(stones[i]);
			maxQueue.add(stones[i]);
			map.put(Integer.valueOf(stones[i]), true);
		}
		int highest = maxQueue.poll();
		int lowest = minQueue.poll();
		int higeshtRemaining = maxQueue.peek();
		int lowestRemaining = minQueue.peek();
		maxQueue.add(highest);
		minQueue.add(lowest);
		if((highest - higeshtRemaining) > (lowestRemaining-lowest)){
			int highestIndex = highest;
			while(highestIndex != lowest){
				if(!map.get(highestIndex)){
					maxQueue.poll();
					maxQueue.add(Integer.valueOf(highestIndex));
					map.put(Integer.valueOf(highestIndex), true);
					isPossible = true;
				}
				highestIndex--;
			}
		}else{
			int lowestIndex = lowest;
			while(lowestIndex != highest){
				if(!map.get(lowestIndex)){
					minQueue.poll();
					minQueue.add(Integer.valueOf(lowestIndex));
					map.put(Integer.valueOf(lowestIndex), true);
					isPossible = true;
				}
				lowestIndex++;
			}
		}
		return stones;
	}

}
