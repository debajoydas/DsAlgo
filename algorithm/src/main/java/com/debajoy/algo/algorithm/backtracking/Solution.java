package com.debajoy.algo.algorithm.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	
	public static void main(String[] args){
		String digits = "7";
		List<String> list= letterCombinations(digits);
	}
	 
    public static List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<String>();
        if("".equals(digits) || digits == null){
        	return list;
        }
        Map<Integer,String> keyMap = new HashMap<Integer,String>();
        keyMap.put(2, "abc");
        keyMap.put(3, "def");
        keyMap.put(4, "ghi");
        keyMap.put(5, "jkl");
        keyMap.put(6, "mno");
        keyMap.put(7, "pqrs");
        keyMap.put(8, "tuv");
        keyMap.put(9, "wxyz");
        
        letterCombinationsRec("",0,digits,list,keyMap);
        return list;
    }

    public static void letterCombinationsRec(String num,int idx,String digits,List<String> list,Map<Integer,String> keyMap) {
        if(idx >= digits.length()){
            list.add(num);
            return;
        }
        int digit = Integer.valueOf(digits.substring(idx,idx+1));
        String val = keyMap.get(digit);
        for(int x = 0; x < val.length(); x++){
            letterCombinationsRec(num+val.substring(x,x+1),idx+1,digits,list, keyMap);
        }
    }

}
