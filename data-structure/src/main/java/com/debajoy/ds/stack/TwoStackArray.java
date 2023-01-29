/**
 * 
 */
package com.debajoy.ds.stack;

/**
 * @author Debajoy
 *
 */
public class TwoStackArray {
	
	public static final int MAX = 10;
	static int[] arr = new int[MAX];
	static int top1; 
	static int top2;
	
	/**
	 * 
	 */
	public TwoStackArray() {
		top1 =-1;
		top2 = MAX;
	}
	
	public static void push1(int data){
		if(top1 < (top2-1)){
			top1 += 1;
			arr[top1] = data;
			System.out.println("Push to Stack-1 successfull : "+data);
		}else{
			System.out.println("Can't push as ... Stack-1 is overflow");
		}
	}
	
	public static void push2(int data){
		if(top2> (top1+1)){
			top2 -=1;
			arr[top2] = data;
			System.out.println("Push to Stack-2 successfull : "+data);
		}else{
			System.out.println("Can't push as ... Stack-2 is overflow");
		}
	}
	
	public static Integer pop1(){
		Integer pop = null;
		if(top1 <= -1){
			System.out.println("Stack-1 is empty,...not able to pop from Stack-1");
			return pop;
		}else{
			pop = arr[top1];
			top1 = top1 -1;
			return pop;
		}
		
	}
	
	public static Integer pop2(){
		Integer pop = null;
		if(top2 == MAX){
			System.out.println("Stack-1 is empty,...not able to pop from Stack-1");
			return pop;
		}else{
			pop = arr[top2];
			top2 = top2 +1;
			return pop;
		}
	}
	
	public static boolean isEmpty1(){
		if(top1 < 0){
			System.out.println("Stack-1 is empty...");
			return false;
		}
		return true;
	}
	
	public static boolean isEmpty2(){
		if(top2 >= MAX){
			System.out.println("Stack-2 is empty...");
			return false;
		}
		return true;
	}
	
	public void display(){
		for(int i =0; i< arr.length ; i++){
				System.out.print(arr[i]+" -> ");
		}
		System.out.println();
	}
	
	public void displayStack1(){
		if(top1 > -1){
			for(int i =0; i<= top1 ; i++){
				System.out.print(arr[i]+" -> ");
			}
		}
		System.out.println();
	}
	
	public void displayStack2(){
		if(top2 < MAX){
			for(int i =(MAX-1); i>= top2 ; i--){
				System.out.print(arr[i]+" -> ");
			}
		}
		System.out.println();
	}
}
