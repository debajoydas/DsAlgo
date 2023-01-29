/**
 * 
 */
package com.debajoy.ds.stack;

/**
 * @author Debajoy
 *
 */
public class StackArray {

	/**
	 * 
	 */
	public StackArray() {
		super();
		top = -1;
	}
	static final int MAX = 1000;
	int arr[] = new int[MAX];
	int top = -1;
	
	public boolean isEmpty(){
		if(top < 0){
			System.out.println("Stack is Empty");
			return true;
		}else {
			System.out.println("Stack is not empty");
			return false;
		}
	}
	public boolean push(int x){
		if(top < MAX){
			top += 1;
			arr[top] = x;
			System.out.println("Push Successful in Stack...");
			return true;
		}else {
			System.out.println("Push not Successful...Stack is overflow");
			return false;
		}
	}
	public int pop(){
		if(top >= 0){
			System.out.println("Pop successful...");
			return arr[top--]; 
		}else{
			System.out.println("Pop not successful... Stack is underflow");
			return -1;
		}
	}
	public int peek(){
		if(top >= 0){
			System.out.println("Top element of stack found : "+arr[top]);
			return arr[top];
		}else{
			System.out.println("top element not found as Stack is empty");
			return -1;
		}
	}
	public void display(){
		for(int i =0; i< arr.length ; i++){
			if(top >= 0 && i<= top){
				System.out.print(arr[i]+" -> ");
			}
		}
		System.out.println();
	}
}
