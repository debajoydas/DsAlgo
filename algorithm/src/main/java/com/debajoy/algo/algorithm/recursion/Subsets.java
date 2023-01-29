/**
 * 
 */
package com.debajoy.algo.algorithm.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dasde
 *
 */
public class Subsets {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3};
		System.out.println(subsets(nums));
	}
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        subsetsHelper(0,nums,subsets,list);
        return subsets;
    }
    public static void subsetsHelper(int idx, int[] nums, List<List<Integer>> subsets, List<Integer> list) {
        if(idx > nums.length){
            return;
        }
        if(idx == nums.length){
            subsets.add(list);
            return;
        }
        List<Integer> listNewWith = new ArrayList<Integer>(list);
        listNewWith.add(nums[idx]);
        List<Integer> listNewWithOut = new ArrayList<Integer>(list);
        subsetsHelper(idx+1,nums,subsets,listNewWith);
        subsetsHelper(idx+1,nums,subsets,listNewWithOut);
    }

}
