package com.debajoy.algo.algorithm.greedy;

import java.util.Arrays;
import java.util.Collections;

import com.debajoy.algo.algorithm.comparator.ArrayIndexComparatorDecending;

public class JobScheduling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] jobids = {1,2,3,4,5};
		Integer[] deadLines = {2,1,2,1,3};
		Integer[] profits = {100,19,27,25,15};
		
		System.out.println(getMaximumProfit(jobids, deadLines, profits));
	}

	public static Integer getMaximumProfit(Integer[] jobids, Integer[] deadLines, Integer[] profits){
		if(jobids == null && deadLines == null && profits == null){
			return 0;
		}
		
		int profit = 0;
		int count = 0;
		boolean[] isBlocked = new boolean[profits.length];
		for(int i = 0; i< profits.length; i++){
			isBlocked[i] = false;
		}
		ArrayIndexComparatorDecending comparator = new ArrayIndexComparatorDecending(profits);
		Integer[] indexArray = comparator.createIndexArray();
		Arrays.sort(indexArray,comparator);
		Arrays.sort(profits,Collections.reverseOrder());
		Integer[] jobidsNew = new Integer[profits.length];
		Integer[] deadLinesNew = new Integer[profits.length];
		for(int i = 0; i<indexArray.length; i++){
			jobidsNew[i] = jobids[indexArray[i]];
			deadLinesNew[i] = deadLines[indexArray[i]];
		}
		
		for(int i = 0; i<profits.length; i++){
			int deadline = deadLinesNew[i];
			if(!isBlocked[deadline]){
				profit += profits[i];
				count++;
				isBlocked[deadline] = true;
			}else{
				int j = deadline;
				while( j > 0){
					if(!isBlocked[j]){
						profit += profits[i];
						count++;
						isBlocked[j] = true;
						break;
					}
					j--;
				}
			}
		}
		
		return profit;
	}
}

