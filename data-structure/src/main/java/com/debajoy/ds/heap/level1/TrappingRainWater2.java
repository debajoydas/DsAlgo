/**
 * 
 */
package com.debajoy.ds.heap.level1;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Debajoy
 *
 */
public class TrappingRainWater2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] heightMap = {{1,4,3,1,3,2},{3,2,1,3,2,4},{2,3,3,2,3,1}};
		System.out.println(trapRainWater(heightMap));
	}

	public static int trapRainWater(int[][] heightMap) {
		int r = heightMap.length;
		int c = heightMap[0].length;
		int water = 0;
		PriorityQueue<Trap> queue = new PriorityQueue<Trap>(new Comparator<Trap>() {

			@Override
			public int compare(Trap t1, Trap t2) {
				// TODO Auto-generated method stub
				return Integer.valueOf(t1.h).compareTo(Integer.valueOf(t2.h));
			}
		});
		boolean[][] isVisited = new boolean[r][c];
		for(int i = 0; i < r; i++){
			for(int j = 0; j < c; j++){
				if(i == 0 || i == r-1 || j == 0 || j == c-1){
					isVisited[i][j] = true;
					queue.add(new Trap(i, j, heightMap[i][j]));
				}
			}
		}
		int[][] dirArray = {{0,-1},{0,1},{-1,0},{1,0}};
		while(queue.size() > 0){
			Trap smallest = queue.poll();
			int rOld = smallest.i;
			int cOld = smallest.j;
			for(int[] dir : dirArray){
				int rNew = smallest.i+dir[0];
				int cNew = smallest.j+dir[1];
				if(rNew < r && rNew >= 0 && cNew < c && cNew >= 0 && !isVisited[rNew][cNew]){
					if(heightMap[rOld][cOld] > heightMap[rNew][cNew]){
						water += heightMap[rOld][cOld] - heightMap[rNew][cNew];
						heightMap[rNew][cNew] = heightMap[rOld][cOld];
						queue.add(new Trap(rNew, cNew, heightMap[rNew][cNew]));
						isVisited[rNew][cNew] = true;
					}else{
						queue.add(new Trap(rNew, cNew, heightMap[rNew][cNew]));
						isVisited[rNew][cNew] = true;
					}
				}
				
			}
		}
        return water;
    }
}

class Trap{
	int i;
	int j;
	int h;
	public Trap(int i, int j, int h) {
		super();
		this.i = i;
		this.j = j;
		this.h = h;
	}
}
