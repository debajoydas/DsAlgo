/**
 * 
 */
package com.debajoy.ds.tree.practice;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Debajoy
 * Binary Tree
 *
 */
public class PepCoding5 {

	/**
	 * @param args
	 */
	static BinaryNode1 root;
	static BinaryNode1 root1;
	static BinaryNode1 root2;
	static BinaryNode1 root3;
	static BinaryNode1 root4;
	static BinaryNode2 root5;
	static BinaryNode1 root6;
	static BinaryNode1 root7;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String SEPERATOR ="**************************************************************************************";
		Integer[] arr = {50,25,12,null,null,37,30,null,null,null,75,62,null,70,null,null,87,null,null};
		
		Integer[] arr1 = {1,2,4,8,12,null,null,13,null,null,
						9,14,null,null,15,null,null,5,10,16,20,24,28,
						null,null,29,null,null,25,30,null,null,31,null,null,
						21,26,32,null,null,33,null,null,27,null,null,
						17,22,null,null,23,null,null,11,18,null,null,
						19,null,null,3,6,null,null,7,null,null};
		
		Integer[] arr2 = {1,2,4,8,12,null,null,13,null,null,
				9,14,null,null,15,null,null,5,10,16,20,24,28,
				null,null,29,null,null,25,30,null,null,31,null,null,
				21,26,32,null,null,33,null,null,27,null,null,
				17,22,null,null,23,null,null,11,18,null,null,
				19,null,null,3,null,null};
		
		Integer[] arr3 = {50,25,12,null,null,
						  37,30,null,null,40,null,null,
						  75,62,60,null,null,
						  77,null,null,87,null,null};
		
		int[] PostOrder = {7,8,3,9,10,4,1,11,5,6,2,0};
		int[] InOrder = {7,3,8,1,9,4,10,0,11,5,2,6};
		
		char[] PreOrderC = {'A','B','D','H','I','E','C','F','G'};
		char[] PostOrderC = {'H','I','D','E','B','F','G','C','A'};
		
		int[] PreOrder1 = {1,2,4,8,9,5,10,11,3,6,12,13,7,14,15};
		int[] PostOrder1 = {8,9,4,10,11,5,2,12,13,6,14,15,7,3,1};
		
		int[] PreOrder2 = {0,1,3,7,8,4,9,10,2,5,11,6,12,13};
		int[] InOrder2 = {7,3,8,1,9,4,10,0,11,5,2,12,6,13};
		
		buildBinaryTree(arr);
		buildBinaryTree1(arr1);
		buildBinaryTree2(arr2);
		buildBinaryTree3(arr3);
		System.out.println("Level Order Traversal in Binary Tree :-");
		levelOrderTraversal(root);
		
		System.out.println(SEPERATOR);
		System.out.println("Level Order Traversal in Binary Tree :-");
		levelOrderTraversal(root1);
		System.out.println(SEPERATOR);
		System.out.println("Level Order Traversal in Binary Tree :-");
		levelOrderTraversal(root2);
		System.out.println(SEPERATOR);
		
		leftViewOfBinaryTree(root2);
		System.out.println(SEPERATOR);
		rightViewOfBinaryTree(root2);
		System.out.println(SEPERATOR);
		System.out.println("Level Order Zigzag Traversal in Binary Tree :-");
		levelOrderTraversalZigZag(root);
		System.out.println(SEPERATOR);
		
		System.out.println("Size of Binary Tree : "+getSize(root));
		System.out.println(SEPERATOR);
		System.out.println("Maximum in Binary Tree : "+maxInTree(root));
		System.out.println(SEPERATOR);
		System.out.println("Height of Binary Tree : "+getHeight(root));
		System.out.println(SEPERATOR);
		System.out.println("Sum of Binary Tree : "+getSum(root));
		System.out.println(SEPERATOR);
		
		System.out.println("PreOrder Node-Wise display in Binary Tree :-");
		display(root);
		System.out.println(SEPERATOR);
		iterativePrePostInOrder(root);
		System.out.println(SEPERATOR);
		int data= 30;
		rootToNodePath(root, data);
		System.out.println(SEPERATOR);
		nodeToRootPath(root, data);
		System.out.println(SEPERATOR);
		
		int kFromRoot = 3;
		System.out.println("Print k-level down from Root (left to right) := ");
		printKLevelDownFromRoot(root, kFromRoot);
		System.out.println(SEPERATOR);
		int k = 1;
		System.out.println("Print k-level down from given Node (left to right) := ");
		printKLevelDownFromAnyNode(root.right, k, null);
		System.out.println(SEPERATOR);
		int kFarAway = 2;
		int dataFar = 21;
		printNodesKLevelFar(root1, dataFar, kFarAway);
		
//		System.out.println(SEPERATOR);
//		pathLeafFromRoot(root);
//		System.out.println(SEPERATOR);
//		pathLeafFromRoot1(root);
//		System.out.println(SEPERATOR);
//		transformTOLeftClonedBinaryTree(root);
//		System.out.println(SEPERATOR);
		System.out.println(SEPERATOR);
		printSingleParentChilds(root);
//		System.out.println(SEPERATOR);
//		System.out.println("Remove Leaves from Binary Tree :=> ");
//		removeLeaves(root);
//		levelOrderTraversal(root);
		
		System.out.println(SEPERATOR);
		printtDiameterOfTree(root2);
		System.out.println(SEPERATOR);
		printtDiameterOfTreeOptimized(root2);
		System.out.println(SEPERATOR);
		tiltOfBinaryTree(root);
		System.out.println(SEPERATOR);
		isBinarySearchTree(root);
		System.out.println(SEPERATOR);
		isBalancedTree(root);
		largestBSTinBinaryTree(root3);
		System.out.println(SEPERATOR);
		
