/**
 * 
 */
package com.debajoy.ds.matrix;

/**
 * @author Debajoy
 *
 */
public class TransposeMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int R = 3; 
        int C = 6; 
        int a[][] = { { 1, 2, 3, 4, 5, 6 }, 
                      { 7, 8, 9, 10, 11, 12 }, 
                      { 13, 14, 15, 16, 17, 18 } }; 
        int[][] aT = transposePrint(R, C, a); 
        printMatrix(a, R, C);
        printMatrix(aT, C, R);
	}
	
	public static void printMatrix(int a[][], int row, int col){
		for(int i = 0;  i< row; i++){
			for(int j = 0; j< col; j++){
				System.out.print(a[i][j]+ " ");
			}
			System.out.println();
		}
	}

	private static int[][] transposePrint(int r, int c, int[][] a) {
		int[][] aT = new int[c][r];
		for(int i = 0; i < c; i++){
			for(int j = 0; j< r; j++){
				aT[i][j] = a[j][i];
			}
		}
		return aT;
	}

}
