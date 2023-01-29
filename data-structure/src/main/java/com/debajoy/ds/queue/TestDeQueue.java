/**
 * 
 */
package com.debajoy.ds.queue;

/**
 * @author Debajoy
 *
 */
public class TestDeQueue {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DeQueueArray deque = new DeQueueArray();
		deque.insertFront(3);
		deque.insertFront(5);
		deque.insertRear(2);
		deque.insertRear(7);
		deque.display();
		deque.insertFront(5);
		deque.display();
		deque.deleteFront();
		deque.display();
		deque.deleteRear();
		deque.display();
		deque.front();
		deque.rear();
		}

}
