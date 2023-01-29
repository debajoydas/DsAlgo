package com.debajoy.ds.tree;

import com.debajoy.ds.tree.BinaryTree.TreeNode;

public class TestBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BinaryTree bTree = new BinaryTree();
		TreeNode root = new TreeNode(1);  
		bTree.root = root;
		bTree.getRoot().left = new TreeNode(2); 
	    bTree.getRoot().right = new TreeNode(3); 
	    bTree.getRoot().left.left = new TreeNode(4); 
	    bTree.getRoot().left.right = new TreeNode(5);
	    bTree.printInOrder(bTree.root);
	    bTree.printPostOrder(bTree.root);
	    bTree.printPreOrder(bTree.root);
	    bTree.printtDiameterOfTree();
	}

}
