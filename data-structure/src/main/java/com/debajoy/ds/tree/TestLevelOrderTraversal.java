/**
 * 
 */
package com.debajoy.ds.tree;

import com.debajoy.ds.tree.BinaryTree.TreeNode;

/**
 * @author Debajoy
 *
 */
public class TestLevelOrderTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 BinaryTree tree_level = new BinaryTree(); 
	        tree_level.root = new TreeNode(1); 
	        tree_level.root.left = new TreeNode(2); 
	        tree_level.root.right = new TreeNode(3); 
	        tree_level.root.left.left = new TreeNode(4); 
	        tree_level.root.left.right = new TreeNode(5); 

	        System.out.println("Level order traversal " + 
	                                "of binary tree is - "); 
	        tree_level.printLevelOrderTraversal(); 

	}

}
