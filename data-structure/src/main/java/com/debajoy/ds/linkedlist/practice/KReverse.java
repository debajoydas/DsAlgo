package com.debajoy.ds.linkedlist.practice;

public class KReverse {
	
	public static void main (String[] args){
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		swapPairs(head);
		displayLinkedList(head);
	}
	
	public static void displayLinkedList(ListNode node) {
		System.out.println();
		ListNode temp = node;
		while(temp != null) {
			System.out.print(temp.val+"->");
			temp = temp.next;
		}
		System.out.println();
	}
	
    public static  ListNode swapPairs(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        int k = 2;
        if(ifReversePossible(curr,k)){
        	while(k > 0 && curr != null){
        		next = curr.next;
        		curr.next = prev;
        		prev = curr;
        		curr = next;
        		k--;
        	}
        	ListNode tail = getTail(prev,2);
        	tail.next = swapPairs(curr);
        	return prev;
        }else{
            return curr;
        }       
    }
    public static boolean ifReversePossible(ListNode node , int k){
        boolean isPossible = true;
        ListNode temp = node;
        if(temp == null){
        	return false;
        }
        while(k > 1 && temp != null){
            temp = temp.next;
            k--;
            if(temp == null){
                return false;
            }
        }
        return isPossible;
    }
    public static ListNode getTail(ListNode head, int k){
        ListNode temp = head;
        while(k > 1 && temp != null){
            temp = temp.next;
            k--;
        }
        return temp;
    }
}