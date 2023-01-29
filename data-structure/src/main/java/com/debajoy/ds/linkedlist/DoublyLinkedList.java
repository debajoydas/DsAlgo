/**
 * 
 */
package com.debajoy.ds.linkedlist;

/**
 * @author Debajoy
 *
 */
public class DoublyLinkedList {
	
	protected DoublyNode head;
	
	static class DoublyNode{
		int data;
		DoublyNode next;
		DoublyNode prev;
		/**
		 * @param data
		 */
		public DoublyNode(int data) {
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}
	public boolean iskEmpty(){
		if(head == null){
			System.out.println("Doubly Linked List is empty...");
			return true;
		}
		return false;
	}
	
	public void display(){
		if(!iskEmpty()){
			DoublyNode temp = head;
			while(temp != null){
				System.out.print(temp.data+ " -> ");
				temp = temp.next;
			}
			System.out.println();
		}
	}
	
	public void push(int data){
		if(!iskEmpty()){
			DoublyNode newNode = new DoublyNode(data);
			newNode.next = head;
			newNode.prev = null;
			head.prev = newNode;
			head = newNode;	
		}
	}
	
	public void insertAfter(int data, DoublyNode beforeNode){
		DoublyNode newNode = new  DoublyNode(data);
		if(iskEmpty()){
			head = newNode;
			return;
		}
		if(beforeNode.next != null){
			newNode.next = beforeNode.next;
			beforeNode.next = newNode;
			newNode.prev = beforeNode;			
			newNode.next.prev = newNode;
		}else{
			beforeNode.next = newNode;
			newNode.prev = beforeNode;
		}	
	}
	
	public void insertBefore(int data, DoublyNode afterNode){
		DoublyNode newNode = new  DoublyNode(data);
		if(iskEmpty()){
			head = newNode;
			return;
		}
		if(afterNode.prev != null){
			newNode.next = afterNode;
			newNode.prev = afterNode.prev;
			afterNode.prev.next = newNode;
			afterNode.prev = newNode;					
		}else{
			newNode.next = afterNode;
			afterNode.prev = newNode;
			head = newNode;
		}

	}
	
	public void append(int data){
		DoublyNode newNode = new  DoublyNode(data);
		if(iskEmpty()){
			head = newNode;
			return;
		}
		DoublyNode temp = head;
		while(temp != null){
			if(temp.next == null){
				temp.next = newNode;
				newNode.prev = temp;
				break;
			}
			temp = temp.next;
		}
		
	}
	
	public void deleteNode(DoublyNode del){
		if(iskEmpty()){
			return;
		}
		if(del == head){
			if(head.next != null){
				head = head.next;
				head.prev = null;
			}else{
				head = null;
			}
		}else if(del.next != null){
			del.next.prev = del.prev;
			del.prev.next = del.next;
		}else if(del.next == null){
			del.prev.next = null;
		}
	}
	
	public void reverse(){
		if(!iskEmpty()){
			DoublyNode temp = null;;
			while(head != null){
				temp = head.prev;	
				head.prev = head.next;
				head.next = temp;
				if(head.prev != null){
					head = head.prev;
				}else{
					break;
				}
			}
		}
	}
	
	public DoublyNode copyListWithArbitaryPointer(DoublyLinkedList dList){

		DoublyNode current = dList.head;
		DoublyNode newHead = null;
		DoublyNode tailNode = null;
		
		while(current != null){		
			if(newHead == null){		
				tailNode = new DoublyNode(current.data);
				tailNode.prev = current;
				newHead = tailNode;			
			}else if(tailNode != null){				
				tailNode.next = new DoublyNode(current.data);
				tailNode.next.prev = current;
				tailNode = tailNode.next;
			}
			current = current.next;
		}	
		DoublyNode newNodeTemp = newHead;
		while(newNodeTemp != null){
			newNodeTemp.prev.next = newNodeTemp;
			newNodeTemp.prev = newNodeTemp.prev.prev.next;
			newNodeTemp = newNodeTemp.next;
		}
		
		DoublyNode newNodeTemp1 = newHead;
		while(newNodeTemp1 != null){
			newNodeTemp.prev.next = newNodeTemp;
			newNodeTemp = newNodeTemp.next;
		}
		return newHead;
	}
	
	public DoublyNode revListInGroupOfGivenSize(DoublyNode head, int k) {
		DoublyNode firstNode = head;
		DoublyNode kthNode = null;
		int counter = 0;
		while(firstNode != null && counter < k){
			if(counter == 0){
				
			}else if(counter == k){
				
			}else{
				
			}
		}
		return null;	
	}
	
	
}

