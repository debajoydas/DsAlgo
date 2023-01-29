package com.debajoy.ds.linkedlist.practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicateArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] nums = {0,0,1,1,1,2,2,3,3,4};
//		int count = removeDuplicates(nums);
//		System.out.println(count);
//		displayArray(nums,count);
		
//		ListNode head = new ListNode(1);
//		head.next = new ListNode(1);
//		head.next.next = new ListNode(1);
//		head.next.next.next = new ListNode(2);
//		head.next.next.next.next = new ListNode(3);
//		deleteDuplicates(head);
//		
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		int left = 2; int right = 4;
		reverseBetween(head,left,right);
	}
	
	 public static ListNode reverseBetween(ListNode head, int left, int right) {
	        int counter = 1;
	        ListNode prevOld = null;
	        ListNode temp = head;
	        while(counter < left){
	        	prevOld= temp;
	            temp = temp.next;
	            counter++;
	        }
	   
	        ListNode curr = temp;
	        ListNode prev = null;
	        ListNode next = null;
	        while(curr != null && counter <= right){
	            next = curr.next;
	            curr.next = prev;
	            prev = curr;
	            curr = next;
	            counter++;
	        }
	        temp.next = prev;
	        ListNode tail = getTail(prev);
	        tail.next = curr;
	        return head;
	    }
	    public static ListNode getTail(ListNode node){
	        ListNode temp = node;
	        ListNode prev = null;
	        while(temp != null){
	            prev = temp;
	            temp = temp.next;
	        }
	        return prev;
	    }
	
    public static ListNode deleteDuplicates(ListNode head) {
    	 
   	 
  ListNode prev = null;
  ListNode temp = head;
  ListNode temp1 = temp;
  Set<Integer> set = new HashSet<Integer>();
  while(temp1 != null){
      if(prev != null && prev.val == temp1.val){
          prev.next = temp1.next;
          set.add(temp1.val);
      }else{
          prev = temp1;
      }
      temp1 = temp1.next;
  }
  ListNode temp2Orig = temp;
  ListNode temp2 = temp2Orig;
  ListNode prev2 = null;
  while(temp2 != null){
      if(!set.contains(temp2.val)){
          break;
      }
      prev2 = temp2;
      temp2 = temp2.next;
  }
  if(prev2 != null){
      prev2.next = null;
  }

  ListNode temp3Orig = temp2;
  ListNode temp3 = temp3Orig;
  ListNode prev3 = null;
  while(temp3 != null){
      if(prev3 != null && set.contains(temp3.val)){
          prev3.next = temp3.next;
      }else{
          prev3 = temp3;
      }
      temp3 = temp3.next;
  }
  return temp3Orig;

  }



	 private static void displayArray(int[] nums, int removeDuplicates) {
		// TODO Auto-generated method stub
		 for(int i = 0; i < removeDuplicates; i++){
			 System.out.print(nums[i]+"->");
		 }
		
	}
	public static int removeDuplicates(int[] nums) {
	        int prev = -1;
	        int count = 0;
	        List<Integer> list = new ArrayList<Integer>();
	        for(int i = 0; i < nums.length; i++){
	            if(prev != -1 && prev == nums[i]){
	                nums[i] = 101;
	                continue;
	            }
	            if(nums[i] != 101){
	                prev = nums[i];
	            }    
	            list.add(i);    
	            count++;
	        }
	        int idx = 0;
	        for(int i = 0; i < count; i++){
	            nums[i] = nums[list.get(i)];    
	        }
	        return count;
	    }

}