		constructBinaryTreeFromPostAndInOrder(PostOrder, InOrder);
		System.out.println(SEPERATOR);
		constructBinaryTreeFromPostAndPreOrder(PostOrderC, PreOrderC);
		System.out.println(SEPERATOR);
		constructBinaryTreeFromPostAndPreOrderInt(PostOrder1, PreOrder1);
		System.out.println(SEPERATOR);
		
		printBinaryTreeInVerticalOrder(root);
		System.out.println(SEPERATOR);
		verticalLengthOfBinaryTree(root);
		System.out.println(SEPERATOR);
		printBinaryTreeInVerticalOrderAlt(root);
		System.out.println(SEPERATOR);
		
		topViewOfBinaryTree(root);
		System.out.println(SEPERATOR);
		bottomViewOfBinaryTree(root);
		System.out.println(SEPERATOR);
		
		printDiagonalOrderRight(root);
		System.out.println(SEPERATOR);
		constructBinaryTreeFromPreAndInOrder(PreOrder2, InOrder2);
		System.out.println(SEPERATOR);
		int node = 11;
		printRootToNodePathFromCompleteZigZagBinaryTree(node);
	}

	private static void buildBinaryTree(Integer[] arr) {
		// TODO Auto-generated method stub
		Stack<BinaryPair> stack = new Stack<BinaryPair>();
		if(arr.length <= 0){
			return;
		}
		root = new BinaryNode1(arr[0]);
		stack.push(new BinaryPair(root,0));
		int index = 0;
		while(stack.size() > 0){
			BinaryPair peek = stack.peek();
			if(peek.status == 0){
				index++;
				if(arr[index] != null){
					BinaryNode1 newNode = new BinaryNode1(arr[index]);
					peek.status += 1;
					peek.node.left = newNode;
					BinaryPair newPair = new BinaryPair(newNode,0);
					stack.push(newPair);
				}else{
					peek.status += 1;
					peek.node.left = null;
				}		
			}else if(peek.status == 1){
				index++;
				if(arr[index] != null){
					BinaryNode1 newNode = new BinaryNode1(arr[index]);
					peek.status += 1;
					peek.node.right = newNode;
					BinaryPair newPair = new BinaryPair(newNode,0);
					stack.push(newPair);
				}else{
					peek.status += 1;
					peek.node.right = null;
				}
			}else{
				stack.pop();
			}
		}
	}
	
	private static void buildBinaryTree1(Integer[] arr) {
		// TODO Auto-generated method stub
		Stack<BinaryPair> stack = new Stack<BinaryPair>();
		if(arr.length <= 0){
			return;
		}
		root1 = new BinaryNode1(arr[0]);
		stack.push(new BinaryPair(root1,0));
		int index = 0;
		while(stack.size() > 0){
			BinaryPair peek = stack.peek();
			if(peek.status == 0){
				index++;
				if(arr[index] != null){
					BinaryNode1 newNode = new BinaryNode1(arr[index]);
					peek.status += 1;
					peek.node.left = newNode;
					BinaryPair newPair = new BinaryPair(newNode,0);
					stack.push(newPair);
				}else{
					peek.status += 1;
					peek.node.left = null;
				}		
			}else if(peek.status == 1){
				index++;
				if(arr[index] != null){
					BinaryNode1 newNode = new BinaryNode1(arr[index]);
					peek.status += 1;
					peek.node.right = newNode;
					BinaryPair newPair = new BinaryPair(newNode,0);
					stack.push(newPair);
				}else{
					peek.status += 1;
					peek.node.right = null;
				}
			}else{
				stack.pop();
			}
		}
	}
	
	private static void buildBinaryTree2(Integer[] arr) {
		// TODO Auto-generated method stub
		Stack<BinaryPair> stack = new Stack<BinaryPair>();
		if(arr.length <= 0){
			return;
		}
		root2 = new BinaryNode1(arr[0]);
		stack.push(new BinaryPair(root2,0));
		int index = 0;
		while(stack.size() > 0){
			BinaryPair peek = stack.peek();
			if(peek.status == 0){
				index++;
				if(arr[index] != null){
					BinaryNode1 newNode = new BinaryNode1(arr[index]);
					peek.status += 1;
					peek.node.left = newNode;
					BinaryPair newPair = new BinaryPair(newNode,0);
					stack.push(newPair);
				}else{
					peek.status += 1;
					peek.node.left = null;
				}		
			}else if(peek.status == 1){
				index++;
				if(arr[index] != null){
					BinaryNode1 newNode = new BinaryNode1(arr[index]);
					peek.status += 1;
					peek.node.right = newNode;
					BinaryPair newPair = new BinaryPair(newNode,0);
					stack.push(newPair);
				}else{
					peek.status += 1;
					peek.node.right = null;
				}
			}else{
				stack.pop();
			}
		}
	}
	
	private static void buildBinaryTree3(Integer[] arr) {
		// TODO Auto-generated method stub
		Stack<BinaryPair> stack = new Stack<BinaryPair>();
		if(arr.length <= 0){
			return;
		}
		root3 = new BinaryNode1(arr[0]);
		stack.push(new BinaryPair(root3,0));
		int index = 0;
		while(stack.size() > 0){
			BinaryPair peek = stack.peek();
			if(peek.status == 0){
				index++;
				if(arr[index] != null){
					BinaryNode1 newNode = new BinaryNode1(arr[index]);
					peek.status += 1;
					peek.node.left = newNode;
					BinaryPair newPair = new BinaryPair(newNode,0);
					stack.push(newPair);
				}else{
					peek.status += 1;
					peek.node.left = null;
				}		
			}else if(peek.status == 1){
				index++;
				if(arr[index] != null){
					BinaryNode1 newNode = new BinaryNode1(arr[index]);
					peek.status += 1;
					peek.node.right = newNode;
					BinaryPair newPair = new BinaryPair(newNode,0);
					stack.push(newPair);
				}else{
					peek.status += 1;
					peek.node.right = null;
				}
			}else{
				stack.pop();
			}
		}
	}
	
	public static void levelOrderTraversal(BinaryNode1 node){
		LinkedList<BinaryNode1> queue = new LinkedList<BinaryNode1>();
		queue.push(node);
		while(queue.size() > 0){
			int size = queue.size();
			for(int i = 0; i < size ; i++){
				BinaryNode1 popped = queue.pop();
				if(popped != null){
					System.out.print(popped.data+" -> ");	
					if(popped.left != null){
						queue.add(popped.left);
					}
					if(popped.right != null){
						queue.add(popped.right);
					}	
				}	
			}
			System.out.println();
		}
	}
	
	public static void levelOrderTraversal(BinaryNode2 node){
		LinkedList<BinaryNode2> queue = new LinkedList<BinaryNode2>();
		queue.push(node);
		while(queue.size() > 0){
			int size = queue.size();
			for(int i = 0; i < size ; i++){
				BinaryNode2 popped = queue.pop();
				System.out.print(popped.data+" -> ");
				if(popped.left != null){
					queue.add(popped.left);
				}
				if(popped.right != null){
					queue.add(popped.right);
				}		
			}
			System.out.println();
		}
	}
	
	public static void levelOrderTraversalZigZag(BinaryNode1 node){
		Stack<BinaryNode1> ms = new Stack<BinaryNode1>();
		Stack<BinaryNode1> cs = new Stack<BinaryNode1>();
		ms.push(node);
		int level = 1;
		while(ms.size() > 0){
			BinaryNode1 popedNode = ms.pop();
			System.out.print(popedNode.data+"->");
			if(level%2 != 0){
				if(popedNode.left != null){
					cs.push(popedNode.left);
				}
				if(popedNode.right != null){
					cs.push(popedNode.right);
				}	
			}else{
				if(popedNode.right != null){
					cs.push(popedNode.right);
				}	
				if(popedNode.left != null){
					cs.push(popedNode.left);
				}
			}
			if(ms.size() <= 0){
				ms = cs;
				cs = new Stack<BinaryNode1>();
				level++;
				System.out.println();
			}
		}		
	}
	
	public static int getSize(BinaryNode1 node){
		if(node == null){
			return 0;
		}
		return getSize(node.left)+getSize(node.right)+1;
	}
	public static int maxInTree(BinaryNode1 node){
		if(node == null){
			return Integer.MIN_VALUE;
		}
		return Math.max(node.data, Math.max(maxInTree(node.left), maxInTree(node.right)));
	}	
	public static int getHeight(BinaryNode1 node){
		if(node == null){
			return Integer.MIN_VALUE;
		}
		int h = -1;
		h = Math.max(h, Math.max(getHeight(node.left), getHeight(node.right)));
		h+=1;
		return h;
	}
	public static int getSum(BinaryNode1 node){
		if(node == null){
			return 0;
		}
		return getSum(node.left)+getSum(node.right)+node.data;
	}
	
	public static void display(BinaryNode1 node){
		if(node == null){
			return;
		}
		System.out.println();
		if(node.left == null){
			System.out.print("*->");
		}else{
			System.out.print(node.left.data+"->");
		}
		System.out.print(node.data+"->");
		if(node.right == null){
			System.out.print("*->");
		}else{
			System.out.print(node.right.data+"->");
		}
		display(node.left);
		display(node.right);
	}
	
	public static void iterativePrePostInOrder(BinaryNode1 node){
		StringBuilder preOrder = new StringBuilder("");
		StringBuilder postOrder = new StringBuilder("");
		StringBuilder inOrder = new StringBuilder("");
		
		Stack<BinaryPair> stack = new Stack<BinaryPair>();
		stack.push(new BinaryPair(node,0));
		
		while(stack.size() > 0){
			BinaryPair peek = stack.peek();		
			if(peek.status == 0){
				preOrder.append(peek.node.data).append("->");
				if(peek.node.left != null){
					stack.push(new BinaryPair(peek.node.left,0));
				}			
				peek.status += 1;
			}else if(peek.status == 1){
				inOrder.append(peek.node.data).append("->");
				if(peek.node.right != null){
					stack.push(new BinaryPair(peek.node.right,0));
				}			
				peek.status += 1;		
			}else{
				postOrder.append(peek.node.data).append("->");
				stack.pop();
			}
		}
		System.out.println("PreOrder Traversal := "+preOrder.toString());
		System.out.println("PostOrder Traversal := "+postOrder.toString());
		System.out.println("InOrder Traversal := "+inOrder.toString());
	}
	
	public static List<BinaryNode1> nodeToRoot(BinaryNode1 node, int data){
		List<BinaryNode1> list = new ArrayList<BinaryNode1>();
		nodeToRootRec(node, data, list);
		return list;
	}
	private static boolean nodeToRootRec(BinaryNode1 node,int data, List<BinaryNode1> list){
		if(node == null){
			return false;
		}else if(node != null && node.data == data){
			list.add(node);
			return true;
		}
		if(nodeToRootRec(node.left, data, list)){
			list.add(node);
			return true;
		}
		if(nodeToRootRec(node.right, data, list)){
			list.add(node);
			return true;
		}
		return false;	
	}
	
	public static List<Integer> nodeToRootPath(BinaryNode1 node, int data){
		List<Integer> list = new ArrayList<Integer>();
		nodeToRootPathRec(node, data, list);
		System.out.println("Distance from Node("+data+") to Root-" +node.data);
		list.forEach(n -> System.out.print(n+ " -> "));
		System.out.println();
		return list;
	}
	
	public static List<Integer> rootToNodePath(BinaryNode1 node, int data){
		List<Integer> list = new ArrayList<Integer>();
		nodeToRootPathRec(node, data, list);
		Collections.reverse(list);
		System.out.println("Distance from Root("+node.data+") to Node-" +data);
		list.forEach(n -> System.out.print(n+ " -> "));
		System.out.println();
		return list;
	}
	private static boolean nodeToRootPathRec(BinaryNode1 node,int data, List<Integer> list){
		if(node == null){
			return false;
		}else if(node != null && node.data == data){
			list.add(node.data);
			return true;
		}
		if(nodeToRootPathRec(node.left, data, list)){
			list.add(node.data);
			return true;
		}
		if(nodeToRootPathRec(node.right, data, list)){
			list.add(node.data);
			return true;
		}
		return false;	
	}
	
	public static void printKLevelDownFromRoot(BinaryNode1 node, int k){
		if(k < 0){
			return;
		}
		LinkedList<BinaryNode1> queue = new LinkedList<BinaryNode1>();
		queue.push(node);
		int level = 0;
		boolean isDone = false;
		while(queue.size() > 0){
			int size = queue.size();
			for(int i = 0; i < size ; i++){
				BinaryNode1 popped = queue.pop();
				if(level == k){
					isDone = true;
					System.out.print(popped.data+" -> ");
				}			
				if(popped.left != null){
					queue.add(popped.left);
				}
				if(popped.right != null){
					queue.add(popped.right);
				}		
			}
			if(isDone){
				System.out.println();
				return;
			}
			level++;
		}
	}
	
	public static void printKLevelDownFromAnyNode(BinaryNode1 node, int k, BinaryNode1 blocked){
		if(node == null || k < 0 || node == blocked){
			return;
		}
		if(k == 0){
			System.out.print(node.data+"->");
		}
		printKLevelDownFromAnyNode(node.left, k-1, blocked);
		printKLevelDownFromAnyNode(node.right, k-1, blocked);
	}
	
	public static void printNodesKLevelFar(BinaryNode1 node, int data, int k){
		System.out.println("Print All Nodes which are "+k+"-level Far Away From Node-"+data);
		List<BinaryNode1> listNodeToRoot = nodeToRoot(node, data);
		for(int i= 0; i <listNodeToRoot.size(); i++){
			printKLevelDownFromAnyNode(listNodeToRoot.get(i), k-i,i == 0? null : listNodeToRoot.get(i-1));
		}
	}
	
	public static void pathLeafFromRoot(BinaryNode1 node){
		System.out.println("Print All paths from Root to Leaf nodes := ");
		StringBuilder path = new StringBuilder("");
		Integer sum = new Integer(0);
		pathLeafFromRootRec(node, path, sum);
	}
	
	public static void pathLeafFromRoot1(BinaryNode1 node){
		System.out.println("Print All paths from Root to Leaf nodes := ");
		String path = new String("");
		Integer sum = new Integer(0);
		pathLeafFromRootRec1(node, path, sum);
	}
	
	public static void pathLeafFromRootRec(BinaryNode1 node, StringBuilder path, Integer sum){
		if(node == null){
			return;
		}else if(node.left == null && node.right == null){
			path.append(node.data).append("->"); 
			sum += node.data;
			System.out.println("Path := "+path.toString()+ " || Sum := "+sum);
			return;
		}	
		StringBuilder pathCop = new StringBuilder(path);
		Integer sumCop = new Integer(sum);
		pathLeafFromRootRec(node.left, path.append(node.data).append("->"), sum.intValue()+node.data);
		pathLeafFromRootRec(node.right, pathCop.append(node.data).append("->"), sumCop.intValue()+node.data);
	}
	
	public static void pathLeafFromRootRec1(BinaryNode1 node, String path, int sum){
		if(node == null){
			return;
		}else if(node.left == null && node.right == null){
			path = path + node.data + "->"; 
			sum += node.data;
			System.out.println("Path := "+path+ " || Sum := "+sum);
			return;
		}	
		pathLeafFromRootRec1(node.left, path + node.data + "->", sum+node.data);
		pathLeafFromRootRec1(node.right,path + node.data + "->", sum+node.data);
	}
	
	public static void transformTOLeftClonedBinaryTree(BinaryNode1 node){
		System.out.println("Transform to Left Cloned Binary Tree :=> ");
		BinaryNode1 node1 = transformTOLeftClonedBinaryTreeRec(node);
		levelOrderTraversal(node1);
		BinaryNode1 node2 = transformBackFromLeftClonedBinaryTreeRec(node1);
		System.out.println("Transform Back From Left Cloned Binary Tree :=> ");
		levelOrderTraversal(node2);
	}
	
	public static BinaryNode1 transformTOLeftClonedBinaryTreeRec(BinaryNode1 node){
		if(node == null){
			return null;
		}
		BinaryNode1 left = transformTOLeftClonedBinaryTreeRec(node.left);
		BinaryNode1 right = transformTOLeftClonedBinaryTreeRec(node.right);
		BinaryNode1 dupNode = new BinaryNode1(node.data);
		node.left= dupNode;
		node.right = right;
		dupNode.left = left;
		return node;
	}

	private static BinaryNode1 transformBackFromLeftClonedBinaryTreeRec(BinaryNode1 node) {
		if(node == null){
			return null;
		}
		BinaryNode1 left = null;
		BinaryNode1 right = null;
		if(node.left != null){
			left = transformTOLeftClonedBinaryTreeRec(node.left.left);	
		}
		right = transformTOLeftClonedBinaryTreeRec(node.right);
		node.left= left;
		node.right = right;
		return node;
	}
	public static void printSingleParentChilds(BinaryNode1 node){
		System.out.println("Print Nodes whose Parent has single child :=> ");
		printSingleParentChilds(node, null);
	}
	private static void printSingleParentChilds(BinaryNode1 current, BinaryNode1 parent){
		if(current == null){
			return;
		}
		if(parent != null && ((parent.left != null && parent.right == null) || (parent.left == null && parent.right != null))){
			System.out.println(current.data);
		}
		printSingleParentChilds(current.left,current);
		printSingleParentChilds(current.right,current);
	}
	
	public static BinaryNode1 removeLeaves(BinaryNode1 node){
		if(node == null || (node != null && node.left == null && node.right == null)){
			return null;
		}
		BinaryNode1 left = removeLeaves(node.left);
		BinaryNode1 right = removeLeaves(node.right);
		node.left = left;
		node.right = right;
		return node;
	}
	
	public static void printtDiameterOfTree(BinaryNode1 root){
		System.out.println("Diameter of Binary Tree is : "+getDiameter(root));
		System.out.println();
	}
	
	private static int getDiameter(BinaryNode1 root){
		if(root == null){
			return 0;
		}
		return Math.max((getHeight(root.left)+getHeight(root.right)+2), Math.max(getDiameter(root.left),getDiameter(root.right)));
	}
	
	public static void printtDiameterOfTreeOptimized(BinaryNode1 root){
		System.out.println("Optimized Way : Diameter of Binary Tree is : "+getDiameterOptimized(root).diameter);
		System.out.println();
	}

	private static DiameterPair getDiameterOptimized(BinaryNode1 node) {
		// TODO Auto-generated method stub
		if(node == null){
			DiameterPair pair = new DiameterPair(-1,0);
			return pair;
		}
		DiameterPair left = getDiameterOptimized(node.left);
		DiameterPair right = getDiameterOptimized(node.right);
		int diameter = Math.max(left.height+right.height+2, Math.max(left.diameter, right.diameter));
		int height = Math.max(left.height, right.height)+1;
		DiameterPair current = new  DiameterPair(height,diameter);
		return current;
	}
	
	public static void tiltOfBinaryTree(BinaryNode1 node){
		System.out.println("Tilt of Binary Tree :=> "+tiltOfBinaryTreeRec(node));
		System.out.println();
	}
	
	public static int tiltOfBinaryTreeRec(BinaryNode1 node){
		if(node == null){
			return 0;
		}
		int left = tiltOfBinaryTreeRec(node.left);
		int right = tiltOfBinaryTreeRec(node.right);
		System.out.println("Tilt of "+node.data+" := "+Math.abs(left-right));
		return left+right+node.data;
	}
	
	public static void isBinarySearchTree(BinaryNode1 node){
		System.out.println("Is it a Binary Search Tree ? :=> "+isBinarySearchTreeRec(node).isBST);
		System.out.println();
	}

	private static BSTPair1 isBinarySearchTreeRec(BinaryNode1 node) {
		// TODO Auto-generated method stub
		if(node == null){		
			BSTPair1 pair = new BSTPair1(Integer.MIN_VALUE,Integer.MAX_VALUE,true);
			return pair;
		}
		BSTPair1 left = isBinarySearchTreeRec(node.left);
		BSTPair1 right = isBinarySearchTreeRec(node.right);
		int max = Math.max(Math.max(left.max, right.max),node.data);
		int min = Math.max(Math.max(left.min, right.min),node.data);
		boolean isBST =  left.isBST && right.isBST && (node.data > left.max && node.data < right.min);
		BSTPair1 current = new BSTPair1(max,min,isBST);
		return current;
	}
	
	public static void isBalancedTree(BinaryNode1 node){
		System.out.println("Is it a Balanced Tree ? :=> "+isBalancedTreeRecc(node).isBalancedTree);
		System.out.println();
	}

	private static BalancedTreePair isBalancedTreeRecc(BinaryNode1 node) {
		// TODO Auto-generated method stub
		if(node == null){
			BalancedTreePair pair = new BalancedTreePair(0, true);
			return pair;
		}
		BalancedTreePair left = isBalancedTreeRecc(node.left);
		BalancedTreePair right = isBalancedTreeRecc(node.left);
		int height = Math.max(left.height, right.height)+1;
		boolean isBalancedTree = left.isBalancedTree && right.isBalancedTree && Math.abs(left.height-right.height) <= 1;
		BalancedTreePair current = new BalancedTreePair(height, isBalancedTree);
		return current;
	}
	
	public static void largestBSTinBinaryTree(BinaryNode1 node){
		AtomicInteger size = new AtomicInteger(0);
		AtomicReference<BinaryNode1> maxNode = new AtomicReference<>(node);
		largestBSTinBinaryTreeRec(node,maxNode,size);
		System.out.println("Largest BST Node with Size in a Binary Tree is :=> "+maxNode.get().data+"(Node) @"+size+"(Size)");
		System.out.println();
	}

	private static BSTPair1 largestBSTinBinaryTreeRec(BinaryNode1 node, AtomicReference<BinaryNode1> maxNode, AtomicInteger size) {
		// TODO Auto-generated method stub
		if(node == null){		
			BSTPair1 pair = new BSTPair1(Integer.MIN_VALUE,Integer.MAX_VALUE,true);
			return pair;
		}
		BSTPair1 left = largestBSTinBinaryTreeRec(node.left, maxNode, size);
		BSTPair1 right = largestBSTinBinaryTreeRec(node.right, maxNode, size);
		int max = Math.max(Math.max(left.max, right.max),node.data);
		int min = Math.max(Math.max(left.min, right.min),node.data);
		boolean isBST =  left.isBST && right.isBST && (node.data > left.max && node.data < right.min);
		int sizeC = left.size+right.size+1;
		BSTPair1 current = new BSTPair1(max,min,isBST,sizeC);
		if(isBST && sizeC > size.get()){
			size.set(sizeC);
			maxNode.set(node);
		}
		return current;
	}
	
	public static void constructBinaryTreeFromPostAndPreOrderInt(int[] post, int[] pre){
		System.out.println("Construct Binary Tree from PostOrder and PreOrder :=>");
		HashMap<Integer, Integer> preMap = new HashMap<>();
		HashMap<Integer, Integer> postMap = new HashMap<>();
		for(int i = 0; i < pre.length; i++){
			preMap.put(pre[i], i);
		}
		for(int i = 0; i < post.length; i++){
			postMap.put(post[i], i);
		}
		root6 = constructBinaryTreeFromPostAndPreOrderRecInt(post, pre, 0, pre.length-1, 0, preMap, postMap);
		levelOrderTraversal(root6);
	}
	private static BinaryNode1 constructBinaryTreeFromPostAndPreOrderRecInt(int[] post, int[] pre, int start, int end, int pos, HashMap<Integer, Integer> preMap, HashMap<Integer, Integer> postMap){
		if(start > end || start >= post.length || end >= post.length){
			return null;
		}
		if(start == end){
			BinaryNode1 node = new BinaryNode1(pre[start]);
			return node;
		}
		BinaryNode1 node = new BinaryNode1(pre[start]);
		int ls = start+1;
		int idx = postMap.get(pre[ls]);
		int length = idx-pos;
		int le = ls+length;
		int rs = le+1;
		int re = end;
		node.left = constructBinaryTreeFromPostAndPreOrderRecInt(post, pre, ls, le, pos, preMap, postMap);
		node.right = constructBinaryTreeFromPostAndPreOrderRecInt(post, pre, rs, re, idx+1, preMap, postMap);
		return node;
	}
	
	public static void constructBinaryTreeFromPostAndPreOrder(char[] post, char[] pre){
		System.out.println("Construct Binary Tree from PostOrder and PreOrder :=>");
		HashMap<Character, Integer> preMap = new HashMap<>();
		HashMap<Character, Integer> postMap = new HashMap<>();
		for(int i = 0; i < pre.length; i++){
			preMap.put(pre[i], i);
		}
		for(int i = 0; i < post.length; i++){
			postMap.put(post[i], i);
		}
		root5 = constructBinaryTreeFromPostAndPreOrderRec(post, pre, 0, pre.length-1, 0, preMap, postMap);
		levelOrderTraversal(root5);
	}
	private static BinaryNode2 constructBinaryTreeFromPostAndPreOrderRec(char[] post, char[] pre, int start, int end, int pos, HashMap<Character, Integer> preMap, HashMap<Character, Integer> postMap){
		if(start > end || start >= post.length || end >= post.length){
			return null;
		}
		if(start == end){
			BinaryNode2 node = new BinaryNode2(pre[start]);
			return node;
		}
		BinaryNode2 node = new BinaryNode2(pre[start]);
		int ls = start+1;
		int idx = postMap.get(pre[ls]);
		int length = idx-pos;
		int le = ls+length;
		int rs = le+1;
		int re = end;
		node.left = constructBinaryTreeFromPostAndPreOrderRec(post, pre, ls, le, pos, preMap, postMap);
		node.right = constructBinaryTreeFromPostAndPreOrderRec(post, pre, rs, re, idx+1, preMap, postMap);
		return node;
	}
	
	public static void constructBinaryTreeFromPostAndInOrder(int[] post, int[] in){
		System.out.println("Construct Binary Tree from PostOrder and InOrder :=>");
		HashMap<Integer, Integer> inMap = new HashMap<>();
		HashMap<Integer, Integer> postMap = new HashMap<>();
		for(int i = 0; i < in.length; i++){
			inMap.put(in[i], i);
		}
		for(int i = 0; i < post.length; i++){
			postMap.put(post[i], i);
		}
		root4 = constructBinaryTreeFromPostAndInOrderRec(post, in, 0, in.length-1, 0, inMap, postMap);
		levelOrderTraversal(root4);
	}
	private static BinaryNode1 constructBinaryTreeFromPostAndInOrderRec(int[] post, int[] in, int start, int end, int count, HashMap<Integer, Integer> inMap, HashMap<Integer, Integer> postMap){
		if(start > end){
			return null;
		}
		int postOrderValue = post[end-count];
		int inOrderIdx = inMap.get(postOrderValue);
		int ls = start; int le = inOrderIdx-1;
		int rs = inOrderIdx+1; int re = end;
		BinaryNode1  node = new BinaryNode1(in[inOrderIdx]);
		node.left = constructBinaryTreeFromPostAndInOrderRec(post, in, ls, le, count, inMap, postMap);
		node.right = constructBinaryTreeFromPostAndInOrderRec(post, in, rs, re, count+1, inMap, postMap);
		return node;
	}
	
	public static void leftViewOfBinaryTree(BinaryNode1 node){
		System.out.println("Left View Of a Binary Tree :=> ");
		HashMap<Integer,ArrayList<Integer>> levelMap = new HashMap<Integer,ArrayList<Integer>>();
		LinkedList<BinaryNode1> queue = new LinkedList<BinaryNode1>();
		queue.push(node);
		int level = 0;
		while(queue.size() > 0){
			int size = queue.size();
			for(int i = 0; i < size ; i++){
				BinaryNode1 popped = queue.pop();
				if(popped != null){
					if(levelMap.get(level) != null){
						levelMap.get(level).add(popped.data);
					}else{
						levelMap.put(level, new ArrayList<>());
						levelMap.get(level).add(popped.data);
					}
					if(popped.left != null){
						queue.add(popped.left);
					}
					if(popped.right != null){
						queue.add(popped.right);
					}	
				}	
			}
			level++;
		}
		levelMap.entrySet().stream().forEach(e -> System.out.println(e.getValue().get(0)));	
	}
	
	public static void rightViewOfBinaryTree(BinaryNode1 node){
		System.out.println("Right View Of a Binary Tree :=> ");
		HashMap<Integer,ArrayList<Integer>> levelMap = new HashMap<Integer,ArrayList<Integer>>();
		LinkedList<BinaryNode1> queue = new LinkedList<BinaryNode1>();
		queue.push(node);
		int level = 0;
		while(queue.size() > 0){
			int size = queue.size();
			for(int i = 0; i < size ; i++){
				BinaryNode1 popped = queue.pop();
				if(popped != null){
					if(levelMap.get(level) != null){
						levelMap.get(level).add(popped.data);
					}else{
						levelMap.put(level, new ArrayList<>());
						levelMap.get(level).add(popped.data);
					}
					if(popped.left != null){
						queue.add(popped.left);
					}
					if(popped.right != null){
						queue.add(popped.right);
					}	
				}	
			}
			level++;
		}
		levelMap.entrySet().stream().forEach(e -> System.out.println(e.getValue().get(e.getValue().size()-1)));	
	}
	
	public static void verticalLengthOfBinaryTree(BinaryNode1 node){
		HashMap<Integer,ArrayList<Integer>> levelMap = new HashMap<Integer,ArrayList<Integer>>();
		int state = 0;
		printBinaryTreeInVerticalOrderRec(node, state, levelMap);
		System.out.println("Vertical Width Of a Binary Tree :=> "+levelMap.size());
	}
	
	public static void printBinaryTreeInVerticalOrder(BinaryNode1 node){
		System.out.println("Vertical Order Traversal Of a Binary Tree :=> ");
		HashMap<Integer,ArrayList<Integer>> levelMap = new HashMap<Integer,ArrayList<Integer>>();
		int state = 0;
		printBinaryTreeInVerticalOrderRec(node, state, levelMap);
		levelMap.entrySet().stream().map(entry -> entry.getValue()).forEach(v -> System.out.println(v+"->"));;
	}

	private static void printBinaryTreeInVerticalOrderRec(BinaryNode1 node, int state, HashMap<Integer, ArrayList<Integer>> levelMap) {
		// TODO Auto-generated method stub
		if(node == null){
			return;
		}
		printBinaryTreeInVerticalOrderRec(node.left, state-1, levelMap);
		printBinaryTreeInVerticalOrderRec(node.right, state+1, levelMap);
		if(levelMap.get(state) == null){
			ArrayList<Integer> list = new ArrayList<>();
			list.add(node.data);
			levelMap.put(state, list);
		}else{
			levelMap.get(state).add(node.data);
		}
	}
	
	public static void printBinaryTreeInVerticalOrderAlt(BinaryNode1 node){
		System.out.println("Vertical Order Traversal Alternative Way Of a Binary Tree :=> ");
		TreeMap<Integer,ArrayList<Integer>> levelMap = new TreeMap<Integer,ArrayList<Integer>>();	
		ArrayDeque<VerticalPair> queue = new ArrayDeque<VerticalPair>();
		VerticalPair pair = new VerticalPair(0,node);
		queue.push(pair);
		while(queue.size() > 0){
			int size = queue.size();
			for(int i = 0; i < size; i++){
				VerticalPair popped = queue.poll();
				if(popped != null && popped.node != null){
					if(levelMap.get(popped.state) == null){
						ArrayList<Integer> list = new ArrayList<>();
						list.add(popped.node.data);
						levelMap.put(popped.state, list);
					}else{
						levelMap.get(popped.state).add(popped.node.data);
					}
					if(popped.node.left != null){
						queue.push(new VerticalPair(popped.state-1,popped.node.left));
					}
					if(popped.node.right != null){
						queue.push(new VerticalPair(popped.state+1,popped.node.right));
					}
				}
			}
		}
		levelMap.entrySet().stream().map(entry -> entry.getValue()).forEach(v -> System.out.println(v+"->"));
		System.out.println("End");
	}
	
	public static void topViewOfBinaryTree(BinaryNode1 node){
		System.out.println("Top View Of a Binary Tree :=> ");
		TreeMap<Integer,ArrayList<Integer>> levelMap = new TreeMap<Integer,ArrayList<Integer>>();	
		ArrayDeque<VerticalPair> queue = new ArrayDeque<VerticalPair>();
		VerticalPair pair = new VerticalPair(0,node);
		queue.push(pair);
		while(queue.size() > 0){
			int size = queue.size();
			for(int i = 0; i < size; i++){
				VerticalPair popped = queue.poll();
				if(popped != null && popped.node != null){
					if(levelMap.get(popped.state) == null){
						ArrayList<Integer> list = new ArrayList<>();
						list.add(popped.node.data);
						levelMap.put(popped.state, list);
					}else{
						levelMap.get(popped.state).add(popped.node.data);
					}
					if(popped.node.left != null){
						queue.push(new VerticalPair(popped.state-1,popped.node.left));
					}
					if(popped.node.right != null){
						queue.push(new VerticalPair(popped.state+1,popped.node.right));
					}
				}
			}
		}
		levelMap.entrySet().stream().map(entry -> entry.getValue()).forEach(v -> System.out.println(v.get(0)+"->"));
	}
	public static void bottomViewOfBinaryTree(BinaryNode1 node){
		System.out.println("Bottom View Of a Binary Tree :=> ");
		TreeMap<Integer,ArrayList<Integer>> levelMap = new TreeMap<Integer,ArrayList<Integer>>();	
		ArrayDeque<VerticalPair> queue = new ArrayDeque<VerticalPair>();
		VerticalPair pair = new VerticalPair(0,node);
		queue.push(pair);
		while(queue.size() > 0){
			int size = queue.size();
			for(int i = 0; i < size; i++){
				VerticalPair popped = queue.poll();
				if(popped != null && popped.node != null){
					if(levelMap.get(popped.state) == null){
						ArrayList<Integer> list = new ArrayList<>();
						list.add(popped.node.data);
						levelMap.put(popped.state, list);
					}else{
						levelMap.get(popped.state).add(popped.node.data);
					}
					if(popped.node.left != null){
						queue.push(new VerticalPair(popped.state-1,popped.node.left));
					}
					if(popped.node.right != null){
						queue.push(new VerticalPair(popped.state+1,popped.node.right));
					}
				}
			}
		}
		levelMap.entrySet().stream().map(entry -> entry.getValue()).forEach(v -> System.out.println(v.get(v.size()-1)+"->"));
	}
	
	public static void printDiagonalOrderRight(BinaryNode1 node){
		System.out.println("Diagonal Order(Right-Wise) Traversal Of a Binary Tree :=> ");
		TreeMap<Integer,ArrayList<Integer>> levelMap = new TreeMap<Integer,ArrayList<Integer>>();
		Queue<BinaryNode1> queue = new LinkedList<BinaryNode1>();
		queue.add(node);
		int level = 0;
		while(queue.size() > 0){
			int size = queue.size();
			for(int i = 0; i < size; i++){
				BinaryNode1 popped = queue.remove();
				while(popped != null){
					if(popped.left != null){
						queue.add(popped.left);
					}
					if(levelMap.get(level) != null){
						levelMap.get(level).add(popped.data);
					}else{
						ArrayList<Integer> list = new ArrayList<Integer>();
						list.add(popped.data);
						levelMap.put(level, list);
					}
					popped = popped.right;
				}
			}
			level++;
		}
		levelMap.entrySet().stream().map(entry -> entry.getValue()).forEach(v -> System.out.println(v));
	}
	
	public static void constructBinaryTreeFromPreAndInOrder(int[] pre, int[] in){
		System.out.println("Construct Binary Tree from PreOrder and InOrder :=>");
		HashMap<Integer, Integer> preMap = new HashMap<>();
		HashMap<Integer, Integer> inMap = new HashMap<>();
		for(int i = 0; i < pre.length; i++){
			preMap.put(pre[i], i);
		}
		for(int i = 0; i < in.length; i++){
			inMap.put(in[i], i);
		}
		root7 = constructBinaryTreeFromPreAndInOrderRec(in, pre, 0, pre.length-1, 0, preMap, inMap);
		levelOrderTraversal(root7);

	}

	private static BinaryNode1 constructBinaryTreeFromPreAndInOrderRec(int[] in, int[] pre, int start, int end, int count,
			HashMap<Integer, Integer> preMap, HashMap<Integer, Integer> inMap) {
		// TODO Auto-generated method stub
		if(start > end || start >= pre.length || end >= pre.length ||  start < 0 || end < 0){
			return null;
		}else if(start == end){
			BinaryNode1 node = new BinaryNode1(pre[start]);
			return node;
		}
		BinaryNode1 node = new BinaryNode1(pre[start]);
		int idx = inMap.get(pre[start]);
		int length = idx - count -1;
		int ls = start+1;
		int le = ls + length;
		int rs = le+1;
		int re = end;
		node.left = constructBinaryTreeFromPreAndInOrderRec(in, pre, ls, le, count, preMap, inMap);
		node.right = constructBinaryTreeFromPreAndInOrderRec(in, pre, rs, re, idx+1, preMap, inMap);
		return node;
	}
	
	public static void printRootToNodePathFromCompleteZigZagBinaryTree(int node) {
		// TODO Auto-generated method stub
		System.out.println("Print Root to Node("+node+") Path in a Complete Binary Tree of ZigZag Order => ");
		int exponent = 0;
		int level = 1;
		int number = 1;
		int idx = 0; int levelCoubnter  = 1;
		List<Integer> output = new ArrayList<>();
		TreeMap<Integer,List<Integer>> map = new TreeMap<Integer,List<Integer>>();
		while(number < node){
			int n = (int) Math.pow(2, exponent);
			if(level%2 != 0){
				List<Integer> list = new ArrayList<Integer>(n);
				for(int i = 0; i < n; i++){
					if(number == node){
						idx = i+1;
						levelCoubnter = level;
					}
					list.add(number);
					number++;
				}
				map.put(level, list);
			}else{
				List<Integer> list = new ArrayList<Integer>(n);
				for(int i = 0; i < n; i++){
					if(number == node){
						idx = i+1;
						levelCoubnter = level;
					}
					list.add(number);
					number++;
				}
				Collections.reverse(list);
				map.put(level, list);
			}
			level++;
			exponent++;
		}
		while(levelCoubnter > 1){
			List<Integer> list = map.get(levelCoubnter);
			output.add(list.get(idx));
			if((idx+1)%2 != 0){
				idx = (idx+1)/2+1;
			}else{
				idx = (idx+1)/2;
			}
			levelCoubnter--;
		}
		output.add(1);
		Collections.sort(output);
		output.stream().forEach(s -> System.out.print(s+"->"));
		
	}
}

