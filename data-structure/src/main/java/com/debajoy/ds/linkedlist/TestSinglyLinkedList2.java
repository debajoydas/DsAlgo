/**
 * 
 */
package com.debajoy.ds.linkedlist;

import com.debajoy.ds.linkedlist.SinglyLinkedList2.Node;

/**
 * @author Debajoy
 *
 */
public class TestSinglyLinkedList2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SinglyLinkedList2 linkedList = new SinglyLinkedList2();
		linkedList.head = new Node(9);
		linkedList.push(2);
		linkedList.display();
		linkedList.push(5);
		linkedList.display();
		linkedList.append(13);
		linkedList.append(1);
		linkedList.insertAfter(linkedList.head.next.next, 10);
		linkedList.display();
		linkedList.deleteAtPosition(2);
		linkedList.display();
		linkedList.deleteNode(10);
		linkedList.display();
		linkedList.deleteAtPosition(0);
		linkedList.display();
		System.out.println("Length of Linked List is : "+linkedList.getCount());
		linkedList.searchKey(1);
		linkedList.getNode(3);
		
		linkedList.head = linkedList.reverseLinkedListRec(linkedList.head);
		linkedList.display();
		
	}

}
