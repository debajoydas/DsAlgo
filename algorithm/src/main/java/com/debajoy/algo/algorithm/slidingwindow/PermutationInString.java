/**
 * 
 */
package com.debajoy.algo.algorithm.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Debajoy
 *
 */
public class PermutationInString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "ab";
		String s2 = "eidboaoo";
		System.out.println(checkInclusion(s1, s2));
	}
	
	public static boolean checkInclusion(String s1, String s2) {
		
		if(s2.length() < s1.length()){
			return false;
		}
		Map<Character, Integer> s1Map = new HashMap<Character, Integer>();
		Map<Character, Integer> s2Map = new HashMap<Character, Integer>();
		boolean result = true;
		for(int i =0; i< s1.length(); i++){
			if(s1Map.get(s1.charAt(i))==null){
				s1Map.put(s1.charAt(i), 1);
			}else{
				s1Map.put(s1.charAt(i), s1Map.get(s1.charAt(i))+1);
			}
		}
		
		char[] charArray = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		for(int i = 0; i< charArray.length; i++){
			s2Map.put(charArray[i], 0);
		}
		for(int i = 0 ;i <s1.length(); i++){
			if(s2Map.get(s2.charAt(i)) == null){
				s2Map.put(s2.charAt(i), 1);
			}else{
				s2Map.put(s2.charAt(i), s2Map.get(s2.charAt(i))+1);
			}
		}
		
		result  = checkIfFound(s1, s2, s1Map, s2Map);
		
		int left = 1; int right = s1.length(); 
		if(result){
			return result;
		}else{
			while(right < s2.length()){
				if(s2Map.get(s2.charAt(right)) <= 0){
					s2Map.put(s2.charAt(right), 1);
				}else{
					s2Map.put(s2.charAt(right), s2Map.get(s2.charAt(right))+1);
				}
				if(s2Map.get(s2.charAt(left-1)) >  0){
					s2Map.put(s2.charAt(left-1), s2Map.get(s2.charAt(left-1))-1);
				}else{
					s2Map.put(s2.charAt(left-1), 0);
				}
				result = checkIfFound(s1,s2,s1Map,s2Map);
				if(result){
					return true;
				}
				right++;
				left++;
			}
		}
		return false;
	}

	private static boolean checkIfFound(String s1, String s2, Map<Character, Integer> s1Map,
			Map<Character, Integer> s2Map) {
		
		// TODO Auto-generated method stub
		boolean result = true;
		for(int i = 0 ;i <s1.length(); i++){
			if(!result){
				break;
			}
			for(Map.Entry<Character, Integer> s1each : s1Map.entrySet()){
				if(s2Map.get(s1each.getKey()) != null && s2Map.get(s1each.getKey()) == s1each.getValue()){
					result = true;
				}else{
					result = false;
					break;
				}
			}
		}
		return result;
	}
}
