/**
 * 
 */
package com.debajoy.algo.algorithm.math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Debajoy
 *
 */
public class LargestInteger {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			System.out.println(getInt(268));
			System.out.println(getInt(670));
			System.out.println(getInt(0));
			System.out.println(getInt(-999));
	}
	
	private static int getInt(int number){
		int size = 0;
		List<Integer> list = new ArrayList<Integer>();
		if(number == 0){
			list.add(5);
			list.add(number);
			return getNumberFromList(list);
		}else if(number > 0){
			while (number > 0) {
				size++;
				list.add(number % 10);
			    number = number / 10;
			}
			Collections.reverse(list);
			boolean tag = false;
			for(int i = 0; i < size; i++){
				if(list.get(i) < 5){
					list.add(i, 5);
					tag = true;
					break;
				}
			}
			if(!tag){
				list.add(5);
			}	
			return getNumberFromList(list);
		}else{
			number = 0 - number;
			while (number > 0) {
				size++;
				list.add(number % 10);
			    number = number / 10;
			}
			Collections.reverse(list);
			boolean tag = false;
			for(int i = 0; i < size; i++){
				if(list.get(i) > 5){
					list.add(i, 5);
					tag = true;
					break;
				}
			}
			if(!tag){
				list.add(5);
			}
			int numberNeg = 0 - getNumberFromList(list);
			return numberNeg;
		}
	}
	
	private static int getNumberFromList(List<Integer> list){
		StringBuffer s= new StringBuffer("");
		list.stream().forEach(n -> {
			s.append(n);
		});
		return Integer.valueOf(s.toString());
	}

}
