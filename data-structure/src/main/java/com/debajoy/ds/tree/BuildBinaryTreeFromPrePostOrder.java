/**
 * 
 */
package com.debajoy.ds.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;import javax.print.attribute.standard.PresentationDirection;

import com.debajoy.ds.tree.BinaryTree.TreeNode;

/**
 * @author Debajoy
 *
 */
public class BuildBinaryTreeFromPrePostOrder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] preorder = {3,9,20,15,7};
		int[] inOrder = {9,3,15,20,7};
		int[] postOrder = {9,15,7,20,3};
		TreeNode root1 = buildTreeFromPost(postOrder, inOrder);
	//	TreeNode root = buildTree(preorder, inOrder);
	}
	
    private static TreeNode buildTreeFromPost(int[] postOrder, int[] inorder) {
		// TODO Auto-generated method stub

    	if(postOrder == null || (postOrder != null && postOrder.length < 1)){
    		return null;
    	}
    	if(inorder == null || (inorder != null && inorder.length < 1)){
    		return null;
    	}
    	List<Integer> list = new ArrayList<Integer>();
    	for(int i : inorder){
    		list.add(i);
    	}
    	int root = postOrder[postOrder.length-1];
		return buildTreeFromPostRec(root,list,postOrder);   
    
	}
    
	private static TreeNode buildTreeFromPostRec(int root, List<Integer> list, int[] postOrder) {
		// TODO Auto-generated method stub
		if(list == null || (list != null && list.size() < 1)){
			return null;
		}else if(list.size() == 1){
			TreeNode node = new TreeNode(root);
			return node;
		}else{
			TreeNode node = new TreeNode(root);
			List<Integer> leftList = new ArrayList<>();
			List<Integer> rightList = new ArrayList<>();
			int index = list.indexOf(new Integer(root));
			leftList.addAll(list.subList(0, index));
			rightList.addAll(list.subList(index+1,list.size()));
			
			int left = 0; int right = 0;
			boolean isFoundL = false;
			for(int i = postOrder.length-1; i >=0 ; i--){
				if(isFoundL){
					break;
				}
				for(int j : leftList){
					if(postOrder[i] == j){
						left = j;
						isFoundL = true;
						break;
					}
				}
			}
			boolean isFoundR = false;
			for(int i = postOrder.length-1; i >=0 ; i--){
				if(isFoundR){
					break;
				}
				for(int j : rightList){
					if(postOrder[i] == j){
						right = j;
						isFoundR = true;
						break;
					}
				}
			}
			
			node.left = buildTreeFromPostRec(left, leftList, postOrder);
			node.right = buildTreeFromPostRec(right, rightList, postOrder);
			return node;
		}
	}

	public static TreeNode buildTree(int[] preorder, int[] inorder) {
    	if(preorder == null || (preorder != null && preorder.length < 1)){
    		return null;
    	}
    	if(inorder == null || (inorder != null && inorder.length < 1)){
    		return null;
    	}
    	List<Integer> list = new ArrayList<Integer>();
    	for(int i : inorder){
    		list.add(i);
    	}
    	int root = preorder[0];
		return buildTreeRec(root,list,preorder);   
    }

	private static TreeNode buildTreeRec(int root, List<Integer> list, int[] preorder) {
		// TODO Auto-generated method stub
		if(list == null || (list != null && list.size() < 1)){
			return null;
		}else if(list.size() == 1){
			TreeNode node = new TreeNode(root);
			return node;
		}else{
			TreeNode node = new TreeNode(root);
			List<Integer> leftList = new ArrayList<>();
			List<Integer> rightList = new ArrayList<>();
			int index = list.indexOf(new Integer(root));
			leftList.addAll(list.subList(0, index));
			rightList.addAll(list.subList(index+1,list.size()));
			
			int left = 0; int right = 0;
			boolean isFoundL = false;
			for(int i = 0; i < preorder.length ; i++){
				if(isFoundL){
					break;
				}
				for(int j : leftList){
					if(preorder[i] == j){
						left = j;
						isFoundL = true;
						break;
					}
				}
			}
			boolean isFoundR = false;
			for(int i = 0; i < preorder.length ; i++){
				if(isFoundR){
					break;
				}
				for(int j : rightList){
					if(preorder[i] == j){
						right = j;
						isFoundR = true;
						break;
					}
				}
			}
			
			node.left = buildTreeRec(left, leftList, preorder);
			node.right = buildTreeRec(right, rightList, preorder);
			return node;
		}
	}

}
