/**
 * 
 */
package com.debajoy.algo.algorithm.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Debajoy
 *
 */
public class WildcardMatching {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public boolean isMatch(String s, String p) {
     
    	char[] charOriginal = new char[s.length()];
    	char[]  charPattern = new char[p.length()];
    	
    	for(int i = 0; i< s.length(); i++){
    		charOriginal[i] = s.charAt(i);
    	}
    	for(int i = 0; i< p.length(); i++){
    		charPattern[i] = p.charAt(i);
    	}
    	
    	Map<Character,List<Integer>> map = new HashMap<Character,List<Integer>>();
    	for(int i = 0; i<charOriginal.length; i++){
    		if(map.get(charOriginal[i]) == null){
    			map.put(charOriginal[i], new ArrayList<Integer>(i));		
    		}else{
    			map.get(charOriginal[i]).add(i);
    		}
    	}
    	
    	int originalIndex = 0;
    	int patternIndex = 0;
    	
    	boolean isMatch = isMatchRec(originalIndex,patternIndex,charOriginal,charPattern);
    	
    	for(int i = 0; i<charPattern.length; i++){

    	}
		return isMatch;
    }
    
    private boolean isMatchRec(int originalIndex, int patternIndex, char[] charOriginal, char[] charPattern) {
		// TODO Auto-generated method stub
		if(isAlBhabet(charOriginal[originalIndex]) && isAlBhabet(charPattern[patternIndex])){
			if(charOriginal[originalIndex] == charPattern[patternIndex]){
				originalIndex++;
				patternIndex++;
				return isMatchRec(originalIndex, patternIndex, charOriginal, charPattern);
			}else{
				return false;
			}
		}else if(isAlBhabet(charOriginal[originalIndex]) && isQuestionMark(charPattern[patternIndex])){
			originalIndex++;
			patternIndex++;
			return isMatchRec(originalIndex, patternIndex, charOriginal, charPattern);
		}else if(isAlBhabet(charOriginal[originalIndex]) && isStar(charPattern[patternIndex])){
			
		}	
		
		return false;
	}

	public static boolean isStar(Character x){
    	return (x == '*');
    }
    
    public static boolean isQuestionMark(Character x){
    	return (x == '?');
    }
    
    public static boolean isAlBhabet(Character x){
    	return (!isStar(x) && !isQuestionMark(x));
    }

}

