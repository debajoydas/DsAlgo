/**
 * 
 */
package com.debajoy.ds.array;

/**
 * @author dasde
 *
 */
public class MajorityElement2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,2,1,1,1,2,2};
		System.out.println(majorityElement(nums));
	}

	 public static int majorityElement(int[] nums) {
	        Integer majorityElement  = null;
	        int netCount = 0;
	        for(int i = 0; i < nums.length; i++){
	            if(majorityElement == null){
	                netCount = 1;
	                majorityElement = nums[i];
	            }else if(nums[i] == majorityElement){
	                netCount++;
	            }else{
	                if(netCount == 0){
	                    majorityElement = nums[i];
	                    netCount = 1;
	                }else{
	                    netCount--;
	                }
	            }
	        }
	        return majorityElement;
	    }
}
