/**
 * 
 */
package com.debajoy.ds.tree.practice;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Debajoy
 *
 */
public class CountGoodNodesBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int goodNodes(TreeNode root) {
        AtomicInteger count = new AtomicInteger(0);
        Integer max = null;
        goodNodesHelper(root,max,count);
        return count.get();
    }
    public void goodNodesHelper(TreeNode root,Integer max,AtomicInteger count){
        if(root == null){
            return;
        }
        if((max == null) || (max != null && root.val >= max)){
            max = root.val;
            count.incrementAndGet();
        }
        goodNodesHelper(root.left,max,count);
        goodNodesHelper(root.right,max,count);
    }

}
