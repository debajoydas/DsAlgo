/**
 * 
 */
package com.debajoy.ds.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.TreeMap;
import java.util.concurrent.ThreadLocalRandom;

import com.debajoy.ds.tree.BinaryTree.TreeNode;

/**
 * @author Debajoy
 *
 */
public class BinaryTree2 {
	
public TreeNode2 root;
	
	/**
	 * @param root the root to set
	 */
	public void setRoot(TreeNode2 root) {
		this.root = root;
	}
	/**
	 * @return the root
	 */
	public TreeNode2 getRoot() {
		return this.root;
	}
	static class TreeNode2{
		int data;
		TreeNode2 left;
		TreeNode2 right;
		public TreeNode2(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	public boolean isEmpty(TreeNode2 node){
		if(node == null){
			return true;
		}
		return false;
	}
	
	public int findLCA(int n1, int n2){
		
		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();
		TreeNode2 temp1 = this.root;TreeNode2 temp2 = this.root;
		
		boolean isExist1 = findPathForGivenNode(temp1, n1, list1);
		boolean isExist2 = findPathForGivenNode(temp2, n2, list2);
		
		if(isExist1 && isExist2){
			for(int i = 0; i < list1.size() && i < list2.size(); i++){
				if((list1.size() <= 1 || list2.size() <= 1) && list1.get(i) == list2.get(i)){
					return list1.get(0);
				}else if(list1.get(i) != list2.get(i)){
					return list1.get(i-1);
				}
			}
		}
		
		return -1;
		
	}

	private boolean findPathForGivenNode(TreeNode2 node, int n, List<Integer> list) {
		// TODO Auto-generated method stub
		if(node != null){
			list.add(node.data);
			if(node.data == n){
				return true;
			}else{
				if(findPathForGivenNode(node.left, n, list) || findPathForGivenNode(node.right, n, list)){
					return true;
				}else{
					list.remove(new Integer(node.data));
					return false;
				}
			}
		}else{
			return false;
		}
	}
	
	public void getTopViewOfBinaryTree(){
		TreeNode2 tempRoot = this.root;
		Map<Integer,List<Integer>> map = new TreeMap<Integer,List<Integer>>();
		Map<Integer,Integer> levelValue = new HashMap<Integer, Integer>();
		levelValue.put(tempRoot.data, 0);
		assignLevelOnNodes(tempRoot, levelValue);
		for(Map.Entry<Integer,Integer> entry : levelValue.entrySet()){
			if(map.get(entry.getValue()) == null){
				List<Integer> newList = new ArrayList<Integer>();
				newList.add(entry.getKey());
				map.put(entry.getValue(), newList);
			}else{
				List<Integer> valueMap = map.get(entry.getValue());
				valueMap.add(entry.getKey());
				map.put(entry.getValue(), valueMap);
			}
		}
		System.out.println("Top View:--->");
		for(Map.Entry<Integer,List<Integer>> entryMap : map.entrySet()){
			System.out.print(entryMap.getValue().get(0) + " -> ");
		}
		System.out.println();
		System.out.println("Bottom View:--->");
		for(Map.Entry<Integer,List<Integer>> entryMap : map.entrySet()){
			if(entryMap.getValue().size() <= 1){
				System.out.print(entryMap.getValue().get(0) + " -> ");
			}else{
				System.out.print(entryMap.getValue().get(ThreadLocalRandom.current().nextInt(1, entryMap.getValue().size())) + " -> ");
			}
		}
		
	}
	
	private void assignLevelOnNodes(TreeNode2 tempRoot, Map<Integer, Integer> levelValue) {
		// TODO Auto-generated method stub
		if(tempRoot.left != null){
			levelValue.put(tempRoot.left.data, levelValue.get(tempRoot.data)-1);
			assignLevelOnNodes(tempRoot.left, levelValue);
		}
		if(tempRoot.right != null){
			levelValue.put(tempRoot.right.data, levelValue.get(tempRoot.data)+1);
			assignLevelOnNodes(tempRoot.right, levelValue);
		}
		return;
	}
	
	public List<List<Integer>> zigzagLevelOrders() {
		
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		LinkedList<TreeNode2> queue = new LinkedList<TreeNode2>();
        int level = 0;
        queue.add(root);
        while(queue.size() > 0){
            int size = queue.size();
            List<Integer> list = new ArrayList<Integer>();
            for(int i = 0; i < size; i++){
                TreeNode2 popedNode = queue.poll();
                list.add(popedNode.data);
                if(popedNode.left != null){
                	queue.add(popedNode.left);
                }
                if(popedNode.right != null){
                	queue.add(popedNode.right);
                }
            }
            if(list.size() > 0){
                if(level%2 != 0){
                    Collections.reverse(list);
                }
                output.add(list);
            }
            level++;
        }
        return output;
	}
	
	public List<List<Integer>> zigzagLevelOrder() {
		
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		Stack<TreeNode2> stack1 = new Stack<TreeNode2>();
		Stack<TreeNode2> stack2 = new Stack<TreeNode2>();
		stack1.push(root);
		while(!stack1.isEmpty() || !stack2.isEmpty()){
			List<Integer> listInner = new ArrayList<Integer>();
			while(!stack1.isEmpty()){
				TreeNode2 popedItem = stack1.pop();
				listInner.add(popedItem.data);
				if(popedItem.left != null){
					stack2.push(popedItem.left);
				}
				if(popedItem.right != null){
					stack2.push(popedItem.right);
				}
			}
			if(listInner.size() > 0){
				output.add(listInner);
			}
			listInner = new ArrayList<>();
			
			while(!stack2.isEmpty()){
				TreeNode2 popedItem = stack2.pop();
				listInner.add(popedItem.data);
				if(popedItem.right != null){
					stack1.push(popedItem.right);	
				}
				if(popedItem.left != null){
					stack1.push(popedItem.left);
				}
			}
			if(listInner.size() > 0){
				output.add(listInner);
			}		
			listInner = new ArrayList<>();
		}
		return output;
    }


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree2 bTree = new BinaryTree2();
		TreeNode2 root = new TreeNode2(1);  
		bTree.root = root;
		bTree.getRoot().left = new TreeNode2(2); 
	    bTree.getRoot().right = new TreeNode2(3); 
	    bTree.getRoot().left.left = new TreeNode2(4); 
	    bTree.getRoot().left.right = new TreeNode2(5);
	    bTree.getRoot().right.left = new TreeNode2(6); 
	    bTree.getRoot().right.right = new TreeNode2(7);
	  /*  System.out.println(bTree.findLCA(2, 7));
	    System.out.println(bTree.findLCA(1, 5));
	    System.out.println(bTree.findLCA(4, 6));
	    System.out.println(bTree.findLCA(4, 5));
	    System.out.println(bTree.findLCA(5, 6));
	    System.out.println(bTree.findLCA(1, 9));
	    bTree.getTopViewOfBinaryTree();
	    System.out.println("--------------ZigZag View----------------");
	    bTree.zigzagLevelOrder();
	    */
	    BinaryTree2 bTree2 = new BinaryTree2();
		TreeNode2 root2 = new TreeNode2(3);  
		bTree2.root = root2;
		bTree2.getRoot().left = new TreeNode2(9); 
		bTree2.getRoot().right = new TreeNode2(20); 
		bTree2.getRoot().right.left = new TreeNode2(15); 
		bTree2.getRoot().right.right = new TreeNode2(7);
		System.out.println("--------------ZigZag View----------------");
	    bTree2.zigzagLevelOrders();
	}

}
