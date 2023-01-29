/**
 * 
 */
package com.debajoy.ds.tree.practice;

/**
 * @author Debajoy
 *
 */
public class HouseRobberIII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(1);
		root.left.left = new TreeNode(2);
		root.left.left.left = new TreeNode(3);
		System.out.println(rob(root));
	}
	
    public static int rob(TreeNode root) {
        HouseRobber robber = robHelper(root); 
        return Math.max(robber.maxWith,robber.maxWithout);
    }
    
    public static HouseRobber robHelper(TreeNode root){
        if(root == null){
            return new HouseRobber(0,0,0);
        }
        HouseRobber left = robHelper(root.left);
        HouseRobber right = robHelper(root.right);
        int maxWith = root.val + left.maxWithout + right.maxWithout;
        int maxWithout = Math.max(left.maxWith,left.maxWithout) + Math.max(right.maxWith,right.maxWithout);
        HouseRobber current = new HouseRobber(root.val,maxWith,maxWithout);
        return current;
    }
}


class HouseRobber{
    int data;
    int maxWith;
    int maxWithout;
    HouseRobber(int data,int maxWith, int maxWithout){
        this.data = data;
        this.maxWith = maxWith;
        this.maxWithout = maxWithout;
    }
}