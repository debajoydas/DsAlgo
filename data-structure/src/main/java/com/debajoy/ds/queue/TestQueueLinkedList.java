/**
 * 
 */
package com.debajoy.ds.queue;

import com.debajoy.ds.queue.QueueLinkedList.QueueNode;

/**
 * @author Debajoy
 *
 */
public class TestQueueLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		QueueLinkedList qList = new QueueLinkedList();
		qList.enQueue(4);
		qList.enQueue(5);
		qList.enQueue(6);
		qList.enQueue(7);
		qList.display();
		qList.deQueue();
		qList.display();
		qList.getFront();
		qList.getRear();
		
	}

}
