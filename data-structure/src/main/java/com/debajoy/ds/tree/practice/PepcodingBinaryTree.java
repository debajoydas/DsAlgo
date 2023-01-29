/**
 * 
 */
package com.debajoy.ds.tree.practice;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Debajoy
 *
 */
public class PepcodingBinaryTree {

	/**
	 * @param args
	 */
	public static final String DASH= "->";
	static BinaryNode1 root;
	static BinaryNode1 root1;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String SEPERATOR ="**************************************************************************************";
		Integer[] arr = {50,25,12,null,null,37,30,null,null,null,75,62,null,70,null,null,87,null,null};
		System.out.println(SEPERATOR);
		root = constructBinaryTree(arr);
		System.out.println("Level Order Traversal in Binary Tree :-");
		levelOrderTraversal(root);
		System.out.println(SEPERATOR);
		System.out.println("Size of Binary Tree : "+getSize(root));
		System.out.println(SEPERATOR);
		System.out.println("Maximum in Binary Tree : "+maxInTree(root));
		System.out.println(SEPERATOR);
		System.out.println("Height of Binary Tree : "+getHeight(root));
		System.out.println(SEPERATOR);
		System.out.println("Sum of Binary Tree : "+getSum(root));
		System.out.println(SEPERATOR);
		levelWiseZigZagTraversal(root);
		System.out.println(SEPERATOR);
		
		leftViewOfBinaryTree(root);
		System.out.println(SEPERATOR);
		rightViewOfBinaryTree(root);
		System.out.println(SEPERATOR);

		iterativePrePostInOrder(root);
		System.out.println(SEPERATOR);
		int data= 30;
		rootToNodePath(root, data);
		System.out.println(SEPERATOR);
		nodeToRootPath(root, data);
		System.out.println(SEPERATOR);
		
		int kFromRoot = 2;
		System.out.println("Print "+kFromRoot+"-level down from Root (left to right) := ");
		printKLevelDownFromRoot(root, kFromRoot);
		System.out.println();
		
		int kFarAway = 2;
		int data2 = 37;
		printNodesKLevelFar(root, data2, kFarAway);
		System.out.println(SEPERATOR);
		
		System.out.println(SEPERATOR);
		printtDiameterOfTree(root);
		System.out.println(SEPERATOR);
		tiltOfBinaryTree(root);
		System.out.println(SEPERATOR);
		isBinarySearchTree(root);
		System.out.println(SEPERATOR);
		isBalancedTree(root);
		largestBSTinBinaryTree(root);
		System.out.println(SEPERATOR);
		
		root1 = new BinaryNode1(4);
		root1.left = new BinaryNode1(3);
		root1.left.left = new BinaryNode1(1);
		root1.left.right = new BinaryNode1(2);
		maxSumBST(root1);
		System.out.println(SEPERATOR);
		
		printBinaryTreeInVerticalOrder(root);
		System.out.println(SEPERATOR);
		verticalLengthOfBinaryTree(root);
		System.out.println(SEPERATOR);
		
