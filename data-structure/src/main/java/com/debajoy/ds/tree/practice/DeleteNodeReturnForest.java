/**
 * 
 */
package com.debajoy.ds.tree.practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Debajoy
 *
 */
	public	class DeleteNodeReturnForest {
	    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
	        List<TreeNode> list = new ArrayList<TreeNode>();
	        Set<Integer> set = new HashSet<Integer>();
	        for(int data : to_delete){
	           set.add(data);
	        }
	        root = deleteHelper(root,set,list);
	        if(root != null){
	            list.add(root);
	        }    
	        return list;
	    }
	    public TreeNode deleteHelper(TreeNode root,Set<Integer> set,List<TreeNode> list){
	        if(root == null){
	            return root;
	        }
	        root.left = deleteHelper(root.left,set,list);
	        root.right = deleteHelper(root.right,set,list);

	        if(set.contains(root.val)){
	            if(root.left != null){
	                list.add(root.left);
	            }
	            if(root.right != null){
	                list.add(root.right);
	            }
	            return null;
	        }

	        return root;
	    }
	}
