/**
 * 
 */
package com.debajoy.ds.tree.practice;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Debajoy
 *
 */
public class BinaryTreeMaximumPathSum {
	
	private static final int MIN_VALUE = -400000;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(-3);
		System.out.println(maxPathSum(root));
	}
	
    public static int maxPathSum(TreeNode root) {
        AtomicInteger maxSum = new AtomicInteger(MIN_VALUE);
        maxPathSumHelper(root,maxSum);
        return maxSum.get();
    }
    
    public static int maxPathSumHelper(TreeNode root, AtomicInteger maxSum) {

        if(root == null){
            return MIN_VALUE;
        }
        int left = maxPathSumHelper(root.left,maxSum);
        int right = maxPathSumHelper(root.right,maxSum);
        int returnVal = 0;
        if(left <= MIN_VALUE && right <= MIN_VALUE){
        	returnVal = root.val;
        }else if(left <= MIN_VALUE && right > MIN_VALUE){
        	returnVal = Math.max(root.val, root.val+right);
        }else if(left > MIN_VALUE && right <= MIN_VALUE){
        	returnVal = Math.max(root.val, root.val+left);
        }else{
        	returnVal = Math.max(root.val, root.val+Math.max(left,right));
        }
        int maxSumValue = Math.max(maxSum.get(),Math.max(root.val,Math.max(left,Math.max(right,Math.max(root.val+left,Math.max(root.val+right,root.val+left+right))))));
        maxSum.set(maxSumValue);
        return returnVal;
    
    
    }

}
