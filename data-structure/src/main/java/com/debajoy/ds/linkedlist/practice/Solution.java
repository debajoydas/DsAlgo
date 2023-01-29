package com.debajoy.ds.linkedlist.practice;

import java.util.Stack;

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

public class Solution {
	
	public static void main(String[] args){
		ListNode head = new ListNode(2);
		head.next = new ListNode(4);
		System.out.println(isPalindrome(head));

	}
	
    public static boolean isPalindrome(ListNode head) {
        boolean isPalindrome = true;
        ListNode temp = head;
        ListNode temp1 = head;
        int size = 0;
        while(temp != null){
            temp = temp.next;
            size++;
        }  
        int secondCount = 0;
        if(size%2 != 0){
            secondCount = size/2+1;
        }else{
            secondCount = size/2;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int counter = 0;
        while(temp1 != null){
            if(counter < size/2){
                stack.push(temp1.val);
            } 
            if(counter >= secondCount){
               if(stack.size() > 0 && stack.pop() != temp1.val){
                   return false;
               }
            }      
            temp1 = temp1.next;
            counter++;
        }
      return isPalindrome;
      
    }
    
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String number1 = getNumber(l1);
        String number2 = getNumber(l2);
        String add = String.valueOf(Integer.valueOf(number1)+Integer.valueOf(number2));
        return getFinalNode(add);
    }
    private static ListNode getFinalNode(String data){
        ListNode head = null;
        ListNode curr = null;        
        for(int i=data.length()-1 ; i >= 0; i--){
            if(head == null){
                head = new ListNode(Integer.valueOf(data.substring(i,i+1)));
                curr = head;
            }else{
                curr.next =  new ListNode(Integer.valueOf(data.substring(i,i+1)));
                curr = curr.next;
 
            }
        }
        return head;
    }
    private static String getNumber(ListNode node){
        StringBuilder sb= new StringBuilder("");
        ListNode temp = node;
        while(temp != null){
            sb.append(temp.val);
            temp = temp.next;
        }
    return sb.toString();
    }
}