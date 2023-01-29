/**
 * 
 */
package com.debajoy.ds.stack;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Debajoy
 *
 */
public class NextGreaterElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int[] nextGreaterElements(int[] nums) {
    	int[] output = new int[nums.length];
    	if(output == null){
    		return null;
    	}else{
    		Map<Range,Integer> map = new HashMap<Range,Integer>();
    		for(int i = 0; i< nums.length; i++){
    			if(i+1 != (nums.length)){
    				
    			}
    			if(i-1 >= 0){
    				
    			}
    		}
    	}
		return nums; 
    }

}
class Range{
	public Range(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}
	int start;
	int end;
}