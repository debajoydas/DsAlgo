package com.debajoy.ds.tree;


public class TestInsertBinaryTree3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree3 bTree = new BinaryTree3();
		com.debajoy.ds.tree.BinaryTree3.TreeNode root = new com.debajoy.ds.tree.BinaryTree3.TreeNode(4);  
		bTree.root = root;
        root.left = new com.debajoy.ds.tree.BinaryTree3.TreeNode(9);  
        root.left.right = new com.debajoy.ds.tree.BinaryTree3.TreeNode(1); 
        root.right = new com.debajoy.ds.tree.BinaryTree3.TreeNode(0); 
       
        System.out.print( "Sum Root to Leaf Numbers:"); 
        System.out.println(bTree.sumNumbers(root));
	}

}
