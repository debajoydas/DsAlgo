/**
 * 
 */
package com.debajoy.ds.tree.practice;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * @author Debajoy
 *
 */
public class PepcodingGenericTree {

	static TreeNode4 root1;
	static TreeNode4Char root2;
	static TreeNode4 root3;
	static TreeNode4 root4;
	static TreeNode4 root5;
	static TreeNode4 root6;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
		char[] arr2 = {'a','b','c','X','d','X','X','e','f','X','g','h','X','i','X','X','j','X','X','k','l','X','X','X'};
		int[] arr3 = {10,40,100,-1,-1,30,90,-1,80,120,-1,110,-1,-1,70,-1,-1,20,60,-1,50,-1,-1,-1};
		int[] arr4 = {10,20,50,-1,60,-1,-1,30,70,-1,80,120,-1,130,-1,-1,90,-1,-1,40,100,-1,110,-1,-1};
		int[] arr5 = {10,20,-50,-1,-60,-1,-1,30,-70,-1,80,-110,-1,120,-1,-1,90,-1,-1,40,-100,-1,-1,-1};
		int[] arr6 = {1,2,5,11,17,19,21,23,-1,-1,-1,-1,
					  -1,-1,6,12,18,20,22,24,-1,-1,-1,
					  -1,-1,-1,-1,3,7,-1,8,13,100,-1,
					  -1,-1,9,-1,-1,4,10,14,-1,15,-1,
					  16,-1,-1,-1,-1};
		final String SEPERATOR ="**************************************************************************************";
		buildBinaryTree1(arr1);
//		System.out.println(SEPERATOR);
//		buildBinaryTree2(arr2);
//		System.out.println(SEPERATOR);
//		buildBinaryTree3(arr3);
//		System.out.println(SEPERATOR);
//		buildBinaryTree4(arr4);
//		System.out.println(SEPERATOR);
//		buildBinaryTree5(arr5);
//		System.out.println(SEPERATOR);
//		buildBinaryTree6(arr6);
//		System.out.println(SEPERATOR);
		System.out.println("Size of Generic Tree : "+getSize(root1));
		System.out.println(SEPERATOR);
		System.out.println("Maximum in Generic Tree : "+maxInTree(root1));
		System.out.println(SEPERATOR);
		System.out.println("Height of Generic Tree : "+getHeight(root1));
		System.out.println(SEPERATOR);
		

	}

	private static int getHeight(TreeNode4 root) {
		int height = -1;
		for(TreeNode4 child : root.children){
			height = Math.max(height, getHeight(child));
		}
		return height+1;
	}

	private static int maxInTree(TreeNode4 root) {
		int max = Integer.MIN_VALUE;
		for(TreeNode4 child : root.children){
			max = Math.max(max, maxInTree(child));
		}
		return Math.max(max, root.data);
	}

	private static int getSize(TreeNode4 root) {
		// TODO Auto-generated method stub
		if(root == null){
			return 0;
		}
		int size = 0;
		for(TreeNode4 child : root.children){
			size += getSize(child);
		}
		return 1+size;
	}

	private static void buildBinaryTree6(int[] arr) {
		// TODO Auto-generated method stub
		Stack<TreeNode4> stack = new Stack<TreeNode4>();
		for(int i = 0; i < arr.length; i++){
			if(stack.size() <= 0){
				TreeNode4 node = new TreeNode4(arr[i]);
				root6 = node;
				stack.push(root1);
			}else{
				if(arr[i] != -1){
					TreeNode4 node = new TreeNode4(arr[i]);
					TreeNode4 peek = stack.peek();
					peek.children.add(node);
					stack.push(node);	
				}else{
					stack.pop();
				}
			}
		}
		levelOrderTraversalLineWise(root6);
	}

	private static void buildBinaryTree5(int[] arr) {
		// TODO Auto-generated method stub
		Stack<TreeNode4> stack = new Stack<TreeNode4>();
		for(int i = 0; i < arr.length; i++){
			if(stack.size() <= 0){
				TreeNode4 node = new TreeNode4(arr[i]);
				root5 = node;
				stack.push(root5);
			}else{
				if(arr[i] != -1){
					TreeNode4 node = new TreeNode4(arr[i]);
					TreeNode4 peek = stack.peek();
					peek.children.add(node);
					stack.push(node);	
				}else{
					stack.pop();
				}
			}
		}
		levelOrderTraversalLineWise(root5);
	}

	private static void buildBinaryTree4(int[] arr) {
		// TODO Auto-generated method stub
		Stack<TreeNode4> stack = new Stack<TreeNode4>();
		for(int i = 0; i < arr.length; i++){
			if(stack.size() <= 0){
				TreeNode4 node = new TreeNode4(arr[i]);
				root4 = node;
				stack.push(root4);
			}else{
				if(arr[i] != -1){
					TreeNode4 node = new TreeNode4(arr[i]);
					TreeNode4 peek = stack.peek();
					peek.children.add(node);
					stack.push(node);	
				}else{
					stack.pop();
				}
			}
		}
		levelOrderTraversalLineWise(root4);
	}

	private static void buildBinaryTree3(int[] arr) {
		// TODO Auto-generated method stub
		Stack<TreeNode4> stack = new Stack<TreeNode4>();
		for(int i = 0; i < arr.length; i++){
			if(stack.size() <= 0){
				TreeNode4 node = new TreeNode4(arr[i]);
				root3 = node;
				stack.push(root3);
			}else{
				if(arr[i] != -1){
					TreeNode4 node = new TreeNode4(arr[i]);
					TreeNode4 peek = stack.peek();
					peek.children.add(node);
					stack.push(node);	
				}else{
					stack.pop();
				}
			}
		}
		levelOrderTraversalLineWise(root3);
	}

	private static void buildBinaryTree2(char[] arr) {
		// TODO Auto-generated method stub
		Stack<TreeNode4Char> stack = new Stack<TreeNode4Char>();
		for(int i = 0; i < arr.length; i++){
			if(stack.size() <= 0){
				TreeNode4Char node = new TreeNode4Char(arr[i]);
				root2 = node;
				stack.push(root2);
			}else{
				if(arr[i] != -1){
					TreeNode4Char node = new TreeNode4Char(arr[i]);
					TreeNode4Char peek = stack.peek();
					peek.children.add(node);
					stack.push(node);	
				}else{
					stack.pop();
				}
			}
		}
	}

	private static void buildBinaryTree1(int[] arr) {
		// TODO Auto-generated method stub
		Stack<TreeNode4> stack = new Stack<TreeNode4>();
		for(int i = 0; i < arr.length; i++){
			if(stack.empty()){
				TreeNode4 node = new TreeNode4(arr[i]);
				root1 = node;
				stack.push(root1);
			}else{
				if(arr[i] != -1){
					TreeNode4 node = new TreeNode4(arr[i]);
					TreeNode4 peek = stack.peek();
					peek.children.add(node);
					stack.push(node);	
				}else{
					stack.pop();
				}
			}
		}
		levelOrderTraversalLineWise(root1);
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

}
