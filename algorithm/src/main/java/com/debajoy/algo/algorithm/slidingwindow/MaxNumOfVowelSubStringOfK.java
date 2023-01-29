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
public class MaxNumOfVowelSubStringOfK {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "tryhard";
		int k  = 4;
		System.out.println(maxVowels(s, k));
	}

	public static int maxVowels(String s, int k) {
		
		if(s== null){
			return 0;
		}
		if(k > s.length()){
			k = s.length();
		}
		char[] vowel  =  {'a','e','i','o','u'};
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i = 0; i< vowel.length; i++){
        	map.put(Character.valueOf(vowel[i]), 1);
        }
        
        int left = 0 ;
        int right = k-1;
        int maxLength = 0;
        int countOfVowel = 0;
        
        for(int i = 0; i< k; i++){
        	if(map.get(s.charAt(i)) != null){
        		countOfVowel += 1;
        	}
        };
        maxLength = Math.max(maxLength, countOfVowel);
        right++;left++;
        
        while(right < s.length()){
        	if(map.get(s.charAt(right)) != null){
        		countOfVowel++;
        		if(map.get(s.charAt(left-1)) != null){
        			countOfVowel--;
        		}
        		maxLength = Math.max(maxLength, countOfVowel);
        		left++;right++;
        	}else{
        		if(map.get(s.charAt(left-1)) != null){
        			countOfVowel--;
        		}
        		maxLength = Math.max(maxLength, countOfVowel);
        		left++;right++;
        	}
        }
		return maxLength;
        
    }
}
