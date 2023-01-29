/**
 * 
 */
package com.debajoy.ds.linkedlist.practice;

/**
 * @author Debajoy
 *
 */
public class SingleLinkedList2 {

	LinkedNode2 head;

	public void traversal(){
		System.out.println();
		LinkedNode2 temp = head;
		while(temp != null){
			System.out.print(temp.data+ " -> ");
			temp = temp.next;
		}
	}
	
	public void traversal(LinkedNode2 head){
		System.out.println();
		LinkedNode2 temp = head;
		while(temp != null){
			System.out.print(temp.data+ " -> ");
			temp = temp.next;
		}
	}
	
	public void pushHead(int data){
		LinkedNode2 newNode = new LinkedNode2(data);
		if(head != null){
			newNode.next = head;
		}	
		head = newNode;
	}
	
	public void deleteHead(){
		if(head != null){
			head = head.next;
		}
	}
	
	public void pushTail(int data){
		LinkedNode2 newNode = new LinkedNode2(data);
		if(head == null){
			head = newNode;
		}else{
			LinkedNode2 temp = head;
			while(temp.next != null){
				temp =  temp.next;
			}
			temp.next = newNode;
		}
	}
	
	public void pushTail(LinkedNode2 newNode){
		if(head == null){
			head = newNode;
		}else{
			LinkedNode2 temp = head;
			while(temp.next != null){
				temp =  temp.next;
			}
			temp.next = newNode;
		}
	}
	
