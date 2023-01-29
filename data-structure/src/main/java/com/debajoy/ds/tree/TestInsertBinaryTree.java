package com.debajoy.ds.tree;

import com.debajoy.ds.tree.BinaryTree.TreeNode;

public class TestInsertBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree bTree = new BinaryTree();
		TreeNode root = new TreeNode(10);  
		bTree.root = root;
        root.left = new TreeNode(11); 
        root.left.left = new TreeNode(7); 
        root.right = new TreeNode(9); 
        root.right.left = new TreeNode(15); 
        root.right.right = new TreeNode(8); 
       
        System.out.print( "Inorder traversal before insertion:"); 
        bTree.printInOrder(bTree.root);
       
        int key = 12; 
        bTree.insertBinaryTree(bTree.root,key);
       
        System.out.print("\nInorder traversal after insertion:"); 
        bTree.printInOrder(bTree.root);
	}

}
