/**
 * 
 */
package com.debajoy.ds.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import com.debajoy.ds.tree.BinaryTree.TreeNode;

/**
 * @author Debajoy
 *
 */
public class BinaryTree {

	public TreeNode root;
	
	/**
	 * @param root the root to set
	 */
	public void setRoot(TreeNode root) {
		this.root = root;
	}
	/**
	 * @return the root
	 */
	public TreeNode getRoot() {
		return this.root;
	}
	static class TreeNode{
		int data;
		TreeNode left;
		TreeNode right;
		public TreeNode(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	public boolean isEmpty(TreeNode node){
		if(node == null){
			return true;
		}
		return false;
	}
	public void printInOrderTraversal(TreeNode node){
		if(isEmpty(node)){
			return;
		}
		printInOrderTraversal(node.left);
		System.out.print(node.data+" -> ");
		printInOrderTraversal(node.right);
	}
	public void printPostOrderTraversal(TreeNode node){
		if(isEmpty(node)){
			return;
		}
		printPostOrderTraversal(node.left);
		printPostOrderTraversal(node.right);
		System.out.print(node.data+" -> ");
	}
	public void printPreOrderTraversal(TreeNode node){
		if(isEmpty(node)){
			return;
		}
		System.out.print(node.data+" -> ");
		printPreOrderTraversal(node.left);
		printPreOrderTraversal(node.right);
	}
	public void printInOrder(TreeNode node){
		System.out.println("IN Order Traversal :");
		printInOrderTraversal(node);
		System.out.println();
	}
	public void printPostOrder(TreeNode node){
		System.out.println("Post Order Traversal :");
		printPostOrderTraversal(node);
		System.out.println();
		
	}
	public void printPreOrder(TreeNode node){
		System.out.println("Pre Order Traversal :");
		printPreOrderTraversal(node);
		System.out.println();
	}
	public void printBFSOrder(TreeNode node){
		System.out.println("BFS Traversal :");
		printBFSTraversal(node);
		System.out.println();
	}
	private void printBFSTraversal(TreeNode node) {
		// TODO Auto-generated method stub
		if(node == null){
			return;
		}
		System.out.print(node.data+" -> ");
		printBFSTraversal(node.left);
		printBFSTraversal(node.right);
	}
	
	public void printInOrderIterative(){
		TreeNode current = root;
		Stack<TreeNode> stackTree = new Stack<TreeNode>();
		while(current != null){
			stackTree.push(current);
			current  = current.left;
			if(current != null){
				System.out.print(current.data+"");
			}
		}
	}
	
	public void insertBinaryTree(TreeNode temp,int data){
		if(this.root == null){
			System.out.println("Tree is empty...");
		}
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(temp);
		
		while(queue != null){
			TreeNode nodePoped = queue.peek();
			queue.remove();
			if(nodePoped.left == null){
				nodePoped.left = new TreeNode(data);
				break;
			}else{
				queue.add(nodePoped.left);
			}
			if(nodePoped.right == null){
				nodePoped.right = new TreeNode(data);
				break;
			}else{
				queue.add(nodePoped.right);
			}
		}
	}
	
	public void printtDiameterOfTree(){
		System.out.println("Diameter of Tree is : "+getDiameter(root));
		System.out.println();
	}
	
	private int getDiameter(TreeNode root){
		if(root == null){
			return 0;
		}
		return Math.max((getHeight(root.left)+getHeight(root.right)+1), Math.max(getDiameter(root.left),getDiameter(root.right)));
	}
	
	private int getHeight(TreeNode node){
		if(node == null){
			return 0;
		}
		return (1+Math.max(getHeight(node.left), getHeight(node.right)));
	}
	
	public void printLevelOrderTraversal(){
		if(root == null){
			return;
		}
		TreeNode temp = root;
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(temp);
		while(queue.size() > 0){
			TreeNode popItem = queue.poll();
			System.out.print(popItem.data+" ");
			if(popItem.left != null){
				queue.add(popItem.left);
			}
			if(popItem.right != null){
				queue.add(popItem.right);
			}
		}
	}
	
	public List<?> inOderIterativeTraversal(){
		List<Integer> output = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if(root == null){
			return null;
		}
		stack.push(root);
		TreeNode current = root;
		while(!stack.isEmpty()){
			TreeNode pop = stack.pop();
		}
		return output;
	}
	
	public void deleteNode(){
		
	}
	
}
