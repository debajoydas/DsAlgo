/**
 * 
 */
package com.debajoy.algo.algorithm.combination;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author dasde
 *
 */
public class Permutations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3};
		System.out.println(permute(nums));
	}

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        for(int i = 0; i < nums.length; i++){
            List<Integer> list = new ArrayList<Integer>();
            Set<Integer> indexes = new HashSet<Integer>();
            list.add(nums[i]);
            indexes.add(i);
            permuteHelper(nums,list,indexes,answer);
        }
        
        return answer;
    }
    public static void permuteHelper(int[] nums,List<Integer> list, Set<Integer> indexes,List<List<Integer>> answer) {
        if(list.size() == nums.length){
            answer.add(list);
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(!indexes.contains(i)){
            	List<Integer> listNew = new ArrayList<>(list);
            	listNew.add(nums[i]);
                indexes.add(i);
                permuteHelper(nums,listNew,indexes,answer);
                indexes.remove(Integer.valueOf(i));
            }
        }
    }
}
