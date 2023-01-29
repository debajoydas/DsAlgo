/**
 * 
 */
package com.debajoy.ds.heap;

import java.util.PriorityQueue;

/**
 * @author Debajoy
 *
 */
public class MergeKSortedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ListNode node1 = new ListNode(1);
		node1.next = new ListNode(4);
		node1.next.next = new ListNode(5);
		node1.next.next.next= new ListNode(8);
		
		ListNode node2 = new ListNode(1);
		node2.next = new ListNode(3);
		node2.next.next = new ListNode(4);
		
		ListNode node3 = new ListNode(2);
		node3.next = new ListNode(6);
		
		ListNode[] nodeArray = new ListNode[3];
		nodeArray[0] = node1;
		nodeArray[1] = node2;
		nodeArray[2] = node3;
		
		ListNode node4 = new ListNode(1);
		
		ListNode[] nodeArray4 = new ListNode[1];
		nodeArray4[0] = node4;
		
		ListNode node = mergeKLists(nodeArray4);
		while(node != null){
			System.out.print(node.val+ "->");
			node =node.next;
		}
		
	}
	
	public static ListNode mergeKLists(ListNode[] lists) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        if(lists == null){
        	return null;
        }else if(lists.length <= 0){
        	return null;
        }else{
        	for(ListNode head : lists){
        		while(head != null){
        			minHeap.add(head.val);
        			head = head.next;
        		}
        	}
        	ListNode head = null;
        	ListNode curr = null;
        	while(minHeap.size() > 0){
        		ListNode node = new ListNode(minHeap.poll());
        		if(head == null){
        			head = node;
        			curr = head;
        		}else{
        			curr.next = node;
        			curr = curr.next;
        		} 		  		
        	}
        	return head;
        }    
    }
	
	   static class ListNode {
		    int val;
		    ListNode next;
		    ListNode() {}
		    ListNode(int val) { this.val = val; }
		    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
		  }
}
