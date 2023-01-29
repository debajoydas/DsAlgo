/**
 * 
 */
package com.debajoy.ds.tree.practice;

import java.util.ArrayDeque;

/**
 * @author Debajoy
 *
 */
public class EvenOddTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(7);
		System.out.println(isEvenOddTree(root));
		

	}
    public static boolean isEvenOddTree(TreeNode root) {
        boolean isEvenOddTree = true;
        int level = 0;
        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(root);
        while(queue.size() > 0){
            int size = queue.size();
            TreeNode prev = null;
            TreeNode curr = null;
            for(int i = 0; i < size; i++){
                TreeNode popped = queue.poll(); 
                curr = popped;     
                if(curr != null && prev != null){
                    if(level%2 == 0 && curr.val <= prev.val){
                        return false;
                    }else if(level%2 != 0 && curr.val >= prev.val){
                        return false;
                    }
                }       
                if((level%2 == 0 && popped != null && popped.val%2 == 0) || (level%2 != 0 && popped != null && popped.val%2 != 0)){
                    return false; 
                }
                if(popped != null && popped.left != null){
                    queue.add(popped.left);
                }
                if(popped != null && popped.right != null){
                    queue.add(popped.right);
                }
                 prev = curr;
                
            }
            level++;
        }
        return isEvenOddTree;
    }
}
