package com.debajoy.ds.tree;

public class BinarySearchTree {

	public BSTNode root;
	
	static class BSTNode{
		
		int data;
		BSTNode left;
		BSTNode right;
		
		public BSTNode(int data) {
			super();
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	public void insert(int data){
		if(root == null){
			root = new BSTNode(data);
			return;
		}
		BSTNode prev = null;
		BSTNode temp = root;
		while(temp != null){
			prev = temp;
			if(temp.data < data){
				temp = temp.right;
			}else if(temp.data > data){
				temp = temp.left;
			}
		}
		if(prev.data > data){
			prev.left = new BSTNode(data);
		}else if(prev.data < data){
			prev.right = new BSTNode(data);
		}

	}
	
	public void InOrder(){
		System.out.println("InOrder traversal is :");
		InOrderTraversal(root);
		System.out.println();
	}
	
	private void InOrderTraversal(BSTNode root){
		if(root == null){
			return;
		}
		InOrderTraversal(root.left);
		System.out.print(root.data+" -> ");
		InOrderTraversal(root.right);
	}
	
	public void checkIfBST(){
		if(root == null){
			return;
		}
		BSTNode tempLeft = root;
		boolean isBST = true;
		
		while(tempLeft != null){
			if(root.left != null && root.data <= root.left.data){
				isBST = false;
				break;
			}
			if(root.right != null && root.data >= root.right.data){
				isBST = false;
				break;
			}
			tempLeft = tempLeft.left;
		}
		
		BSTNode tempRight = root;
		while(tempRight != null && isBST){
			if(root.left != null && root.data <= root.left.data){
				isBST = false;
				break;
			}
			if(root.right != null && root.data >= root.right.data){
				isBST = false;
				break;
			}
			tempRight = tempRight.right;
		}
		if(isBST){
			System.out.println("It's a BST....");
		}else{
			System.out.println("It's not a BST...");
		}
	}
	
	public void delete(BSTNode node){
		if(root == null){
			return;
		}
		BSTNode temp = root;
		BSTNode prev = null;
		while(temp.data != node.data){
			prev = temp;
			if(temp.data < node.data){
				temp = temp.right;
			}else if(temp.data > node.data){
				temp = temp.right;
			}
		}
		
		if(temp.right == null && temp.left != null){
			if(prev.left == temp){
				prev.left = temp.left;
			}else if(prev.right == temp){
				prev.right = temp.left;
			}
		}else if(temp.left == null && temp.right != null){
			if(prev.left == temp){
				prev.left = temp.right;
			}else if(prev.right == temp){
				prev.right = temp.right;
			}
		}else if(temp.left == null && temp.right == null){
			if(prev.left == temp){
				prev.left = null;
			}else if(prev.right == temp){
				prev.right = null;
			}
		}else if(temp.left != null && temp.right != null){
			BSTNode tempRightMin = temp.right;
			BSTNode tempRightMinPrev = temp;
			while(tempRightMin != null){
				tempRightMinPrev = tempRightMin;
				if(tempRightMin.left == null && tempRightMin.right == null){
					if(prev.left == temp){
						prev.left = tempRightMin;
					}else if(prev.right == temp){
						prev.right = tempRightMin;
					}
				}
				tempRightMin = tempRightMin.left;
			}
			
		}

	}
}
