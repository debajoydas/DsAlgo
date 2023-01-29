/**
 * 
 */
package com.debajoy.ds.tree.practice;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Debajoy
 *
 */
public class SortedListBST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(-10);
		head.next = new ListNode(-3);
		head.next.next = new ListNode(0);
		head.next.next.next = new ListNode(5);
		head.next.next.next.next = new ListNode(9);
		TreeNode root = sortedListToBST(head);
		levelOrderTraversal(root);
	}
	
	private static void levelOrderTraversal(TreeNode root) {
		ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
		queue.add(root);
		while(queue.size() > 0){
			int size = queue.size();
			for(int i = 0; i < size; i++){
				TreeNode polled  = queue.poll();
				if(polled != null){
					System.out.print(polled.val+"->");
					if(polled.left != null){
						queue.add(polled.left);
					}
					if(polled.right != null){
						queue.add(polled.right);
					}
				}
			}
			System.out.println();
		}
	}
	
    public static TreeNode sortedListToBST(ListNode head) {
        Map<Integer, ListNode> map = new HashMap<Integer, ListNode>();
        ListNode temp = head;
        int index = 0;
        while(temp != null){
            map.put(index,temp);
            index++;
            temp = temp.next;
        }
        int start = 0; int end = index-1;
        return sortedListToBSTHelper(start,end,map);
    }
     public static TreeNode sortedListToBSTHelper(int start, int end, Map<Integer, ListNode> map) {
         if(start > end || start >= map.size() || start < 0 || end < 0 || end >= map.size()){
             return null;
         }
         if(start == end){
             return new TreeNode(map.get(start).val);
         }
         int mid = (start + end)/2;
         TreeNode root = new TreeNode(map.get(mid).val);
         root.left = sortedListToBSTHelper(start,mid-1,map);
         root.right = sortedListToBSTHelper(mid+1,end,map);
         return root;
     }

}
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }