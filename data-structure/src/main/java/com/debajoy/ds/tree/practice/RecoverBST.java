/**
 * 
 */
package com.debajoy.ds.tree.practice;

/**
 * @author Debajoy
 *
 */

public class RecoverBST {
    TreeNode prev = null;
    TreeNode first = null;
    TreeNode second = null;
    public void recoverTree(TreeNode root) {   
        inOrderTraversal(root);
        if(first != null && second != null){
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }
    public void inOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        inOrderTraversal(root.left);
        if(prev != null){
            if(first == null && prev.val > root.val){
                first = prev; 
            }
            if(first != null && prev.val > root.val){
                second = root;
            }
        }
        prev = root;
        inOrderTraversal(root.right);
    }

}
