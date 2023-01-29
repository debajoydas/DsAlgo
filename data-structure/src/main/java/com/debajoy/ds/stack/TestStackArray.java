/**
 * 
 */
package com.debajoy.ds.stack;

/**
 * @author Debajoy
 *
 */
public class TestStackArray{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackArray sA = new StackArray();
		sA.isEmpty();
		sA.push(5);
		sA.display();
		sA.isEmpty();
		sA.push(3);
		sA.push(7);
		sA.push(12);
		sA.push(9);
		sA.display();
		sA.pop();
		sA.pop();
		sA.peek();
		sA.display();
	}
}
