/**
 * 
 */
package com.debajoy.ds.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Debajoy
 *
 */
public class SmallestUnoccupiedChair {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] times =  {{3,10},{1,5},{2,6}};
		int targetFriend = 0;
		System.out.println(smallestChair(times, targetFriend));

	}
	
    public static int smallestChair(int[][] times, int targetFriend) {
    	Map<Integer,int[]> map = new TreeMap<Integer,int[]>();
    	int targetFind = times[targetFriend][0];
    	for(int[] arrP: times){
    		map.put(arrP[0], arrP);
    	}
    	int[] chairs = new int[times.length];
    	for(Map.Entry<Integer,int[]> entry : map.entrySet()){
    		int[] val = entry.getValue();
    		int key = entry.getKey();
    		for(int i = 0; i < chairs.length; i++){		
    			if(chairs[i] == 0 || (val[0] >= chairs[i])){
    				chairs[i] = val[1];
    				if(key == targetFind){
    					return i;
    				}
    				break;
    			}else{
    				continue;
    			}
    		}
    	}
    	
		return 0;
    	
    }
}

