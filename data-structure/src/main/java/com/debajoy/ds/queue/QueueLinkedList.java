/**
 * 
 */
package com.debajoy.ds.queue;

/**
 * @author Debajoy
 *
 */
public class QueueLinkedList {

	private QueueNode front;
	private QueueNode rear;
	int queueSize;
	
	public QueueLinkedList() {
		this.front = null;
		this.rear = null;
		queueSize = 0;
	}
	
	static class QueueNode{
		int data;
		QueueNode next;		
		public QueueNode(int data) {
			this.data  = data;
			this.next = null;
		}
	}
	
	public boolean isEmpty(){
		if(queueSize <= 0){
			System.out.println("Queue is empty...");
			return true;
		}
		return false;
	}
	
	public void enQueue(int data){
		QueueNode temp = rear;
		if(!isEmpty()){
				QueueNode newNode = new QueueNode(data);				
				rear.next = newNode;
				rear = rear.next;
		}else{
			QueueNode newNode = new QueueNode(data);
			rear = newNode;
			front = newNode;
		}
		queueSize += 1;
	}
	
	public void deQueue(){
		if(!isEmpty()){
			front = front.next;
			queueSize -= 1;
		}
		if(queueSize == 1){
			rear = front;
		}else if(queueSize <= 0){
			rear = front = null;
		}
	}

	public void display(){
		QueueNode tempFront = front;
		QueueNode tempRear = rear;
		if(!isEmpty()){
			while(tempFront != tempRear){
				System.out.print(tempFront.data + " -> ");
				tempFront = tempFront.next;
			}
			System.out.print(tempFront.data + " ->");
			System.out.println();
		}
	}
	
	public Integer getFront(){
		if(!isEmpty()){
			System.out.println("Front is : "+front.data);
			return front.data;
		}else{
			return null;
		}
	}
	
	public Integer getRear(){
		if(!isEmpty()){
			System.out.println("Rear is : "+rear.data);
			return rear.data;
		}else{
			return null;
		}
	}
}
