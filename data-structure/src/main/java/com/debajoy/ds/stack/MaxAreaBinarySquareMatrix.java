/**
 * 
 */
package com.debajoy.ds.stack;

import java.util.Stack;

/**
 * @author Debajoy
 *
 */
public class MaxAreaBinarySquareMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
		System.out.println(maximalSquare(matrix));
	}
	
	 public static int maximalSquare(char[][] matrix) {
		 if(matrix == null || (matrix != null && matrix.length < 1)){
				return 0;
		 }else{
				int[] histogramArr = new int[matrix[0].length];
				int area = 0;
				for(int i = 0; i < matrix.length; i++){
					for(int j = 0 ; j < matrix[i].length; j++){
						if(matrix[i][j] == '0'){
							histogramArr[j] = 0;
						}else{
							histogramArr[j]++;
						}
					}
					area = Math.max(area, maxAreaInHstogram(histogramArr));
				}
				return area;
		 }	        
	 }

	private static int maxAreaInHstogram(int[] height){
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
				if(height[i] <= (rb[i]-lb[i]-1)){
					maxArea = Math.max(maxArea, height[i]*height[i]);
				}
			}
			return maxArea;	
		}
	}
}
