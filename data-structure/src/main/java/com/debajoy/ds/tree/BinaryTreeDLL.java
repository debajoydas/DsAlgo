package com.debajoy.ds.tree;

import com.debajoy.ds.linkedlist.DoublyLinkedList;
import com.debajoy.ds.tree.BinaryTree.TreeNode;

public class BinaryTreeDLL {
	
	public TreeNodeDLL root;
	public TreeNodeDLL head;
	private TreeNodeDLL prev;
	
	
	/**
	 * @param root the root to set
	 */
	public void setRoot(TreeNodeDLL root) {
		this.root = root;
	}
	/**
	 * @return the root
	 */
	public TreeNodeDLL getRoot() {
		return this.root;
	}
	static class TreeNodeDLL{
		int data;
		TreeNodeDLL left;
		TreeNodeDLL right;
		public TreeNodeDLL(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	public void convertBTtoDLL(TreeNodeDLL root){

		if(root ==  null){
			return;
		}
		convertBTtoDLL(root.left);
		
		if(head ==  null){
			head = root;
			head.left = null;
			prev = head;
		}else{
			root.left = prev;
			prev.right = root;
			prev = root;
		}
		convertBTtoDLL(root.right);
	}
	
	public void convertBinaryTreeToDoublyLinkedList(){
		DoublyLinkedList list = new DoublyLinkedList();
		convertBinaryTreeToDoublyLinkedListRec(this.root, list);
	}
	 private void convertBinaryTreeToDoublyLinkedListRec(TreeNodeDLL root, DoublyLinkedList list) {
		// TODO Auto-generated method stub
		 if(root == null){
			 return;
		 }
		 convertBinaryTreeToDoublyLinkedListRec(root.left, list);
		
	}
	public void printList(TreeNodeDLL head)  
	    { 
	        System.out.println("Extracted Double Linked List is : "); 
	        TreeNodeDLL temp = head;
	        while (temp != null)  
	        { 
	            System.out.print(temp.data + " -> "); 
	            temp = temp.right; 
	        } 
	        System.out.println();
	    } 

}
