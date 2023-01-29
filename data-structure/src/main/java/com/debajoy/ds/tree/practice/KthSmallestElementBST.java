/**
 * 
 */
package com.debajoy.ds.tree.practice;

import java.util.concurrent.atomic.AtomicInteger;

public class KthSmallestElementBST {
	static TreeNode ans = null;
	public static void main(String[] args){
			TreeNode root = new TreeNode(5);
			root.left = new TreeNode(3);
			root.right = new TreeNode(6);
			root.left.left = new TreeNode(2);
			root.left.right = new TreeNode(4);
			root.left.left.left = new TreeNode(1);
			int k = 3;
			System.out.println(kthSmallest(root, k));
	}
		
	    
    public static int kthSmallest(TreeNode root, int k) {      
        AtomicInteger kA = new AtomicInteger(k);
        inOrder(root,kA);
        return (ans != null) ? ans.val : 0;
    }
    public static void inOrder(TreeNode root, AtomicInteger kA){
        if(root == null || ans != null){
            return;
        }
        inOrder(root.left,kA);
        kA.decrementAndGet();
        if(kA.get() == 0){
            if(ans == null){
                ans = root;
                return;
            }
        }
        inOrder(root.right,kA);
    }
	}