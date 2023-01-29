/**
 * 
 */
package com.debajoy.ds.tree.practice;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Debajoy
 *
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class CompleteBinaryTreeInserter {
    TreeNode root;
    int counts;
    Map<Integer,TreeNode> map = new HashMap<Integer,TreeNode>();
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode rootTree = new TreeNode(1);
		rootTree.left = new TreeNode(2);
		rootTree.right = new TreeNode(3);
		rootTree.left.left = new TreeNode(4);
		rootTree.left.right = new TreeNode(5);
		rootTree.right.left = new TreeNode(6);
		CompleteBinaryTreeInserter obj = new CompleteBinaryTreeInserter(rootTree);
		 int param_1 = obj.insert(7);
		 int param_2 = obj.insert(8);
		 TreeNode param_3 = obj.get_root();
		 System.out.println(param_1);
		 System.out.println(param_2);
	}
	
    public CompleteBinaryTreeInserter(TreeNode root) {
        this.root = root;
        AtomicInteger count = new AtomicInteger(0);
        levelOrderTraversal(root,count,map);
        this.counts = count.get();
    }


    public void levelOrderTraversal(TreeNode root, AtomicInteger count, Map<Integer,TreeNode> map){
        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(root);
        while(queue.size() > 0){
            int size = 0;
            for(int i = 0; i < queue.size(); i++){
                TreeNode popped = queue.poll();
                if(popped != null){
                    count.incrementAndGet();
                    map.put(count.get(),popped);
                }
                if(popped != null && popped.left != null){
                    queue.add(popped.left);
                }
                if(popped != null && popped.right != null){
                    queue.add(popped.right);
                }
            }
        }
    }
    
    public int insert(int val) {
        int newCount = counts+1;
        TreeNode parent = map.get(newCount/2);
        if(parent != null){
            TreeNode newNode = new TreeNode(val);
            if(parent.left == null){
                parent.left = newNode;
            }else if(parent.right == null){
                parent.right = newNode;
            }
            map.put(newCount,newNode);
            counts = newCount;
            return parent.val;
        }
        return -1;
    }
    
    public TreeNode get_root() {
        return root;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */