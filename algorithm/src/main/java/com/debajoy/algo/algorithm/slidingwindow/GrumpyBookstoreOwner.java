/**
 * 
 */
package com.debajoy.algo.algorithm.slidingwindow;

import java.util.Arrays;

/**
 * @author Debajoy
 *
 */
public class GrumpyBookstoreOwner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] customers = {1,0,1,2,1,1,7,5};
		int[] grumpy = {0,1,0,1,0,1,0,1};
		int X = 3;
		System.out.println(maxSatisfied(customers, grumpy, X));

	}

	public static int maxSatisfied(int[] customers, int[] grumpy, int X) {
		
		int sum = 0;
		if(X >= customers.length){
			for(int i = 0; i< grumpy.length; i++){
				sum += customers[i];
			}
			return sum;
		}
		
		int left = 0;
		int right = (left+X-1);
		int maxCustomer = 0;
		for(int i = 0; i< grumpy.length; i++){
			if(grumpy[i] == 0){
				sum += customers[i];
			}
		}
		int sumIndex = sum;
		while(right < grumpy.length){
			if(left-1 < 0){
				for(int i =0; i< X; i++){
					if(grumpy[i] == 1){
						sumIndex += customers[i];
					}
				}
				left++;
				right++;
			}else{
				if(grumpy[left-1] == 1){
					sumIndex -= customers[left-1];
				}
				if(grumpy[right] == 1){
					sumIndex += customers[right];
				}			
				left++;
				right++;
			}
			maxCustomer = Math.max(maxCustomer, sumIndex);
		}
		return maxCustomer;     
    }
}
