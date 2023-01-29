/**
 * 
 */
package com.debajoy.ds.linkedlist.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Debajoy
 *
 */
public class SingleLinkedList3 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String SEPERATOR ="**************************************************************************************";	
		LinkedListNew list = new LinkedListNew();
		System.out.println(SEPERATOR);
		list.addFirst(2);
		list.display();
		System.out.println(SEPERATOR);
		list.addFirst(3);
		list.addLast(6);
		list.display();
		System.out.println(SEPERATOR);
		list.addLast(10);
		list.display();
		System.out.println(SEPERATOR);
		list.addAfterNode(6, 5);
		list.display();
		System.out.println(SEPERATOR);
		list.addBeforeNode(2, 12);
		list.display();
		System.out.println(SEPERATOR);
		list.addBeforeNode(3, 23);
		list.display();
		System.out.println(SEPERATOR);
		list.addAfterNode(10, 30);
		list.display();
		System.out.println(SEPERATOR);
		list.deleteFirst();
		list.display();
		System.out.println(SEPERATOR);
		list.deleteLast();
		list.display();
		System.out.println(SEPERATOR);
		list.deleteNode(3);
		list.display();
		System.out.println(SEPERATOR);
		
		LinkedListNew list1 = new LinkedListNew();
		list1.addLast(2);
		list1.addLast(20);
		list1.addLast(12);
		list1.addLast(11);
		list1.addLast(25);
		list1.addLast(15);
		list1.display();
		list1.reverse();
		list1.display();
		System.out.println(SEPERATOR);
		list1.kthElementFromLast(7);
		System.out.println(SEPERATOR);
		
		LinkedListNew list2 = new LinkedListNew();
		LinkedListNew list3 = new LinkedListNew();
		
		ListNode3 intersectionNode = new ListNode3(29);
		intersectionNode.next = new ListNode3(50);
		intersectionNode.next.next = new ListNode3(60);
		intersectionNode.next.next.next = new ListNode3(48);
		intersectionNode.next.next.next.next = new ListNode3(54);
		
		list2.head = new ListNode3(2);
		list2.head.next = new ListNode3(20);
		list2.head.next.next = new ListNode3(12);
		list2.head.next.next.next = new ListNode3(11);
		list2.head.next.next.next.next = new ListNode3(25);		
		list2.head.next.next.next.next.next = intersectionNode;
		
		list3.head = new ListNode3(11);
		list3.head.next = new ListNode3(1);
		list3.head.next.next = new ListNode3(19);
		list3.head.next.next.next = intersectionNode;
				
		list2.display();
		list3.display();
		
		findIntersectionPint(list2,list3);
		System.out.println(SEPERATOR);
		
		LinkedListNew list4 = new LinkedListNew();
		ListNode3 node1 = list4.head = new ListNode3(1);
		ListNode3 node2 = list4.head.next = new ListNode3(2);
		ListNode3 node3 = list4.head.next.next = new ListNode3(3);
		ListNode3 node4 = list4.head.next.next.next = new ListNode3(4);
		ListNode3 node5 = list4.head.next.next.next.next = new ListNode3(5);	
		node1.random = node3;
		node2.random = node1;
		node3.random = node5;
		node4.random = node3;
		node5.random = node2;
		ListNode3 clonedNode = list4.cloneNode();
		display(clonedNode);
		System.out.println(SEPERATOR);
		
		LinkedListNew list5 = new LinkedListNew();
		ListNode3 nodes1 = list5.head = new ListNode3(3);
		ListNode3 nodes2 = list5.head.next = new ListNode3(2);
		ListNode3 nodes3 = list5.head.next.next = new ListNode3(0);
		ListNode3 nodes4 = list5.head.next.next.next = new ListNode3(1);
		ListNode3 nodes5 = list5.head.next.next.next.next = new ListNode3(5);
		ListNode3 nodes6 = list5.head.next.next.next.next.next = new ListNode3(8);
		ListNode3 nodes7 = list5.head.next.next.next.next.next.next = new ListNode3(9);
		ListNode3 nodes8 = list5.head.next.next.next.next.next.next.next = new ListNode3(10);
		list5.head.next.next.next.next.next.next.next.next = nodes4;
		list5.isCircleExist();
		
		
		LinkedListNew list6 = new LinkedListNew();
		ListNode3 nodese1 = list6.head = new ListNode3(1);
		ListNode3 nodese2 = list6.head.next = new ListNode3(2);
		ListNode3 nodese3 = list6.head.next.next = nodese1;
		list6.isCircleExist();
		
		LinkedListNew list7 = new LinkedListNew();
		list7.head = new ListNode3(1);
		list7.head.next = new ListNode3(2);
		list7.head.next.next = new ListNode3(-3);
		list7.head.next.next.next = new ListNode3(3);
		list7.head.next.next.next.next = new ListNode3(1);
		list7.removeZeroSumConsecutive();
		list7.display();
		
	}

	private static void display(ListNode3 clonedNode) {
		// TODO Auto-generated method stub
		while(clonedNode != null){
			System.out.println(clonedNode.data+"->");
			clonedNode = clonedNode.next;
		}
	}

	private static void findIntersectionPint(LinkedListNew list2, LinkedListNew list3) {
		// TODO Auto-generated method stub
		int size2 = getSize(list2.head);
		int size3 = getSize(list3.head);
		ListNode3 temp2 = list2.head;
		ListNode3 temp3 = list3.head;
		Map<Integer,String> map = new HashMap<Integer,String>();
		map.put(1, "New");
		map.get(1);
		int extraCounter = 0;
		if(size2 > size3){
			while(extraCounter < (size2-size3)){
				temp2 = temp2.next;
				extraCounter++;
			}
		}else if(size3 > size2){
			while(extraCounter < (size3-size2)){
				temp3 = temp3.next;
				extraCounter++;
			}
		}
		while(temp2 != null && temp3 != null && temp2 != temp3){
			temp2 = temp2.next;
			temp3 = temp3.next;
		}
		if(temp2 != null && temp3 != null && temp2 == temp3){
			System.out.println("Intersection Point is :=> "+temp2.data);
		}else{
			System.out.println("No Intersection Point Found");
		}
		
	}

	private static int getSize(ListNode3 head) {
		// TODO Auto-generated method stub
		ListNode3 temp = head;
		int size = 0;
		while(temp != null){
			temp = temp.next;
			size += 1;
		}
		return size;
	}

}

