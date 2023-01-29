/**
 * 
 */
package com.debajoy.ds.linkedlist;

import com.debajoy.ds.linkedlist.SinglyLinkedList.Node;

/**
 * @author Debajoy
 *
 */
public class TestSinglyLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SinglyLinkedList linkedList = new SinglyLinkedList();
		linkedList.head = new Node(1);
		Node first = new Node(2);
		Node second = new Node(3);
		Node third = new Node(4);
		Node fourth = new Node(5);
		linkedList.head.next = first;
		first.next = second;
		second.next = third;
		third.next = fourth;
		Node node = linkedList.rotateRight(linkedList.head, 2);
		linkedList.display(node);
	}
}
