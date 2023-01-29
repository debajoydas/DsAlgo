/**
 * 
 */
package com.debajoy.ds.stack;

/**
 * @author Debajoy
 *
 */
public class StackLinkedList {

	static StackNode head;
	static StackNode minNode;
	
	static class StackNode{
		/**
		 * @param data
		 */
		public StackNode(int data) {
			super();
			this.data = data;
		}
		int data;
		StackNode next;
	}
	
	public static void push(int data){
		if(!isEmpty()){
			StackNode newNode = new StackNode(data);
			if(minNode != null){
				if(minNode.data > data){
					minNode = newNode;
				}
			}
			StackNode temp = head;
			head = newNode;
			newNode.next = temp;
			System.out.println("Push into Stack successfully...");
		}
	}
	
	public static Integer pop(){
		if(!isEmpty()){
			StackNode deleteNode = head;
			System.out.println("Pop Stack successfully... -> " + head.data);
			head = head.next;
			return head.data;
		}
		return null;
	}
	
	public static Integer peek(){
		if(!isEmpty()){
			return head.data;
		}
		return null;
	}
	
	public static boolean isEmpty(){
		if(head == null){
			System.out.println("Stack is empty...");
			return true;
		}
		return false;
	}
	
	public static void display(){
		StackNode temp = head;
		while(temp != null){
			System.out.print(temp.data+" -> ");
			temp = temp.next;
		}
		System.out.println();
	}
}