	public void deleteTail(){
		if(head != null){
			LinkedNode2 temp = head;
			LinkedNode2 prev = null;
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
	
	public void pushAfter(int node,int data){
		LinkedNode2 newNode = new LinkedNode2(data);
		LinkedNode2 temp = head;
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
	
	public void deleteNode(int node){
		if(head != null){
			LinkedNode2 temp = head;
			LinkedNode2 prev = null;
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
	
	public void pushBefore(int node,int data){
		LinkedNode2 newNode = new LinkedNode2(data);
		LinkedNode2 temp = head;
		LinkedNode2 prev = null;
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
	
	public void getNthNode(int n){
		System.out.println();
		System.out.print(n+"-th Node := ");
		LinkedNode2 temp = head;
		while(n > 1 && temp != null){
			temp = temp.next;
			n--;
		}
		if(temp != null){
			System.out.print(temp.data);
		}
	}

	public void getNthNodeFromLast(int n){
		System.out.println();
		System.out.print(n+"-th Node From the Lst:= ");
		LinkedNode2 ref = head;
		LinkedNode2 main = head;
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

	public void getMiddlehNode(){
		System.out.println();
		System.out.print("Middle Node/Nodes From the List:= ");
		LinkedNode2 slow = head;
		LinkedNode2 fast = head;
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
	
	public void checkIfLoopExist(){
		System.out.println();
		LinkedNode2 slow = head;
		LinkedNode2 fast = head;
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
	
	public int getLengthOfLoop(){
		System.out.println();
		LinkedNode2 slow = head;
		LinkedNode2 fast = head;
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
			LinkedNode2 pointerMeet = slow;
			while(pointerMeet != slow && length > 0){
				pointerMeet = pointerMeet.next;
				length++;
			}
		}
		return length;
	}
	
	public SingleLinkedList2 mergeSortedLinkedList(SingleLinkedList2 list1 , SingleLinkedList2 list2){
		LinkedNode2 l1 = list1.head;
		LinkedNode2 l2 = list2.head;
		SingleLinkedList2 mergedList = new SingleLinkedList2();
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
	
	public void reverse(){
		System.out.println();
		System.out.println("Reverse the Lisnked List : - ");
		LinkedNode2 current = head;
		LinkedNode2 prev = null;
		LinkedNode2 next = null;
		
		while(current != null){
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head=prev;
	}
	
	public int length(){
		LinkedNode2 temp = head;
		int count = 0;
		while(temp != null){
			count++;
			temp = temp.next;
		}
		return count;
	}
	
	private boolean isKReversePossible(LinkedNode2 node, int k){
		while(k > 0){
			if(node == null){
				return false;
			}
			node = node.next;
			k--;
		}
		return true;
	}
	
	public void KreverseMain(int k){
		this.head = Kreverse(head, k);
	}
	
	public LinkedNode2 Kreverse(LinkedNode2 head,int k){
		
		LinkedNode2 current = head;
		LinkedNode2 prev = null;
		LinkedNode2 next = null;
		int count = k;
		if(isKReversePossible(current, k)){
			while(k > 0 && current != null){
				next = current.next;
				current.next = prev;
				prev = current;
				current = next;
				k--;
		}
		LinkedNode2 tail = tailNode(prev);
		tail.next = Kreverse(current,count);
		return prev;
		}else{
			return current;
		}
	}
	
	private static LinkedNode2 tailNode(LinkedNode2 node){
		while(node != null && node.next != null){
			node = node.next;
		}
		return node;
	}
	
	public void reverseRecursive(){
		System.out.println("Reverse LinkedList in Recursive way :- ");
		LinkedNode2 temp = head;
		reverseRecursiveCall(temp);
	}
	
	private LinkedNode2 reverseRecursiveCall(LinkedNode2 node) {
		// TODO Auto-generated method stub
		if(node == null){
			return null;
		}
		LinkedNode2 next = reverseRecursiveCall(node.next); 
		if(next == null){
			this.head = node;
		}else{
			next.next = node;
			node.next = null;
		}		
		return node;
	}

	public boolean isLinkedListPalindrome(){
		StringBuilder sb = new StringBuilder();
		LinkedNode2 temp  =  head;int size=0;
		while(temp != null){
			sb.append(temp.data);
			size++;
			temp= temp.next;
		}
		boolean res = true;
		int i = 0;
		int j = size-1;
		while(i < j){
			if(sb.charAt(i) != sb.charAt(j)){
				res = false;break;
			}
			i++;j--;
		}
		return res;
	}
	
	public static void main(String[] args) {
		
		SingleLinkedList2 list = new SingleLinkedList2();
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
		list.pushHead(33);
		list.pushHead(35);
		list.reverse();
		list.traversal(list.head);
		System.out.println();
		list.KreverseMain(3);
		list.traversal(list.head);
		System.out.println();
		list.reverseRecursive();
		list.traversal(list.head);
		System.out.println();
		
		SingleLinkedList2 list1 = new SingleLinkedList2();
		list1.pushTail(2);
		list1.pushTail(3);
		list1.pushTail(4);
		list1.pushTail(12);
		list1.pushTail(4);
		list1.pushTail(3);
		list1.pushTail(2);
		list1.traversal(list1.head);
		System.out.println("Is LinkedList Palindrome ? "+list1.isLinkedListPalindrome());
		
		SingleLinkedList2 list2 = new SingleLinkedList2();
		list2.pushTail(2);
		list2.pushTail(3);
		list2.pushTail(4);
		list2.pushTail(5);
		LinkedNode2 nodeCommon = new LinkedNode2(10);
		nodeCommon.next = new LinkedNode2(12);
		nodeCommon.next.next = new LinkedNode2(1);
		nodeCommon.next.next.next = new LinkedNode2(122);
		nodeCommon.next.next.next.next = new LinkedNode2(11);
		list2.pushTail(nodeCommon);
		
		SingleLinkedList2 list3 = new SingleLinkedList2();
		list3.pushTail(2);
		list3.pushTail(3);
		list3.pushTail(nodeCommon);
		
		System.out.println("find Intersection Point :=> "+findIntersectionPoint(list2,list3));
	}

	private static String findIntersectionPoint(SingleLinkedList2 list2, SingleLinkedList2 list3) {
		// TODO Auto-generated method stub
		LinkedNode2 ptn2 = list2.head;
		LinkedNode2 ptn3 = list3.head;
		int length2 = list2.length();
		int length3 = list3.length();
		if(length2 > length3){
			int diff = length2-length3;
			while(diff > 0){
				ptn2 = ptn2.next;
				diff--;
			}
		}else if(length3 > length2){
			int diff = length3-length2;
			while(diff > 0){
				ptn3 = ptn3.next;
				diff--;
			}
		}
	
		while(ptn2 != ptn3){
			ptn2 = ptn2.next;
			ptn3 = ptn3.next;
		}
		list2.traversal();
		list3.traversal();
		return ptn2 == ptn3 ? String.valueOf(ptn2.data): null;
	}
}

class LinkedNode2{
	int data;
	LinkedNode2 next;
	public LinkedNode2(int data) {
		super();
		this.data = data;
	}
}