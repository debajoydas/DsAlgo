/**
 * 
 */
package com.debajoy.algo.algorithm.twopointer;

/**
 * @author Debajoy
 *
 */
public class MergeSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {1,2,3,0,0,0};
		int m = 3;
		int[] nums2 = {2,5,6};
		int n = 3;
		merge(nums1, m, nums2, n);
		display(nums1);
	}
	
	 private static void display(int[] nums1) {
		// TODO Auto-generated method stub
		for(int i : nums1){
			System.out.print(i+"->");
		}
		System.out.println(Character.isLetterOrDigit(','));
		String s = "sada";
        if(Character.toLowerCase(s.charAt(0)) != Character.toLowerCase(s.charAt(2))){
           
        }
	}

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
	        int l1 = m-1;
	        int r1 = nums1.length-1;
	        int l2 = n-1;
	        while(l1 >= 0 && l2 >= 0 && r1 >= 0){
	            if(nums1[l1] < nums2[l2]){
	                nums1[r1] = nums2[l2];
	                l2--;
	                r1--;
	            }else{
	                nums1[r1] = nums1[l1];
	                l1--;
	                r1--;
	            }
	        }
	        while(l1 >= 0 && r1 >= 0){
	                nums1[r1] = nums1[l1];
	                l1--;
	                r1--;
	        }

	        while(l2 >= 0 && r1 >= 0){
	                nums1[r1] = nums2[l2];
	                l2--;
	                r1--;
	        }
	    }

}
