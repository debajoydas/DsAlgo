/**
 * 
 */
package com.debajoy.algo.algorithm.dp.rev1;

/**
 * @author Debajoy
 *
 */
public class TemplateOffering {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] temples = {1,3,6,7,7,10,7,6,5,3,4,6,1,5,9,7,6,4};
		int n = temples.length;
		System.out.println("Minimum Offering to Temples :=> "+getMinimumOffering(temples, n));
	}
	
	public static int getMinimumOffering(int[] temples, int n){
		int minOffering = 0;
		int[] left = new int[n];
		left[0] = 1;
		int[] right = new int[n];
		right[n-1] = 1;
		for(int i = 1;  i< n; i++){
			if(temples[i] > temples[i-1]){
				left[i] = left[i-1] + 1;
			}else{
				left[i] = 1;
			}
		}
		for(int i = n-2; i >=0; i--){
			if(temples[i] > temples[i+1]){
				right[i] = right[i+1] + 1; 
			}else{
				right[i] = 1;
			}
			minOffering += Math.max(right[i], left[i]);
		}
		return minOffering;
	}

}
