/**
 * 
 */
package com.debajoy.ds.tree.practice;

/**
 * @author Debajoy
 *
 */
public class LcaBST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(2);
		root.right = new TreeNode(8);
		
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(9);
		
		TreeNode p = root.left.right.left = new TreeNode(3);
		TreeNode q = root.left.right.right = new TreeNode(5);
		
		System.out.println(lowestCommonAncestor(root, p, q).val);
	}
	 public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	        TreeNode curr = root;
	        TreeNode smallest = null;
	        TreeNode largest = null;
	        if(p.val > q.val){
	            largest = p;
	            smallest = q;
	        }else{
	            largest = q;
	            smallest = p;
	        }
	        while(curr != null && !(curr.val > smallest.val && curr.val < largest.val)){
	            if(curr.val < smallest.val){
	                curr = curr.right;
	            }else if(curr.val > largest.val){
	                curr = curr.left;
	            }
	        }
	        return curr;
	    }

}
