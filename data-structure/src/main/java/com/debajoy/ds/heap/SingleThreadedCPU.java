/**
 * 
 */
package com.debajoy.ds.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Debajoy
 *
 */
public class SingleThreadedCPU {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] tasks = {{1,2},{2,4},{3,2},{4,1}};
		Arrays.asList(getOrder(tasks)).forEach(t -> System.out.print(t+"->"));
	}
	
    public static int[] getOrder(int[][] tasks) {
    	PriorityQueue<Task> queue = new PriorityQueue<Task>(new Comparator<Task>() {
			@Override
			public int compare(Task o1, Task o2) {
				// TODO Auto-generated method stub
				return Integer.valueOf(o1.i).compareTo(Integer.valueOf(o2.i));
			}
		});
    	for(int task = 0; task < tasks.length; task++){
    		queue.add(new Task(task, tasks[task][0],  tasks[task][0]));
    	}
    	int amin = -1; int pmin = 0;
    	for(Task que : queue){
    		if(amin == -1){
    			amin = que.a;
    			pmin = que.p;
    		}else{
        		 if(amin == que.a){
        			if(pmin > que.p){
        				pmin = que.p;
        			}
        		}
    		}
    	}
		return null;     
    }

}

class Task{
	public Task(int i, int a, int p) {
		super();
		this.i = i;
		this.a = a;
		this.p = p;
	}
	int i;
	int a;
	int p;
}