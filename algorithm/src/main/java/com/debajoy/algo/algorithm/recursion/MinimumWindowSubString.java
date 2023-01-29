/**
 * 
 */
package com.debajoy.algo.algorithm.recursion;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

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

		System.out.println(minWindowSubString("ABACD", "AD"));
	}

	private static String minWindowSubString(String s, String t) {
		// TODO Auto-generated method stub
		if(s == null){
			return null;
		}else if(t == null){
			return null;
		}
		int sIndex = 0;
		int tIndex = 0;
		ArrayDeque<Integer> listOfIndexInS = new ArrayDeque<Integer>();
		return minWindowSubStringRec(s,t,sIndex,tIndex, listOfIndexInS);
	}

	private static String minWindowSubStringRec(String s, String t, int sIndex, int tIndex, ArrayDeque<Integer> listOfIndexInS) {
		// TODO Auto-generated method stub
		if(sIndex >= s.length() && tIndex < t.length()){
			return "";
		}else if(tIndex >= t.length() && listOfIndexInS.size() == t.length()){
			return s.substring(listOfIndexInS.peekFirst(),listOfIndexInS.peekLast());
		}else if(tIndex >= t.length() && listOfIndexInS.size() < t.length()){
			return "";
		}
		
		if(s.charAt(sIndex) == t.charAt(tIndex)){
			String s1 = minWindowSubStringRec(s, t, sIndex+1, tIndex, listOfIndexInS);
			ArrayDeque<Integer> listOfIndexInSMod = new ArrayDeque<>(listOfIndexInS);
			listOfIndexInSMod.offer(sIndex);
			String s2 = minWindowSubStringRec(s1, t, sIndex+1, tIndex+1, listOfIndexInSMod);
			return (s1.length() > s2.length())?s2:s1;
		}else{
			return minWindowSubStringRec(s, t, sIndex+1, tIndex+1, listOfIndexInS);
		}
		
	}

}
