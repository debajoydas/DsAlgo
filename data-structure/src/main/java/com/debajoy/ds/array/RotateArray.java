/**
 * 
 */
package com.debajoy.ds.array;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author dasde
 *
 */
public class RotateArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-1,-100,3,99};
		int k = 2;
		rotate(nums, k);
		String s = "30";
		System.out.println(s.substring(1, s.length()));
		int sks = s.charAt(0) - s.charAt(1);
		for(int i : nums) {
			System.out.print(i+"->");
		}
        PriorityQueue<Integer> queue = new PriorityQueue(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                int idx = 0;
                String str1 = String.valueOf(o1);
                String str2 = String.valueOf(o2);
                while(idx < str1.length() && idx < str2.length()){
                    if(str1.charAt(idx) == str2.charAt(idx)){
                        idx++;
                    }else{
                        return str1.charAt(idx) - str2.charAt(idx);
                    }
                }
                if(idx >= str1.length()){
                    return 1;
                }else if(idx >= str2.length()){
                    return -1;
                }else{
                    return 0;
                }
            }
        });
	}	
    public static void rotate(int[] nums, int k) {

        int length = nums.length;
        if(k%length != 0){
            if(k > length){
                k = k%length;
            }
            int first = 0; int last = length-1;
            reverseArray(first,last,nums);
            first = 0; last = k-1;
            reverseArray(first,last,nums);
            first = k; last = length-1;
            reverseArray(first,last,nums);
        }
}
public static void reverseArray(int first, int last, int[] nums){
        while(last > first){
                int temp = nums[last];
                nums[last] = nums[first];
                nums[first] = temp;
                last--;
                first++;
            } 
}
}
