/**
 * 
 */
package com.debajoy.ds.tree.practice;

import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Debajoy
 *
 */
public class PepCoding3 {

	/**
	 * @param args
	 */
	static BinaryNode root;
	public static void main(String[] args) {
		
		Integer[] arr = {50,25,12,null,null,37,30,null,null,null,75,62,null,70,null,null,87,null,null};
	//	Integer[] arr = {8,3,1,null,null,6,4,null,null,7,null,null,10,null,14,13,null,null,null};
		Stack<NodeStatus> stack = new Stack<NodeStatus>();
		int idx = 0;
		if(arr != null && arr.length > 0){
			BinaryNode node = new BinaryNode(arr[0]);
			NodeStatus nodeStatus = new NodeStatus(node, 1);
			root = node;
			stack.push(nodeStatus);
			
			while(stack.size() > 0){
				NodeStatus peek = stack.peek();
				if(peek.status == 1){
					idx++;
					if(arr[idx] != null){
						peek.status++;
						peek.node.left = new BinaryNode(arr[idx]);
						stack.push(new NodeStatus(peek.node.left, 1));
					}else{
						peek.status++;
					}
				}else if(peek.status == 2){
					idx++;
					if(arr[idx] != null){
						peek.status++;
						peek.node.right = new BinaryNode(arr[idx]);
						stack.push(new NodeStatus(peek.node.right, 1));
					}else{
						peek.status++;
					}
				
				}else{
					stack.pop();
				}
			}
		}
		System.out.println("Minimum Camera required :-> "+minCameraRequired(root));
		System.out.println("Maximum Robbery :-> "+maxRobbery(root));
	}
	
	// We only set camera when somenode needs it and convey it to Parent
	//1.if you need a camera -> -1 / 1
	//2. if you have a camera -> 0 / 0
	// 3. if you are covered -> 1  / 2
	public static int minCameraRequired(BinaryNode node){
		AtomicInteger minCamera = new AtomicInteger();
		return minCameraRequired(node, minCamera, true);
	}
	private static int minCameraRequired(BinaryNode node,AtomicInteger minCamera, boolean isRoot){
		if(node == null){
			return 1;
		}
		int condL = minCameraRequired(node.left, minCamera,false);
		int condR = minCameraRequired(node.right, minCamera,false);
		if(!isRoot){
			if(condL == 1 && condR == 1){
				return -1;
			}else if(condL == -1 || condR == -1){
				minCamera.incrementAndGet();
				return 0;
			}else if(condL == 0 || condR == 0){
				return 1;
			}
		}else{
			if(condL == 1 && condR == 1){
				 minCamera.incrementAndGet();
			}else if(condL == -1 || condR == -1){
				minCamera.incrementAndGet();
			}else if(condL == 0 || condR == 0){
				minCamera.get();
			}
		}
		return minCamera.get();
	}
	
	public static int maxRobbery(BinaryNode node){
		return Math.max(maxRobberyRec(node).p, maxRobberyRec(node).q) ;
	}

	private static Robbery maxRobberyRec(BinaryNode node) {
		// TODO Auto-generated method stub
		if(node == null){
			return new Robbery(0, 0);
		}
		Robbery left = maxRobberyRec(node.left);
		Robbery right = maxRobberyRec(node.right);
		int robPlus = node.data+left.q+right.q;
		int robMiinus = Math.max(left.p, left.q) + Math.max(right.p, right.q);
		Robbery rob = new Robbery(robPlus, robMiinus);
		return rob;
	}
	
	public static int longestZigZagPath(BinaryNode node){
		return 0;
	}

}

class Robbery{
	public Robbery(int p, int q) {
		super();
		this.p = p;
		this.q = q;
	}
	int p;
	int q;
}
