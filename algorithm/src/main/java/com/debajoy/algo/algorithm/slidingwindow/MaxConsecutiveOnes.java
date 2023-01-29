/**
 * 
 */
package com.debajoy.algo.algorithm.slidingwindow;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Debajoy
 *
 */
public class MaxConsecutiveOnes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] A = {0,0,1,1,1,0,0};
		int K = 0;

		System.out.println(longestOnes(A, K));
	}

	private static int longestOnes(int[] arr, int k) {
		// TODO Auto-generated method stub
		if(arr == null){
			return 0;
		}
		int left = 0;
		int right = 0;
		int maxLength = 0;
		List<Integer> lastPositionOfZero = new ArrayList<Integer>();
		int kRec = k;
		
		while(right < arr.length){
			if(arr[right] == 1){	
				maxLength = Math.max(maxLength, right-left+1);
				right++;
			}else if(arr[right] == 0){
				if(k > 0){
					if(kRec > 0){
						if(lastPositionOfZero.size() <= 0){
							lastPositionOfZero.add(right);
						}
						maxLength = Math.max(maxLength, right-left+1);
						right++;
						kRec--;
					}else{
						kRec = k;
						left = lastPositionOfZero.get(0)+1;
						right = left;
						lastPositionOfZero.clear();
					}
				}else{
					left = right+1;
					right = left;
				}

			}
		}
		
		return maxLength;
	}

}
