/**
 * 
 */
package com.debajoy.ds.heap.level1;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;


/**
 * @author Debajoy
 *
 */
public class TaskScheduler {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] tasks = {'A','A','A','A','A','A','B','C','D','E','F','G'};
		int n = 2;
		System.out.println(leastInterval(tasks, n));
	}
	
    public static int leastInterval(char[] tasks, int n) {
    	PriorityQueue<TaskN> maxHeap = new PriorityQueue<>(new Comparator<TaskN>() {
			@Override
			public int compare(TaskN t1, TaskN t2) {
				// TODO Auto-generated method stub
				return Integer.valueOf(t2.count).compareTo(Integer.valueOf(t1.count));
			}
		});
    	Map<Character,Integer> map = new HashMap<>();
    	for(char c : tasks){
    		if(map.get(c) == null){
    			map.put(c, 1);
    		}else{
    			map.put(c, map.get(c)+1);
    		}
    	}
    	for(Map.Entry<Character,Integer> m : map.entrySet()){
    		TaskN task = new TaskN(m.getKey(),m.getValue());
    		maxHeap.add(task);
		}
    	int pointer = 0;
    	int totalnoOfTask = 0;
    	Character[] arr = new Character[tasks.length+tasks.length*n];
    	while(maxHeap.size() > 0){
    		TaskN mas = maxHeap.poll();
    		pointer = 0;
    		while(mas.count > 0){
    			if(arr[pointer] == null){
    				arr[pointer] = Character.valueOf(mas.task);
    				totalnoOfTask++;
    				mas.count -= 1;
    				if(totalnoOfTask < tasks.length){
    					pointer = pointer + n + 1;
        				
    				}				
    			}else{
    				pointer++;
    			} 			
    		}
    	}
    	for(int i = arr.length-1; i >= 0; i--){
    		if(arr[i] != null){
    			return i+1;
    		}
    	}
    	return pointer+1; 
    }
}

class TaskN{
	char task;
	int count;
	public TaskN(char task, int count) {
		super();
		this.task = task;
		this.count = count;
	}
	
}
