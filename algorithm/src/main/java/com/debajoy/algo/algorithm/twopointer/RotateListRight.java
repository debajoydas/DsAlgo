package com.debajoy.algo.algorithm.twopointer;

/**
 * @author Debajoy
 *
 */
public class RotateListRight {

	/**
	 * @param args
	 */
	public static void main(String[] args) {}
	
	public static ListNode rotateRight(ListNode head, int k) {
		
		if(head == null){
			return null;
		}
		ListNode headPointer = head;

		ListNode temp = head;
		int n = 0;
		while(temp != null){
			temp = temp.next;
			n++;
		}
		if(k > n){
			 k = k%n;
		}
		if(k == n || k == 0){
			return head;
		}
		int r = n-k;
		while(r > 1){
			headPointer = headPointer.next;
			r--;
		}
		ListNode headOut = headPointer.next;
		headPointer.next = null;
		ListNode temp1 = headOut;
		while(temp1.next != null){
			temp1 = temp1.next;
		}
		temp1.next = head;

		return headOut;
        
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
    	this.val = val; this.next = next;
    }
}