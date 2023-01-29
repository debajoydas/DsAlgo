/**
 * 
 */
package com.debajoy.ds.linkedlist;

/**
 * @author Debajoy
 *
 */
public class CircularLinkedList {
 
	private CircularNode last;
	private int queueSize;
	
	static class CircularNode{
		int data;
		CircularNode next;
		public CircularNode(int data) {
			this.data = data;
			next = null;
		}
	}
	
	public boolean isEmpty(){
		if(queueSize <= 0){
			System.out.println("Queue is empty...");
			return true;
		}
		return false;
	}
	
	public Integer getLast(){
		if(!isEmpty()){
			System.out.println("Last Node : " +last.data);
			return last.data;
		}
		return null;
	}
	
	public CircularNode getLastNode(){
		return last;
	}
	
	public void inserLast(int data){
		CircularNode newNode = new CircularNode(data);
		if(!isEmpty()){	
			newNode.next = last.next;
			last.next = newNode;
			last = newNode;
		}else{
			last = newNode;
			newNode.next = newNode;
		}
		queueSize += 1;
	}
	
	public void insertAfter(CircularNode node, int data){
		CircularNode newNode = new CircularNode(data);
		if(!isEmpty()){
			CircularNode temp = last;
			while(temp != node){
				temp = temp.next;
			}
			newNode.next = temp.next;
			temp.next = newNode;
			queueSize += 1;
		}
	}
	
	public void insertBegin(int data){
		CircularNode newNode = new CircularNode(data);
		if(!isEmpty()){
			newNode.next = last.next;
			last.next = newNode;
		}else{
			last = newNode;
			newNode.next = newNode;
		}
		queueSize += 1;
	}
	
	public void display(){
		if(!isEmpty()){
			CircularNode temp = last;
			temp = temp.next;
			while(temp != last){
				if(temp != null){
					System.out.print(temp.data+" -> ");
					temp = temp.next;					
				}else{
					System.out.print("Node not found...");
					break;
				}					
			}
			System.out.print(last.data+" -> ");
			System.out.println();
		}
	}
}
