package com.debajoy.ds.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import com.debajoy.ds.graph.Node;
import com.debajoy.ds.tree.BinaryTree3.TreeNode;

public class BinaryTree3 {
	
	public TreeNode root;
	
	static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode next;
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public boolean isEmpty(TreeNode node){
		if(node == null){
			return true;
		}
		return false;
	}
	
	public boolean isValidBSTOptimized(TreeNode node) {
    	if(node == null){
    		return true;
    	}else{
    		Queue<Integer> list = new LinkedList<Integer>();    		
    		isValidBSTOptimized(node, list);
    		return checkIfListSorted(list);
    	}	
    }
	
    private boolean checkIfListSorted(Queue<Integer> list) {
		// TODO Auto-generated method stub
    	if(list == null || (list != null && list.size() < 1)){
    		return true;
    	}else{
    		int prev = Integer.MIN_VALUE;
    		while(list.size() > 0){
    			if(prev < list.peek()){
    				prev = list.poll();
    			}else{
    				return false;
    			}
    		}
    	}
		return true;
	}

	private void isValidBSTOptimized(TreeNode node, Queue<Integer> list) {
    	if(node == null){
    		return;
    	}
    	isValidBSTOptimized(node.left,list);
    	list.add(node.val);
    	isValidBSTOptimized(node.right, list);
    }

	public boolean isValidBST(TreeNode node) {
    	if(node == null){
    		return true;
    	}
    	return getBSTPair(node).isBST;
    }

	private BSTPair getBSTPair(TreeNode node) {
		// TODO Auto-generated method stub
		if(node == null){
			BSTPair leafPair = new BSTPair();
			leafPair.min = Integer.MAX_VALUE;
			leafPair.max = Integer.MIN_VALUE;
			leafPair.isBST = true;
			return leafPair;
		}
		BSTPair lNode= getBSTPair(node.left);
		BSTPair rNode = getBSTPair(node.right);
		BSTPair mPair = new BSTPair();
		mPair.isBST = lNode.isBST && rNode.isBST && (node.val > lNode.max && node.val < rNode.min);
		mPair.min = Math.min(node.val, Math.min(lNode.min, rNode.min));
		mPair.max = Math.max(node.val, Math.max(lNode.max, rNode.max));
		return mPair;
	}
	
    public int sumNumbers(TreeNode root) {
    	if(root == null){
    		return 0;
    	}
    	List<Integer> sumList = new ArrayList<Integer>();
    	int sum = 0;
    	sumNumbersRec(root, sumList, sum);
		return sumList.stream().mapToInt(Integer::intValue).sum();   
    }

	private void sumNumbersRec(TreeNode root, List<Integer> sumList, int sum) {
		// TODO Auto-generated method stub
		if(root == null){
			return;
		}
		if(root.left == null && root.right == null){
			sum = sum*10 + root.val;
			sumList.add(sum);
			return;
		}
		sum = sum*10 + root.val;
		sumNumbersRec(root.left, sumList, sum);
		sumNumbersRec(root.right, sumList, sum);
	}
	
    public TreeNode connect(TreeNode root) {
    	if(root == null){
    		return null;
    	}
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.add(root);
    	while(queue.size() > 0){
    		TreeNode prev = null;
    		int size = queue.size();
    		for(int i = 0; i < size; i++){
    			TreeNode currentNode = queue.poll();
    			if(prev == null){
    				prev = currentNode;
    			}else{
    				prev.next = currentNode;
    				prev = currentNode;
    			}
    			if(currentNode.left != null){
    				queue.add(currentNode.left);
    			}
    			if(currentNode.right != null){
    				queue.add(currentNode.right);
    			}
    		}		
    	}
		return root; 
    }
    
    public List<Integer> postorderTraversal(TreeNode root) {
    	List<Integer> list = new ArrayList<Integer>();
    	if(root == null){
    		return list;
    	}
    	Stack<TreePair> stack = new Stack<TreePair>();
    	TreePair pair = new TreePair(root, 1);
    	stack.push(pair);
    	while(stack.size()> 0){
    		TreePair current = stack.peek();
    		if(current.state == 1){
    			current.state++;
    			if(current.node.left != null){
    				TreePair pairLeft = new TreePair(current.node.left, 1);
    				stack.push(pairLeft);
    			}
    		}else if(current.state == 2){
    			current.state++;
    			if(current.node.right != null){
    				TreePair pairRight = new TreePair(current.node.right, 1);
    				stack.push(pairRight);
    			}
    		}else{
    			list.add(current.node.val);
    			stack.pop();
    		}
    	}
    	return list;
    }
    
    public int countNodes(TreeNode root) {
        if(root == null){
        	return 0;
        }
        int leftCount = leftCount(root,0);
        int rightCount = rightCount(root,0);
        
        if(leftCount == rightCount){
        	return (int) (Math.pow(2, leftCount)-1);
        }else{
        	return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

	private int rightCount(TreeNode root, int i) {
		// TODO Auto-generated method stub
		if(root == null){
			return i;
		}
		i += 1;
		return rightCount(root.right,i);
	}

	private int leftCount(TreeNode root, int i) {
		// TODO Auto-generated method stub
		if(root == null){
			return i;
		}
		i += 1;
		return leftCount(root.left,i);
	}		
	
    public List<Integer> rightSideView(TreeNode root) {
    	List<Integer> list = new ArrayList<Integer>();
    	if(root == null){
    		return list;
    	}
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.add(root);
    	while(queue.size() > 0){
    		int size = queue.size();
    		TreeNode rightMostItemInLevel = null;
    		for(int i = 0; i < size; i++){
    			rightMostItemInLevel = queue.poll();
    			if(rightMostItemInLevel.left != null){
    				queue.add(rightMostItemInLevel.left);
    			}
    			if(rightMostItemInLevel.right != null){
    				queue.add(rightMostItemInLevel.right);
    			}		
    		}
    		if(rightMostItemInLevel != null){
    			list.add(rightMostItemInLevel.val);
    		}
    	}
    	return list;
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        List<TreeNode> listP = new ArrayList<TreeNode>();
        getPathFromRoot(root, p, listP);
        Collections.reverse(listP);
        
        List<TreeNode> listQ = new ArrayList<TreeNode>();
        getPathFromRoot(root, q, listQ);
        Collections.reverse(listQ);
        
        int index = 0;
        while(index < Math.min(listP.size(),listQ.size()) && listP.get(index) == listQ.get(index)){
            index++;
        }
        return listP.get(index-1);
    }
    
    private static boolean getPathFromRoot(TreeNode root, TreeNode p, List<TreeNode> listP){
        if(root == null){
            return false;
        }
        if(root.val == p.val){
            listP.add(root);
            return true;
        }else{
            boolean leftB = getPathFromRoot(root.left, p, listP);
            boolean rightB = false;
            if(leftB){
                listP.add(root);
            }else{
                rightB = getPathFromRoot(root.right, p, listP);
                if(rightB){
                    listP.add(root);
                }
            }
            if(leftB || rightB){
                return true;
            }else{
                return false;
            }
        }
        
    }
}

class TreePair{
	TreeNode node;
	int state;
	public TreePair(TreeNode node, int state) {
		super();
		this.node = node;
		this.state = state;
	}
}

class BSTPairs{
	int prev;
	boolean isBST;
}

class BSTPair{
	int min;
	int max;
	boolean isBST;
}