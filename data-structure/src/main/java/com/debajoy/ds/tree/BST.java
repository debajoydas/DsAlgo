/**
 * 
 */
package com.debajoy.ds.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

import com.debajoy.ds.tree.BinarySearchTree.BSTNode;

/**
 * @author Debajoy
 * 
 * Problem: Given values of two values n1 and n2 in a Binary Search Tree, find the Lowest Common Ancestor (LCA). For Simplicity, you may assume that both the values exist in the tree.

Consider the below BST:
BST_LCA
In the above BST:
LCA of 10 and 14 is 12
LCA of 14 and 8 is 8
LCA of 10 and 22 is 20

 *
 */
public class BST {
	
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

		public BSTNode() {
			// TODO Auto-generated constructor stub
		}
	}
	
	 public static void main(String args[]) 
	    {
	        // Let us construct the BST shown
	        // in the above figure
		  	BST tree = new BST();
	        tree.root = new BSTNode(20);
	        tree.root.left = new BSTNode(8);
	        tree.root.right = new BSTNode(22);
	        tree.root.left.left = new BSTNode(4);
	        tree.root.left.right = new BSTNode(12);
	        tree.root.left.right.left = new BSTNode(10);
	        tree.root.left.right.right = new BSTNode(14);

	        int n1 = 10, n2 = 14;
	        BSTNode t = tree.lcaOptimizedRecur(tree.root, n1, n2);
	       System.out.println("LCA of " + n1 + " and " 
	                               + n2 + " is " + t.data);

	        n1 = 14;
	        n2 = 8;
	        t = tree.lcaOptimizedRecur(tree.root, n1, n2);
	        System.out.println("LCA of " + n1 + " and " 
	                                + n2 + " is " + t.data);

	        n1 = 10;
	        n2 = 22;
	        t = tree.lcaOptimizedRecur(tree.root, n1, n2);
	        System.out.println("LCA of " + n1 + " and " 
	                                + n2 + " is " + t.data);
	        
	        System.out.println(isBST(tree.root));
	        
	        System.out.println("-----------------------");
		  	BST tree1 = new BST();
	        tree1.root = new BSTNode(20);
	        tree1.root.left = new BSTNode(8);
	        tree1.root.right = new BSTNode(10);
	        tree1.root.left.left = new BSTNode(4);
	        tree1.root.left.right = new BSTNode(12);
	        tree1.root.left.right.left = new BSTNode(22);
	        tree1.root.left.right.right = new BSTNode(14);

	    //    tree1.root = correctBST(tree1.root);
	    //    InOrderTraversalPlain(tree1.root);
	    //    System.out.println(numTrees(5));
	        int[] post = {1, 7, 5, 50, 40, 10};
	        int[] post1 = {0,1,5,7,6,4,14,17,21,20,16,10};
	       BSTNode root =  constructTree(post1, post1.length);
	       InOrderTraversalPlain(root);
	    }

	private BSTNode lca(BSTNode root2, int n1, int n2) {
		// TODO Auto-generated method stub
		if(root2 == null){
			return null;
		}
		BSTNode temp = root2;
		BSTNode temp1 = root2;
		StringBuilder s1 = new StringBuilder("");
		StringBuilder s2 = new StringBuilder("");
		
		while(n1 != temp.data){
			if(temp.data > n1){
				s1.append(0);
				temp =  temp.left;
			}else if(temp.data < n1){
				s1.append(1);
				temp =  temp.right;
			}
		}
		while(n2 != temp1.data){
			if(temp1.data > n2){
				s2.append(0);
				temp1 =  temp1.left;
			}else if(temp.data < n2){
				s2.append(1);
				temp1 =  temp1.right;
			}
		}
		BSTNode next = root2;
		BSTNode temp2 = root2;
		if(s1.length() > 0 && s2.length() > 0 ){
			int maxlength = Math.max(s1.length(),s2.length());		
			for(int i = 0; i< maxlength; i++){
				if(s1.length() >= (i+1) && s2.length() >= (i+1)){
					if(s1.charAt(i) == s2.charAt(i)){
						temp2 = next;
						if(String.valueOf(s1.charAt(i)).equals("0")){
							next = next.left;
						}else if(String.valueOf(s1.charAt(i)).equals("1")){
							next = next.right;
						}
					}else{	
						break;
					}
				}
			}
		}
		return next;
	}
	
	private BSTNode lcaOptimizedRecur(BSTNode root, int n1, int n2) {

		if(root == null){
			return null;
		}
		if(root.data > n1 && root.data > n2){
			return lcaOptimizedRecur(root.left, n1, n2);
		}else if(root.data < n1 && root.data < n2){
			return lcaOptimizedRecur(root.right, n1, n2);
		}
		return root;
	}
	
	public static boolean isIdentical(BSTNode root1, BSTNode root2)
	{	
		if(root1 == null && root2 == null){
			return false;
		}else if(root1 != null && root2 == null){
			return false;
		}else if(root1 == null && root2 != null){
			return false;
		}else{
			String trre1 = InOrderTraversal(root1, new StringBuilder(""));
			if(trre1.equalsIgnoreCase(InOrderTraversal(root2, new StringBuilder("")))){
				return true;
			}else{
				return false;
			}
		}
	  }
	
	public static String InOrderTraversal(BSTNode node, StringBuilder sd){
		if(node == null){
			return "";
		}
		InOrderTraversal(node.left,sd);
		sd.append(node.data);
		InOrderTraversal(node.right, sd);
		return sd.toString();
	}
	
	public static void InOrderTraversalPlain(BSTNode node){
		if(node == null){
			return;
		}
		InOrderTraversalPlain(node.left);
		System.out.println(node.data);
		InOrderTraversalPlain(node.right);
	}
	
	/***
	 * 
	 *  Closest Neighbor in BST 
		Given a binary search tree and a number N. Your task is to complete the function findMaxforKey(),
 		that find's the greatest number in the binary search tree that is less than or equal to N. 
 		Print the value of the element if it exists otherwise print -1.

	 * 
	 * 
	 */
	public static int findMaxforKey(BSTNode node, int val, int size){
		
		int result = -1;
		if(node == null){
			return -1;
		}
		BSTNode prev = null;
		
		while(node != null){
			if(node.data > val){
				if(node.left != null){
					prev = node;
					node = node.left;
				}else{
					break;
				}

			}else if(node.data < val){
				if(node.right != null){
					prev = node;
					node = node.right;
				}else{
					break;
				}

			}else{
				result = node.data;
				break;
			}
		}
		if(prev.data < val && node.data < val){
			result = Math.max(prev.data, node.data);
		}else if(prev.data > val && node.data < val){
			result = node.data;
		}else if(prev.data < val && node.data > val){
			result = prev.data;
		}
		return result;
	}
	
	public static int findMaxforKeyOptimized(BSTNode node, int val, int size){
		if(node == null){
			return -1;
		}
		List<Integer> list = new ArrayList<Integer>(); 
		InOrderTraversalInt(node, list);
		int prev = -1;
		for(int i=0; i<list.size() ; i++){
			if(val > list.get(i)){
				prev = list.get(i);
				continue;
			}else if(val == list.get(i)){
				return val;
			}else if(val < list.get(i)){
				return prev;
			}
		}
		return -1;
	}
	public static void InOrderTraversalInt(BSTNode node, List<Integer> list){
		if(node == null){
			return;
		}
		InOrderTraversalInt(node.left,list);
		list.add(node.data);
		InOrderTraversalInt(node.right, list);
	}
	
	public static boolean isBST(BSTNode root){
		boolean result = true;
		if(root == null){
			return false;
		}
		List<Integer> list = new ArrayList<Integer>();
		InOrderTraversalInt(root, list);	
		for(int i = 0; i< list.size()-1; i++){
			if(list.get(i) < list.get(i+1)){
				continue;
			}else{
				result = false;
			}
		}
		return result;
    }
	
	
    public static BSTNode correctBST(BSTNode root){

    	if(root == null){
    	   return null;
       }
       BSTNode prev = null;
       BSTNode[] resultNodes = new BSTNode[6];
       resultNodes = traverse(root, prev, false, resultNodes);
       if(resultNodes != null){
           BSTNode firstIncorrect = resultNodes[0];
           BSTNode secondIncorrect = resultNodes[1];
           BSTNode firstIncorrectParent = resultNodes[2];
           BSTNode secondIncorrectParent = resultNodes[3];
           
           BSTNode temp = root;
           while(temp.data != firstIncorrectParent.data){
        	   if(temp.data > firstIncorrectParent.data){
        		   temp = temp.left;
        	   }else if(temp.data < firstIncorrectParent.data){
        		   temp = temp.right;
        	   }
           }
           while(temp.data != secondIncorrectParent.data){
        	   if(temp.data > secondIncorrectParent.data){
        		   temp = temp.left;
        	   }else if(temp.data < secondIncorrectParent.data){
        		   temp = temp.right;
        	   }
           }
       }
       return root;
    }

	private static BSTNode[] traverse(BSTNode root, BSTNode prev, boolean isLeft, BSTNode[] resultNodes) {
		// TODO Auto-generated method stub
		
		if(root == null){
			return null;
		}
		if(resultNodes != null && resultNodes[0] != null && resultNodes[1] != null){
			return resultNodes;
		}
		if(prev != null){
			if(isLeft){
				if(root.data >= prev.data){
					resultNodes[0] = root;
					resultNodes[2] = prev;
				//	resultNodes[4] = new BST
					
				}
			}else{
				if(root.data <= prev.data){
					resultNodes[1] = root;
					resultNodes[3] = prev;
				//	resultNodes[5] = 1;
				}
			}
		
		}
		prev = root;
		traverse(root.left, prev , true, resultNodes);
	    traverse(root.right, prev , false, resultNodes);
	    return resultNodes;
	}
	
    public static int numTrees(int n)
    {
       int sum = 0;
       for(int i =1;i<=n ; i++){
    	//   numTreesRec(i,n) = numTreesRec(i-1,n) * numTreesRec(n-i,n);
       }
       return sum;
    }

	private static int numTreesRec(int i, int n) {
		// TODO Auto-generated method stub
	       if(i == 1 || i == 0){
	    	   return 1;
	       }else if(i == 2){
	    	   return 2;
	       }else if(i == 3){
	    	   return 5;
	       }
	       return numTreesRec(i-1,n) * numTreesRec(n-i,n);
	}
	
	
	/*
	 * Construct BST from Postorder 
Given postorder traversal of a Binary Search Tree, you need to complete the function constructTree() which will create a BST. The output will be the inorder of the constructed BST.

Input:
The constructTree() method consist of two arguments as input, the array consisting of the post order traversal and the size of the array.

Output:
Print the Inorder traversal of the constructed BST.

Constraints:
1 <= T <= 100
1 <= N <= 100

Example:
Input:
2
6
1 7 5 50 40 10
9
216 823 476 429 850 93 18 975 862
	 * 
	 * 
	 */
	
    public static BSTNode constructTree(int inOrder[],int n){
    	
    	BSTNode root = null;
    	BSTNode templeft = null;
    	BSTNode tempRight = null;
        if(inOrder == null){
        	return null;
        }
        int[] postOrder = Arrays.copyOf(inOrder, inOrder.length);
        Arrays.sort(inOrder);
        int rootPosition = -1;
        for(int i = 0; i < inOrder.length; i++){
        	if(inOrder[i] == postOrder[postOrder.length-1]){
        		rootPosition = i;
        		root = new BSTNode(inOrder[i]);
        		templeft = root;
        		tempRight = root;
        	}
        }
        int leftSideLength = rootPosition;
        int rightSideLength = rootPosition;
     
        for(int j = postOrder.length-2; j >=0; j--){
        	for(int i = leftSideLength-1; i>=0; i--){
        		if(leftSideLength > 2){
             		if(postOrder[j] == inOrder[i]){
        				templeft.left = new BSTNode(postOrder[j]);
        				templeft = templeft.left;
        				leftSideLength -= 1;
        				break;
             		}	
        		}else{
        			if(templeft.data > postOrder[1]){
        				templeft.left = new BSTNode(postOrder[1]);
            			templeft.left.left = new BSTNode(postOrder[0]);
            			break;
        			}else if(templeft.data < postOrder[1]){
        				templeft.right = new BSTNode(postOrder[1]);
            			templeft.left = new BSTNode(postOrder[0]);
            			break;
        			}
        		}
        	}
        }
        
        for(int j = postOrder.length-2; j >=0; j--){
        	for(int i = rightSideLength+1; i < inOrder.length; i++){

        		if(inOrder.length-(rightSideLength+1) > 2){
             		if(postOrder[j] == inOrder[i]){
             			tempRight.right = new BSTNode(postOrder[j]);
             			tempRight = tempRight.right;
             			rightSideLength += 1;
        				break;
             		}	
        		}else{
        			if(tempRight.data > postOrder[postOrder.length-2]){
            			tempRight.left = new BSTNode(postOrder[postOrder.length-2]);
            			tempRight.right = new BSTNode(postOrder[postOrder.length-3]);
            			break;
        			}else if(tempRight.data < postOrder[postOrder.length-2]){
            			tempRight.right = new BSTNode(postOrder[postOrder.length-2]);
            			tempRight.right.right = new BSTNode(postOrder[postOrder.length-3]);
            			break;
        			}
        		}
        	
        	}
        }
        
        return root;
    }
}
