/**
 * 
 */
package com.debajoy.ds.linkedlist;

import com.debajoy.ds.linkedlist.SinglyLinkedList2.Node;
import com.debajoy.ds.linkedlist.practice.SingleLinkedList;

/**
 * @author Debajoy
 *
 */
public class TestSinglyLinkedListLoop {

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
		linkedList.head.next.next.next.next.next = linkedList.head.next;
		linkedList.isLoopExistAlternative(linkedList.head);
		linkedList.getLengthOfLoop();
		linkedList.getLengthOfLoopAlternative();
		
	}

}
