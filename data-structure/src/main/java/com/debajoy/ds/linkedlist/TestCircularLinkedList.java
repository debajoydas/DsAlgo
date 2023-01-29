package com.debajoy.ds.linkedlist;

public class TestCircularLinkedList {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		CircularLinkedList cList = new CircularLinkedList();
		cList.inserLast(1);
		cList.inserLast(2);
		cList.inserLast(3);
		cList.inserLast(4);
		cList.inserLast(5);
		cList.display();
		cList.getLast();
		cList.insertBegin(6);
		cList.display();
		cList.getLast();	
		cList.insertAfter(cList.getLastNode().next.next, 7);
		cList.display();
		cList.getLast();
		cList.inserLast(8);
		cList.display();
		cList.getLast();
	}
}
