/**
 * 
 */
package com.debajoy.ds.tree.practice;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Debajoy
 * Generic Tree
 *
 */
public class PepCoding4 {

	/**
	 * @param args
	 */
	static TreeNode4 root;
	static TreeNode4Char root1;
	static TreeNode4 root2;
	static TreeNode4 root3;
	static TreeNode4 predecessor;
	static TreeNode4 successor;
	static int state = 0;
	static int ceil = Integer.MAX_VALUE;
	static int floor = Integer.MIN_VALUE;
	static TreeNode4 root4;
	static TreeNode4 root5;
	static int diameter5 = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
		char[] arr1 = {'a','b','c','X','d','X','X','e','f','X','g','h','X','i','X','X','j','X','X','k','l','X','X','X'};
		int[] arr2 = {10,40,100,-1,-1,30,90,-1,80,120,-1,110,-1,-1,70,-1,-1,20,60,-1,50,-1,-1,-1};
		int[] arr3 = {10,20,50,-1,60,-1,-1,30,70,-1,80,120,-1,130,-1,-1,90,-1,-1,40,100,-1,110,-1,-1};
		int[] arr4 = {10,20,-50,-1,-60,-1,-1,30,-70,-1,80,-110,-1,120,-1,-1,90,-1,-1,40,-100,-1,-1,-1};
		int[] arr5 = {1,2,5,11,17,19,21,23,-1,-1,-1,-1,
					  -1,-1,6,12,18,20,22,24,-1,-1,-1,
					  -1,-1,-1,-1,3,7,-1,8,13,100,-1,
					  -1,-1,9,-1,-1,4,10,14,-1,15,-1,
					  16,-1,-1,-1,-1};
		final String SEPERATOR ="**************************************************************************************";
		buildBinaryTree(arr);
		buildBinaryTree2(arr1);
		buildBinaryTree3(arr2);
		buildBinaryTree4(arr3);
		buildBinaryTree5(arr4);
		buildBinaryTree6(arr5);
		System.out.println("Size of Generic Tree : "+getSize(root));
		System.out.println(SEPERATOR);
		System.out.println("Maximum in Generic Tree : "+maxInTree(root));
		System.out.println(SEPERATOR);
		System.out.println("Height of Generic Tree : "+getHeight(root));
		System.out.println(SEPERATOR);
		traversalEuler(root);
		System.out.println(SEPERATOR);
		levelOrderTraversalLineWise(root);
		System.out.println(SEPERATOR);
		levelOrderTraversalAlt(root);
		System.out.println(SEPERATOR);
		levelOrderTraversalLineWiseZigZagSpaceOptimized(root);
//		System.out.println(SEPERATOR);
//		System.out.println("Mirror Image");
//		mirrorImage(root);
//		levelOrderTraversalLineWise(root);
//		System.out.println(SEPERATOR);
//		System.out.println("Remove Leaves");
//		removeLeaves(root);
//		levelOrderTraversalLineWise(root);
//		System.out.println(SEPERATOR);
//		System.out.println("Linearise a Generic Tree");
//		linearizeTree(root);
//		levelOrderTraversalLineWise(root);
//		System.out.println(SEPERATOR);
//		System.out.println("Linearise a Generic Tree in an Optimized Way");
//		linearizeTreeOptimized(root);
//		levelOrderTraversalLineWise(root);
		System.out.println(SEPERATOR);
		int data = 111;
		System.out.println("Find "+data+" in Tree :- "+find(root, data));
		System.out.println(SEPERATOR);
		int dataNToR = 120;
		nodeTRootPath(root, dataNToR);
		System.out.println(SEPERATOR);
		int data1 = 50;
		int data2 = 120;
		System.out.println("LCA of "+data1+" & "+data2+" :=> "+LCA(root, data1, data2));
		System.out.println(SEPERATOR);
		System.out.println("Distances between "+data1+" & "+data2+" :=> "+distanceBetweenNodes(root, data1, data2));
		System.out.println(SEPERATOR);
		System.out.println("Are Generic Trees Similar in Shape? -> "+areTreeSimilarInShape(root, root1));
		System.out.println(SEPERATOR);
		System.out.println("Are Generic Trees Mirror in Shape? -> "+areTreeMirrorInShape(root, root2));
		System.out.println(SEPERATOR);
		System.out.println("Is Generic Tree Symmetric in Shape? -> "+isTreeSymetric(root3));
		System.out.println(SEPERATOR);
		int dataPreSuccess = 110;
		findPredecessorSucessor(root,dataPreSuccess);
		if(predecessor != null){
			System.out.println("Predecessor of "+dataPreSuccess+" := "+predecessor.data);
		}else{
			System.out.println("Predecessor of "+dataPreSuccess+" not found");
		}
		if(successor != null){
			System.out.println("Successor  of "+dataPreSuccess+" := "+successor.data);
		}else{
			System.out.println("Successor of "+dataPreSuccess+" not found");
		}	
		System.out.println(SEPERATOR);
		int ceilFloorData = 110;
		findCeilAndFloor(root, ceilFloorData);
		System.out.println("Ceil of "+ceilFloorData+" -> "+ceil);
		System.out.println("Floor of "+ceilFloorData+" -> "+floor);
		System.out.println(SEPERATOR);
		int k = 10;
		System.out.println(k+" - Largest Element in the Tree is :=> "+findKthLargest(root, k));
		System.out.println(SEPERATOR);
		System.out.println("Node with Maximum Sum SubTree :=> "+findMaxSubTreeSum(root4));
		System.out.println(SEPERATOR);
		System.out.println("Find Diameter :=> "+finddiameter(root5));
		System.out.println(SEPERATOR);
		getDiameter(root5);
		System.out.println("Find Diameter :=> "+diameter5);
		System.out.println(SEPERATOR);
		iterativePreAandPostOrder(root);
	}	

	public static void buildBinaryTree(int[] arr){
		Stack<TreeNode4> stack =new Stack<TreeNode4>();
		for(int i = 0 ; i< arr.length; i++){
			if(stack.empty()){
				TreeNode4 node = new TreeNode4(arr[i]);
				root = node;
				stack.push(root);
			}else{
				if(arr[i] != -1){
					TreeNode4 node = new TreeNode4(arr[i]);
					stack.peek().children.add(node);
					stack.push(node);
				}else{
					stack.pop();
				}
			}
		}		
		printPreOrderOneLevelDown(root);
	}
	public static void buildBinaryTree2(char[] arr1){
		Stack<TreeNode4Char> stack1 = new Stack<TreeNode4Char>();
		for(int i = 0; i < arr1.length; i++){
			if(stack1.size() <= 0){
				root1 = new TreeNode4Char(arr1[i]);
				stack1.add(root1);
			}else{
				if(arr1[i] == 'X'){
					stack1.pop();			
				}else{
					if(stack1.size() > 0){
						TreeNode4Char _childNode  = new TreeNode4Char(arr1[i]);
						stack1.peek().children.add(_childNode);
						stack1.push(_childNode);
					}	
				}
			}
		}
	}
	
	public static void buildBinaryTree3(int[] arr){
		Stack<TreeNode4> stack =new Stack<TreeNode4>();
		for(int i = 0 ; i< arr.length; i++){
			if(stack.empty()){
				TreeNode4 node = new TreeNode4(arr[i]);
				root2 = node;
				stack.push(root2);
			}else{
				if(arr[i] != -1){
					TreeNode4 node = new TreeNode4(arr[i]);
					stack.peek().children.add(node);
					stack.push(node);
				}else{
					stack.pop();
				}
			}
		}		
		printPreOrderOneLevelDown(root2);
	}
	
	public static void buildBinaryTree4(int[] arr){
		Stack<TreeNode4> stack =new Stack<TreeNode4>();
		for(int i = 0 ; i< arr.length; i++){
			if(stack.empty()){
				TreeNode4 node = new TreeNode4(arr[i]);
				root3 = node;
				stack.push(root3);
			}else{
				if(arr[i] != -1){
					TreeNode4 node = new TreeNode4(arr[i]);
					stack.peek().children.add(node);
					stack.push(node);
				}else{
					stack.pop();
				}
			}
		}		
		printPreOrderOneLevelDown(root3);
	}
	
	public static void buildBinaryTree5(int[] arr){
		Stack<TreeNode4> stack =new Stack<TreeNode4>();
		for(int i = 0 ; i< arr.length; i++){
			if(stack.empty()){
				TreeNode4 node = new TreeNode4(arr[i]);
				root4 = node;
				stack.push(root4);
			}else{
				if(arr[i] != -1){
					TreeNode4 node = new TreeNode4(arr[i]);
					stack.peek().children.add(node);
					stack.push(node);
				}else{
					stack.pop();
				}
			}
		}		
		printPreOrderOneLevelDown(root4);
	}
	
	public static void buildBinaryTree6(int[] arr){
		Stack<TreeNode4> stack =new Stack<TreeNode4>();
		for(int i = 0 ; i< arr.length; i++){
			if(stack.empty()){
				TreeNode4 node = new TreeNode4(arr[i]);
				root5 = node;
				stack.push(root5);
			}else{
				if(arr[i] != -1){
					TreeNode4 node = new TreeNode4(arr[i]);
					stack.peek().children.add(node);
					stack.push(node);
				}else{
					stack.pop();
				}
			}
		}		
		levelOrderTraversalLineWise(root5);
	}
	
	private static void printPreOrderOneLevelDown(TreeNode4 node) {
		String s1 = new String("");
		for(int i = 0; i < node.children.size(); i++){
			s1 = s1.concat(node.children.get(i).data+",");
		}
		s1 += ".";
		System.out.println(node.data+ " -> "+s1);
		for(int i = 0; i < node.children.size(); i++){
			printPreOrderOneLevelDown(node.children.get(i));
		}
	}
	public static int getSize(TreeNode4 node){
		if(node == null){
			return 0;
		}
		int  size = 0;
		for(TreeNode4 child : node.children){
			size += getSize(child);
		}
		return size+1;
	}
	public static int maxInTree(TreeNode4 node){
		if(node == null){
			return 0;
		}
		int max = node.data;
		for(TreeNode4 child : node.children){
			max = Math.max(max, maxInTree(child));
		}
		return max;
	}	
	public static int getHeight(TreeNode4 node){
		int h = -1;
		for(TreeNode4 child : node.children){
			h = Math.max(h, getHeight(child));
		}
		h+=1;
		return h;
	}
	
	public static void traversalEuler(TreeNode4 node){
		System.out.println("Node Pre -> "+node.data);
		for(TreeNode4 child : node.children){
			System.out.println("Egde Pre -> "+node.data+" - "+child.data);
			traversalEuler(child);
			System.out.println("Egde Post -> "+node.data+" - "+child.data);
		}
		System.out.println("Node Post -> "+node.data);
	}

	public static void levelOrderTraversalLineWise(TreeNode4 node){
		ArrayDeque<TreeNode4> queue = new ArrayDeque<TreeNode4>();
		queue.add(node);
		while(queue.size()>0){
			int size = queue.size();
			for(int i = 0; i < size; i++){
				TreeNode4 polledNode = queue.poll();
				System.out.print(polledNode.data+ " -> ");
				for(TreeNode4 child : polledNode.children){
					queue.add(child);
				}
			}
			System.out.println();		
		}
	}
	
	public static void levelOrderTraversalAlt(TreeNode4 node){
		ArrayDeque<TreeNode4> queue = new ArrayDeque<TreeNode4>();
		queue.add(node);
		while(queue.size()>0){
				TreeNode4 polledNode = queue.poll();
				System.out.print(polledNode.data+ " -> ");
				for(TreeNode4 child : polledNode.children){
					queue.add(child);
				}
			System.out.println();		
		}
	}
	
	public static void levelOrderTraversalLineWiseZigZag(TreeNode4 node){
		Stack<TreeNode4> ms = new Stack<TreeNode4>();
		Stack<TreeNode4> cs = new Stack<TreeNode4>();
		ms.push(node);
		int level = 1;
		while(ms.size() > 0){
			TreeNode4 poped = ms.pop();
			System.out.print(poped.data+" ");
			if(level%2 != 0){
				for(int i = 0; i < poped.children.size(); i++ ){
					cs.add(poped.children.get(i));
				}
			}else{
				for(int i = poped.children.size()-1; i >= 0; i-- ){
					cs.add(poped.children.get(i));
				}
			}
			if(ms.size() <= 0){
				ms = cs;
				cs = new Stack<TreeNode4>();
				level++;
				System.out.println();
			}			
		}
	}
	
	public static void levelOrderTraversalLineWiseZigZagSpaceOptimized(TreeNode4 node){
		ArrayDeque<TreeNode4> queue = new ArrayDeque<TreeNode4>();
		queue.add(node);
		int level = 0;
		
		while(queue.size()>0){
			int size = queue.size();
			List<Integer> zigzagList = new ArrayList<Integer>();
			for(int i = 0; i < size; i++){
				TreeNode4 polledNode = queue.poll();
				zigzagList.add(polledNode.data);
				for(int j = 0; j < polledNode.children.size(); j++ ){
					queue.add(polledNode.children.get(j));
				}
			}
			if(level %2 == 0){
				for(int j = 0; j < zigzagList.size(); j++ ){
					System.out.print(zigzagList.get(j)+ " -> ");
				}
			}else{
				for(int j = zigzagList.size()-1 ; j >= 0; j-- ){
					System.out.print(zigzagList.get(j)+ " -> ");
				}
			}
			level++;
			System.out.println();		
		}
	}
	
	public static void mirrorImage(TreeNode4 node){
		if(node == null){
			return;
		}
		for(int i = 0; i < node.children.size(); i++){
			mirrorImage(node.children.get(i));
		}
		Collections.reverse(node.children);
	}
	
	public static void removeLeaves(TreeNode4 node){
		// Always remove leaves in Pre-Order
		for(int i = node.children.size()-1; i >= 0; i--){
			TreeNode4 child = node.children.get(i);
			if(child.children.size() == 0){
				node.children.remove(i);
			}
		}	
		for(int i = 0; i < node.children.size(); i++){
			removeLeaves(node.children.get(i));
		}
	}
	
	public static void linearizeTree(TreeNode4 node){
		for(TreeNode4 child : node.children){
			linearizeTree(child);
		}
		while(node.children != null && node.children.size() > 1){
			TreeNode4 last = node.children.remove(node.children.size()-1);
			TreeNode4 secondLast = node.children.get(node.children.size()-1);
			TreeNode4 secondLastTail = getTail(secondLast);
			secondLastTail.children.add(last);
		}
	}
	
	private static TreeNode4 getTail(TreeNode4 secondLast){
		while(secondLast.children.size() == 1){
			secondLast = secondLast.children.get(0);
		}
		return secondLast;
	}
	
	public static TreeNode4 linearizeTreeOptimized(TreeNode4 node){
		TreeNode4 last = linearizeTreeOptimized(node.children.get(node.children.size()-1));
		while(node.children.size() > 1){
			TreeNode4 lN = node.children.remove(node.children.size()-1);
			TreeNode4 secondlN = node.children.remove(node.children.size()-1);
			TreeNode4 secondlTail = linearizeTreeOptimized(secondlN);
			secondlTail.children.add(lN);
		}
		return last;
	}
	
	public static boolean find(TreeNode4 node, int data){
		if(node == null){
			return false;
		}else if(node != null && node.data == data){
			return true;
		}
		for(TreeNode4 child : node.children){
			if(find(child, data)){
				return true;
			}
		}
		return false;
	}
	
	public static List<Integer> nodeTRootPath(TreeNode4 node, int data){
		List<Integer> list = new ArrayList<Integer>();
		nodeToRootPathRec(node, data, list);
		Collections.reverse(list);
		System.out.println("Distance from Root("+node.data+") to Node-" +data);
		list.forEach(n -> System.out.print(n+ " -> "));
		return list;
	}
	private static boolean nodeToRootPathRec(TreeNode4 node,int data, List<Integer> list){
		if(node == null){
			return false;
		}else if(node != null && node.data == data){
			list.add(node.data);
			return true;
		}
		for(TreeNode4 child : node.children){
			if(nodeToRootPathRec(child, data, list)){
				list.add(node.data);
				return true;
			}
		}
		return false;	
	}
	public static List<Integer> nodeToRootPathWithoutSysOut(TreeNode4 node,int data){
		List<Integer> list = new ArrayList<Integer>();
		nodeToRootPathRec(node, data, list);
		Collections.reverse(list);
		return list;
	}
	
	
	public static int LCA(TreeNode4 node, int data1, int data2){
		List<Integer> list1 = nodeToRootPathWithoutSysOut(node, data1);
		List<Integer> list2 = nodeToRootPathWithoutSysOut(node, data2);
		int counter = 0; Integer lca = null;
		while(counter < list1.size() && counter < list2.size()){
			if(list1.get(counter) == list2.get(counter)){
				lca = list1.get(counter);
				counter++;
			}else{
				return lca;
			}
		}
		return lca;
	}
	
	public static int distanceBetweenNodes(TreeNode4 node,int data1, int data2){
		List<Integer> list1 = nodeToRootPathWithoutSysOut(node, data1);
		List<Integer> list2 = nodeToRootPathWithoutSysOut(node, data2);
		int counter = 0;
		while(counter < list1.size() && counter < list2.size()){
			if(list1.get(counter) == list2.get(counter)){
				counter++;
			}else{
				break;
			}
		}
		return (list1.size()-counter)+(list2.size()-counter);
	}
	
	private static boolean areTreeSimilarInShape(TreeNode4 node1, TreeNode4Char node2) {
		// TODO Auto-generated method stub
		if(node1.children.size() == node2.children.size()){
			for(int i = 0; i < node1.children.size(); i++){
				if(!areTreeSimilarInShape(node1.children.get(i), node2.children.get(i))){
					return false;
				}
			}
		}else{
			return false;
		}
		return true;
	}
	
	public static boolean areTreeMirrorInShape(TreeNode4 node1, TreeNode4 node2){
		// TODO Auto-generated method stub
		if(node1.children.size() == node2.children.size()){
			for(int i = 0; i < node1.children.size(); i++){
				if(!areTreeMirrorInShape(node1.children.get(i), node2.children.get(node2.children.size()-i-1))){
					return false;
				}
			}
		}else{
			return false;
		}
		return true;
	}
	
	public static boolean isTreeSymetric(TreeNode4 node){
		return areTreeMirrorInShape(node, node);
	}
	
	private static void initialize() {
		// TODO Auto-generated method stub
		predecessor = null;
		successor = null;
	}
	
	public static void findPredecessorSucessor(TreeNode4 node, int data) {
		// TODO Auto-generated method stub
		initialize();
		findPredecessorSucessorRec(node, data);
	}
	
	public static void findPredecessorSucessorRec(TreeNode4 node, int data) {
		if(state == 0){
			if(node.data == data){
				state = 1;
			}else{
				predecessor = node;
			}
		}else if(state == 1){
			successor = node;
			state = 2;
		}
		for(TreeNode4 child : node.children){
			findPredecessorSucessorRec(child, data);
		}
	}
	
	public static void findCeilAndFloor(TreeNode4 node, int data) {
		if(node.data > data){
			if(node.data < ceil){
				ceil = node.data;
			}
		}
		if(node.data < data){
			if(node.data > floor){
				floor = node.data;
			}
		}
		for(TreeNode4 child : node.children){
			findCeilAndFloor(child, data);
		}
	}

	public static int findKthLargest(TreeNode4 node, int k) {
		int factor = Integer.MAX_VALUE;
		for(int i = 0; i < k; i++){
			floor = Integer.MIN_VALUE;
			findCeilAndFloor(node, factor);
			factor = floor; 
		}
		return floor;
	}
	
	public static int findMaxSubTreeSum(TreeNode4 node){
		MaxSubTree maxSubTree = new MaxSubTree(Integer.MIN_VALUE, node);
		findNodeWithMaxSubTreeSum(node, maxSubTree);
		return maxSubTree.node.data;
	}
	
	public static int findNodeWithMaxSubTreeSum(TreeNode4 node, MaxSubTree maxSubTree) {
		int sum = 0;
		for(TreeNode4 child : node.children){
			sum += findNodeWithMaxSubTreeSum(child, maxSubTree);
		}
		sum += node.data;
		if(maxSubTree.maxSum < sum){
			maxSubTree.setMaxSum(sum);
			maxSubTree.setNode(node);
		}
		return sum;
	}
	
	public static int finddiameter(TreeNode4 node){
		AtomicInteger diameter = new AtomicInteger(0);
		diameterOfGenericTree(node, diameter);
		return diameter.get();
	}
	
	public static void diameterOfGenericTree(TreeNode4 node,AtomicInteger diameterInt){
		int diameter = 0;
		for(TreeNode4 child : node.children){
			diameterOfGenericTree(child,diameterInt);
		}
		List<Integer> heights = new ArrayList<Integer>();
		for(TreeNode4 child : node.children){
			heights.add(getHeight(child));
		}
		heights.sort(Collections.reverseOrder());
		if(heights.size() >= 2){
			diameter =  2 + heights.get(0)+heights.get(1);
		}else if(heights.size() == 1){
			diameter =  1 + heights.get(0);
		}
		if(diameterInt.get() < diameter){
			diameterInt.set(diameter);
		}
	}

	public static int getDiameter(TreeNode4 node) {
		int dch = -1;
		int sdch = -1;
		for(TreeNode4 child : node.children){
			int ch = getDiameter(child);
			if(ch > dch){
				sdch = dch;
				dch = ch;
			}else if(ch > sdch){
				sdch = ch;
			}
		}
		int cand = dch + sdch + 2;
		if(cand > diameter5){
			diameter5 = cand;
		}
		dch+=1;
		return dch;
	}
	
	public static void iterativePreAandPostOrder(TreeNode4 node){
		Stack<StackPair> stack = new Stack<StackPair>();
		StackPair stackPair = new StackPair(-1,node);
		StringBuilder preOrderString = new StringBuilder("");
		StringBuilder postOrderString = new StringBuilder("");
		stack.push(stackPair);
		while(stack.size() > 0){
			StackPair topPair = stack.peek();
			if(topPair != null && topPair.status == -1){
				preOrderString.append(topPair.node.data+"->");
				topPair.status+=1;
			}else if(topPair != null && topPair.status >= 0 && topPair.status < topPair.node.children.size()){
				StackPair childPair = new StackPair(-1,topPair.node.children.get(topPair.status));
				stack.push(childPair);
				topPair.status+=1;		
			}else if(topPair != null && topPair.status == topPair.node.children.size()){
				postOrderString.append(topPair.node.data+"->");
				stack.pop();
			}
		}
		System.out.println("PreOrder := "+preOrderString.toString());
		System.out.println("PostOrder := "+postOrderString.toString());
	}

}

class MaxSubTree{
	int maxSum;
	TreeNode4 node;
	public MaxSubTree(int maxSum, TreeNode4 node) {
		super();
		this.maxSum = maxSum;
		this.node = node;
	}
	public int getMaxSum() {
		return maxSum;
	}
	public void setMaxSum(int maxSum) {
		this.maxSum = maxSum;
	}
	public TreeNode4 getNode() {
		return node;
	}
	public void setNode(TreeNode4 node) {
		this.node = node;
	}
	
}

class TreeNode4{
	int data;
	List<TreeNode4> children;
	public TreeNode4(int data) {
		super();
		this.data = data;
		children = new ArrayList<TreeNode4>();
	}
}

class StackPair{
	int status;
	TreeNode4 node;
	public StackPair(int status, TreeNode4 node) {
		super();
		this.status = status;
		this.node = node;
	}
	public StackPair() {
	}
}

class TreeNode4Char{
	public TreeNode4Char(char data) {
		super();
		this.data = data;
	}
	char data;
	List<TreeNode4Char> children = new ArrayList<>();
}