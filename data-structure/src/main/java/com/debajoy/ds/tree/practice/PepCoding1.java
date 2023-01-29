package com.debajoy.ds.tree.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class PepCoding1 {
	static PracNode root;
	static PracNodeChar root1;
	static PracNode root2;
	public static void main(String[] args) {
		int[] arr = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
		Stack<PracNode> stack = new Stack<PracNode>();
		for(int i = 0; i < arr.length; i++){
			if(stack.size() <= 0){
				root = new PracNode(arr[i]);
				stack.add(root);
			}else{
				if(arr[i] == -1){
					stack.pop();			
				}else{
					if(stack.size() > 0){
						PracNode _childNode  = new PracNode(arr[i]);
						stack.peek().children.add(_childNode);
						stack.push(_childNode);
					}	
				}
			}
		}
		char[] arr1 = {'a','b','c','X','d','X','X','e','f','X','g','h','X','i','X','X','j','X','X','k','l','X','X','X'};
		Stack<PracNodeChar> stack1 = new Stack<PracNodeChar>();
		for(int i = 0; i < arr1.length; i++){
			if(stack1.size() <= 0){
				root1 = new PracNodeChar(arr1[i]);
				stack1.add(root1);
			}else{
				if(arr1[i] == 'X'){
					stack1.pop();			
				}else{
					if(stack1.size() > 0){
						PracNodeChar _childNode  = new PracNodeChar(arr1[i]);
						stack1.peek().children.add(_childNode);
						stack1.push(_childNode);
					}	
				}
			}
		}
		
		int[] arr2 = {10,40,100,-1,-1,30,90,-1,80,120,-1,110,-1,-1,70,-1,-1,20,60,-1,50,-1,-1,-1};
	//	int[] arr2 = {10,40,100,-1,-1,30,90,-1,80,120,-1,110,-1,-1,70,-1,-1,20,60,-1,50,-1,-1,140,-1,-1};
		Stack<PracNode> stack2 = new Stack<PracNode>();
		for(int i = 0; i < arr2.length; i++){
			if(stack2.size() <= 0){
				root2 = new PracNode(arr2[i]);
				stack2.add(root2);
			}else{
				if(arr2[i] == -1){
					stack2.pop();			
				}else{
					if(stack2.size() > 0){
						PracNode _childNode  = new PracNode(arr2[i]);
						stack2.peek().children.add(_childNode);
						stack2.push(_childNode);
					}	
				}
			}
		}
	//	root1.children.add(new PracNodeChar('s'));
		printPreOrderOneLevelDown(root);
		System.out.println("Size of Generic Tree : "+getSize(root));
		System.out.println("Maximum in Generic Tree : "+maxInTree(root));
		System.out.println("Height of Generic Tree : "+getHeight(root));
	//	traversalTreeEulerPath(root);
	//	levelOrdeRTraversal(root);
		levelOrderLineWise(root);
	//	levelOrderLineWiseZigZag(root);
	//	mirror(root);
	//	levelOrderLineWise(root);
	//	removeLeaves(root);
	//	levelOrderLineWise(root);
	//	linearizeTree(root);
	//	linearizeTreeOptimized(root);
	//	levelOrderLineWise(root);
		int find = 110;
		System.out.println("Find " +find+" : "+find(root, find));
		nodeToRootPath(root, find);
		int data1 = 120; int data2 = 110;
		System.out.println("Lowest Common Ancestor between Node-"+data1+" Node-"+data2+ " -> "+LCA(root, data1, data2));
		System.out.println("Distances between Nodes-("+data1+") Node-("+data2+ ") -> "+distanceBetweenNodes(root, data1, data2));
		System.out.println("Are Generic Trees Similar in Shape? -> "+areTreeSimilarInShape(root, root1));
		System.out.println("Are Generic Trees Mirror in Shape? -> "+areTreeMirrorInShape(root, root2));
	}
	
	public void display(PracNode node){
		printPreOrderOneLevelDown(node);
	}

	private static void printPreOrderOneLevelDown(PracNode node) {
		// TODO Auto-generated method stub
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
	
	public static int getSize(PracNode node){
		if(node == null){
			return 0;
		}
		int  size = 0;
		for(PracNode child : node.children){
			size += getSize(child);
		}
		return size+1;
	}
	
	public static int maxInTree(PracNode node){
		if(node == null){
			return node.data;
		}
		int max = node.data;
		for(PracNode child : node.children){
			max = Math.max(max, maxInTree(child));
		}
		return max;
	}
	
	public static int getHeight(PracNode node){
		int h = 0;
		for(PracNode child : node.children){
			h = Math.max(h, getHeight(child));
		}
		// If Height is being measured by number of edges from root to the deepest node
		if(node.children == null || (node.children != null & node.children.size() <= 0)){
			return h;
		}else{
			return h+1;			
		}	
		// If Height is being measured by number of nodes from root to the deepest node inclusive
		// return h+1;		
	}
	
	public static void traversalTreeEulerPath(PracNode node){
		if(node == null){
			return;
		}
		System.out.println("Node Pre-Order : "+node.data);
		for(PracNode child : node.children){
			System.out.println("Edge Pre-Order : "+node.data+" -> "+child.data);
			traversalTreeEulerPath(child);
			System.out.println("Edge Post-Order : "+node.data+" -> "+child.data);
		}
		System.out.println("Node Post-Order : "+node.data);
	}
	
	public static void levelOrdeRTraversal(PracNode node){
		// Remove -- Print -- Add children
		System.out.println();
		LinkedList<PracNode> queue = new LinkedList<PracNode>();
		queue.add(node);
		while(queue.size() > 0){
			PracNode _remove = queue.poll();
			System.out.print(_remove.data+ " -> ");
			for(PracNode child : _remove.children){
					queue.add(child);
			}
		}
	}
	
	public static void levelOrderLineWise(PracNode node){
		System.out.println();
		LinkedList<PracNode> queue = new LinkedList<PracNode>();
		queue.add(node);
		while(queue.size() > 0){
			int size = queue.size();
			for(int i = 0; i< size; i++){
				PracNode _remove = queue.poll();
				System.out.print(_remove.data+ " -> ");
				for(PracNode child : _remove.children){
					queue.add(child);
				}	
			}
			System.out.println();
		}	 
	}
	
	public static void levelOrderLineWiseZigZag(PracNode node){
		System.out.println();
		LinkedList<PracNode> queue = new LinkedList<PracNode>();
		queue.add(node);
		boolean isLToR = true;
		while(queue.size() > 0){
			int size = queue.size();
			if(isLToR){
				for(int i = 0; i< size; i++){
					PracNode _remove = queue.poll();
					System.out.print(_remove.data+ " -> ");
					for(PracNode child : _remove.children){
						queue.add(child);
					}	
				}	
			}else{
				Stack<Integer> stack = new Stack<Integer>();
				for(int i = 0; i< size; i++){
					PracNode _remove = queue.poll();
					stack.push(_remove.data);
					for(PracNode child : _remove.children){
						queue.add(child);
					}	
				}	
				while(stack.size() > 0){
					System.out.print(stack.pop()+ " -> ");
				}
			}
			System.out.println();
			isLToR = !isLToR;
		}	
	}
	
	public static void mirror(PracNode node){
		if(node == null){
			return;
		}
		for(PracNode child : node.children){
			mirror(child);
		}
		Collections.reverse(node.children);
	}
	
	public static boolean removeLeaves(PracNode node){
		if(node == null || node.children == null || (node.children != null && node.children.size() <=  0)){
			return true;
		}
		Iterator<PracNode> iterator = node.children.iterator();
		while(iterator.hasNext()){
			PracNode child = iterator.next();
			if(removeLeaves(child)){
				iterator.remove();
			}
		}
		return false;
	}
	
	//Linearize a Generic Tree
	public static void linearizeTree(PracNode node){
		for(PracNode child : node.children){
			linearizeTree(child);
		}
		while(node.children != null && node.children.size() > 1){
			PracNode last = node.children.remove(node.children.size()-1);
			PracNode secondLast = node.children.get(node.children.size()-1);
			PracNode secondLastTail = getTail(secondLast);
			secondLastTail.children.add(last);
		}
	}

	private static PracNode getTail(PracNode secondLast) {
		while(secondLast.children.size() == 1){
			secondLast = secondLast.children.get(0);
		}
		return secondLast;
	}
	
	//Linearize a Generic Tree in Optimized way
	public static PracNode linearizeTreeOptimized(PracNode node){
			if(node.children.size() <= 0){
				return node;
			}
			PracNode lastTail = linearizeTreeOptimized(node.children.get(node.children.size()-1));
			while(node.children != null && node.children.size() > 1){
				PracNode last = node.children.remove(node.children.size()-1);
				PracNode secondLast = node.children.get(node.children.size()-1);
				PracNode secondLastTail = linearizeTreeOptimized(secondLast);
				secondLastTail.children.add(last);
			}
			return lastTail;
	}

	public static boolean find(PracNode node, int data){
		if(node == null){
			return false;
		}else if(node != null && node.data == data){
			return true;
		}
		boolean isFound = false;
		for(PracNode child : node.children){
			isFound = find(child, data);
			if(isFound){
				return isFound;
			}
		}
		return isFound;
	}
	
	public static List<Integer> nodeToRootPath(PracNode node,int data){
		List<Integer> list = new ArrayList<Integer>();
		nodeToRootPathRec(node, data, list);
		Collections.reverse(list);
		System.out.println("Distance from Root("+node.data+") to Node-" +data);
		list.forEach(n -> System.out.print(n+ " -> "));
		return list;
	}
	
	public static List<Integer> nodeToRootPathWithoutSysOut(PracNode node,int data){
		List<Integer> list = new ArrayList<Integer>();
		nodeToRootPathRec(node, data, list);
		Collections.reverse(list);
		return list;
	}
	
	private static boolean nodeToRootPathRec(PracNode node,int data, List<Integer> list){
		if(node == null){
			return false;
		}else if(node != null && node.data == data){
			list.add(node.data);
			return true;
		}
		boolean isFound = false;
		for(PracNode child : node.children){
			isFound = nodeToRootPathRec(child, data, list);
			if(isFound){
				list.add(node.data);
				return isFound;
			}
		}
		return isFound;	
	}
	
	public static int LCA(PracNode node, int data1, int data2){
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
	 
	public static int distanceBetweenNodes(PracNode node,int data1, int data2){
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
	
	public static boolean areTreeSimilarInShape(PracNode node1, PracNodeChar node2){
		if(node1.children.size() != node2.children.size()){
			return false;
		}
		boolean isSimilar = true;
		for(int i = 0; i < node1.children.size(); i++){
			if(!areTreeSimilarInShape(node1.children.get(i), node2.children.get(i))){
				isSimilar = false;
				return isSimilar;
			}
		}
		return isSimilar;
	}
	
	public static boolean areTreeMirrorInShape(PracNode node1, PracNode node2){
		if(node1.children.size() != node2.children.size()){
			return false;
		}
		for(int i = 0; i < node1.children.size(); i++){
			if(!areTreeMirrorInShape(node1.children.get(i), node2.children.get(node2.children.size()-1-i))){
				return false;
			}
		}
		return true;
	}
}

class PracNode{
	public PracNode(int data) {
		super();
		this.data = data;
	}
	int data;
	List<PracNode> children = new ArrayList<>();
}

class PracNodeChar{
	public PracNodeChar(char data) {
		super();
		this.data = data;
	}
	char data;
	List<PracNodeChar> children = new ArrayList<>();
}
