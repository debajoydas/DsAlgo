package com.debajoy.algo.algorithm.combination;

import java.util.ArrayList;
import java.util.List;

public class SubArrayProb {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 2 , 3 , 4};
		int size = arr.length;
		computeAllNonEmptySubArray(arr,size);
	}

	private static void computeAllNonEmptySubArray(int[] arr, int size) {
		// TODO Auto-generated method stub
		System.out.println("Combination of all Subarrays...");
		computeSubArray(arr,0,size);
	}

	private static void computeSubArray(int[] arr, int index, int size) {
		// TODO Auto-generated method stub
		if(arr == null){
			return;
		}
		List<List<Integer>> outpputList = new ArrayList<List<Integer>>();
		while(index < size){
			int innserIdx = index;
			while(innserIdx < size){
				List<Integer> lists = new ArrayList<Integer>();
				for(int i = index; i<=innserIdx; i++){
					lists.add(arr[i]);
				}
				outpputList.add(lists);
				innserIdx++;
			}
			index++;
		}
		outpputList.stream().forEach(l -> {
			l.stream().forEach(e -> System.out.print(e));
			System.out.println();
		});
		System.out.println("Total no. of count :"+outpputList.size());
	}

}
