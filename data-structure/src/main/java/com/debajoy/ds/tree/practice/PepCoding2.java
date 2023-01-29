/**-
 * 
 */
package com.debajoy.ds.tree.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @author Debajoy
 *
 */
public class PepCoding2 {

	static BinaryNode root;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	Integer[] arr = {50,25,12,null,null,37,30,null,null,null,75,62,null,70,null,null,87,null,null};
		Integer[] arr = {50,25,12,null,null,37,30,null,null,null,75,62,null,70,null,null,87,null,null};
		Stack<NodeStatus> stack = new Stack<NodeStatus>();
		int idx = 0;
		if(arr != null && arr.length > 0){
			BinaryNode node = new BinaryNode(arr[0]);
			NodeStatus nodeStatus = new NodeStatus(node, 1);
			root = node;
			stack.push(nodeStatus);
			
			while(stack.size() > 0){
				NodeStatus peek = stack.peek();
				if(peek.status == 1){
					idx++;
					if(arr[idx] != null){
						peek.status++;
						peek.node.left = new BinaryNode(arr[idx]);
						stack.push(new NodeStatus(peek.node.left, 1));
					}else{
						peek.status++;
					}
				}else if(peek.status == 2){
					idx++;
					if(arr[idx] != null){
						peek.status++;
						peek.node.right = new BinaryNode(arr[idx]);
						stack.push(new NodeStatus(peek.node.right, 1));
					}else{
						peek.status++;
					}
				
				}else{
					stack.pop();
				}
			}
		}
	//	dispalyLevelOrderTraversal(root);
		dispalyPreOrderDottedTraversal(root);
		System.out.println("Size of Binary Tree is :"+size(root));
		System.out.println("Sum of Binary Tree is :"+sum(root));
		System.out.println("Max of Binary Tree is :"+max(root));
		System.out.println("Height of Binary Tree is :"+height(root));
		System.out.println("Pre Order Traversal :-> ");preOrder(root);
		System.out.println();
		System.out.println("In Order Traversal :-> ");inOrder(root);
		System.out.println();
		System.out.println("Post Order Traversal :-> ");postOrder(root);
		System.out.println();
		System.out.println("Level Order Traversal :-> ");levelOrderTraversal(root);
		iterativePrePostInOrder(root);
		System.out.println();
		int find = 12;
		nodeToRootPath(root, find);
		int k = 2;
		printKthLevelDown(root, k);
		System.out.println();
		printKthLevelDownRecursive(root, k);
		System.out.println();
		int dataN = 50; int kN = 3;
		printKNodeAway(root, dataN, kN);
		System.out.println();
		int low = 100;
		int high = 500;
		pathLeafToRootInRange(root, low, high);
//		System.out.println("Before Transform to Left-Cloned Tree :->");
//		dispalyLevelOrderTraversal(root);
//		BinaryNode rootClone = transformToLeftClonedTreeNew(root);
//		System.out.println("After Transform to Left-Cloned Tree :->");
//		dispalyLevelOrderTraversal(rootClone);
//		System.out.println("Return to Normal Tree from Left-Cloned Tree :->");
//		BinaryNode rootCloneRevert = transformToLeftClonedTreeNew(rootClone);
//		dispalyLevelOrderTraversal(rootCloneRevert);
		System.out.println("Print Single Child Node :-");
		printSingleChildNode(root);
		System.out.println();
		System.out.println("Find Diameter of Binary Tree :- "+findDiameterOptimized(root).dia);
		System.out.println("Find Tilt of Root of Binary Tree :- "+findTiltOfBinaryTee(root).tilt);
		System.out.println("IS it A Binary Search Tree ? "+isBinarySearchTree(root).isBST);
		System.out.println("IS it A Balanced Tree ? "+isBalancedTree(root).isBalanced);
		printLargestBinarySearchTree(root);
		
