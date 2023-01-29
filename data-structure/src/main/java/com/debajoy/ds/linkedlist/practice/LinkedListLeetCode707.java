package com.debajoy.ds.linkedlist.practice;

public class LinkedListLeetCode707 {
	
	   ListNode head;
	    int size;
	    public LinkedListLeetCode707() {
	        size = 0;
	    }
	    
	    public int get(int index) {
	        if(index >= size){
	            return -1;
	        }else{
	            int count = 0;
	            ListNode temp = head;
	            while(count < index && temp != null){
	                count++;
	                temp= temp.next;
	            }
	            return temp.val;
	        }
	    }
	    
	    public void addAtHead(int val) {
	        if(head == null){
	            head = new ListNode(val);
	        }else{
	            ListNode node = new ListNode(val);
	            node.next = head;
	            head = node;
	        }
	        size++;
	    }
	    
	    public void addAtTail(int val) {
	       if(head == null){
	            head = new ListNode(val);
	        }else{
	            ListNode temp = head;
	            ListNode prev = null;
	            while(temp != null){
	                prev = temp;
	                temp = temp.next;
	            }
	            prev.next = new ListNode(val);
	        }
	        size++;
	    }
	    
	    public void addAtIndex(int index, int val) {
	        if(index == size){
	            if(head == null){
	                head = new ListNode(val);
	            }else{
	                ListNode temp = head;
	                ListNode prev = null;
	                while(temp != null){
	                    prev = temp;
	                    temp = temp.next;
	                }
	                prev.next = new ListNode(val);
	            }
	            size++;
	        }else if(index < size){
	            ListNode temp = head;
	            ListNode prev = null;
	            int count = 0;
	            while(count < index && temp != null){
	                count++;
	                prev = temp;
	                temp = temp.next;
	            }
	            if(prev != null){
	                prev.next = new ListNode(val);
	                prev.next.next = temp;
	            }else if(prev == null){
	            	ListNode node =  new ListNode(val);
	            	node.next = head;
	            	head = node;
	            }
	            size++;
	        }
	    }
	    
	    public void deleteAtIndex(int index) {
	        if(get(index) != -1){
	            int count = 0;
	            ListNode temp = head;
	            ListNode prev = null;
	            while(count < index && temp != null){
	                count++;
	                prev = temp;
	                temp = temp.next;
	            }
	            if(prev != null){
	                prev.next = temp.next;
	            }else{
	                head = head.next;
	            }
	            size--;
	        }
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListLeetCode707 list = new LinkedListLeetCode707();
		list.addAtHead(2);
		list.addAtIndex(0,1);
		list.get(1);
	}

}
