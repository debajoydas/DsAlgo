/**
 * 
 */
package com.debajoy.algo.algorithm.slidingwindow;

import java.time.chrono.IsoChronology;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Debajoy
 *
 */
public class MinimumWindowSubString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minWindowSubString("a", "aa"));
	}

	private static String minWindowSubString(String S, String T) {
		// TODO Auto-generated method stub
		if(S == null){
			return "";
		}else if(T == null){
			return "";
		}
		Map<Character,Integer> orgMap = new HashMap<Character, Integer>();
		for(int i = 0; i< T.length(); i++){
			orgMap.put(T.charAt(i), orgMap.getOrDefault(T.charAt(i), 0)+1);
		}
		Map<Character,Integer> dynMap = new HashMap<Character, Integer>();
		int leftIndex = 0; int rightIndex = 0;
		int minLength = Integer.MAX_VALUE;
		int leftResult = 0;
		int rightResult = 0;
		boolean isRight = true;
		boolean isChanged = false;
		
		while(rightIndex < S.length()){
			if(isRight){
				dynMap.put(S.charAt(rightIndex), dynMap.getOrDefault(S.charAt(rightIndex), 0)+1);
			}		
			if(isContainString(orgMap, dynMap)){
				if(minLength > (rightIndex-leftIndex)){
					isChanged = true;
					minLength = rightIndex-leftIndex;
					leftResult = leftIndex;
					rightResult = rightIndex;
				}
				dynMap.put(S.charAt(leftIndex), dynMap.getOrDefault(S.charAt(leftIndex), 0)-1);
				leftIndex++;
				isRight = false;
			}else{
				rightIndex++;
				isRight= true; 
			}
		}
		return (isChanged) ? S.substring(leftResult,rightResult+1):"";
	}

	private static boolean isContainString(Map<Character,Integer> orgMap, Map<Character,Integer> dynMap){
		boolean output = false;
		for(Character cOrg : orgMap.keySet()){
			if(dynMap.get(cOrg) != null && dynMap.get(cOrg) >= orgMap.get(cOrg)){
				output = true;
			}else{
				output = false;
				break;
			}
		}
		return output;
	}
}
