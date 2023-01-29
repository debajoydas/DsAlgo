/**
 * 
 */
package com.debajoy.ds.queue;

/**
 * @author Debajoy
 *
 */
public class QueueArray {

	static int front;static int rear;static int queueSize;
	static int CAPACITY = 5;
	static int[] arr = new int[CAPACITY];
	
	/**
	 * 
	 */
	public QueueArray() {
		front = -1;
		rear = -1;
		queueSize = 0;
	}
	
	public static void enQueue(int data){
		if(!isFull()){
			if(rear == -1 && front == -1){
				rear = 0; front = 0;
				arr[rear] = data;
				queueSize += 1;
			}else if(rear >= 0){
				if(!isFull()){
					rear = (rear + 1) % CAPACITY;
					arr[rear] = data;
					queueSize += 1;
				}
			}
		}
	}
	
	public static Integer deQueue(){
		Integer dequeued = null;
		if(!isEmpty()){
			if(rear == front){
				queueSize = 0;
				return arr[front];
			}else if(front >= 0){
				dequeued = arr[front];
				front = (front + 1) % CAPACITY;
				queueSize -= 1;
				return dequeued;
			}
		}
		return dequeued;
	}
	
	private static boolean isEmpty() {
		if(queueSize <= 0){
			front = -1;rear = -1;
			System.out.println("Queue is empty...");
			return true;
		}
		// TODO Auto-generated method stub
		return false;
	}

	public static boolean isFull(){
		if(queueSize == CAPACITY){
			System.out.println("Queue is full...");
			return true;
		}else{
			return false;
		}
	}
	
	public static void display(){
		if(!isEmpty()){
			int temp = front;
			while(temp != rear){
				System.out.print(arr[temp] + " -> ");
				temp = (temp+1)%CAPACITY;
			}
			System.out.print(arr[temp] + " -> ");
			System.out.println();
		}
	}
	
    // Method to get front of queue 
    public static Integer front() { 
        if (!isEmpty()) {
        	System.out.println("Front is : "+arr[front]);
        	return arr[front];
        }else{
        	return null;
        }       
    } 
        
    // Method to get rear of queue 
    public static Integer rear() { 
        if (!isEmpty()) {
        	System.out.println("Rear is : "+arr[rear]);
        	return arr[rear];
        }else{
        	return null;
        }  
    } 
}
