/**
 * 
 */
package com.debajoy.ds.stack;

/**
 * @author Debajoy
 *
 */
public class TestTwoStackArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoStackArray sA = new TwoStackArray();
		sA.isEmpty1();
		sA.push1(5);
		sA.display();
		sA.isEmpty2();
		sA.push1(3);
		sA.push1(7);
		sA.push2(12);
		sA.push2(9);
		sA.push2(11);
		sA.display();
		sA.displayStack1();
		sA.displayStack2();
		System.out.println("top from Stack-1 : "+sA.arr[sA.top1]);
		System.out.println("top from Stack-2 : "+sA.arr[sA.top2]);
		sA.pop1();
		sA.pop2();
		sA.display();
		System.out.println("top from Stack-1 : "+sA.arr[sA.top1]);
		System.out.println("top from Stack-2 : "+sA.arr[sA.top2]);
	}
}
