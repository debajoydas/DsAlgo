/**
 * 
 */
package com.debajoy.ds.tree.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Debajoy
 *
 */
public class UniqueBST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		System.out.println(numUniqueBSTTrees(n));
	}
	
    public static List<TreeNode> generateTrees(int n) {
        return generateTreesRec(1,n);
    }
    public static List<TreeNode> generateTreesRec(int start, int end){
        if(start > end){
            List<TreeNode> baseList = new ArrayList<TreeNode>();
            baseList.add(null);
            return baseList;
        }
        List<TreeNode> output = new ArrayList<TreeNode>();
        for(int i = start; i <= end; i++){
            List<TreeNode> left = generateTreesRec(start, i-1);
            List<TreeNode> right = generateTreesRec(i+1, end);
            for(TreeNode leftnode : left){
                for(TreeNode rightnode : right){
                    TreeNode root = new TreeNode(i);
                    root.left = leftnode;
                    root.right = rightnode;
                    output.add(root);
                }
            }
        }
        return output;
    }
    
    public static int numUniqueBSTTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            dp[i] = 0;
            for(int j = 0; j < i; j++){
                dp[i] += dp[j] * dp[i-j-1];
            }
        }
        return dp[n];
    }
}
