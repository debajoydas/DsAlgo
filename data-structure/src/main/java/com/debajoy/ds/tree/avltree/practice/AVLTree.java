/**
 * 
 */
package com.debajoy.ds.tree.avltree.practice;

import java.util.ArrayDeque;

/**
 * @author Debajoy
 *
 */
public class AVLTree {

	AVLNode root;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String SEPERATOR ="**************************************************************************************";
		 AVLNode root = insert(null,13);
		 insert(root, 10);
		 insert(root, 15);
		 insert(root, 16);
		 insert(root, 11);
		 insert(root, 5);
		 insert(root, 6);
		 insert(root, 4);
		 insert(root, 7);
		 displayLevelOrderTraversal(root);
		 System.out.println(SEPERATOR);
		 root = delete(root, 15);
		 displayLevelOrderTraversal(root);
		 
	}
	public static void displayLevelOrderTraversal(AVLNode root){
		ArrayDeque<AVLNode> queue = new ArrayDeque<AVLNode>();
		queue.add(root);
		while(queue.size() > 0){
			int size = queue.size();
			for(int i = 0; i < size; i++){
				AVLNode polled  = queue.poll();
				if(polled != null){
					System.out.print(polled.data+"->");
					if(polled.left != null){
						queue.add(polled.left);
					}
					if(polled.right != null){
						queue.add(polled.right);
					}
				}
			}
			System.out.println();
		}	
	}
	public static int height(AVLNode node){
		if(node == null){
			return 0;
		}
		return node.height;
	}	
	public static int getBalance(AVLNode node){
		if(node == null){
			return 0;
		}
		int balance = 0;
		if(node.left != null && node.right == null){
			balance = height(node.left)+1;
		}else if(node.left == null && node.right != null){
			balance = height(node.right)+1;
		}else if(node.left != null && node.right != null){
			balance = height(node.left)-height(node.right);
		}
		return balance;
	}
	public static AVLNode getLeftRotation(AVLNode node){
		AVLNode temp = node.right;
		node.right = temp.left;
		temp.left = node;
		node.height = (node.left == null && node.right == null) ? 0 : Math.max(height(node.left), height(node.right))+1;
		temp.height = (temp.left == null && temp.right == null) ? 0 : Math.max(height(temp.left), height(temp.right))+1;
		return temp;
	}
	public static AVLNode getRightRotation(AVLNode node){
		AVLNode temp = node.left;
		node.left = temp.right;
		temp.right = node;
		node.height = (node.left == null && node.right == null) ? 0 : Math.max(height(node.left), height(node.right))+1;
		temp.height = (temp.left == null && temp.right == null) ? 0 : Math.max(height(temp.left), height(temp.right))+1;
		return temp;
	}
	public static AVLNode insert(AVLNode root,int data){
		if(root == null){
			return new AVLNode(data);
		}
		if(data < root.data){
			root.left = insert(root.left, data);
		}else if(data > root.data){
			root.right = insert(root.right, data);
		}else{
			return root;
		}
		root.height = Math.max(height(root.left), height(root.right))+1;
		int balanceFactor = getBalance(root);
		if(balanceFactor > 1 && root.left != null && data < root.left.data){
			//LL
			return getRightRotation(root);
		}else if(balanceFactor < -1 && root.right != null && data > root.right.data){
			//RR
			return getLeftRotation(root);
		}else if(balanceFactor > 1 && root.left != null && data > root.left.data){
			//LR
			root.left = getLeftRotation(root.left);
			return getRightRotation(root);
		}else if(balanceFactor < -1 && root.right != null && data < root.right.data){
			//RL
			root.right = getRightRotation(root.right);
			return getLeftRotation(root);
		}
		return root;
	}
	
	public static AVLNode delete(AVLNode root,int data){
		if(root == null){
			return root;
		}
		if(data < root.data){
			root.left = delete(root.left, data);
		}else if(data > root.data){
			root.right = delete(root.right, data);
		}else{
			if(root.left != null && root.right == null){
				root = root.left;
			}else if(root.left == null && root.right != null){
				root = root.right;
			}else if(root.left == null && root.right == null){
				root = null;
			}else{
				AVLNode temp = null;
				if(getBalance(root.left) >= 0){
					temp = getMinNodeOfChildren(root.right);
					root.data = temp.data;
					root.right = delete(root.right, temp.data);
				}else{
					temp = getMaxNodeOfChildren(root.left);
					root.data = temp.data;
					root.left = delete(root.left, data);
				}
			}
		}
		if(root == null){
			return root;
		}
		root.height = (root.left == null && root.right == null) ? 0 : Math.max(height(root.left), height(root.right))+1;
		int balanceFactor = getBalance(root);
		if(balanceFactor > 1 && getBalance(root.left) >= 0){
			//LL
			return getRightRotation(root);
		}else if(balanceFactor > 1 && getBalance(root.left) < 0){
			//LR
			root.left = getLeftRotation(root.left);
			return getRightRotation(root);
		}else if(balanceFactor < -1 && getBalance(root.right) < 0){
			//RR
			return getLeftRotation(root);
		}else if(balanceFactor < -1 && getBalance(root.left) >= 0){
			//RL
			root.right = getRightRotation(root.right);
			return getLeftRotation(root);
		}
		return root;
	}
	
	private static AVLNode getMaxNodeOfChildren(AVLNode node) {
		// TODO Auto-generated method stub
		if(node == null){
			return node;
		}
		while(node.right != null){
			node = node.right;
		}
		return node;
	}
	private static AVLNode getMinNodeOfChildren(AVLNode node) {
		// TODO Auto-generated method stub
		if(node == null){
			return node;
		}
		while(node.left != null){
			node = node.left;
		}
		return node;
	}
	public void search(AVLNode root,int data){
		
	}

}

class AVLNode{
	int data;
	int height;
	AVLNode left;
	AVLNode right;
	public AVLNode(int data, int height) {
		super();
		this.data = data;
		this.height = height;
	}
	public AVLNode(int data) {
		super();
		this.data = data;
	}
}
