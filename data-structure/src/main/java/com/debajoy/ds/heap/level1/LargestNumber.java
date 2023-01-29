/**
 * 
 */
package com.debajoy.ds.heap.level1;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author dasde
 *
 */
public class LargestNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums= {432,43243};
		System.out.println(largestNumber(nums));

	}

    public static String largestNumber(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                String str1 = String.valueOf(o1);
                String str2 = String.valueOf(o2);

                if(str1.length() == str2.length()){
                    if(Integer.valueOf(str1) > Integer.valueOf(str2)){
                        return -1;
                    }else if(Integer.valueOf(str1) < Integer.valueOf(str2)){
                        return 1;
                    }else{
                        return 0;
                    }
                }else if(str1.length() > str2.length()){
                    int diff = str1.length() - str2.length();
                    String str1Part1 = str1.substring(0,str2.length());
                    String str1Part2 = str1.substring(str2.length(),str1.length());
                    if(Integer.valueOf(str1Part1) > Integer.valueOf(str2) ){
                        return -1;
                    }else if(Integer.valueOf(str1Part1).intValue() == Integer.valueOf(str2).intValue()){
                        int idx = 0;
                        while(idx < str2.length() && idx < str1Part2.length()){
                            if(str2.charAt(idx) == str1Part2.charAt(idx)){
                                idx++;
                            }else{
                                return str2.charAt(idx) - str1Part2.charAt(idx);
                            }
                        }
                        if(str2.length() >= idx ){
                            return 1;
                        }else if(str1Part2.length() >= idx){
                            return -1;
                        }else{
                            return 0;
                        }
                    }else{
                        return 1;
                    }
                }else{
                    int diff = str2.length() - str1.length();
                    String str2Part1 = str2.substring(0,str1.length());
                    String str2Part2 = str2.substring(str1.length(),str2.length());
                    if(Integer.valueOf(str2Part1) > Integer.valueOf(str1) ){
                        return 1;
                    }else if(Integer.valueOf(str2Part1) == Integer.valueOf(str1)){
                        int idx1 = 0;
                        while(idx1 < str1.length() && idx1 < str2Part2.length()){
                            if(str1.charAt(idx1) == str2Part2.charAt(idx1)){
                                idx1++;
                            }else{
                                return str2Part2.charAt(idx1) - str1.charAt(idx1);
                            }
                        }
                        if(str2Part2.length() >= idx1 ){
                            return 1;
                        }else if(str1.length() >= idx1){
                            return -1;
                        }else{
                            return 0;
                        }
                    }else{
                        return -1;
                    }
                }
                
            }
        });
        for(int num : nums){
            queue.add(num);
        }
        StringBuilder sb = new StringBuilder();
        while(queue.size() > 0){
            sb.append(queue.poll());
        }       
        return sb.toString();
    }
}
