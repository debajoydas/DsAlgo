/**
 * 
 */
package com.debajoy.algo.algorithm.math;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Debajoy
 *
 */
public class MathProblems {

	/**
	 * @param args
	 */	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String SEPERATOR ="**************************************************************************************";
		System.out.println(SEPERATOR);
		int n = 800;
		System.out.println("Prime Factors of "+n+" :=>");
		findPrimeFactors(n);
		System.out.println(SEPERATOR);
		findPrimeFactorsCount(n);

	}
	
	public static void findLCM(int num1, int num2){

	}
	
	public static void findGCD(int num1, int num2){

	}
	
	public static void findPrimeFactors(int n){
		int c = 2;
		while(n > 1){
			if(n%c == 0){
				System.out.print(c +" ");
				n = n/c;
			}else{
				c++;
			}	
		}
		System.out.println();
	}
	
	public static void findPrimeFactorsCount(int n){
		Map<Integer,Integer> mapCount = new HashMap<Integer,Integer>();
		int c = 2;
		while(n > 1){
			if(n%c == 0){
				if(mapCount.get(c) != null){
					mapCount.put(c, mapCount.get(c)+1);
				}else{
					mapCount.put(c, 1);
				}
				n = n/c;
			}else{
				c++;
			}	
		}
		mapCount.entrySet().stream().forEach(entry -> System.out.println("Prime Factor-"+entry.getKey()+" exists "+entry.getValue()+ " times"));
		System.out.println();
	}

}