class ListNode3{
	int data;
	ListNode3 next;
	ListNode3 random;
	public ListNode3(int data) {
		super();
		this.data = data;
	}
}

class LinkedListNew{
	ListNode3 head;
	ListNode3 tail;
	int size;
	
	public void display(){
		System.out.println();
		ListNode3 temp = head;
		System.out.print("List :=> ");
		while(temp != null){
			System.out.print(temp.data+"->");
			temp = temp.next;
		}
		System.out.println();
		System.out.print("Head :=>"+(head != null ? head.data : "null") + " && ");
		System.out.print("Tail :=>"+(tail != null ? tail.data : "null") + " && ");
		System.out.print("Size :=>"+size+ " && ");
		System.out.println();
	}
	public void removeZeroSumConsecutive() {
	      Map<Integer,ListNode3> map = new HashMap<Integer,ListNode3>();
	      ListNode3 dummy = new ListNode3(0);
	      dummy.next = head;
	      ListNode3 temp = dummy;
	      int sum = 0;
	        while(temp != null){
	        	 sum += temp.data;
	            if(map.get(sum) != null){
	            	ListNode3 exisitngNode = map.get(sum);
	            	ListNode3 tempexisitngNode = exisitngNode;
	                int count = sum;
	                while(tempexisitngNode != temp){
	                    if(tempexisitngNode != exisitngNode){
	                        count += tempexisitngNode.data;
	                        map.remove(count);
	                    }
	                    tempexisitngNode = tempexisitngNode.next;
	                }
	                exisitngNode.next = temp.next;
	            }else{
	                map.put(sum,temp);
	            }
	            
	            temp = temp.next;
	        }
	      head = dummy.next;
	}
	public void isCircleExist() {
		// TODO Auto-generated method stub
		ListNode3 fastPointer = head;
		ListNode3 slowPointer = head;
		int size = 0;
		boolean isCircleExist = false;
		while(fastPointer != null && slowPointer != null){
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
			if(fastPointer == slowPointer){
				isCircleExist = true;
				break;
			}
		}
		if(isCircleExist){
			System.out.println("Circle Exists in LinkedList...");
			slowPointer = head;
			ListNode3 temp = fastPointer;
			while(temp != slowPointer){
				temp = temp.next;
				slowPointer = slowPointer.next;
			}
			if(temp == slowPointer){
				System.out.println("Starting Point of the Loop is :=> "+slowPointer.data);
			}
			ListNode3 tempNew = fastPointer;
			while(size == 0 || (size > 0 && fastPointer != tempNew)){
				tempNew = tempNew.next;
				size++;
			}
			if(tempNew == fastPointer){
				System.out.println("Size of the Loop is :=> "+size);
			}
		}
	}
	public ListNode3 cloneNode() {
		ListNode3 temp = head;
		while(temp != null){
			ListNode3 newNode = new ListNode3(temp.data);
			ListNode3 next = temp.next;
			temp.next = newNode;
			newNode.next = next;
			temp = next;
		}
		temp = head;
		while(temp != null){
			ListNode3 random = temp.random;
			if(temp.next != null && random != null){
				temp.next.random = random.next;
			}
			if(temp.next != null){
				temp = temp.next.next;
			}			
		}
		temp = head;
		ListNode3 dummy1 = null;
        if(temp != null){
            dummy1 = temp.next;
        }
		ListNode3 dummy = dummy1;
		while(temp != null && dummy != null){
			if(temp.next != null){
				ListNode3 next1 = temp.next.next;
				temp.next = next1;
			}	
			if(dummy.next != null){
				ListNode3 dummynext1 = dummy.next.next;
				dummy.next = dummynext1;
			}
			temp = temp.next;
			dummy = dummy.next;
			
		}
		return dummy1;
	}
	public void kthElementFromLast(int k){
		System.out.println(k+"-no. Element from the End in the LinkedList is :=>");
		ListNode3 temp = head;
		if(k == size){
			System.out.print(temp.data);
			return;
		}else if(k > size){
			System.out.println("Please provide valid data for K");
		}else{
			k = size-k+1;
			while(temp != null && k > 0){
				temp = temp.next;
				k--;
				if(k == 1){
					System.out.print(temp.data);
				}
			}
		}
	}
	public void reverse() {
		System.out.println("Reverse the Linked List :=>");
		ListNode3 prev = null;
		ListNode3 curr = head;
		ListNode3 next = null;
		while(curr != null){
			next = curr.next;
			curr.next = prev;
			prev = curr;
			if(curr.next == null){
				tail = curr;
			}
			curr = next;
		}
		head = prev;
		System.out.println();
	}
	public void addLast(int data){
		System.out.println("Add Data ("+data+") at the last of LinkedList");
		if(head == null){
			head = new ListNode3(data);
			tail = head;
		}else{
			ListNode3 temp = head;
			while(temp != null){
				tail = temp;
				temp = temp.next;
			}
			tail.next = new ListNode3(data);
			tail = tail.next;
		}
		size += 1;
	}
	public void addFirst(int data){
		System.out.println("Add Data ("+data+") at the Head of LinkedList");
		if(head == null){
			head = new ListNode3(data);
			tail = head;
		}else{
			ListNode3 temp = head;
			head = new ListNode3(data);
			head.next = temp;
			tail = temp;
		}
		size += 1;
		System.out.println();
	}
	public void addAfterNode(int node, int data){
		System.out.println("Add Data ("+data+") In the Middle of LinkedList After the Node ("+node+")");
		if(head == null){
			System.out.println("Can't be added as Node doesn't exist");
		}else{
			ListNode3 temp = head;
			while(temp != null){
				if(temp.data == node){
					break;
				}
				temp = temp.next;
			}
			if(temp != null){
				ListNode3 nextNode = temp.next;
				temp.next = new ListNode3(data);
				temp.next.next = nextNode;
				if(nextNode == null){
					tail = temp.next;
				}
				size += 1;
			}else{
				System.out.println("Can't be added as Node doesn't exist");
			}
		}
		System.out.println();
	}
	public void addBeforeNode(int node, int data){
		System.out.println("Add Data ("+data+") In the Middle of LinkedList Before the Node ("+node+")");
		if(head == null){
			System.out.println("Can't be added as Node doesn't exist");
		}else{
			ListNode3 temp = head;
			ListNode3 prev = null;
			while(temp != null){
				if(temp.data == node){
					break;
				}
				prev = temp;
				temp = temp.next;
			}
			if(temp != null){
				if(prev != null){
					prev.next = new ListNode3(data);
					prev.next.next = temp;
				}else{
					ListNode3 newHead = new ListNode3(data);
					ListNode3 tempHead = head;
					head = newHead;
					head.next = tempHead;
				}
				size += 1;
			}else{
				System.out.println("Can't be added as Node doesn't exist");
			}
		}
		System.out.println();
	}
	public void deleteNode(int data){
		System.out.println("Delete Node ("+data+") from LinkedList");
		if(head == null){
			System.out.println("Node cant be deleted as LinkedList is empty");
		}else{
			ListNode3 temp = head;
			ListNode3 prev = null;
			while(temp != null){
				if(temp.data == data){
					break;
				}
				prev = temp;
				temp = temp.next;
			}
			if(temp != null){
				if(prev != null){
					prev.next = temp.next;
					if(prev.next == null){
						tail = prev;
					}
				}else{
					head = temp.next;
				}
				size -= 1;
			}else{
				System.out.println("Node cant be deleted as it's not found in the LinkedList");
			}
		}
		System.out.println();
	}
	public void deleteFirst(){
		System.out.println("Delete from the First of LinkedList");
		if(head == null){
			System.out.println("Node cant be deleted as LinkedList is empty");
		}else{
			head = head.next;
			if(head == null){
				tail = head;
			}
			size -= 1;
		}
		System.out.println();
	}
	public void deleteLast(){
		System.out.println("Delete from the Last of LinkedList");
		if(head == null){
			System.out.println("Node cant be deleted as LinkedList is empty");
		}else{
			ListNode3 temp = head;
			ListNode3 prev = null;
			while(temp.next != null){
				prev = temp;
				temp = temp.next;
			}
			if(prev == null){
				head = tail = null;
			}else{
				prev.next = null;
				tail = prev;
			}
			size -= 1;
		}
		System.out.println();
	}
}
