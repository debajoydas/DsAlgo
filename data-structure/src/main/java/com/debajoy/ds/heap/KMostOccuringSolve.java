/**
 * 
 */
package com.debajoy.ds.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Debajoy
 *
 */
public class KMostOccuringSolve {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3,1,4,4,5,2,6,1};
		int n = arr.length;
		int k = 2;
		
		int[] arr1 = {3, 3, 3, 4, 1, 1, 6, 1};
		int n1 = arr1.length;
		int k1 = 3;
		
		int[] arr2 = {3 ,1, 5, 5, 5, 1, 7, 8};
		int n2 = arr1.length;
		int k2 = 3;
		
		kMostOccuring(arr, n, k);
		kMostOccuring(arr1, n1, k1);
		kMostOccuring(arr2, n2, k2);
		

	}

    public static void kMostOccuring(int arr[], int n, int k){
        // your code here
    	if(arr == null){
    		return;
    	}
    	PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
    	for(int i : arr){
    		queue.add(i);
    	}
    	Integer prev = null;
    	int count = 0;
    	int sum = 0;
    	while(queue.size() > 0){
    		Integer current = queue.poll();
    		if(prev == null){
    			prev = current;
    			count = 1;
    		}else {
    			if(prev == current){
    				count += 1;
    			}else{
    				if(count >= k){
    					sum += count;
    				}
    				count = 1;
    				prev = current;
    			}
    		}
    	}
    	System.out.println(sum);
    }
    
    public static ArrayList<Integer> nearlySorted(int arr[], int num, int k){
        // your code here
    	if(arr == null){
    		return null;
    	}
    	PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
    	List<Integer> list = new ArrayList<Integer>();
    	for(int i : arr){
    		queue.add(i);
    	}
    	while(queue.size() > 0){
    		list.add(queue.poll());
    	}
    	return (ArrayList<Integer>) list;
    }
    
    public static int[] kMostOccuringElements(int arr[], int k){
    	PriorityQueue<MostFrequent> queue = new PriorityQueue<>(new Comparator<MostFrequent>() {
			@Override
			public int compare(MostFrequent o1, MostFrequent o2) {
				// TODO Auto-generated method stub
				return Integer.valueOf(o2.count).compareTo(Integer.valueOf(o1.count));
			}
		});
    	int[] output = new int[k];
    	Arrays.sort(arr);
    	Integer prev = null;
    	int count = 0;
    	for(int i = 0; i < arr.length; i++){
    		if(prev == null){
    			count = 1;
    		}else if(prev != null && prev == arr[i]){
    			count++;
    		}else if(prev != null && prev != arr[i]){
    			queue.add(new MostFrequent(prev, count));
    			count = 1;
    		}
    		prev = arr[i];
    	}
    	queue.add(new MostFrequent(prev, count));
    	for(int i = 0 ; i < k; i++){
    		output[i] = queue.poll().data;
    	}
    	return output;
    }
}

class MostFrequent{
	int data;
	int count;
	public MostFrequent(int data, int count) {
		super();
		this.data = data;
		this.count = count;
	}
}
