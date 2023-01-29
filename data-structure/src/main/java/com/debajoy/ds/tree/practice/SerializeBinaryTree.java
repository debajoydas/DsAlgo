/**
 * 
 */
package com.debajoy.ds.tree.practice;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * @author Debajoy
 *
 */

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
  }
 
public class SerializeBinaryTree {
	
	static String SEPERATOR = ",";
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		String s = serialize(root);
		TreeNode rootRecon = deserialize(s);
		levelOrderTraversal(rootRecon);
	}
	
	private static void levelOrderTraversal(TreeNode root) {
		// TODO Auto-generated method stub
		ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
		queue.add(root);
		while(queue.size() > 0){
			int size = queue.size();
			for(int i = 0; i < size ; i++){
				TreeNode polledNode = queue.pop();
				System.out.print(polledNode.val+"->");
				if(polledNode.left != null){
					queue.add(polledNode.left);
				}
				if(polledNode.right != null){
					queue.add(polledNode.right);
				}	
			}
			System.out.println();
		}
		
	}
	
	
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder("");
        serializeRec(root,sb);
        return sb.toString();
    }

    public static void serializeRec(TreeNode root, StringBuilder sb) {
        if(root == null){
            sb.append("n").append(SEPERATOR);
            return;
        }
        sb.append(root.val).append(SEPERATOR);
        serializeRec(root.left,sb);
        serializeRec(root.right,sb);
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if(data == null || data.length() <= 0){
            return null;
        }
        int idx = 0;
        String[] strarr = data.split(SEPERATOR);
        TreeNode root = new TreeNode(Integer.valueOf(strarr[idx]));
        BinaryData element = new BinaryData(root, 0);
        Stack<BinaryData> stack = new Stack<BinaryData>();
        stack.add(element);
        idx++;
        while(!stack.isEmpty() && idx < data.length()){
            BinaryData peek = stack.peek();
            if(peek.status == 0){
                if(!strarr[idx].equals("n")){
                    int data1 = Integer.parseInt(strarr[idx]);
                    TreeNode newNode = new TreeNode(data1);
                    BinaryData newElement = new BinaryData(newNode, 0);
                    peek.status += 1;
                    peek.node.left = newNode;
                    stack.push(newElement);
                    idx++;                   
                }else{
                    peek.status += 1;
                    peek.node.left = null;
                    idx++;
                }

            }else if(peek.status == 1){
                if(!strarr[idx].equals("n")){
                    int data2 = Integer.parseInt(strarr[idx]);
                    TreeNode newNode = new TreeNode(data2);
                    BinaryData newElement = new BinaryData(newNode, 0);
                    peek.status += 1;
                    peek.node.right = newNode;
                    stack.push(newElement);
                    idx++;
                }else{
                    peek.status += 1;
                    peek.node.right = null;
                    idx++;
                }
            }else{
                stack.pop();
            }
        }
        return root;
    }
}

class BinaryData{
    TreeNode node;
    int status;
    BinaryData(TreeNode node, int status){
        this.node = node;
        this.status = status;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
