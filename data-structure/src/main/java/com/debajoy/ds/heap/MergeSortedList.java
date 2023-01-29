/**
 * 
 */
package com.debajoy.ds.heap;

import java.util.PriorityQueue;

/**
 * @author Debajoy
 *
 */
public class MergeSortedList {
	
	protected static ListNode head;
	
	static class ListNode {
		int data;
		ListNode next;
		public ListNode(int data) {
			this.data = data;
		}
		public int getCount() {
			// TODO Auto-generated method stub
			return 0;
		}	
	}
	
	static class CustomMinHeap {

		ListNode root;
		int heapSize;
		
		public CustomMinHeap() {
			this.heapSize = 0;
			root = null;
		}
		
		public void insertElement(ListNode head){
			if(head == null){
				return;
			}
			int count = 0;
			ListNode temp = head;
			while(temp !=  null){
				count++;
				temp = temp.next;
			}
			if(heapSize == 0){
				heapSize += temp.getCount();
				if(root == null){
					root = head;
				}else{
					ListNode tempRoot = root;
					while(head != null){
						tempRoot.next = head.next;
						head = head.next;
					} 
				}
				
			}else if(heapSize > 0){		
				heapSize += temp.getCount();
				ListNode tempHead = head;
				while(tempHead != null){
					ListNode tempSecond = root;
					while(tempSecond != null){
						if(tempSecond.data > tempHead.data){
							
						}else if(tempSecond.data < tempHead.data){
							
						}else if(tempSecond.data == tempHead.data){
							
						}
					}
				}
				
			}

			
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null){
        	return null;
        }else if(lists != null && lists.length == 1){
        	return lists[0];
        }else if(lists != null && lists.length > 1){
        	PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        	
        }
		return null;
        
    }
}
