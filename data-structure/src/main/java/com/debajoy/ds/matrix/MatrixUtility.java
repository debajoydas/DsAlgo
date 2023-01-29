/**
 * 
 */
package com.debajoy.ds.matrix;

/**
 * @author Debajoy
 *
 */
public class MatrixUtility {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int R = 4; 
        int C = 4; 
        int a[][] = { { 1, 3, 4, 8 }, 
                      { 2, 4, 6, 10 }, 
                      { 3, 5, 7, 12 },
                      { 10, 6, 8, 13 }}; 
        int a1[][] = { {1,2,3,4}, 
                {5,6,7,8}, 
                {9,10,11,12},
                {13,14,15,16}}; 
        int a1new[][] = { {1,2,3,4}, 
                {5,6,7,8}, 
                {9,10,11,12},
                {13,14,15,16}}; 
        
        int[][] matrix1 = { {1,2,3,4}, 
                {5,6,7,8}, 
                {9,10,11,12},
                {13,14,15,16}};
        int[][] matrix2 = { {1,2,3,4}, 
                {5,6,7,8}, 
                {9,10,11,12},
                {13,14,15,16}};
        
        int[][] matrix3 = { {1,2,3,4}, 
                {5,6,7,8}, 
                {9,10,11,12}};
        int row3 = 3; int col3 = 4;
        int[][] matrix4 = { {1,2,3}, 
                {5,6,7}, 
                {9,10,11},
                {13,14,15}};
        int row4 = 4; int col4 = 3;
        
        System.out.println("Rotation 90 Degree AntiClockWise Of Matrix Space Optimized");
        printMatrix(rotateMatrixSpaceOptimized(a1new,R,C),R,C);
        System.out.println("<------------------------------------------------------------------>");
        
        
        System.out.println("Rotation 90 Degree AntiClockWise Of Matrix");
        printMatrix(rotateMatrix(a1,R,C),R,C);
        System.out.println("<------------------------------------------------------------------>");
        
        System.out.println("Multiplication Of Matrix");
        printMatrix(multiplyMatrix(matrix3,matrix4, row3, col3, row4, col4),row3,col4);
        
        int[][] matrix5 = { {1,2,1}, 
                {0,1,0}};
        int row5 = 2; int col5 = 3;
        int[][] matrix6 = { {1,2}, 
                {0,1},
                {2,1}};
        int row6 = 3; int col6 = 2;
        
        System.out.println("Multiplication Of Matrix");
        printMatrix(multiplyMatrix(matrix5,matrix6, row5, col5, row6, col6),row5,col6);
        System.out.println("<------------------------------------------------------------------>");
        
        int r1= 4; int c1=4;
        System.out.println("Sum Of Matrix");
        printMatrix(sumMatrix(matrix1,matrix2, r1, c1),r1,c1);
        System.out.println("<------------------------------------------------------------------>");
        int search = 5;
        System.out.println(getPositionFromSortedMatrix(a, R, C, search));
        System.out.println("<------------------------------------------------------------------>");
        spriralMatrix(a1, R, C);
        
	}

	private static int[][] rotateMatrix(int[][] a1, int r, int c) {
		// TODO Auto-generated method stub
		int[][] rotateMatrix = new int[r][c];
		for(int i = 0; i< r; i++){
			for(int j = 0; j< c; j++){
				rotateMatrix[i][j] = a1[j][c-i-1];
			}
		}
		return rotateMatrix;
	}
	
	private static int[][] rotateMatrixSpaceOptimized(int[][] a1, int r, int c) {
		// Create a Transpose Matrix without extra space
		for(int i = 0; i < c; i++){
			for(int j = i; j< r; j++){
				int temp = a1[i][j];
				a1[i][j] = a1[j][i];
				a1[j][i] = temp;
			}
		}
		// reverse the matrix 
		for(int i = 0; i < c; i++){
			for(int j = 0; j < r/2 ; j++){
				int temp = a1[j][i];
				a1[j][i] = a1[r-j-1][i];
				a1[r-j-1][i] = temp;
			}
		}
		return a1;
		
	}

	private static int[][] multiplyMatrix(int[][] matrix3, int[][] matrix4, int row3, int col3, int row4, int col4) {
		// TODO Auto-generated method stub
		if(col3 != row4){
			return null;
		}
		int[][] mul = new int[row3][col4];
		for(int i = 0; i< row3; i++){
			for(int j = 0; j< col4; j++){
				for(int k = 0; k< col3; k++){
					mul[i][j] += matrix3[i][k]*matrix4[k][j];
				}
			}
		}
		return mul;
	}

	private static int[][] sumMatrix(int[][] matrix1, int[][] matrix2, int r1, int c1) {
		// TODO Auto-generated method stub
		int[][] sumMatrix = new int[r1][c1];
		for(int i = 0; i< r1; i++){
			for(int j = 0; j< c1; j++){
				sumMatrix[i][j] = matrix1[i][j]+matrix2[i][j];
			}
		}
		return sumMatrix;
	}

	private static void spriralMatrix(int[][] a, int r, int c) {
		// TODO Auto-generated method stub
		int rowIndex = 0;
		int colIndex = 0;
		
		while(rowIndex < r && colIndex < c){
			for(int i = colIndex; i < c; i++){
				System.out.println(a[rowIndex][i]);
			}
			rowIndex++;
			for(int i = rowIndex; i < r; i++){
				System.out.println(a[i][c-1]);
			}
			c--;
			if(rowIndex < r){
				for(int i = c-1; i >=  colIndex; i--){
					System.out.println(a[r-1][i]);
				}
			    r--;
			}
			if(colIndex < c){
				for(int i = r-1; i>= rowIndex; i--){
					System.out.println(a[i][colIndex]);
				}
				colIndex++;
			}
		}
	}
	
	public static void printMatrix(int a[][], int row, int col){
		for(int i = 0;  i< row; i++){
			for(int j = 0; j< col; j++){
				System.out.print(a[i][j]+ " ");
			}
			System.out.println();
		}
	}

	private static String getPositionFromSortedMatrix(int[][] a, int r, int c, int search) {
		// TODO Auto-generated method stub
		int rIndex = 0;
		int cIndex = c-1;
		
		while(rIndex < r){
			if(a[rIndex][cIndex] == search){
				return "Found || Row :" +rIndex + " Col :"+cIndex;
			}else if(a[rIndex][cIndex] > search){
				cIndex--;
			}else if(a[rIndex][cIndex] < search){
				rIndex++;
			}
		}
		return "Not found";
	}

}
