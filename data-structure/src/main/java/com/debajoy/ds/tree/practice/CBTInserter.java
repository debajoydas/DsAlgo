/**
 * 
 */
package com.debajoy.ds.tree.practice;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Debajoy
 *
 */

 class TreeNodeNew {
      int val;
      TreeNodeNew left;
      TreeNodeNew right;
      TreeNodeNew() {}
      TreeNodeNew(int val) { this.val = val; }
      TreeNodeNew(int val, TreeNodeNew left, TreeNodeNew right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
 }
 
public class CBTInserter {
	TreeNodeNew root;
    public static final int DEFAULT_CAPACITY = 16;
    double loadfactor = 0.75;
    TreeNodeNew[] arr = new TreeNodeNew[DEFAULT_CAPACITY];
    AtomicInteger index = new AtomicInteger(-1);

    public CBTInserter(TreeNodeNew root) {
        this.root = root;
        levelOrderTraversal(root,index,arr);
    }
     
    public void levelOrderTraversal(TreeNodeNew root,AtomicInteger index, TreeNodeNew[] arr){
        ArrayDeque<TreeNodeNew> queue = new ArrayDeque<TreeNodeNew>();
        queue.add(root);
        while(queue.size() > 0){
        	TreeNodeNew popped = queue.poll();
            if(popped != null){
                index.getAndIncrement();
                if(index.get() >= arr.length){
                    arr = Arrays.copyOf(arr,arr.length*2);
                }
                arr[index.get()] = popped;
                if(popped.left != null){
                    queue.add(popped.left);
                }
                if(popped.right != null){
                    queue.add(popped.right);
                }
            }
        }
    }
    
    public int insert(int val) {
        index.getAndIncrement();
        if(Double.valueOf(index.get()) > Double.valueOf(arr.length*loadfactor)){
            arr = Arrays.copyOf(arr,arr.length*2);
        }
        int parentIdx = (index.get()-1)/2;
        TreeNodeNew parent = arr[parentIdx];
        if(parent != null && parent.left == null){
            parent.left = new TreeNodeNew(val); 
            arr[index.get()] = parent.left;  
        }else if(parent != null && parent.right == null){
            parent.right = new TreeNodeNew(val);
            arr[index.get()] = parent.right;  
        }
        return parent.val;
    }
    
    public TreeNodeNew get_root() {
        return this.root;
    }
    
    public static void main(String[] args){
    	TreeNodeNew root = new TreeNodeNew(1);
    	root.left = new TreeNodeNew(2);
    	 CBTInserter obj = new CBTInserter(root);
    	 int param_1 = obj.insert(3);
    	 int param_2 = obj.insert(4);
    	 TreeNodeNew rootDerived = obj.get_root();
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */