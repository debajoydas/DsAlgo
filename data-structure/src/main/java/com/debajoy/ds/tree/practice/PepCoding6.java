/**
 * 
 */
package com.debajoy.ds.tree.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Debajoy
 *
 */
public class PepCoding6 {

	/**
	 * @param args
	 * Binary Search Tree
	 */
	static BSTNode root;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String SEPERATOR ="**************************************************************************************";
		int[] arr = {12,25,37,50,62,75,87};
		System.out.println(SEPERATOR);
		root = constructBinaryTree(arr);
		levelOrderTraversal(root);
		System.out.println(SEPERATOR);
		System.out.println("Size of Binary Search Tree : "+getSize(root));
		System.out.println(SEPERATOR);
		System.out.println("Maximum in Binary Search Tree : "+maxInTree(root));
		System.out.println(SEPERATOR);
		System.out.println("Minimum in Binary Search Tree : "+minInTree(root));
		System.out.println(SEPERATOR);
		System.out.println("Height of Binary Search Tree : "+getHeight(root));
		System.out.println(SEPERATOR);
		System.out.println("Sum of Binary Search Tree : "+getSum(root));
		System.out.println(SEPERATOR);
		int data1 = 75;int data2 = 14;
		System.out.println("Find data("+data1+") in Binary Search Tree : "+find(root,data1));
		System.out.println("Find data("+data2+") in Binary Search Tree : "+find(root,data2));
		System.out.println(SEPERATOR);
		int data3 = 70;
		addNode(root, data3);
		int data4 = 30;
		addNode(root, data4);
		levelOrderTraversal(root);
		System.out.println(SEPERATOR);
//		replaceSum(root);
//		int data5 = 75;
//		removeNode(root, data5);
//		levelOrderTraversal(root);
//		int data6 = 62;
//		removeNode(root, data6);
//		levelOrderTraversal(root);
		int data7 = 31; int data8 = 70;
		findLCA(root, data7, data8);
		findLCAOptimized(root, data7, data8);
		System.out.println(SEPERATOR);
		int range1 = 13; int range2 = 71;
		printInRangeNodes(root, range1, range2);
		System.out.println(SEPERATOR);
		int sum = 100;
		targetSumSubSets(root, sum);
	}
	
	public static BSTNode constructBinaryTree(int[] arr){
		int low = 0;
		int high = arr.length-1;
		return constructBinaryTreeRec(arr,low,high);
	}

	private static BSTNode constructBinaryTreeRec(int[] arr, int low, int high) {
		// TODO Auto-generated method stub
		if(low > high){
			return null;
		}
		int mid = (low+high)/2;
		BSTNode node = new BSTNode(arr[mid]);
		node.left = constructBinaryTreeRec(arr, low, mid-1);
		node.right = constructBinaryTreeRec(arr, mid+1, high);
		return node;
	}
	
	public static void levelOrderTraversal(BSTNode node){
		System.out.println("Level Order Traversal in Binary Search Tree :-");
		LinkedList<BSTNode> queue = new LinkedList<BSTNode>();
		queue.push(node);
		while(queue.size() > 0){
			int size = queue.size();
			for(int i = 0; i < size ; i++){
				BSTNode popped = queue.pop();
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
	
	public static int getSize(BSTNode node){
		if(node == null){
			return 0;
		}
		return getSize(node.left)+getSize(node.right)+1;
	}
	public static int maxInTree(BSTNode node){
		if(node.right != null){
			return maxInTree(node.right);
		}else{
			return node.data;
		}
	}	
	public static int minInTree(BSTNode node){
		if(node.left != null){
			return minInTree(node.left);
		}else{
			return node.data;
		}	
	}	
	public static boolean find(BSTNode node, int data){
		if(node == null){
			return false;
		}
		if(data > node.data){
			return find(node.right, data);
		}else if(data < node.data){
			return find(node.left, data);
		}else{
			return true;
		}
	}
	public static int getHeight(BSTNode node){
		if(node == null){
			return Integer.MIN_VALUE;
		}
		int h = -1;
		h = Math.max(h, Math.max(getHeight(node.left), getHeight(node.right)));
		h+=1;
		return h;
	}
	public static int getSum(BSTNode node){
		if(node == null){
			return 0;
		}
		return getSum(node.left)+getSum(node.right)+node.data;
	}

	public static BSTNode addNode(BSTNode node, int data){
		System.out.println("Add Node with data("+data+") in the BST :=>");
		return addNodeRec(node, data);	
	}
	private static BSTNode addNodeRec(BSTNode node, int data){
		if(node == null){
			BSTNode newNode = new BSTNode(data);
			return newNode;
		}
		if(data > node.data){
			node.right = addNodeRec(node.right, data);
		}else if(data < node.data){
			node.left = addNodeRec(node.left, data);
		}
		return node;
	}
	
	public static BSTNode removeNode(BSTNode node, int data){
		System.out.println("Remove Node with data("+data+") in the BST :=>");
		return removeNodeRec(node, data);	
	}
	private static BSTNode removeNodeRec(BSTNode node, int data){
		if(node == null){
			return null;
		}else if(node.data > data){
			node.left = removeNodeRec(node.left, data);
		}else if(node.data < data){
			node.right = removeNodeRec(node.right, data);
		}else if(node.data == data){
			if(node.left == null && node.right == null){
				return null;
			}else if(node.left != null && node.right == null){
				return node.left;
			}else if(node.left == null && node.right != null){
				return node.right;
			}else if(node.left != null && node.right != null){
				int max = getMaxParent(node.left);
				node.data = max;
				node.left = removeNodeRec(node.left, max);
			}
		}
		return node;
	}

	private static int getMaxParent(BSTNode node) {
		// TODO Auto-generated method stub
		if(node.right != null){
			return getMaxParent(node.right);
		}else{
			return node.data;
		}
	}
	
	public static void replaceSum(BSTNode node){
		System.out.println("Replace Sum of Bigger Integer :=> ");
		AtomicInteger sum = new AtomicInteger(0);
		replaceSumOfLargerInteger(node, sum);
		levelOrderTraversal(node);
	}
	private static void replaceSumOfLargerInteger(BSTNode node, AtomicInteger sum){
		if(node == null){
			return;
		}
		replaceSumOfLargerInteger(node.right, sum);
		int old = node.data;
		node.data = sum.get();
		sum.getAndAdd(old);
		replaceSumOfLargerInteger(node.left, sum);
	}
	public static void findLCAOptimized(BSTNode node, int data1, int data2){
		Integer lca = findLCAOptimizedRec(node, data1, data2);
		if(lca != null){
			System.out.println("LCA of ("+data1+") & ("+data2+") => "+lca);
		}else{
			System.out.println("LCA of ("+data1+") & ("+data2+") => "+"Not possible");
		}	
	}
	public static Integer findLCAOptimizedRec(BSTNode node, int data1, int data2){
		if(node == null){
			return null;
		}
		if(data1 < node.data  && data2 < node.data){
			return findLCAOptimizedRec(node.left, data1, data2);
		}else if(data1 > node.data  && data2 > node.data){
			return findLCAOptimizedRec(node.right, data1, data2);
		}else{
			return node.data;
		}
	}
	
	public static void findLCA(BSTNode node, int data1, int data2){
		System.out.println();
		List<Integer> list1 = rootToNodePath(node, data1);
		List<Integer> list2 = rootToNodePath(node, data2);
		int index = 0;
		if(list1.size() ==0 || list2.size() == 0){
			System.out.println("LCA of ("+data1+") & ("+data2+") => "+"Not possible");
		}else{
			while(index < list1.size() && index < list2.size()){
				if(list1.get(index) != list2.get(index)){
					 break;
				}
				index++;
			}
			System.out.println("LCA of ("+data1+") & ("+data2+") => "+list1.get(index-1));
		}		
	}

	public static List<Integer> rootToNodePath(BSTNode node, int data){
		List<Integer> list = new ArrayList<Integer>();
		nodeToRootPathRec(node, data, list);
		Collections.reverse(list);
		return list;
	}

	private static boolean nodeToRootPathRec(BSTNode node, int data, List<Integer> list) {
		if(node == null){
			return false;
		}else if(node != null && node.data == data){
			list.add(node.data);
			return true;
		}
		if(data < node.data && nodeToRootPathRec(node.left, data, list)){
			list.add(node.data);
			return true;
		}else if(data > node.data && nodeToRootPathRec(node.right, data, list)){
			list.add(node.data);
			return true;
		}
		return false;	
	}
	
	public static void printInRangeNodes(BSTNode node, int range1, int range2){
		int small = range1 > range2 ? range2 :range1;
		int large = range1 > range2 ? range1 :range2;
		System.out.println("Node AMong the given range Range1-> "+small+" && Range2-> "+large+":=> ");
		printInRangeNodesRec(node, small, large);
		System.out.println();
	}

	private static void printInRangeNodesRec(BSTNode node, int range1, int range2) {
		// TODO Auto-generated method stub
		if(node == null){
			return;
		}
		if(node.data >= range1 && node.data <= range2){
			printInRangeNodesRec(node.left, range1, range2);
			System.out.print(node.data+", ");
			printInRangeNodesRec(node.right, range1, range2);
		}else if(node.data > range1 && node.data > range2){
			printInRangeNodesRec(node.left, range1, range2);
		}else if(node.data < range1 && node.data < range2){
			printInRangeNodesRec(node.right, range1, range2);
		}	
	}
	
	public static void targetSumSubSets(BSTNode node, int sum){
		System.out.println("Target Sum Subsets of Sum-("+sum+") => ");
		Stack<BSTPair2> stack = new Stack<>();
		Stack<BSTPair2> rstack = new Stack<>();
		stack.push(new BSTPair2(node,0));
		rstack.push(new BSTPair2(node,0));
		
		BSTNode next = getNextInOrderNode(stack);
		BSTNode rnext = getNextReverseInOrderNode(rstack);
		while(next != null && rnext != null && next.data < rnext.data){
			if(next.data + rnext.data < sum){
				next = getNextInOrderNode(stack);
			}else if(next.data + rnext.data > sum){
				rnext = getNextReverseInOrderNode(rstack);
			}else{
				System.out.println("["+next.data+"]|["+rnext.data+"]");
				next = getNextInOrderNode(stack);
				rnext = getNextReverseInOrderNode(rstack);
			}
		}
	}
	
	private static BSTNode getNextInOrderNode(Stack<BSTPair2> stack){
		while(stack.size() > 0){
			BSTPair2 peek = stack.peek();
			if(peek.state == 0){
				if(peek.node.left != null){
					stack.push(new BSTPair2(peek.node.left, 0));
				}
				peek.state += 1;
			}else if(peek.state == 1){
				if(peek.node.right != null){
					stack.push(new BSTPair2(peek.node.right, 0));
				}
				peek.state += 1;
				return peek.node;
			}else{
				stack.pop();
			}
		}
		return null;		
	}
	
	
	private static BSTNode getNextReverseInOrderNode(Stack<BSTPair2> stack){
		while(stack.size() > 0){
			BSTPair2 peek = stack.peek();
			if(peek.state == 0){
				if(peek.node.right != null){
					stack.push(new BSTPair2(peek.node.right, 0));
				}
				peek.state += 1;
			}else if(peek.state == 1){
				if(peek.node.left != null){
					stack.push(new BSTPair2(peek.node.left, 0));
				}
				peek.state += 1;
				return peek.node;
			}else{
				stack.pop();
			}
		}
		return null;		
	}
	
}

class BSTPair2{
	BSTNode node;
	int state;
	public BSTPair2(BSTNode node, int state) {
		super();
		this.node = node;
		this.state = state;
	}
	public BSTPair2() {
		super();
	}
}

class BSTNode{
	int data;
	BSTNode left;
	BSTNode right;
	public BSTNode(int data) {
		super();
		this.data = data;
	}
	public BSTNode(int data, BSTNode left, BSTNode right) {
		super();
		this.data = data;
		this.left = left;
		this.right = right;
	}
}