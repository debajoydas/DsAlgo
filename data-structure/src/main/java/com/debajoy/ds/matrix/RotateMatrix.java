package com.debajoy.ds.matrix;

import java.util.ArrayList;
import java.util.List;

public class RotateMatrix {
	public static void main(String[] args)  
    { 
    int a[][] = { {1, 2, 3, 4}, 
                  {5, 6, 7, 8}, 
                {9, 10, 11, 12}, 
                {13, 14, 15, 16} }; 
    
    int R = 4; int C = 4;
    rotatematrix(R, C, a);  
    }

	private static void rotatematrix(int r, int c, int[][] a) {
		List<Integer> moveElements = new ArrayList<Integer>();
		int c1= 0; int c2 = c-1;
		int r1 = 0; int r2 = r-1;
		
		for(int i = c1; i <= c2; i++){
			
		}
		for(int i = r1; i <= r2; i++){
			
		}
		for(int i = c2; i >= c1; i--){
			
		}
		for(int i = r2; i >= r1; i--){
			
		}
		
	} 
}
