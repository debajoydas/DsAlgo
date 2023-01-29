/**
 * 
 */
package com.debajoy.algo.algorithm.slidingwindow;

/**
 * @author Debajoy
 *
 */
public class MaximumPointsCards {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] cardPoints = {1,79,80,1,1,1,200,1};
		int k = 3;
		System.out.println(maxScore(cardPoints, k));
	}

	public static int maxScore(int[] cardPoints, int k) {
	        
		int leftSum = 0;
		int rightSum = 0;
		int sum = 0;
		if(k > cardPoints.length){
			for(int i = 0; i< cardPoints.length; i++){
				sum += cardPoints[i];
			}
			return sum;
		}
		for(int i = 0; i< k; i++){
			sum += cardPoints[i];
		}
		int maxScore = sum;
		int index = 1;
		while(index <= k){
			leftSum += cardPoints[k-index];
			rightSum += cardPoints[cardPoints.length-index];
			maxScore = Math.max(maxScore, (sum-leftSum+rightSum));
			index++;
		}
		return maxScore;
	}
}
