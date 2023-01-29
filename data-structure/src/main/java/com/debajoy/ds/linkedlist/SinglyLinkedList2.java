/**
 * 
 */
package com.debajoy.ds.linkedlist;

import java.util.Stack;

import com.debajoy.ds.linkedlist.SinglyLinkedList.Node;

/**
 * @author Debajoy
 *
 */
public class SinglyLinkedList2 {


	protected static Node head;
	
	static class Node {
		int data;
		Node next;
		/**
		 * @param data
		 */
		public Node(int data) {
			super();
			this.data = data;
		}
		
	}

	public void display() {
		// TODO Auto-generated method stub
		if(head == null){
			System.out.println("LinkedList is Empty");
		}
		Node pointer = head;
		while(pointer != null){
			System.out.print(pointer.data+" -> ");
			pointer = pointer.next;
		}
		System.out.println();
	}
	
	public void deleteAtPosition(int position){
		if(head == null){
			System.out.println("Linked list is empty");
		}
		Node temp = head;
		Node prev = null;
		int pointer = 0;
		if(position == 0){
			head = head.next;
		}else{
			while(temp != null){
				if(pointer == position){
					prev.next = temp.next;
					break;
				}
				prev = temp;
				temp = temp.next;
				pointer++;
			}
		}

	}
	
	public void deleteNode(int key){
		
		if(head == null){
			System.out.println("Linked List is empty");
			return;
		}
		Node temp = head;
		Node prev = null;
		while(temp != null){
			if(temp.data == key){
				prev.next = temp.next;
			}
			prev = temp;
			temp = temp.next;
		}
	}
	
	public void deleteList(){
		head = null;
	}

	public static void push(int data){
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}
	
	public static void insertAfter(Node prevNode, int data){
		Node newNode = new Node(data);
		if(head == null){
			System.out.println("Linked List is empty");
		}	
		newNode.next = prevNode.next;
		prevNode.next = newNode;
	}
	
	public static void append(int data){
		Node newNode = new Node(data);
		if(head == null){
			head = newNode;
		}
		Node lastNode = head;
		while(lastNode.next != null){
			lastNode = lastNode.next;
		}
		lastNode.next = newNode;
	}
	
	public static int getCount(){
		return getCountRec(head);
	}

	private static int getCountRec(Node head2) {
		// TODO Auto-generated method stub
		if(head2 == null){
			return 0;
		}
		return 1 + getCountRec(head2.next);
	}
	
	public static boolean searchKey(int key){
		return searchRecKey(head, key);
	}

	private static boolean searchRecKey(Node head2, int key) {
		// TODO Auto-generated method stub
		if(head2 == null){
			System.out.println("key does not found in Linked List...");
			return false;
		}
		if(head2.data == key){
			System.out.println("key is found in the linked list...");
			return true;
		}else{
			searchRecKey(head2.next, key);
		}
		return false;
	}
	
	public static void reverseLinkedList(){
		if(head == null){
			System.out.println("Linked List is empty");
		}
		Node current = head;
		Node prev = null;
		Node next = null;
		while(current != null)
		{
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
	}
	
	public static boolean isLoopExist(Node head2){
		Node temp = head2;
		Node slowPointer = temp;
		Node fastPointer = temp;
		while(temp != null){
			if(slowPointer == null){
				System.out.println("Loop doen't exist...");
				return false;
			}
			slowPointer = slowPointer.next;
			if(fastPointer == null || fastPointer.next == null){
				System.out.println("Loop doen't exist...");
				return false;
			}
			fastPointer = fastPointer.next.next;
			if(slowPointer == fastPointer){
				System.out.println("Loop found in LinkedList...");
				return true;
			}
			temp= temp.next;
		}
		return false;
	}
	
	
	public static boolean isLoopExistAlternative(Node head){

		System.out.println();
		Node slow = head;
		Node fast = head;
		boolean ifLoopExist = false;
		int count = 1;
		while(slow != null && fast != null){
			if(slow.data == fast.data && count > 1){
				ifLoopExist = true;
				break;
			}
			slow = slow.next;
			if(fast.next != null){
				fast = fast.next.next;
			}else{
				break;
			}
			count++;
		}
		return ifLoopExist;
	
	}
	
	public static int getLengthOfLoop(){
		Node temp = head;
		Node slowPointer = temp;
		Node fastPointer = temp;
		int countOfLoop = 0;
		Node pointerFound = null;
		while(temp != null){
			if(slowPointer == null){
				System.out.println("Loop doen't exist...");
			}
			slowPointer = slowPointer.next;
			if(fastPointer == null || fastPointer.next == null){
				System.out.println("Loop doen't exist...");
			}
			fastPointer = fastPointer.next.next;
			if(slowPointer == fastPointer){
				System.out.println("Loop found in LinkedList...");
				pointerFound = slowPointer;
				break;
			}
			temp= temp.next;
		}
		while(slowPointer != null){
			slowPointer = slowPointer.next;
			countOfLoop++;
			if(slowPointer == pointerFound){
				System.out.println("Count of Loop is :" +countOfLoop);
				break;
			}
		}
		return countOfLoop;
	}
	
	public static int getLengthOfLoopAlternative(){
		System.out.println();
		Node slow = head;
		Node fast = head;
		boolean ifLoopExist = false;
		int count = 1;
		while(slow != null && fast != null){
			if(slow.data == fast.data && count > 1){
				ifLoopExist = true;
				break;
			}
			slow = slow.next;
			if(fast.next != null){
				fast = fast.next.next;
			}else{
				break;
			}
			count++;
		}
		int length = 0;
		if(ifLoopExist){
			Node pointerMeet = slow;
			while(pointerMeet != slow || length == 0){
				pointerMeet = pointerMeet.next;
				length++;
			}
			System.out.println("Count of Loop is :" +length);
		}
		return length;
	}
	
	public static Node getNode(int position){
		Node node = getnThNode(head, position);
		return node;
	}

	private static Node getnThNode(Node head2, int position) {
		// TODO Auto-generated method stub
		if(head2 == null){	
			System.out.println("Linked List is empty...");
			return null;
		}
		if(position == 1){
			System.out.println("N'th Node is . :" +head2.data);
			return head2;
		}
		Node node = getnThNode(head2.next, (position - 1));
		return null;
		
	}
	
	public void longestPalindromic() {
		Node tempOuter = head;
		Node tempInner = head;
		Stack<Integer> stackCompare = new Stack<Integer>();
		int counter = 0; int midElementCounter = 0;
		while(tempOuter != null){
			tempInner = head;
			counter++;
			if(counter % 2 == 0){
				midElementCounter = counter/2; 
			}else{
				midElementCounter = (counter + 1)/2;
			}
			int count = 0;
			while(tempInner != tempOuter && count < midElementCounter){
				stackCompare.push(tempInner.data);
				tempInner = tempInner.next;
				count++;
			}
			while(tempInner != tempOuter && count > midElementCounter){
				tempInner = tempInner.next;
				count++;
			}
			tempOuter= tempOuter.next;
		}
	}
	
	public static Node reverseLinkedListRec(Node head){
		
		if(head == null){
			return head;
		}
		if(head.next == null){
			return head;
		}
		Node remaining = reverseLinkedListRec(head.next);
		head.next.next = head;
		head.next = null;
		
		return remaining;
	}
	
}
