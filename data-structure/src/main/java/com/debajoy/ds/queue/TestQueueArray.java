/**
 * 
 */
package com.debajoy.ds.queue;

/**
 * @author Debajoy
 *
 */
public class TestQueueArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		QueueArray qArray = new QueueArray();
		qArray.enQueue(4);
		qArray.enQueue(1);
		qArray.enQueue(5);
		qArray.enQueue(7);
		qArray.enQueue(8);
		qArray.enQueue(9);
		qArray.front();
		qArray.rear();
		qArray.display();
		qArray.deQueue();
		qArray.deQueue();
		qArray.deQueue();
		qArray.display();
		qArray.front();
		qArray.rear();
		
	}

}
