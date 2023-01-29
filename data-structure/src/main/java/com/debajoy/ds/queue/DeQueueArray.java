/**
 * 
 */
package com.debajoy.ds.queue;

/**
 * @author Debajoy
 *
 */
public class DeQueueArray {
	
	static int front; static int rear;static int queueSize;
	static int CAPACITY = 10;
	static int[] arr = new int[CAPACITY];
	/**
	 * 
	 */
	public DeQueueArray() {
		front = -1;
		rear = -1;
		queueSize = 0;
	}

	public static boolean isEmpty(){
		if(queueSize <= 0){
			System.out.println("Queue is empty");
			return true;
		}
		return false;
	}
	
	public static boolean isFull(){
		if(queueSize == CAPACITY){
			System.out.println("Queue is full...");
			return true;
		}
		return false;
	}
	
	public static void insertFront(int data){
		if(!isFull()){
			if(front == -1 && rear == -1){
				front += 1; rear += 1;
				arr[front] = data;
				queueSize += 1;
				System.out.println("insert into the Front is successful... : " +data);
			}else{
				front = (front+CAPACITY-1)%CAPACITY;
				arr[front] = data;
				queueSize += 1;
				System.out.println("insert into the Front is successful... : " +data);
			}
		}
	}
	
	public static void insertRear(int data){
		if(!isFull()){
			if(front == -1 && rear == -1){
				front += 1; rear += 1;
				arr[front] = data;
				queueSize += 1;
				System.out.println("insert into the Rear is successful... : " +data);
			}else{
				rear = (rear+1)%CAPACITY;
				arr[rear] = data;
				queueSize += 1;
				System.out.println("insert into the Rear is successful... : " +data);
			}
		}
	}
	
	public static void deleteFront(){
		Integer deletedItem = null;
		if(!isEmpty()){
			if(front == rear){
				deletedItem = arr[front];
				front = -1;
				rear = -1;
				queueSize -= 1;
				System.out.println("Delete from Front successful :" +deletedItem);
			}else{
				deletedItem = arr[front];
				front = (front+1)%CAPACITY;
				queueSize -= 1;
				System.out.println("Delete from Front successful :" +deletedItem);				
			}
		}
	}
	
	public static void deleteRear(){
		Integer deletedItem = null;
		if(!isEmpty()){
			if(front == rear){
				deletedItem = arr[rear];
				front = -1;
				rear = -1;
				queueSize -= 1;
				System.out.println("Delete from Front successful :" +deletedItem);
			}else{
				deletedItem = arr[rear];
				rear = (rear+CAPACITY-1)%CAPACITY;
				queueSize -= 1;
				System.out.println("Delete from Front successful :" +deletedItem);				
			}
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
