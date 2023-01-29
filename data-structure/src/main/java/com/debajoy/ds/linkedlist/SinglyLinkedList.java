/**
 * 
 */
package com.debajoy.ds.linkedlist;

import com.debajoy.ds.linkedlist.SinglyLinkedList2.Node;

/**
 * @author Debajoy
 *
 */
public class SinglyLinkedList {

	protected static Node head;
	
	static class Node {
		int data;
		Node next;
		/**
		 * @param data
		 */
		public Node(int data) {
			super();
			this.data = data;
		}
		
	}
	
	public static Node rotateRight(Node head, int k) {
		
		Node headPointer = head;

		Node temp = head;
		int n = 0;
		while(temp != null){
			temp = temp.next;
			n++;
		}
		if(k > n){
			 k = k%n;
		}
		if(k == n){
			return head;
		}
		int r = n-k;
		while(r > 1){
			headPointer = headPointer.next;
			r--;
		}
		Node headOut = headPointer.next;
		headPointer.next = null;
		Node temp1 = headOut;
		while(temp1.next != null){
			temp1 = temp1.next;
		}
		temp1.next = head;

		return headOut;
        
    }




	public void display() {
		// TODO Auto-generated method stub
		if(head == null){
			System.out.println("LinkedList is Empty");
		}
		Node pointer = head;
		while(pointer != null){
			System.out.print(pointer.data+" -> ");
			pointer = pointer.next;
		}
		System.out.println();
	}
	
	public static void push(int data){
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}
	
	public static void insertAfter(Node prevNode, int data){
		Node newNode = new Node(data);
		if(head == null){
			System.out.println("Linked List is empty");
		}	
		newNode.next = prevNode.next;
		prevNode.next = newNode;
	}
	
	public static void append(int data){
		Node newNode = new Node(data);
		if(head == null){
			head = newNode;
		}
		Node lastNode = head;
		while(lastNode.next != null){
			lastNode = lastNode.next;
		}
		lastNode.next = newNode;
	}

	public void removeLoop() {
		// TODO Auto-generated method stub
		
		final int BIG_NEGTIVE = 100000;
		final int SMALL_NEGTIVE = 50000;
		if(head == null ){
			return;
		}
		Node temp = head;
		Node prev = null;
		while(temp != null){		
			if(temp.data < -SMALL_NEGTIVE){
				prev.next = null;
				break;
			}
			temp.data = -(BIG_NEGTIVE + temp.data);
			prev = temp;
			temp = temp.next;
		}
		Node temp1 = head;
		while(temp1 != null){
			temp1.data = -(temp1.data+BIG_NEGTIVE);
			temp1 = temp1.next;
		}
		
	}
	
	public void rotate(int k) {
		// TODO Auto-generated method stub
		if(head == null){
			return;
		}
		int lengthOfList = getLength();
		if(k< lengthOfList){
			int counter = 1;
			Node rotateStart = head;
			Node rotateEnd = head;
			Node newHead = null;
			while(counter < k){
				rotateEnd = rotateEnd.next;
				counter++;
			}
			newHead = rotateEnd.next;
			rotateEnd.next = null;
			Node iter = newHead;
			while(iter.next != null){
				iter = iter.next;
			}
			iter.next = rotateStart;
			head = newHead;
			
		}else if(k > lengthOfList){
			 k = k%lengthOfList;
			 rotate(k);
		}
	}

	private int getLength() {
		// TODO Auto-generated method stub
		if(head ==  null){
			return 0;
		}
		int count = 0;
		Node temp = head;
		while(temp != null){
			count++;
			temp = temp.next;
		}
		return count;
	}




	public void display(com.debajoy.ds.linkedlist.SinglyLinkedList.Node node) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		if(head == null){
			System.out.println("LinkedList is Empty");
		}
		Node pointer = node;
		while(pointer != null){
			System.out.print(pointer.data+" -> ");
			pointer = pointer.next;
		}
		System.out.println();
	
	}
}
