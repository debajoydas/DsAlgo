package com.debajoy.ds.linkedlist;

import com.debajoy.ds.linkedlist.SinglyLinkedList.Node;

public class TestRemoveLoopinList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SinglyLinkedList linkedList = new SinglyLinkedList();
		linkedList.head = new Node(0);
		linkedList.head.next = new Node(1);
		linkedList.head.next.next = new Node(2);
		linkedList.head.next.next.next = new Node(3);
		linkedList.head.next.next.next.next = new Node(4);
		linkedList.head.next.next.next.next.next = new Node(5);
		linkedList.head.next.next.next.next.next.next = new Node(6);
		linkedList.head.next.next.next.next.next.next.next = new Node(7);
		linkedList.head.next.next.next.next.next.next.next.next = new Node(8);
		linkedList.head.next.next.next.next.next.next.next.next.next = linkedList.head.next.next.next;
		
	//	linkedList.display();
		
		linkedList.removeLoop();
		
		linkedList.display();
		
		linkedList.rotate(9);
		
		linkedList.display();	
		
	}

}
