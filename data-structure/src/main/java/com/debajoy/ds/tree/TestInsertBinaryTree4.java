/**
 * 
 */
package com.debajoy.ds.tree;

/**
 * @author Debajoy
 *
 */
public class TestInsertBinaryTree4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree3 bTree = new BinaryTree3();
		com.debajoy.ds.tree.BinaryTree3.TreeNode root = new com.debajoy.ds.tree.BinaryTree3.TreeNode(1);  
		bTree.root = root;
        root.left = new com.debajoy.ds.tree.BinaryTree3.TreeNode(2);  
        root.left.left = new com.debajoy.ds.tree.BinaryTree3.TreeNode(4); 
        root.left.right = new com.debajoy.ds.tree.BinaryTree3.TreeNode(5); 
        root.right = new com.debajoy.ds.tree.BinaryTree3.TreeNode(3); 
        root.right.left = new com.debajoy.ds.tree.BinaryTree3.TreeNode(6); 
        root.right.right = new com.debajoy.ds.tree.BinaryTree3.TreeNode(7); 
       
        System.out.print( "Sum Root to Leaf Numbers:"); 
        System.out.println(bTree.connect(root));
	}

}
