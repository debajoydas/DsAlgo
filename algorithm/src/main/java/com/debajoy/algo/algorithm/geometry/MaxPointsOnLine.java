/**
 * 
 */
package com.debajoy.algo.algorithm.geometry;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Debajoy
 *
 */
public class MaxPointsOnLine {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] points = {{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
		System.out.println(maxPoints(points));

	}
	
	public static int maxPoints(int[][] points) {
        Map<Double,Integer> map = new HashMap<>();
        AtomicInteger max = new AtomicInteger(0);
        for(int i = 0; i < points.length-1; i++){
        	for(int j = i+1 ; j < points.length; j++){
        		Double val = Double.MAX_VALUE;
        		if(points[j][0] == points[i][0] && points[j][1] == points[i][1]){
        			val = (double) 0;
        		}else if(points[j][0]-points[i][0] != 0){
        			val = (double) ((points[j][1]-points[i][1])/(points[j][0]-points[i][0]));
        		}
        		if(map.get(val) != null){
        			map.put(val, map.get(val)+1);
        		}else{
        			map.put(val, 1);
        		}
        	}
        }
        map.entrySet().stream().forEach(e -> {
        	max.set(Math.max(max.get(), e.getValue())); 
        });
        return max.get();
    }

}