		topViewOfBinaryTree(root);
		System.out.println(SEPERATOR);
		bottomViewOfBinaryTree(root);
		System.out.println(SEPERATOR);
	}

	public static void topViewOfBinaryTree(BinaryNode1 node){
		System.out.println("Top View Of a Binary Tree :=> ");
		TreeMap<Integer,ArrayList<Integer>> levelMap = new TreeMap<Integer,ArrayList<Integer>>();	
		ArrayDeque<VerticalPair> queue = new ArrayDeque<VerticalPair>();
		VerticalPair pair = new VerticalPair(0,node);
		queue.push(pair);
		while(queue.size() > 0){
			int size = queue.size();
			for(int i = 0; i < size; i++){
				VerticalPair popped = queue.poll();
				if(popped != null && popped.node != null){
					if(levelMap.get(popped.state) == null){
						ArrayList<Integer> list = new ArrayList<>();
						list.add(popped.node.data);
						levelMap.put(popped.state, list);
					}else{
						levelMap.get(popped.state).add(popped.node.data);
					}
					if(popped.node.left != null){
						queue.push(new VerticalPair(popped.state-1,popped.node.left));
					}
					if(popped.node.right != null){
						queue.push(new VerticalPair(popped.state+1,popped.node.right));
					}
				}
			}
		}
		levelMap.entrySet().stream().map(entry -> entry.getValue()).forEach(v -> System.out.println(v.get(0)+"->"));
	}
	public static void bottomViewOfBinaryTree(BinaryNode1 node){
		System.out.println("Bottom View Of a Binary Tree :=> ");
		TreeMap<Integer,ArrayList<Integer>> levelMap = new TreeMap<Integer,ArrayList<Integer>>();	
		ArrayDeque<VerticalPair> queue = new ArrayDeque<VerticalPair>();
		VerticalPair pair = new VerticalPair(0,node);
		queue.push(pair);
		while(queue.size() > 0){
			int size = queue.size();
			for(int i = 0; i < size; i++){
				VerticalPair popped = queue.poll();
				if(popped != null && popped.node != null){
					if(levelMap.get(popped.state) == null){
						ArrayList<Integer> list = new ArrayList<>();
						list.add(popped.node.data);
						levelMap.put(popped.state, list);
					}else{
						levelMap.get(popped.state).add(popped.node.data);
					}
					if(popped.node.left != null){
						queue.push(new VerticalPair(popped.state-1,popped.node.left));
					}
					if(popped.node.right != null){
						queue.push(new VerticalPair(popped.state+1,popped.node.right));
					}
				}
			}
		}
		levelMap.entrySet().stream().map(entry -> entry.getValue()).forEach(v -> System.out.println(v.get(v.size()-1)+"->"));
	}

	private static void verticalLengthOfBinaryTree(BinaryNode1 root) {
		HashMap<Integer,ArrayList<Integer>> levelMap = new HashMap<Integer,ArrayList<Integer>>();
		int state = 0;
		printBinaryTreeInVerticalOrderRec(root, state, levelMap);
		System.out.println("Vertical Width Of a Binary Tree :=> "+levelMap.size());
	}

	public static void printBinaryTreeInVerticalOrder(BinaryNode1 node){
		System.out.println("Vertical Order Traversal Of a Binary Tree :=> ");
		HashMap<Integer,ArrayList<Integer>> levelMap = new HashMap<Integer,ArrayList<Integer>>();
		int state = 0;
		printBinaryTreeInVerticalOrderRec(node, state, levelMap);
		levelMap.entrySet().stream().map(entry -> entry.getValue()).forEach(v -> System.out.println(v+"->"));;
	}

	private static void printBinaryTreeInVerticalOrderRec(BinaryNode1 node, int state, HashMap<Integer, ArrayList<Integer>> levelMap) {
		// TODO Auto-generated method stub
		if(node == null){
			return;
		}
		printBinaryTreeInVerticalOrderRec(node.left, state-1, levelMap);
		printBinaryTreeInVerticalOrderRec(node.right, state+1, levelMap);
		if(levelMap.get(state) == null){
			ArrayList<Integer> list = new ArrayList<>();
			list.add(node.data);
			levelMap.put(state, list);
		}else{
			levelMap.get(state).add(node.data);
		}
	}

	public static void largestBSTinBinaryTree(BinaryNode1 node){
		AtomicInteger size = new AtomicInteger(0);
		AtomicReference<BinaryNode1> maxNode = new AtomicReference<>(node);
		largestBSTinBinaryTreeRec(node,maxNode,size);
		System.out.println("Largest BST Node with Size in a Binary Tree is :=> "+maxNode.get().data+"(Node) @"+size+"(Size)");
		System.out.println();
	}

	private static BSTPair1 largestBSTinBinaryTreeRec(BinaryNode1 node, AtomicReference<BinaryNode1> maxNode, AtomicInteger size) {
		// TODO Auto-generated method stub
		if(node == null){		
			BSTPair1 pair = new BSTPair1(Integer.MIN_VALUE,Integer.MAX_VALUE,true);
			return pair;
		}
		BSTPair1 left = largestBSTinBinaryTreeRec(node.left, maxNode, size);
		BSTPair1 right = largestBSTinBinaryTreeRec(node.right, maxNode, size);
		int max = Math.max(Math.max(left.max, right.max),node.data);
		int min = Math.max(Math.max(left.min, right.min),node.data);
		boolean isBST =  left.isBST && right.isBST && (node.data > left.max && node.data < right.min);
		int sizeC = left.size+right.size+1;
		BSTPair1 current = new BSTPair1(max,min,isBST,sizeC);
		if(isBST && sizeC > size.get()){
			size.set(sizeC);
			maxNode.set(node);
		}
		return current;
	}
	
	// Maximum Sum BST in Binary Tree
    public static int maxSumBST(BinaryNode1 root) {
        AtomicInteger sumInt = new AtomicInteger(0);
        maxSumBSTRec(root,sumInt);
        System.out.println("Maximum Sum BST in Binary Tree := "+sumInt.get());
        return sumInt.get();
    }

    public static BST maxSumBSTRec(BinaryNode1 root,AtomicInteger sumInt) {
        if(root == null){
            return new BST(Integer.MIN_VALUE,Integer.MAX_VALUE,true,0);
        }
        BST left = maxSumBSTRec(root.left,sumInt);
        BST right = maxSumBSTRec(root.right,sumInt);
        int max = Math.max(left.max,Math.max(root.data,right.max));
        int min = Math.min(left.min,Math.min(root.data,right.min));
        boolean isRootBST = left.isBST && right.isBST && (root.data > left.max && root.data < right.min);
        int sum = left.sum + right.sum + root.data;
        if(isRootBST){
            if(sumInt.get() < sum){
                sumInt.set(sum);
            }
        }
        BST pairRoot = new BST(max,min,isRootBST,sum);
        return pairRoot;
    }

	private static void isBalancedTree(BinaryNode1 root) {
		System.out.println("Is it a Balanced Tree ? :=> "+isBalancedTreeRec(root).isBalancedTree);
		System.out.println();
	}

	private static BalancedTreePair isBalancedTreeRec(BinaryNode1 root) {
		// TODO Auto-generated method stub
		if(root == null){
			return new BalancedTreePair(0, true);
		}
		BalancedTreePair left = isBalancedTreeRec(root.left);
		BalancedTreePair right = isBalancedTreeRec(root.right);
		int height = Math.max(left.height, right.height)+1;
		boolean isBalanceTree = left.isBalancedTree && right.isBalancedTree && (Math.abs(left.height-right.height) <= 1);
		BalancedTreePair newPair = new BalancedTreePair(height, isBalanceTree);
		return newPair;
	}

	private static void isBinarySearchTree(BinaryNode1 root) {
		System.out.println("Is it a Binary Search Tree ? :=> "+isBinarySearchTreeRec(root).isBST);
		System.out.println();
	}

	private static BSTPair1 isBinarySearchTreeRec(BinaryNode1 root) {
		if(root == null){
			return new BSTPair1(Integer.MIN_VALUE,Integer.MAX_VALUE,true);
		}
		BSTPair1 leftPair = isBinarySearchTreeRec(root.left);
		BSTPair1 rightPair = isBinarySearchTreeRec(root.right);
		int max = Math.max(rightPair.max, Math.max(leftPair.max, root.data));
		int min = Math.min(rightPair.min, Math.min(leftPair.min, root.data));
		boolean isAsNodeBST = false;
		if(root.data > leftPair.max && root.data < rightPair.min){
			isAsNodeBST = true;
		}
		BSTPair1 returnPair = new BSTPair1(max,min,isAsNodeBST && leftPair.isBST && rightPair.isBST);
		return returnPair;
	}

	private static void tiltOfBinaryTree(BinaryNode1 root) {
		System.out.println("Tilt of Binary Tree :=> "+tiltOfBinaryTreeRec(root));
		System.out.println();
	}

	private static int tiltOfBinaryTreeRec(BinaryNode1 root) {
		// TODO Auto-generated method stub
		if(root ==  null){
			return 0;
		}
		int left = tiltOfBinaryTreeRec(root.left);
		int right = tiltOfBinaryTreeRec(root.right);
		int tilt = Math.abs(left-right);
		System.out.println("Tilt of "+root.data+" := "+tilt);
		return left+right+root.data;
	}

	private static void printtDiameterOfTree(BinaryNode1 root) {
		System.out.println("Diameter of Binary Tree is : "+getDiameter(root));
		System.out.println();	
	}

	private static int getDiameter(BinaryNode1 root) {
		// TODO Auto-generated method stub
		if(root == null){
			return 0;
		}
		int selfDiameter = 0;
		if(root.left != null && root.right != null){
	        selfDiameter = getHeight(root.left)+getHeight(root.right)+2;
	    }else if(root.left != null && root.right == null){
	        selfDiameter = getHeight(root.left) + 1;
	    }else if(root.left == null && root.right != null){
	        selfDiameter = getHeight(root.right) + 1;
	    }
		return Math.max(selfDiameter, Math.max(getDiameter(root.left), getDiameter(root.right)));
	}

	private static void printNodesKLevelFar(BinaryNode1 root, int data, int kFarAway) {
		// TODO Auto-generated method stub
		System.out.println("Print "+kFarAway+"-level Away from Root (down to up) := ");
		List<BinaryNode1> list = nodeToRootPathUtility(root, data);
		for(int i = 0; i < list.size(); i++){
			BinaryNode1 origNode = (i == 0) ? null : list.get(i-1);
			printKLevelDownFromRootUtility(list.get(i), kFarAway-i, origNode);
		}
		System.out.println();
	}
	
	private static void printKLevelDownFromRootUtility(BinaryNode1 root, int kFromRoot, BinaryNode1 origNode) {
		if(root == null || kFromRoot < 0 || (root == origNode)){
			return;
		}
		if(root != null && kFromRoot == 0){
			System.out.print(root.data+"; ");
			return;
		}
		printKLevelDownFromRootUtility(root.left, kFromRoot-1, origNode);
		printKLevelDownFromRootUtility(root.right, kFromRoot-1, origNode);
	}

	private static void printKLevelDownFromRoot(BinaryNode1 root, int kFromRoot) {
		// TODO Auto-generated method stub
		if(root == null){
			return;
		}
		if(kFromRoot == 0){
			System.out.print(root.data+DASH);
			return;
		}
		printKLevelDownFromRoot(root.left, kFromRoot-1);
		printKLevelDownFromRoot(root.right, kFromRoot-1);
	}

	private static List<BinaryNode1> nodeToRootPathUtility(BinaryNode1 root, int data) {
		// TODO Auto-generated method stub
		List<BinaryNode1> list = new ArrayList<BinaryNode1>();
		nodeToRootPathRecUtility(root,data,list);
		return list;
	}
	
	private static boolean nodeToRootPathRecUtility(BinaryNode1 root, int data, List<BinaryNode1> list) {
		// TODO Auto-generated method stub
		if(root == null){
			return false;
		}
		if(root.data == data){
			list.add(root);
			return true;
		}
		boolean leftCheck = nodeToRootPathRecUtility(root.left, data, list);
		boolean rightCheck = false;
		if(leftCheck){
			list.add(root);
			return true;
		}else{
			rightCheck = nodeToRootPathRecUtility(root.right, data, list);
			if(rightCheck){
				list.add(root);
				return true;
			}
		}
		return leftCheck || rightCheck;
		
	}

	private static List<Integer> nodeToRootPath(BinaryNode1 root, int data) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<Integer>();
		if(nodeToRootPathRec(root,data,list)){
			System.out.println("Node to Root path :=>"+getStringFromList(list));
		}
		return list;
	}
	
	public static String getStringFromList(List<Integer> list){
		StringBuilder sb = new StringBuilder();
		for(int i : list){
			sb.append(i).append(DASH);
		}
		return sb.toString();
	}

	private static boolean nodeToRootPathRec(BinaryNode1 root, int data, List<Integer> list) {
		// TODO Auto-generated method stub
		if(root == null){
			return false;
		}
		if(root.data == data){
			list.add(root.data);
			return true;
		}
		boolean leftCheck = nodeToRootPathRec(root.left, data, list);
		boolean rightCHeck = false;
		if(leftCheck){
			list.add(root.data);
		}else{
			rightCHeck = nodeToRootPathRec(root.right, data, list);
			if(rightCHeck){
				list.add(root.data);
			}
		}
		return leftCheck || rightCHeck;
	}

	private static void rootToNodePath(BinaryNode1 root, int data) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<Integer>();
		if(nodeToRootPathRec(root,data,list)){
			Collections.reverse(list);
			System.out.println("Root to Root path :=>"+getStringFromList(list));
		}	
	}

	private static void iterativePrePostInOrder(BinaryNode1 root) {
		// TODO Auto-generated method stub
		StringBuilder preOrder = new StringBuilder();
		StringBuilder postOrder = new StringBuilder();
		StringBuilder inOrder = new StringBuilder();
		BinaryPair pair = new BinaryPair(root,0);
		Stack<BinaryPair> stack = new Stack<>();
		stack.push(pair);
		while(!stack.isEmpty()){
			BinaryPair peek = stack.peek();
			if(peek.status == 0){
				preOrder.append(peek.node.data).append(DASH);
				peek.status += 1;
				if(peek.node.left != null){
					stack.push(new BinaryPair(peek.node.left,0));
				}
			}else if(peek.status == 1){
				inOrder.append(peek.node.data).append(DASH);
				peek.status += 1;
				if(peek.node.right != null){
					stack.push(new BinaryPair(peek.node.right,0));
				}
			}else{
				postOrder.append(peek.node.data).append(DASH);
				stack.pop();
			}
		}
		System.out.println("Pre-Order traversal := "+preOrder.toString());
		System.out.println("In-Order traversal := "+inOrder.toString());
		System.out.println("Post-Order traversal := "+postOrder.toString());		
		
	}

	private static int getSum(BinaryNode1 root) {
		// TODO Auto-generated method stub
		if(root == null){
			return 0;
		}
		return root.data+getSum(root.left)+getSum(root.right);
	}

	private static void rightViewOfBinaryTree(BinaryNode1 root) {
		ArrayDeque<BinaryNode1> queue = new ArrayDeque<BinaryNode1>();
		queue.add(root);
		while(queue.size() > 0){
			int size = queue.size();
			List<Integer> list = new ArrayList<Integer>();
			for(int i = 0; i < size; i++){
				BinaryNode1 polled  = queue.poll();
				if(polled != null){
					list.add(polled.data);
					if(polled.left != null){
						queue.add(polled.left);
					}
					if(polled.right != null){
						queue.add(polled.right);
					}
				}
			}
			Collections.reverse(list);
			System.out.print(list.size() > 0 ? list.get(0) : "");
			System.out.println();
		}
	}

	private static void leftViewOfBinaryTree(BinaryNode1 root) {
		ArrayDeque<BinaryNode1> queue = new ArrayDeque<BinaryNode1>();
		queue.add(root);
		while(queue.size() > 0){
			int size = queue.size();
			List<Integer> list = new ArrayList<Integer>();
			for(int i = 0; i < size; i++){
				BinaryNode1 polled  = queue.poll();
				if(polled != null){
					list.add(polled.data);
					if(polled.left != null){
						queue.add(polled.left);
					}
					if(polled.right != null){
						queue.add(polled.right);
					}
				}
			}
			System.out.print(list.size() > 0 ? list.get(0) : "");
			System.out.println();
		}
	}

	private static int getHeight(BinaryNode1 root) {
		// TODO Auto-generated method stub
		if(root == null){
			return Integer.MIN_VALUE;
		}
		int height= -1;
		height = Math.max(height, Math.max(getHeight(root.left),getHeight(root.right)));
		return height+1;
	}

	private static int maxInTree(BinaryNode1 root) {
		// TODO Auto-generated method stub
		if(root == null){
			return Integer.MIN_VALUE;
		}
		return Math.max(root.data, Math.max(maxInTree(root.left), maxInTree(root.right)));
	}

	private static int getSize(BinaryNode1 root) {
		// TODO Auto-generated method stub
		if(root == null){
			return 0;
		}
		return 1 +  getSize(root.left) + getSize(root.right);
	}
	
	private static void levelWiseZigZagTraversal(BinaryNode1 root) {
		ArrayDeque<BinaryNode1> queue = new ArrayDeque<BinaryNode1>();
		int level = 0;
		queue.add(root);
		while(queue.size() > 0){
			int size = queue.size();
			List<Integer> displayList = new ArrayList<>();
			for(int i = 0; i < size; i++){
				BinaryNode1 polled  = queue.poll();
				if(polled != null){
					displayList.add(polled.data);
					if(polled.left != null){
						queue.add(polled.left);
					}
					if(polled.right != null){
						queue.add(polled.right);
					}
				}
			}
			if(level%2 == 1){
				Collections.reverse(displayList);	
			}
			for(int data : displayList){
				System.out.print(data+"->");
			}
			level++;
			System.out.println();
		}
	}
	
	private static void levelOrderTraversal(BinaryNode1 root) {
		ArrayDeque<BinaryNode1> queue = new ArrayDeque<BinaryNode1>();
		queue.add(root);
		while(queue.size() > 0){
			int size = queue.size();
			for(int i = 0; i < size; i++){
				BinaryNode1 polled  = queue.poll();
				if(polled != null){
					System.out.print(polled.data+"->");
					if(polled.left != null){
						queue.add(polled.left);
					}
					if(polled.right != null){
						queue.add(polled.right);
					}
				}
			}
			System.out.println();
		}
	}

	private static BinaryNode1 constructBinaryTree(Integer[] arr) {
		// TODO Auto-generated method stub
		Stack<BinaryPair> stack = new Stack<BinaryPair>();
		BinaryNode1 rootNode = new BinaryNode1(arr[0]);
		stack.push(new BinaryPair(rootNode,0));
		root = rootNode;
		int i = 1;
		while(!stack.isEmpty() && i < arr.length){
			BinaryPair peek = stack.peek();
			if(peek.status == 0){
				if(arr[i] != null){
					BinaryNode1 newNode = new BinaryNode1(arr[i]);
					peek.node.left = newNode;
					peek.status += 1;
					stack.push(new BinaryPair(newNode,0));
				}else{
					peek.status += 1;
					peek.node.left = null;
				}
				i++;
			}else if(peek.status == 1){
				if(arr[i] != null){
					BinaryNode1 newNode = new BinaryNode1(arr[i]);
					peek.node.right = newNode;
					peek.status += 1;
					stack.push(new BinaryPair(newNode,0));
				}else{
					peek.status += 1;
					peek.node.right = null;
				}	
				i++;
			}else{
				stack.pop();
			}
		}
		return root;
	}
	
    public int lowestCommonAncestor(BinaryNode1 root, BinaryNode1 p, BinaryNode1 q) {
        if(root == null){
            return -1;
        }
        List<Integer> listP = nodeToRootPath(root, p.data);
        Collections.reverse(listP);
        
        List<Integer> listQ = nodeToRootPath(root, q.data);
        Collections.reverse(listQ);
        
        int index = 0;
        while(index < Math.min(listP.size(),listQ.size()) && listP.get(index) == listQ.get(index)){
            index++;
        }
        return listP.get(index-1);
    }

}
class BST{
    int max;
    int min;
    boolean isBST;
    int sum;
    BST(int max,int min,boolean isBST, int sum){
        this.max = max;
        this.min = min;
        this.isBST = isBST;
        this.sum = sum;
    }
}