		System.out.println("Serialized String from Binary Tree :"+Serialize(root));
	}

	public static void dispalyLevelOrderTraversal(BinaryNode node){
		LinkedList<BinaryNode> queue = new LinkedList<>();
		queue.add(node);
		while(queue.size() > 0){
			int size = queue.size();
			for(int i = 0; i < size; i++){
				BinaryNode removed = queue.poll();
				System.out.print(removed.data+" -> ");
				if(removed.left != null){
					queue.add(removed.left);
				}
				if(removed.right != null){
					queue.add(removed.right);
				}
			}
			System.out.println();
		}
	}
	
	public static void dispalyPreOrderDottedTraversal(BinaryNode node){
		if(node != null){
			String print = new String();
			print = String.valueOf(node.left != null ? node.left.data:".").concat(" <- "+String.valueOf(node.data)+" -> ").concat(String.valueOf(node.right != null ? node.right.data:"."));
			System.out.println(print);
			dispalyPreOrderDottedTraversal(node.left);
			dispalyPreOrderDottedTraversal(node.right);
		}
	}
	
	private static int size(BinaryNode node) {
		// TODO Auto-generated method stub
		if(node == null){
			return 0;
		}else{
			return 1+size(node.left)+size(node.right);
		}
	}

	public static int sum(BinaryNode node){
		// TODO Auto-generated method stub
		if(node == null){
			return 0;
		}else{
			return node.data+sum(node.left)+sum(node.right);
		}
	}

	public static int max(BinaryNode node){
		if(node == null){
			return Integer.MIN_VALUE;
		}
		int maxChild = Math.max(max(node.left), max(node.right));
		return Math.max(node.data, maxChild);
	}
	
	public static int height(BinaryNode node){
		if(node == null){
			return 0;
		}else{
			int h = 0;
			h = Math.max(height(node.left), height(node.right));
			if(node.left == null && node.right == null){
				return h;
			}else{
				return h+1;
			}
		}
	}
	
	public static void preOrder(BinaryNode node){
		if(node == null){
			return;
		}
		System.out.print(node.data+" -> ");
		preOrder(node.left);
		preOrder(node.right);
	}
	
	public static void postOrder(BinaryNode node){
		if(node == null){
			return;
		}
		preOrder(node.left);
		preOrder(node.right);
		System.out.print(node.data+" -> ");	
	}
	
	public static void inOrder(BinaryNode node){
		if(node == null){
			return;
		}
		preOrder(node.left);
		System.out.print(node.data+" -> ");
		preOrder(node.right);
	}
	
	public static void levelOrderTraversal(BinaryNode node){
		LinkedList<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.push(node);
		while(queue.size() > 0){
			int size = queue.size();
			for(int i = 0; i < size ; i++){
				BinaryNode popped = queue.pop();
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
	
	public static void iterativePrePostInOrder(BinaryNode node){
		Stack<NodeStatus> stack = new Stack<NodeStatus>();
		List<Integer> preOrderList = new ArrayList<Integer>();
		List<Integer> postOrderList = new ArrayList<Integer>();
		List<Integer> inOrderList = new ArrayList<Integer>();
		stack.add(new NodeStatus(node, 1));
		while(stack.size() > 0){
			NodeStatus peek = stack.peek();
			if(peek.status == 1){
				preOrderList.add(peek.node.data);
				peek.status++;
				if(peek.node.left != null){
					stack.push(new NodeStatus(peek.node.left, 1));
				}
			}else if(peek.status == 2){
				inOrderList.add(peek.node.data);
				peek.status++;
				if(peek.node.right != null){
					stack.push(new NodeStatus(peek.node.right, 1));
				}
			}else if(peek.status > 2){
				postOrderList.add(peek.node.data);
				stack.pop();
			}
		}
		System.out.println("Pre-Order traversal :-> ");
		preOrderList.forEach(s -> System.out.print(s+" -> "));
		System.out.println();
		System.out.println("In-Order traversal :-> ");
		inOrderList.forEach(s -> System.out.print(s+" -> "));
		System.out.println();
		System.out.println("Post-Order traversal :-> ");
		postOrderList.forEach(s -> System.out.print(s+" -> "));
	}
	
	public static List<Integer> nodeToRootPath(BinaryNode node, int data){
		List<Integer> list = new ArrayList<Integer>();
		nodeToRootPathRec(node, data, list);
		Collections.reverse(list);
		System.out.println("Distance from Root("+node.data+") to Node-" +data);
		list.forEach(n -> System.out.print(n+ " -> "));
		return list;
	
	}

	private static boolean nodeToRootPathRec(BinaryNode node, int data, List<Integer> list) {
		if(node == null){
			return false;
		}else if(node != null && node.data == data){
			list.add(node.data);
			return true;
		}
		boolean isFound = false;
		isFound = nodeToRootPathRec(node.left, data, list); 
		if(isFound){
			list.add(node.data);
			return isFound;
		}else{
			isFound = nodeToRootPathRec(node.right, data, list);
			if(isFound){
				list.add(node.data);
			}
			return isFound;	
		}
	}
	
	public static List<BinaryNode> nodeToRootPathNodes(BinaryNode node, int data){
		List<BinaryNode> list = new ArrayList<BinaryNode>();
		nodeToRootPathNodesRec(node, data, list);
		return list;
	
	}
	
	private static boolean nodeToRootPathNodesRec(BinaryNode node, int data, List<BinaryNode> list) {
		if(node == null){
			return false;
		}else if(node != null && node.data == data){
			list.add(node);
			return true;
		}
		boolean isFound = false;
		isFound = nodeToRootPathNodesRec(node.left, data, list); 
		if(isFound){
			list.add(node);
			return isFound;
		}else{
			isFound = nodeToRootPathNodesRec(node.right, data, list);
			if(isFound){
				list.add(node);
			}
			return isFound;	
		}
	}
	
	public static void printKthLevelDown(BinaryNode node, int k){
		LinkedList<BinaryNode> queue = new LinkedList<BinaryNode>();
		System.out.println();
		System.out.println("Print Kth Level Down Elements :-> ");
		queue.push(node);
		int level = 0;
		while(queue.size() > 0){
			int size = queue.size();
			for(int i = 0; i < size ; i++){
				BinaryNode popped = queue.pop();
				if(level == k){
					System.out.print(popped.data+" -> ");	
				}			
				if(popped.left != null){
					queue.add(popped.left);
				}
				if(popped.right != null){
					queue.add(popped.right);
				}		
			}
			level++;
		}
	}
	
	private static void printKthLevelDownRecursive(BinaryNode node, int k) {
		// TODO Auto-generated method stub
		if(node == null || k < 0){
			return;
		}
		if(k == 0){
			System.out.print(node.data+" -> ");
		}
		printKthLevelDownRecursive(node.left, k-1);
		printKthLevelDownRecursive(node.right, k-1);
	}
	
	private static void printKthLevelDownAvoidBlocker(BinaryNode node, BinaryNode blocNode, int k) {
		// TODO Auto-generated method stub
		if(node == null || k < 0 || (blocNode != null && node.equals(blocNode))){
			return;
		}
		if(k == 0){
			System.out.print(node.data+" ; ");
		}
		printKthLevelDownAvoidBlocker(node.left, blocNode, k-1);
		printKthLevelDownAvoidBlocker(node.right, blocNode, k-1);
	}
	
	private static void printKNodeAway(BinaryNode node, int data, int k){
		System.out.println("Print "+k+" edges Away from Node-("+data+")");
		List<BinaryNode> path = nodeToRootPathNodes(node, data);
		for(int i  = 0; i< path.size(); i++){
			if(k >= i){
				if(i > 0){
					printKthLevelDownAvoidBlocker(path.get(i), path.get(i-1), k-i);
				}else{
					printKthLevelDownAvoidBlocker(path.get(i), null, k-i);
				}
			}		
		}
	}
	
	private static List<List<Integer>> pathLeafToRootInRange(BinaryNode node, int low, int high){
		System.out.println("All the Path from Leaf to Root :-> ");
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		pathLeafToRootInRangeRec(node, low, high, list, output);
		output.forEach(l -> printList(l));
		return output;
	}

	private static void printList(List<Integer> l) {
		// TODO Auto-generated method stub
		l.forEach(s-> System.out.print(s+" -> "));
		System.out.println();
	}

	private static void pathLeafToRootInRangeRec(BinaryNode node, int low, int high, List<Integer> list, List<List<Integer>> output) {
		// TODO Auto-generated method stub
		if(node == null){
			return;
		}
		int sum = list.stream().mapToInt(Integer::intValue).sum();
		if(node.left == null && node.right == null){
			sum += node.data;
			if(sum >= low && sum <= high){
				list.add(node.data);
				output.add(list);
			}
			return;
		}
		sum += node.data;
		if(sum <= high){
			list.add(node.data);
			pathLeafToRootInRangeRec(node.left, low, high, list, output);
			List<Integer> listCopy = new ArrayList<Integer>(list);
			pathLeafToRootInRangeRec(node.right, low, high, listCopy, output);
		}	
		
	}
	
	public static void transformToLeftClonedTree(BinaryNode node){
		if(node != null && node.left == null && node.right == null){
			return;
		}
		if(node.left != null){
			transformToLeftClonedTree(node.left);
			BinaryNode child = node.left;
			node.left = node.clone();
			node.left.left = child;
			
		}
		if(node.right != null){
			transformToLeftClonedTree(node.right);
		}
	}
	
	public static BinaryNode transformToLeftClonedTreeNew(BinaryNode node){
		if(node == null){
			return null;
		}
		BinaryNode ln = transformToLeftClonedTreeNew(node.left);
		BinaryNode rn = transformToLeftClonedTreeNew(node.right);
		BinaryNode newNode = new BinaryNode(node.data);
		newNode.left = ln;
		node.left = newNode;
		node.right = rn;
		return node;
	}
	
	public static BinaryNode transformBackFromLeftClonedTreeNew(BinaryNode node){
		if(node == null){
			return null;
		}
		BinaryNode ln = transformBackFromLeftClonedTreeNew(node.left.left);
		BinaryNode rn = transformBackFromLeftClonedTreeNew(node.right);
		node.left  = ln;
		node.right = rn;
		return node;
	}
	
	public static void printSingleChildNode(BinaryNode node){
		if(node == null){
			return;
		}
		if(node.left != null && node.right == null){
			System.out.print(node.left.data+ " -> ");
			printSingleChildNode(node.left);
		}else if(node.left == null && node.right != null){
			System.out.print(node.right.data+ " -> ");
			printSingleChildNode(node.right);
		}else{
			printSingleChildNode(node.left);
			printSingleChildNode(node.right);
		}
	}
	
	public static BinaryNode removeLeaves(BinaryNode node){
		if(node == null){
			return null;
		}
		if(node.left == null && node.right == null){
			return null;
		}
		node.left = removeLeaves(node.left);
		node.right = removeLeaves(node.right);
		return node;
	}
	
	public static int findDiameter(BinaryNode node){
		if(node == null){
			return 0;
		}
		int dia = getDiameterEachNode(node);
		return Math.max(dia, Math.max(findDiameter(node.left), findDiameter(node.right)));
	}

	public static int getDiameterEachNode(BinaryNode node){
		if(node.left != null && node.right != null){
			return height(node.left)+height(node.right)+2;
		}else if(node.left != null && node.right == null){
			return height(node.left)+1;
		}else if(node.left == null && node.right != null){
			return height(node.right)+1;
		}else{
			return 0;
		}	
	}
	
	public static Diameter findDiameterOptimized(BinaryNode node){
		if(node  == null){
			Diameter dp = new Diameter(-1, 0);
			return dp;
		}
		Diameter lDia = findDiameterOptimized(node.left);
		Diameter rDia = findDiameterOptimized(node.right);
		
		Diameter diameter = new Diameter();	
		diameter.ht = Math.max(lDia.ht, rDia.ht)+1;
		
		diameter.dia = Math.max(lDia.ht+rDia.ht+2, Math.max(lDia.dia, rDia.dia));
		return diameter;
	}
	
	public static Tilt findTiltOfBinaryTee(BinaryNode node){
		if(node == null){
			Tilt t = new Tilt(0,0);
			return t;
		}
		Tilt tiltL = findTiltOfBinaryTee(node.left);
		Tilt tiltR = findTiltOfBinaryTee(node.right);
		
		Tilt tilt = new Tilt();
		tilt.tilt = Math.abs((tiltL.sum-tiltR.sum));
		tilt.sum = node.data+tiltL.sum+tiltR.sum;
		System.out.println("Tilt of Node-"+node.data+" := "+tilt.tilt);
		return tilt;
	}
	
	public static BSTPair isBinarySearchTree(BinaryNode node){
		if(node == null){
			BSTPair emptyPair = new BSTPair(Integer.MIN_VALUE,Integer.MAX_VALUE,true);
			return emptyPair;
		}
		BSTPair lBST = isBinarySearchTree(node.left);
		BSTPair rBST = isBinarySearchTree(node.right);
		
		BSTPair currentPair = new BSTPair();
		currentPair.isBST = lBST.isBST && rBST.isBST && (node.data >= lBST.max && node.data <= rBST.min);
		currentPair.min = Math.min(node.data, Math.min(lBST.min, rBST.min));
		currentPair.max = Math.max(node.data, Math.max(lBST.max, rBST.max));
		return currentPair;
	}
	
	public static BalancePair isBalancedTree(BinaryNode node){
		
		if(node == null){
			BalancePair empPair = new BalancePair(0,true);
			return empPair;
		}
		
		BalancePair lPair = isBalancedTree(node.left);
		BalancePair rPair = isBalancedTree(node.right);
		
		BalancePair pair = new BalancePair();
		pair.isBalanced = lPair.isBalanced && rPair.isBalanced && (Math.abs(rPair.height-lPair.height) <= 1);
		pair.height = Math.max(rPair.height,lPair.height)+1;
		
		return pair;
	}
	public static void printLargestBinarySearchTree(BinaryNode node){
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		findLargestBinarySearchTree(node,map);
		int maxCount = 0;
		int N = 0;
		for(Map.Entry<Integer, Integer> entry : map.entrySet()){
			if(entry.getValue() > maxCount){
				maxCount = entry.getValue();
				N = entry.getKey();
			}
		}
		System.out.println("Node := "+N+" ;; count := "+maxCount);
	}
	
	public static BSTPair findLargestBinarySearchTree(BinaryNode node,Map<Integer,Integer> map){
		if(node == null){
			BSTPair emptyPair = new BSTPair(Integer.MIN_VALUE,Integer.MAX_VALUE,true,0);
			return emptyPair;
		}
		BSTPair lBST = findLargestBinarySearchTree(node.left,map);
		BSTPair rBST = findLargestBinarySearchTree(node.right,map);
		
		BSTPair currentPair = new BSTPair();
		currentPair.isBST = lBST.isBST && rBST.isBST && (node.data >= lBST.max && node.data <= rBST.min);
		currentPair.min = Math.min(node.data, Math.min(lBST.min, rBST.min));
		currentPair.max = Math.max(node.data, Math.max(lBST.max, rBST.max));
		currentPair.count = 1+ lBST.count+rBST.count;
		if(currentPair.isBST){
			map.put(node.data, currentPair.count);
		}
		return currentPair;
	}
	
	public static String Serialize(BinaryNode node){
		StringBuilder sb = new StringBuilder("");
		SerializeRec(node,sb);
		return sb.toString();
	}
	public static void SerializeRec(BinaryNode node,StringBuilder sb){
		if(node == null){
			sb.append("null"+",");
			return;
		}
		sb.append(node.data+",");
		SerializeRec(node.left, sb);
		SerializeRec(node.right, sb);
	}
}

class BalancePair{
	int height;
	boolean isBalanced;
	public BalancePair() {
	}
	public BalancePair(int height, boolean isBalanced) {
		super();
		this.height = height;
		this.isBalanced = isBalanced;
	}
}

class BSTPair{
	Integer max;
	Integer min;
	boolean isBST;
	Integer count;
	public BSTPair(Integer max, Integer min, boolean isBST, Integer count) {
		super();
		this.max = max;
		this.min = min;
		this.isBST = isBST;
		this.count = count;
	}
	public BSTPair() {
	}
	public BSTPair(Integer max, Integer min, boolean isBST) {
		super();
		this.max = max;
		this.min = min;
		this.isBST = isBST;
	}
}

class BinaryNode{
	int data;
	BinaryNode left;
	BinaryNode right;
	public BinaryNode(int data) {
		super();
		this.data = data;
		this.left = this.right = null;
	}
	@Override
	public BinaryNode clone(){
		BinaryNode node = new BinaryNode(this.data);
		return node;
	}
}

class NodeStatus{
	public NodeStatus(BinaryNode node, int status) {
		super();
		this.node = node;
		this.status = status;
	}
	BinaryNode node;
	int status;
}

class Diameter{
	int ht;
	int dia;
	public Diameter() {
	}
	public Diameter(int ht, int dia) {
		this.ht = ht;
		this.dia = dia;
	}
}

class Tilt{
	int tilt;
	int sum;
	public Tilt() {
	}
	public Tilt(int tilt, int sum) {
		super();
		this.tilt = tilt;
		this.sum = sum;
	}
}