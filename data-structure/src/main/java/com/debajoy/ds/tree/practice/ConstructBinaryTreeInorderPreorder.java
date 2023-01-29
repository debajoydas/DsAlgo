/**
 * 
 */
package com.debajoy.ds.tree.practice;

import java.util.HashMap;

/**
 * @author Debajoy
 *
 */

public class ConstructBinaryTreeInorderPreorder {
	
	public static void main(String[] args){
		
	}
	    
		public TreeNode buildTree(int[] pre, int[] in) {
	        HashMap<Integer, Integer> preMap = new HashMap<>();
			HashMap<Integer, Integer> inMap = new HashMap<>();
			for(int i = 0; i < pre.length; i++){
				preMap.put(pre[i], i);
			}
			for(int i = 0; i < in.length; i++){
				inMap.put(in[i], i);
			}
			return constructBinaryTreeFromPreAndInOrderRec(in, pre, 0, pre.length-1, 0, preMap, inMap);
	    }
	
	    private static TreeNode constructBinaryTreeFromPreAndInOrderRec(int[] in, int[] pre, int start, int end, int count,
			HashMap<Integer, Integer> preMap, HashMap<Integer, Integer> inMap) {
	    	if(start > end || start >= pre.length || end >= pre.length || start < 0 || end < 0){
	    		return null;
	    	}
	    	if(start == end){
	    		TreeNode newNode = new TreeNode(pre[start]);
	    		return newNode;
	    	}
	    
	    	int rootVal = pre[start];
	    	int inRootIdx = inMap.get(rootVal);
	    	TreeNode root = new TreeNode(rootVal);
	    	int ls = start+1;
	    	int length = inRootIdx-count-1;
	    	int le = ls+length;
	    	int rs = le+1;
	    	int re = end;
	    	root.left = constructBinaryTreeFromPreAndInOrderRec(in, pre, ls, le, count, preMap, inMap);
	    	root.right = constructBinaryTreeFromPreAndInOrderRec(in, pre, rs, re, inRootIdx+1, preMap, inMap);
	    	return root;
	    }
	}
