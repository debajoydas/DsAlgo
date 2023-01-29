/**
 * 
 */
package com.debajoy.algo.algorithm.twopointer;

/**
 * @author Debajoy
 *
 */
public class ContainerWithMostWater {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] height = {2,3,4,5,18,17,6};
		System.out.println(maxArea(height));

	}

	 public static int maxArea(int[] height) {
		
		int left = 0;
		int right = height.length-1;
		int maxWaterArea = 0;
		
		if(height == null || (height != null && (height.length <= 1))){
			return 0;
		}
		
		while(left < right){
			if(height[left] < height[right]){
				maxWaterArea = Math.max(maxWaterArea, height[left]*(right-left));
				left++;
			}else{
				maxWaterArea = Math.max(maxWaterArea, height[right]*(right-left));
				right--;
			}
		}
		return maxWaterArea;        
	 }
}
