/**
 * 
 */
package com.debajoy.algo.algorithm.backtracking;

/**
 * @author Debajoy
 *
 */
public class Sudoku {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int grid[][] = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
			solveSuduko(grid, 0, 0);

	}

	private static void print(int[][] grid) {
		// TODO Auto-generated method stub
		System.out.println("Sudoku does exist...");
		for(int i =0; i<grid.length; i++){
			for(int j = 0; j< grid[0].length; j++){
				System.out.print(grid[i][j]+" - ");
			}
			System.out.println();
		}
	}

	private static void solveSuduko(int[][] grid, int i, int j) {
		// TODO Auto-generated method stub
		if(i == grid.length){
			print(grid);
			return;
		}
		int ni = 0; 
		int nj = 0;
		if(j >= grid[0].length-1){
			ni = i+1;
			nj = 0;
		}else{
			ni = i;
			nj = j+1;
		}
		if(grid[i][j] != 0){
			solveSuduko(grid, ni, nj);
		}else{
			for(int k = 1; k <= 9; k++){
				if(isValid(grid,i,j,k)){
					grid[i][j] = k;
					solveSuduko(grid, ni, nj);
					grid[i][j] = 0;
				}
			}
		}
	}

	private static boolean isValid(int[][] grid, int i, int j, int value) {
		// TODO Auto-generated method stub
		for(int k = 0; k < grid[i].length; k++){
			if(grid[i][k] == value){
				return false;
			}
		}
		for(int k = 0; k < grid.length; k++){
			if(grid[k][j] == value){
				return false;
			}
		}
		int startRow = 3*(i/3);
		int startCol = 3*(j/3);
		
		for(int m = startRow; m < (startRow+3); m++){
			for(int n = startCol; n < (startCol+3); n++){
				if(grid[m][n] == value){
					return false;
				}
			}
		}
		return true;
	}

}
