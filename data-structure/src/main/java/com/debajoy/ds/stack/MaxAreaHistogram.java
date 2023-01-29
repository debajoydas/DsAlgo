/**
 * 
 */
package com.debajoy.ds.stack;

import java.util.Stack;

/**
 * @author Debajoy
 *
 */
public class MaxAreaHistogram {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] height = {2,1,5,6,2,3};
		System.out.println(largestRectangleArea(height));
	}
	
	public static int largestRectangleArea(int[] height) {
		if(height == null || (height != null && height.length < 1)){
			return 0;
		}else{
			int[] lb = new int[height.length];
			int[] rb = new int[height.length];
			Stack<Integer> stack = new Stack<>();
			stack.push(height.length-1);
			rb[height.length-1] = height.length;
			for(int i = height.length-2; i >= 0; i--){
				while(stack.size() > 0 && height[i] <= height[stack.peek()]){
					stack.pop();
				}
				if(stack.size() <= 0){
					rb[i] = height.length;
				}else{
					rb[i] = stack.peek();
				}
				stack.push(i);
			}
			
			stack = new Stack<>();
			stack.push(0);
			lb[0] = -1;
			for(int i = 1; i < height.length; i++){
				while(stack.size() > 0 && height[i] <= height[stack.peek()]){
					stack.pop();
				}
				if(stack.size() <= 0){
					lb[i] = -1;
				}else{
					lb[i] = stack.peek();
				}
				stack.push(i);
			}
			
			int maxArea = 0;
			for(int i = 0; i < height.length; i++){
				maxArea = Math.max(maxArea, height[i]*(rb[i]-lb[i]-1));
			}
			return maxArea;	
		}
	}

}
