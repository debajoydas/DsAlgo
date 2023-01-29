/**
 * 
 */
package com.debajoy.ds.tree;

import com.debajoy.ds.tree.BST.BSTNode;

/**
 * @author Debajoy
 *
 */
public class TestIdenticalTree {

	/**
	 * 
	 */
	public TestIdenticalTree() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST tree1 = new BST();
        tree1.root = new BSTNode(1);
        tree1.root.left = new BSTNode(2);
        tree1.root.right = new BSTNode(3);
        tree1.root.left.right = new BSTNode(5);
        tree1.root.right.right = new BSTNode(10);

        
        BST tree2 = new BST();
        tree2.root = new BSTNode(1);
        tree2.root.left = new BSTNode(2);
        tree2.root.right = new BSTNode(3);
        tree2.root.left.right = new BSTNode(5);
        tree2.root.right.right = new BSTNode(10);
        
		BST tree3 = new BST();
		tree3.root = new BSTNode(5);
		tree3.root.left = new BSTNode(2);
        tree3.root.right = new BSTNode(12);
        tree3.root.left.left = new BSTNode(1);
        tree3.root.left.right = new BSTNode(3);
        tree3.root.right.left = new BSTNode(9);
        tree3.root.right.right = new BSTNode(21);
        tree3.root.right.right.left = new BSTNode(19);
        tree3.root.right.right.right = new BSTNode(25);
        
        BST tree4 = new BST();
        tree4.root = new BSTNode(5);
        tree4.root.left = new BSTNode(1);
        tree4.root.right = new BSTNode(7);
        tree4.root.left.right = new BSTNode(3);
        tree4.root.right.right = new BSTNode(9);

        System.out.println(BST.findMaxforKey(tree4.root, 8, 5));
        System.out.println(BST.findMaxforKeyOptimized(tree4.root, 8, 5));
        
        System.out.println(BST.findMaxforKey(tree3.root, 24, 9));
        System.out.println(BST.findMaxforKeyOptimized(tree3.root, 24, 9));
        
        System.out.println(BST.findMaxforKey(tree3.root, 4, 9));
        System.out.println(BST.findMaxforKeyOptimized(tree3.root, 4, 9));
        
        
     //   System.out.println(BST.isIdentical(tree1.root, tree2.root));
	}

}