class VerticalPair{
	int state;
	BinaryNode1 node;
	public VerticalPair(int state, BinaryNode1 node) {
		super();
		this.state = state;
		this.node = node;
	}
	public VerticalPair(){
	}
}

class BalancedTreePair{
	int height;
	boolean isBalancedTree;
	public BalancedTreePair(int height, boolean isBalancedTree) {
		super();
		this.height = height;
		this.isBalancedTree = isBalancedTree;
	}
}

class BSTPair1{
	int max;
	int min;
	boolean isBST;
	int size;
	public BSTPair1(int max, int min, boolean isBST, int size) {
		super();
		this.max = max;
		this.min = min;
		this.isBST = isBST;
		this.size = size;
	}
	public BSTPair1(int max, int min, boolean isBST) {
		super();
		this.max = max;
		this.min = min;
		this.isBST = isBST;
	}
	public BSTPair1(){
	}
}

class DiameterPair{
	int height;
	int diameter;
	public DiameterPair(int height, int diameter) {
		super();
		this.height = height;
		this.diameter = diameter;
	}
	public DiameterPair(){}
}

class BinaryPair{
	BinaryNode1 node;
	int status;
	public BinaryPair(BinaryNode1 node, int status) {
		super();
		this.node = node;
		this.status = status;
	}
	public BinaryPair(){}
}

class BinaryNode1{
	int data;
	BinaryNode1 left;
	BinaryNode1 right;
	public BinaryNode1(int data) {
		super();
		this.data = data;
	}
	public BinaryNode1(int data, BinaryNode1 left, BinaryNode1 right) {
		super();
		this.data = data;
		this.left = left;
		this.right = right;
	}
	public BinaryNode1() {
	}
	
}

class BinaryNode2{
	char data;
	BinaryNode2 left;
	BinaryNode2 right;
	public BinaryNode2(char data) {
		super();
		this.data = data;
	}
	public BinaryNode2(char data, BinaryNode2 left, BinaryNode2 right) {
		super();
		this.data = data;
		this.left = left;
		this.right = right;
	}
	public BinaryNode2() {
	}
	
}