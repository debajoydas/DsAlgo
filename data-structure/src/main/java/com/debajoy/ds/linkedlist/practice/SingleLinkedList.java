/**
 * 
 */
package com.debajoy.ds.linkedlist.practice;

/**
 * @author Debajoy
 *
 */
public class SingleLinkedList {

	static LinkedNode head;
	
	public static void traversal(){
		System.out.println();
		LinkedNode temp = head;
		while(temp != null){
			System.out.print(temp.data+ " -> ");
			temp = temp.next;
		}
	}
	
	public static void traversal(LinkedNode head){
		System.out.println();
		LinkedNode temp = head;
		while(temp != null){
			System.out.print(temp.data+ " -> ");
			temp = temp.next;
		}
	}
	
	public static void pushHead(int data){
		LinkedNode newNode = new LinkedNode(data);
		if(head != null){
			newNode.next = head;
		}	
		head = newNode;
	}
	
	public static void deleteHead(){
		if(head != null){
			head = head.next;
		}
	}
	
	public static void pushTail(int data){
		LinkedNode newNode = new LinkedNode(data);
		if(head == null){
			head = newNode;
		}else{
			LinkedNode temp = head;
			while(temp.next != null){
				temp =  temp.next;
			}
			temp.next = newNode;
		}
	}
	
	public static void deleteTail(){
		if(head != null){
			LinkedNode temp = head;
			LinkedNode prev = null;
			while(temp.next != null){
				prev = temp;
				temp =  temp.next;
			}
			if(prev != null){
				prev.next = null;
			}else{
				head = null;
			}
		}
	}
	
	public static void pushAfter(int node,int data){
		LinkedNode newNode = new LinkedNode(data);
		LinkedNode temp = head;
		boolean isPossible = false;
		if(head != null){
			while(temp != null && !isPossible){
				if(temp.data == node){
					isPossible = true;
				}
				if(!isPossible){
					temp =  temp.next;	
				}
			}
			newNode.next = temp.next;
			temp.next = newNode;	
		}
	}
	
	public static void deleteNode(int node){
		if(head != null){
			LinkedNode temp = head;
			LinkedNode prev = null;
			boolean isPossible = false;
			while(temp != null && !isPossible){
				if(temp.data == node){
					isPossible = true;
				}
				if(!isPossible){
					prev = temp;
					temp = temp.next;	
				}
			}
			if(prev != null){
				prev.next = temp.next;
			}else if(prev == null && isPossible){
				head = null;
			}
		}
	}
	
	public static void pushBefore(int node,int data){
		LinkedNode newNode = new LinkedNode(data);
		LinkedNode temp = head;
		LinkedNode prev = null;
		boolean isPossible = false;
		if(head != null){
			while(temp != null && !isPossible){
				if(temp.data == node){
					isPossible = true;
				}
				if(!isPossible){
					prev = temp;
					temp =  temp.next;	
				}
			}
			if(prev != null){
				newNode.next = temp;
				prev.next = newNode;
			}else if(prev == null && isPossible){
				newNode.next = temp;
				head = newNode;
			}
		}
	}
	//	Write a function to get Nth node in a Linked List
	
	public static void getNthNode(int n){
		System.out.println();
		System.out.print(n+"-th Node := ");
		LinkedNode temp = head;
		while(n > 1 && temp != null){
			temp = temp.next;
			n--;
		}
		if(temp != null){
			System.out.print(temp.data);
		}
	}

	public static void getNthNodeFromLast(int n){
		System.out.println();
		System.out.print(n+"-th Node From the Lst:= ");
		LinkedNode ref = head;
		LinkedNode main = head;
		// using 2- pointer concept..first move ref pointer to x..then move both the pointer until ref pointer reaches ends 1 by 1
		while(n > 1 && ref != null){
			ref = ref.next;
			n--;
		}
		if(ref != null){
			while(ref.next != null){
				ref = ref.next;
				main = main.next;
			}
			System.out.print(main.data);
		}
	}

