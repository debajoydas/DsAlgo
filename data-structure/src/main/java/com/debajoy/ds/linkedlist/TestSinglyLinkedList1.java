/**
 * 
 */
package com.debajoy.ds.linkedlist;

import com.debajoy.ds.linkedlist.SinglyLinkedList.Node;

/**
 * @author Debajoy
 *
 */
public class TestSinglyLinkedList1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SinglyLinkedList linkedList = new SinglyLinkedList();
		linkedList.head = new Node(9);
		linkedList.push(2);
		linkedList.display();
		linkedList.push(5);
		linkedList.display();
		linkedList.append(13);
		linkedList.append(1);
		linkedList.insertAfter(linkedList.head.next.next, 10);
		linkedList.display();
	}

}
