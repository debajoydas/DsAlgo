package com.debajoy.ds.matrix;

public class SpiralMatrix {
	
	public static void main(String[] args) 
    { 
        int R = 3; 
        int C = 6; 
        int a[][] = { { 1, 2, 3, 4, 5, 6 }, 
                      { 7, 8, 9, 10, 11, 12 }, 
                      { 13, 14, 15, 16, 17, 18 } }; 
        spiralPrint(R, C, a); 
    }

	private static void spiralPrint(int row, int column, int[][] a) {
		// TODO Auto-generated method stub
		
		int currentRow = 0;
		int currentColumn = 0;
		
		while(currentRow < row && currentColumn < column ){
			if(currentRow < row-1){
				for(int i=currentColumn; i< column; i++){
					System.out.print(a[currentRow][i]+"->");
				}
				currentRow++;
			}
			if(currentColumn < column-1){
				for(int i = currentRow; i< row; i++){
					System.out.print(a[i][column-1]+"->");
				}
				column--;
			}

			if(currentRow < row-1){
				for(int i = (column-1); i>= currentColumn; i--){
					System.out.print(a[row-1][i]+"->");
				}
				row--;
			}
			if(currentColumn < column-1){
				for(int i = (row - 1); i>= currentRow; i--){
					System.out.print(a[i][currentColumn]+"->");
				}	
				currentColumn++;
			}
		}
		
	} 

}
