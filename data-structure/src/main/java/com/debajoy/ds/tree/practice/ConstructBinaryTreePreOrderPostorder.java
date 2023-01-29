/**
 * 
 */
package com.debajoy.ds.tree.practice;

import java.util.HashMap;

/**
 * @author Debajoy
 *
 */
public class ConstructBinaryTreePreOrderPostorder {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
		HashMap<Integer, Integer> preMap = new HashMap<>();
		HashMap<Integer, Integer> postMap = new HashMap<>();
		for(int i = 0; i < pre.length; i++){
			preMap.put(pre[i], i);
		}
		for(int i = 0; i < post.length; i++){
			postMap.put(post[i], i);
		}
		return constructBinaryTreeFromPostAndPreOrderRecInt(post, pre, 0, pre.length-1, 0, preMap, postMap);
    }
    	private static TreeNode constructBinaryTreeFromPostAndPreOrderRecInt(int[] post, int[] pre, int start, int end,
    			int count, HashMap<Integer, Integer> preMap, HashMap<Integer, Integer> postMap){
    		if(start > end || start >= post.length || end >= post.length){
    			return null;
    		}
    		if(start == end){
    			TreeNode node = new TreeNode(start);
    			return node;
    		}
            TreeNode node = new TreeNode(pre[start]);
		    int ls = start+1;
		    int idx = postMap.get(pre[ls]);
		    int length = idx-count;
		    int le = ls+length;
		    int rs = le+1;
		    int re = end;
		    node.left = constructBinaryTreeFromPostAndPreOrderRecInt(post, pre, ls, le, count, preMap, postMap);
		    node.right = constructBinaryTreeFromPostAndPreOrderRecInt(post, pre, rs, re, idx+1, preMap, postMap);
		    return node;
    	}
}