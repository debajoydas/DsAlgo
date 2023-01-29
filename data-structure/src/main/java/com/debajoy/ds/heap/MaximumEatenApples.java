/**
 * 
 */
package com.debajoy.ds.heap;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Debajoy
 *
 */
public class MaximumEatenApples {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] apples = {1,2,3,5,2};
		int[] days = {3,2,1,4,2};
	//	System.out.println(eatenApples(apples, days));
		
		int[] apples1 = {3,0,0,0,0,2};
		int[] days1 = {3,0,0,0,0,2};
	//	System.out.println(eatenApples(apples1, days1));

		int[] apples2 = {2,1,10};
		int[] days2 = {2,10,1};
		System.out.println(eatenApples(apples2, days2));
	}

	public static int eatenApples(int[] apples, int[] days) {		
		AtomicInteger totalAppleEatn = new AtomicInteger();
		PriorityQueue<Apple> heap = new PriorityQueue<Apple>(new Comparator<Apple>(){
			@Override
			public int compare(Apple o1, Apple o2) {
				// TODO Auto-generated method stub
				return Integer.valueOf(o1.getDaysRemaining()).compareTo(Integer.valueOf(o2.getDaysRemaining()));
			}
			
		});
		for(int i = 0; i < days.length; i++){
			AtomicInteger eachDayEat = new AtomicInteger();
			if(apples[i] > 0 && days[i] > 0){
				if(heap.size() > 0){
					Iterator<Apple> iterator = heap.iterator();
					iterator.forEachRemaining((a) -> {
						a.decrementRottonDate();
						if(a.getAppleRemaining() <= 0 || a.getDaysRemaining() <= 0){
							heap.remove(a);
						}else{
							eachDayEat.getAndIncrement();
						}
					});
				}
				Apple apple = null;
				if(eachDayEat.get() > 0){				
					 apple = new Apple(apples[i], days[i]-1);
					 totalAppleEatn.getAndIncrement();
				}else{
					 apple = new Apple(apples[i]-1, days[i]-1);	
				}			
				if(!(apple.getAppleRemaining() <= 0 || apple.getDaysRemaining() <= 0)){
					totalAppleEatn.getAndIncrement();
					if(heap.size() <= 0){
						heap.add(apple);
					}else if(heap.size() > 0 && 
							!(apple.getAppleRemaining() < heap.peek().appleRemaining && apple.getDaysRemaining() <heap.peek().daysRemaining)){
						heap.add(apple);
					}
				}
			}else{
				if(heap.size() > 0){
					totalAppleEatn.getAndIncrement();
					heap.peek().appleRemaining--;
					Iterator<Apple> iterator = heap.iterator();
					iterator.forEachRemaining((a) -> {
						a.decrementRottonDate();
						if(a.getAppleRemaining() <= 0 || a.getDaysRemaining() <= 0){
							heap.remove(a);
						}
					});
				}
			}
		}
		while(heap.size() > 0){
			Apple peek = heap.peek();
			if(peek.appleRemaining <= 0 || peek.daysRemaining <= 0){
				heap.poll();
			}else{
				totalAppleEatn.getAndIncrement();
				Iterator<Apple> iterator = heap.iterator();
				iterator.forEachRemaining((a) -> {
					a.decrementRottonDate();
					a.decrementApple();
				});
			}
		}
		return totalAppleEatn.get();  
    }
}
 class Apple{
	int appleRemaining;
	int daysRemaining;
	public int getAppleRemaining() {
		return appleRemaining;
	}
	public int getDaysRemaining() {
		return daysRemaining;
	}
	 public Apple(int appleRemaining, int daysRemaining) {
		super();
		this.appleRemaining = appleRemaining;
		this.daysRemaining = daysRemaining;
	}
	public void decrementApple(){
		this.appleRemaining--;
	}
	public void decrementRottonDate(){
		this.daysRemaining--;
	}
 }