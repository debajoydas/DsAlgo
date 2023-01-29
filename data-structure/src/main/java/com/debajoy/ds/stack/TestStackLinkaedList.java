/**
 * 
 */
package com.debajoy.ds.stack;

import com.debajoy.ds.stack.StackLinkedList.StackNode;

/**
 * @author Debajoy
 *
 */
public class TestStackLinkaedList{
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackLinkedList stackLn = new StackLinkedList();
		stackLn.head = new StackNode(3);
		stackLn.push(5);
		stackLn.push(6);
		stackLn.push(1);
		stackLn.push(2);
		stackLn.display();
		stackLn.pop();
		stackLn.pop();
		stackLn.display();

	}

}
