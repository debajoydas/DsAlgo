/**
 * 
 */
package com.debajoy.ds.tree.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author dasde
 *
 */
public class PathSumIII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		TreeNode root = new TreeNode(10);
//		root.left = new TreeNode(5);
//		root.right = new TreeNode(-3);
//		root.left.left = new TreeNode(3);
//		root.left.right = new TreeNode(2);
//		root.right.right = new TreeNode(11);
//		root.left.left.left = new TreeNode(3);
//		root.left.left.right = new TreeNode(-2);
//		root.left.right.right = new TreeNode(1);
		TreeNode root = new TreeNode(1000000000);
		root.left = new TreeNode(1000000000);
		root.left.left = new TreeNode(294967296);
		root.left.left.left = new TreeNode(1000000000);
		root.left.left.left.left = new TreeNode(1000000000);
		root.left.left.left.left.left = new TreeNode(1000000000);
//		
		int targetSum = 0;
		System.out.println(pathSum(root, targetSum));
		
	}

    public static int pathSum(TreeNode root, int targetSum) {
        AtomicInteger count = new AtomicInteger(0);
        List<Long> list = pathSum(root,targetSum,count);
        return count.get();
    }

    public static List<Long> pathSum(TreeNode root, int targetSum, AtomicInteger count) {
        if(root == null){
            return new ArrayList<Long>();
        }
        List<Long> left = pathSum(root.left,targetSum,count);
        List<Long> right = pathSum(root.right,targetSum,count);
        List<Long> current = new ArrayList<Long>();
        current.add(Long.valueOf(root.val));
        if(left.size() <= 0 && right.size() <= 0){
            for(Long i : current){
                if(i == targetSum){
                    count.incrementAndGet();
                }
            }
            return current;
        }
        for(Long data : left){
            current.add(data+root.val);
        }
        for(Long data : right){
            current.add(data+root.val);
        }
        for(Long i : current){
            if(i == targetSum){
                count.incrementAndGet();
            }
        }
        return current;    
        
    }
}
