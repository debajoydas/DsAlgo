/**
 * 
 */
package com.debajoy.ds.heap;

import java.util.PriorityQueue;

/**
 * @author Debajoy
 *
 */
public class FurthestBuildingReach {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] heights = {4,12,2,7,3,18,20,3,19};
		int bricks = 10;
		int ladders = 2;
		System.out.println(furthestBuilding(heights, bricks, ladders));
		
		int[] heights1 = {14,3,19,3};
		int bricks1 = 17;
		int ladders1 = 0;
		System.out.println(furthestBuilding(heights1, bricks1, ladders1));
		
		int[] heights2 = {4,2,7,6,9,14,12};
		int bricks2 = 5;
		int ladders2 = 1;
		System.out.println(furthestBuilding(heights2, bricks2, ladders2));
		
		int[] heights3 = {17,16,5,10,10,14,7};
		int bricks3 = 74;
		int ladders3 = 6;
		System.out.println(furthestBuilding(heights3, bricks3, ladders3));
		
		int[] heights4 = {1,2};
		int bricks4 = 0;
		int ladders4 = 0;
		System.out.println(furthestBuilding(heights4, bricks4, ladders4));
		
		int[] heights5 = {7,5,13};
		int bricks5 = 0;
		int ladders5 = 0;
		System.out.println(furthestBuilding(heights5, bricks5, ladders5));
		
	}
	
	public static int furthestBuilding(int[] heights, int bricks, int ladders) {
		int ans = 0;
		int[] diff = new int[heights.length-1];
		for(int i = 0; i < diff.length; i++){
			diff[i] = heights[i+1] - heights[i];
		}
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		int laddersTemp = ladders;
		int usedLadder = 0;
		int destWithOnlyLadder = 0;
		while(laddersTemp > 0 && destWithOnlyLadder < diff.length){
			if(diff[destWithOnlyLadder] > 0){
				laddersTemp--;
				minHeap.add(diff[destWithOnlyLadder]);
			}
			destWithOnlyLadder++;
		}
		if(ladders <= 0 && bricks <= 0){
			for(int i = 0; i < diff.length; i++){
				ans = i;
				if(diff[i] < 0){
					continue;
				}else{
					ans = (i-1);
					break;
				}
			}
		}else if(ladders >= diff.length){
			ans = diff.length-1;
		}else{
			if(destWithOnlyLadder <= 0){
				for(int i = 0; i < diff.length; i++){
					ans = i;
					if(diff[i] < 0){
						continue;
					}
					bricks = bricks - diff[i];
					if(bricks < 0){
						ans = (i-1);
						break;
					}
				}
			}else{
				for(int i = (destWithOnlyLadder+1); i < diff.length; i++){
					ans = i;
					if(diff[i] < 0){
						continue;
					}
					if(diff[i] <= minHeap.peek()){
						bricks = bricks - diff[i];
						if(bricks < 0){
							ans = (i-1);
							break;
						}
					}else{
						if(minHeap.peek() > bricks){
							ans = (i-1);
							break;
						}else{
							bricks = bricks - minHeap.poll();
							if(usedLadder > ladders){
								ans = (i-1);
								break;
							}
							usedLadder += 1;
							Math.floorMod(1, 2);
						}
					}
				}
			}
		}
		return (ans+1); 
    }

}
