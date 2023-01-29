/**
 * 
 */
package com.debajoy.algo.algorithm.backtracking;

/**
 * @author Debajoy
 *
 */
public class NQueenProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int board[][] = { { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 } };
		int n = board.length;
		if (solveNQUtil(board, n)) {
            System.out.print("Solution does not exist");
        }
	}

	private static boolean solveNQUtil(int[][] board, int n) {
		boolean[] cols = new boolean[n];
		boolean[] diagonal = new boolean[2*n-1];
		boolean[] revDiagonal = new boolean[2*n-1];
		int row = 0;
		int col = 0;
		return solveNQUtilRec(board,n,row,col,cols,diagonal,revDiagonal);
	}

	private static boolean solveNQUtilRec(int[][] board, int n, int row, int col, boolean[] cols, boolean[] diagonal, boolean[] revDiagonal) {
		if(row == board.length){
			print(board);
			return true;
		}
		for(int c = 0; c < board[row].length; c++){
			if(!isAlreadyExist(board,row,c,cols,diagonal,revDiagonal)){
				board[row][c] = 1;
				cols[c] = true;
				diagonal[row+c] = true;
				revDiagonal[row-c+board.length-1] = true;
				solveNQUtilRec(board, n, row+1, 0, cols, diagonal, revDiagonal);
				board[row][c] = 0;
				cols[c] = false;
				diagonal[row+c] = false;
				revDiagonal[row-c+board.length-1] = false;
			}
		}
		return false;
	}

	private static void print(int[][] board) {
		// TODO Auto-generated method stub
		for(int i = 0; i< board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				System.out.print(board[i][j]+ " ");
			}
			System.out.println();
		}
		
	}

	private static boolean isAlreadyExist(int[][] board, int row, int c, boolean[] cols, boolean[] diagonal,
			boolean[] revDiagonal) {
		// TODO Auto-generated method stub
		if(cols[c]){
			return true;
		}
		if(diagonal[row+c]){
			return true;
		}
		if(revDiagonal[row-c+board.length-1]){
			return true;
		}
		return false;
	}
}
