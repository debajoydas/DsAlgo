/**
 * 
 */
package com.debajoy.ds.linkedlist;

/**
 * @author Debajoy
 *
 */
public class FindDuplicate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,3,4,2,2};
		System.out.println(findDuplicate(nums));
	}

	public static int findDuplicate(int[] nums) {
		int slow = nums[0];
		int fast = nums[0];
		do{
			slow = nums[slow];
			fast = nums[nums[fast]];
		}while(slow != fast);
		fast = nums[0];
		while(slow != fast){
			slow = nums[slow];
			fast = nums[fast];
		}	
        return slow;
    }
	
}
