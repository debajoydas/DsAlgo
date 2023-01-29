/**
 * 
 */
package com.debajoy.ds.graph;

/**
 * @author Debajoy
 *
 */
public class Node {
	int vertixExist;
	int weight;
	public Node(){
		System.out.println();
	}
	public Node(int vertixExist, int weight) {
		super();
		this.vertixExist = vertixExist;
		this.weight = weight;
	}
	public int getVertixExist() {
		return vertixExist;
	}
	public void setVertixExist(int vertixExist) {
		this.vertixExist = vertixExist;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
}
