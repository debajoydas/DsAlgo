package com.debajoy.ds.tree;

import com.debajoy.ds.tree.BinaryTreeDLL.TreeNodeDLL;

public class TestTreeDLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeDLL tree = new BinaryTreeDLL(); 
        tree.root = new TreeNodeDLL(5); 
        tree.root.left = new TreeNodeDLL(3); 
        tree.root.right = new TreeNodeDLL(6); 
        tree.root.left.right = new TreeNodeDLL(4); 
        tree.root.left.left = new TreeNodeDLL(1); 
        tree.root.right.right = new TreeNodeDLL(8); 
        tree.root.left.left.right = new TreeNodeDLL(2); 
        tree.root.left.left.left = new TreeNodeDLL(0); 
        tree.root.right.right.left = new TreeNodeDLL(7); 
        tree.root.right.right.right = new TreeNodeDLL(9); 
        
        tree.convertBTtoDLL(tree.root);
        tree.printList(tree.head);
	}

}
