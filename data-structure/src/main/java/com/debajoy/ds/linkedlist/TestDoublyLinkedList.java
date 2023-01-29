/**
 * 
 */
package com.debajoy.ds.linkedlist;

import com.debajoy.ds.linkedlist.DoublyLinkedList.DoublyNode;

/**
 * @author Debajoy
 *
 */
public class TestDoublyLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoublyLinkedList dList = new DoublyLinkedList();
		dList.head = new DoublyNode(5);
		dList.push(6);
		dList.push(7);
		dList.push(4);
		dList.display();
		dList.insertAfter(7, dList.head.next);
		dList.display();
		dList.insertBefore(4, dList.head.next.next.next);
		dList.display();
		dList.append(10);
		dList.display();
		dList.deleteNode(dList.head.next.next);
		dList.deleteNode(dList.head);
		dList.display();
		dList.reverse();
		dList.display();
		System.out.println("head :"+dList.head.data);
		
		DoublyLinkedList dList1 = new DoublyLinkedList();
		dList1.head = new DoublyNode(4);
		dList1.push(4);
		dList1.push(3);
		dList1.push(2);
		dList1.push(1);
		
		DoublyLinkedList copyOfdList = new DoublyLinkedList();
		copyOfdList.head = copyOfdList.copyListWithArbitaryPointer(dList1);
		copyOfdList.display();
	}

}
