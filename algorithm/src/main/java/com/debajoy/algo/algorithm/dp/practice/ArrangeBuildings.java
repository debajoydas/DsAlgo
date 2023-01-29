/**
 * 
 */
package com.debajoy.algo.algorithm.dp.practice;

/**
 * @author Debajoy
 *
 */
public class ArrangeBuildings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		System.out.println(getCountBuildings(n));
	}

	private static int getCountBuildings(int n) {
		// TODO Auto-generated method stub
		int oldB = 1;int oldS = 1;
		for(int i = 2; i<= n; i++){
			int newS =  oldB+oldS;
			int newB = oldS;
			oldB = newB;
			oldS = newS;
		}
		return (int) Math.pow((oldB+oldS), 2);
	}

}
