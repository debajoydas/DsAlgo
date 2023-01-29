/**
 * 
 */
package com.debajoy.ds.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Debajoy
 *
 */
public class IPO {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] Profits = {1,2,3};
		int[] Capital = {1,1,2};
		int k = 1;
		int W = 0;
		System.out.println(findMaximizedCapital(k, W, Profits, Capital));
	}
	
	public static int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
		PriorityQueue<IPOCap> minQueue =  new PriorityQueue<IPOCap>(new Comparator<IPOCap>() {
			@Override
			public int compare(IPOCap o1, IPOCap o2) {
				// TODO Auto-generated method stub
				return Integer.valueOf(o2.p).compareTo(Integer.valueOf(o1.p));
			}
		});
		PriorityQueue<IPOCap> tempQueue =  new PriorityQueue<IPOCap>(new Comparator<IPOCap>() {
			@Override
			public int compare(IPOCap o1, IPOCap o2) {
				// TODO Auto-generated method stub
				return Integer.valueOf(o2.p).compareTo(Integer.valueOf(o1.p));
			}
		});
		
		for(int i = 0; i< Profits.length; i++){
			IPOCap cap = new IPOCap(Profits[i],Capital[i]);
			minQueue.add(cap);
		}
		while(k > 0){
			if(minQueue.size() <= 0){
				break;
			}
			IPOCap cap = minQueue.poll();
			if(W >= cap.c){
				k--;
				W += cap.p;
				minQueue.addAll(tempQueue);
				tempQueue.clear();
			}else{
				tempQueue.add(cap);
			}	
		}
		return W;        
	}
}
 class IPOCap {
	 public IPOCap(int p, int c) {
		super();
		this.p = p;
		this.c = c;
		this.w = this.p - this.c;
	}
	int p;
	 int c;
	 int w;
	 
 }