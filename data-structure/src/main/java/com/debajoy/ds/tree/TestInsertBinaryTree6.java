/**
 * 
 */
package com.debajoy.ds.tree;

/**
 * @author Debajoy
 *
 */
public class TestInsertBinaryTree6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree3 bTree = new BinaryTree3();
		com.debajoy.ds.tree.BinaryTree3.TreeNode root = new com.debajoy.ds.tree.BinaryTree3.TreeNode(3);  
		bTree.root = root;
        root.left = new com.debajoy.ds.tree.BinaryTree3.TreeNode(5);  
        root.left.left = new com.debajoy.ds.tree.BinaryTree3.TreeNode(6); 
        root.left.right = new com.debajoy.ds.tree.BinaryTree3.TreeNode(2); 
        root.left.right.left = new com.debajoy.ds.tree.BinaryTree3.TreeNode(7); 
        root.left.right.right = new com.debajoy.ds.tree.BinaryTree3.TreeNode(4); 
        root.right = new com.debajoy.ds.tree.BinaryTree3.TreeNode(1); 
        root.right.left = new com.debajoy.ds.tree.BinaryTree3.TreeNode(0); 
        root.right.right = new com.debajoy.ds.tree.BinaryTree3.TreeNode(8); 
       
        System.out.print( "LCA of Nodes : "); 
        System.out.println(bTree.lowestCommonAncestor(root,root.left,root.left.right.right).val);
	}

}
