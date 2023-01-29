/**
 * 
 */
package com.debajoy.ds.tree.practice;

/**
 * @author Debajoy
 *
 */

public class LongestUnivaluePath {
	
		static int maxReturn = 0;
		
		public static void main(String[] args){
			TreeNode root = new TreeNode(1);
			root.left = new TreeNode(4);
			root.right = new TreeNode(5);
			root.left.left = new TreeNode(4);
			root.left.right = new TreeNode(4);
			root.right.right = new TreeNode(5);
			System.out.println(longestUnivaluePath(root));
		}
	
	    public static int longestUnivaluePath(TreeNode root) {
	        longestPathRec(root);
	        return maxReturn;
	    }

	    public static int longestPathRec(TreeNode root){
	        if(root == null){
	            return 0;
	        }
	        int left = longestPathRec(root.left);
	        int right = longestPathRec(root.right);
	        int maxLength = 0;
	        int height = 0;
	        if(root.left != null && root.right != null){
	            if(root.val == root.left.val && root.val == root.right.val){
	                maxLength = 2 + left + right;
	                height = 1 + Math.max(left,right);
	            }else if(root.val == root.left.val && root.val != root.right.val){
	                maxLength = 1 + left;
	                height = maxLength;
	            }else if(root.val != root.left.val && root.val == root.right.val){
	                maxLength = 1 + right;
	                 height = maxLength; 
	            }
	        }else if(root.left != null && root.right == null){
	            if(root.val == root.left.val){
	                maxLength = 1 + left;
	                 height = maxLength;
	            }
	        }else if(root.left == null && root.right != null){
	            if(root.val == root.right.val){
	                maxLength = 1 + right;
	                 height = maxLength;
	            }
	        }
	        maxReturn = Math.max(maxReturn,maxLength);
	        return height;
	    }
	}
