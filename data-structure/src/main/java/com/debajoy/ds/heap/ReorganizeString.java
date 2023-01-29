/**
 * 
 */
package com.debajoy.ds.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

/**
 * @author Debajoy
 *
 */
public class ReorganizeString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reorganizeString("aab"));
	}
	
	public static String reorganizeString(String str) {
        if(str == null){
        	return "";
        }
        StringBuilder outputStr = new StringBuilder("");
        Map<Character,Integer> charMap = new HashMap<Character,Integer>();
        for(int i =0; i < str.length(); i++){
        	if(charMap.get(str.charAt(i)) == null){
        		charMap.put(str.charAt(i), 1);
        	}else{
        		charMap.put(str.charAt(i), charMap.get(str.charAt(i))+1);
        	}
        }
        PriorityQueue<Map.Entry<Character,Integer>> maxQueue = new PriorityQueue<Map.Entry<Character,Integer>>(new ComparatorCus());
        for(Map.Entry<Character,Integer> map : charMap.entrySet()){
        	maxQueue.add(map);
        }
        List<Character> output = new ArrayList<Character>();
        Character prevTurn =null;
        boolean isPossible = true;
        
        while(maxQueue.size() > 0){
        	Map.Entry<Character,Integer> removeItem = maxQueue.poll();
        	if(prevTurn == null || (prevTurn != removeItem.getKey())){
        		if(removeItem.getValue() > 1){
            		removeItem.setValue(removeItem.getValue() - 1);
            		output.add(removeItem.getKey());
            		maxQueue.add(removeItem);
            	}else if(removeItem.getValue() == 1){
            		output.add(removeItem.getKey());
            		maxQueue.remove(removeItem);
            	}
        		prevTurn = removeItem.getKey();
        	}else{
        		if(maxQueue.size() > 0){		
        			Map.Entry<Character,Integer> removeItem2nd = maxQueue.poll();
        			maxQueue.add(removeItem);
            		if(removeItem2nd.getValue() > 1){
            			removeItem2nd.setValue(removeItem2nd.getValue() - 1);
                		output.add(removeItem2nd.getKey());
                		maxQueue.add(removeItem2nd);
                	}else if(removeItem2nd.getValue() == 1){
                		output.add(removeItem2nd.getKey());
                		maxQueue.remove(removeItem2nd);
                	}
            		prevTurn = removeItem2nd.getKey();
        		}else{
        			isPossible = false;
        			break;
        		}
        		
        	}   	
        }
        
        if(isPossible){
        	 for(Character c : output){
        		 outputStr.append(String.valueOf(c));
        	 }
        	 return outputStr.toString();
        }else{
        	return "";
        }
    }

}

class ComparatorCus  implements Comparator<Map.Entry<Character,Integer>>{

	@Override
	public int compare(Entry<Character, Integer> o1, Entry<Character, Integer> o2) {
		// TODO Auto-generated method stub
		return o2.getValue().compareTo(o1.getValue());
	}

	
}