	public static void getMiddlehNode(){
		System.out.println();
		System.out.print("Middle Node/Nodes From the List:= ");
		LinkedNode slow = head;
		LinkedNode fast = head;
		while(fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		if(fast.next == null){
			System.out.print(slow.data);
		}else{
			System.out.print(slow.data+" && "+slow.next.data);
		}
	}
	
	public static void checkIfLoopExist(){
		System.out.println();
		LinkedNode slow = head;
		LinkedNode fast = head;
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
		System.out.println("Does Loop Exist in LinkedList ? "+ifLoopExist);
	}
	
	public static int getLengthOfLoop(){
		System.out.println();
		LinkedNode slow = head;
		LinkedNode fast = head;
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
			LinkedNode pointerMeet = slow;
			while(pointerMeet != slow && length > 0){
				pointerMeet = pointerMeet.next;
				length++;
			}
		}
		return length;
	}
	
	public static SingleLinkedList mergeSortedLinkedList(SingleLinkedList list1 , SingleLinkedList list2){
		LinkedNode l1 = list1.head;
		LinkedNode l2 = list2.head;
		SingleLinkedList mergedList = new SingleLinkedList();
		 while(!(l1 == null && l2 == null)){
			 if(l1 != null && l2 != null){
				 if(l1.data < l2.data){
					 mergedList.pushTail(l1.data);
					 l1 = l1.next;
				 }else{
					 mergedList.pushTail(l2.data);
					 l2 = l2.next;
				 }
			 }else if(l1 == null){
				 mergedList.pushTail(l2.data);
				 l2 = l2.next;
			 }else if(l2 == null){
				 mergedList.pushTail(l1.data);
				 l1 = l1.next;
			 }
		 }
		 return mergedList;
	}
	
	public static void reverse(){
		System.out.println();
		System.out.println("Reverse the Lisnked List : - ");
		LinkedNode current = head;
		LinkedNode prev = null;
		LinkedNode next = null;
		
		while(current != null){
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head=prev;
	}
	
	public static void Kreverse(int k){
		System.out.println();
		System.out.println("Reverse the Lisnked List : - ");
		LinkedNode current = head;
		LinkedNode prev = null;
		LinkedNode next = null;
		
		while(current != null){
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head=prev;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingleLinkedList list = new SingleLinkedList();
		list.pushHead(4);
		list.pushHead(9);
		list.pushHead(1);
		list.pushHead(5);
		list.pushTail(3);
		list.pushHead(6);
		list.pushTail(11);
		list.pushAfter(4,15);
		list.pushAfter(1,10);
		list.pushBefore(5, 20);
		list.pushBefore(11, 12);
		list.pushBefore(6, 15);
		list.traversal(list.head);
		list.deleteHead();
		list.deleteTail();
		list.deleteTail();
		list.deleteNode(10);
		list.traversal(list.head);
		list.getNthNode(5);
		list.getNthNodeFromLast(5);
		list.getMiddlehNode();
		list.deleteTail();
		list.traversal(list.head);
		list.getMiddlehNode();
		list.checkIfLoopExist();
		list.reverse();
		list.traversal(head);
		System.out.println();
		// Merge 2 sorted LinkedLists
//		SingleLinkedList list1 = new SingleLinkedList();
//		list1.pushTail(4);
//		list1.pushTail(7);
//		list1.pushTail(9);
//		list1.pushTail(15);
//		list1.pushTail(24);
//		list1.pushTail(30);
//		System.out.println("List-1 :- ");
//		list1.traversal(list1.head);
//		SingleLinkedList list2 = new SingleLinkedList();
//		list2.pushTail(2);
//		list2.pushTail(5);
//		list2.pushTail(8);
//		list2.pushTail(11);
//		list2.pushTail(12);
//		list2.pushTail(29);
//		System.out.println(list2.head);
//		System.out.println("List-2 :- ");
//		list2.traversal();
//		System.out.println("Merge two Sorted List :- ");
//		list.mergeSortedLinkedList(list1, list2).traversal();
		
		
	}
}

class LinkedNode{
	int data;
	LinkedNode next;
	public LinkedNode(int data) {
		super();
		this.data = data;
	}
}