/**
 * 
 */
package com.debajoy.ds.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import javax.print.attribute.standard.PresentationDirection;

import com.debajoy.ds.tree.BinaryTree.TreeNode;

/**
 * @author Debajoy
 *
 */
public class BuildBinaryTreeFromPrePostOrderOptimized {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] preorder = {3,9,20,15,7};
		int[] inOrder = {9,3,15,20,7};
		int[] postOrder = {9,15,7,20,3};
	//	TreeNode root1 = buildTreeFromPost(postOrder, inOrder);
		TreeNode root = buildTree(preorder, inOrder);
		System.out.println("Done");
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
			int indexRoot = IntStream.range(0, postOrder.length).filter(i -> root == postOrder[i]).findFirst().orElse(-1);
			int fixedenghthLeft = rightList.size();

            int left=0;int right = 0;
			if(indexRoot-1-fixedenghthLeft >= 0){
                left = postOrder[indexRoot-1-fixedenghthLeft];
            }
			if(indexRoot-1 >= 0){
                right = postOrder[indexRoot-1];
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
			
			int indexRoot = IntStream.range(0, preorder.length).filter(i -> root == preorder[i]).findFirst().orElse(-1);
			int fixedenghthRight = leftList.size();

			int left = 0; int right = 0;
			if(indexRoot+1+fixedenghthRight < preorder.length){
                left = preorder[indexRoot+1];
            }
			if(indexRoot-1 < preorder.length){
                right = preorder[indexRoot+1+fixedenghthRight];
            }
			
			node.left = buildTreeRec(left, leftList, preorder);
			node.right = buildTreeRec(right, rightList, preorder);
			return node;
		}
	}

}
