/**
 * 
 */
package com.debajoy.algo.algorithm.math;

import java.util.Stack;

/**
 * @author Debajoy
 *
 */
public class AddTwoNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(9);
		
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(9);
		l2.next.next = new ListNode(9);
		l2.next.next.next = new ListNode(9);
		l2.next.next.next.next = new ListNode(9);
		l2.next.next.next.next.next = new ListNode(9);
		l2.next.next.next.next.next.next = new ListNode(9);
		l2.next.next.next.next.next.next.next = new ListNode(9);
		l2.next.next.next.next.next.next.next.next = new ListNode(9);
		l2.next.next.next.next.next.next.next.next.next = new ListNode(9);
		addTwoNumbers(l1, l2);
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		Stack<String> stack1 = new Stack<String>();
		Stack<String> stack2 = new Stack<String>();
		StringBuffer s1 = new StringBuffer("");
		StringBuffer s2 = new StringBuffer("");
		String output;
		while(l1 != null){
			stack1.push(String.valueOf(l1.val));
			l1 = l1.next;
		}
		while(l2 != null){
			stack2.push(String.valueOf(l2.val));
			l2 = l2.next;
		}
		while(stack1.size() > 0){
			s1.append(stack1.pop());
		}
		while(stack2.size() > 0){
			s2.append(stack2.pop());
		}
		output = String.valueOf(Long.valueOf(Long.valueOf(s1.toString())) + Long.valueOf(Long.valueOf(s2.toString())));
		StringBuffer outputBuf = new StringBuffer(output);
		outputBuf = outputBuf.reverse();
		output = outputBuf.toString();
		if(output == null || (output != null && output.length() < 1)){
			return null;
		}
		ListNode head = new ListNode(Integer.valueOf(output.substring(0,1)));
		ListNode curr = head;
		ListNode prev = null;
		for(int i = 1; i< output.length(); i++){
			prev = curr;
			curr = new ListNode(Integer.valueOf(output.substring(i,i+1)));
			prev.next = curr;
		}
		return head;
	}

}

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { 
    	 this.val = val; 
     }
     ListNode(int val, ListNode next) { 
    	 this.val = val; 
    	 this.next = next; 
     }
}