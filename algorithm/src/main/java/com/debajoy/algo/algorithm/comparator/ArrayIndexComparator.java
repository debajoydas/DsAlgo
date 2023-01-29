/**
 * 
 */
package com.debajoy.algo.algorithm.comparator;

import java.util.Comparator;

/**
 * @author Debajoy
 *
 */
public class ArrayIndexComparator implements Comparator<Integer> {

	protected Integer[] array;
	
	public ArrayIndexComparator(Integer[] array) {
		super();
		this.array = array;
	}
	
	public Integer[] createIndexArray(){
		Integer[] indexes = null;
		if(array != null){
			indexes = new Integer[array.length];
			for(int i= 0; i< array.length; i++){
				indexes[i] = i;
			}
		}
		return indexes;
	}
	
	@Override
	public int compare(Integer index1, Integer index2) {
		// TODO Auto-generated method stub
		return array[index1].compareTo(array[index2]);
	}

	
}
