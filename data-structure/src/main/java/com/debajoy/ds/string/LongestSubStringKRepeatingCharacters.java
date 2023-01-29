/**
 * 
 */
package com.debajoy.ds.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/** S
 * @author dasde
 *
 */
public class LongestSubStringKRepeatingCharacters {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "bbaaacbd";
		int k = 3;
		System.out.println(longestSubstring(s, k));
	}
	
    public static int longestSubstring(String s, int k) {
        if(k <= 1){
            return s.length();
        }
        char[] arr= new char[s.length()];
        for(int i = 0; i < s.length(); i++){
            arr[i] = s.charAt(i);
        }
        AtomicInteger max = new AtomicInteger(0);
        longestSubstringHelper(arr,0,arr.length-1,k,max);
        return max.get();
    }
    public static void longestSubstringHelper(char[] arr, int start, int end, int k, AtomicInteger max) {
        if(start >= end || start < 0 || end < 0 || start >= arr.length || end >= arr.length){
            return;
        }
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i = start; i <= end; i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        List<Integer> invalidPoints = new ArrayList<Integer>();
        for(int i = start; i <= end; i++) {
        	if(map.get(arr[i]) < k) {
        		invalidPoints.add(i);
        	}
        }
        for(int i = 0; i < invalidPoints.size(); i++) {
        	if(i == 0) {
        		longestSubstringHelper(arr, start, invalidPoints.get(i)-1, k, max);
        	}else {
        		longestSubstringHelper(arr, invalidPoints.get(i-1)+1, invalidPoints.get(i)-1, k, max);
        	}
        }
        if(invalidPoints.size() > 0) {
        	longestSubstringHelper(arr, invalidPoints.get(invalidPoints.size()-1)+1, end, k, max);
        }
        if(invalidPoints.size() <= 0) {
        	int maxValue = Math.max(max.get(), end-start+1);
        	max.set(maxValue);
        }
    }

}
