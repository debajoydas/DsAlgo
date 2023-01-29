/**
 * 
 */
package com.debajoy.ds.tree.practice;

import java.util.HashMap;

public class ConstructBinaryTreeInorderPostorder {
    public TreeNode buildTree(int[] in, int[] post) {
		HashMap<Integer, Integer> inMap = new HashMap<>();
		HashMap<Integer, Integer> postMap = new HashMap<>();
		for(int i = 0; i < in.length; i++){
			inMap.put(in[i], i);
		}
		for(int i = 0; i < post.length; i++){
			postMap.put(post[i], i);
		}
		return constructBinaryTreeFromPostAndInOrderRec(post, in, 0, in.length-1, 0, inMap, postMap);
    }

    private static TreeNode constructBinaryTreeFromPostAndInOrderRec(int[] post, int[] in, int start, int end, int count, 
    		HashMap<Integer, Integer> inMap, HashMap<Integer, Integer> postMap){
    	if(start > end){
    		return null;
    	}
    	int rootValue = post[end-count];
    	TreeNode root = new TreeNode(rootValue);
    	int rootInIdx = inMap.get(rootValue);
    	int ls = start;
    	int le = rootInIdx-1;
    	int rs = rootInIdx+1;
    	int re = end;
    	root.left = constructBinaryTreeFromPostAndInOrderRec(post, in, ls, le, count, inMap, postMap);
    	root.right = constructBinaryTreeFromPostAndInOrderRec(post, in, rs, re, count+1, inMap, postMap);
    	return root;
    }
}