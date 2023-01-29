/**
 * 
 */
package com.debajoy.algo.algorithm.backtracking;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author dasde
 *
 */
public class SudokuSolution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = 
				{{'5','3','.','.','7','.','.','.','.'},
				{'6','.','.','1','9','5','.','.','.'},
				{'.','9','8','.','.','.','.','6','.'},
				{'8','.','.','.','6','.','.','.','3'},
				{'4','.','.','8','.','3','.','.','1'},
				{'7','.','.','.','2','.','.','.','6'},
				{'.','6','.','.','.','.','2','8','.'},
				{'.','.','.','4','1','9','.','.','5'},
				{'.','.','.','.','8','.','.','7','9'}};
		solveSudoku(board);
	}
	
	public static void solveSudoku(char[][] board) {
        Map<Integer,HashSet<Character>> rowMap = new HashMap<Integer,HashSet<Character>>();
        Map<Integer,HashSet<Character>> colMap = new HashMap<Integer,HashSet<Character>>();
        Map<Integer,HashSet<Character>> smallMap = new HashMap<Integer,HashSet<Character>>();
        AtomicInteger count = new AtomicInteger(0);
        int row = -1;
        int col = -1;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] != '.'){
                    count.incrementAndGet();
                    HashSet<Character> rowSet = rowMap.get(i);
                    if(rowSet == null){
                        rowSet = new HashSet<Character>();
                    }
                    rowSet.add(board[i][j]);
                    rowMap.put(i,rowSet);
                    HashSet<Character> colSet = colMap.get(j);
                    if(colSet == null){
                        colSet = new HashSet<Character>();
                    }
                    colSet.add(board[i][j]);
                    colMap.put(j,colSet);
                    int key = getsmallSetKey(i,j);
                    HashSet<Character> smallSet = smallMap.get(key);
                    if(smallSet == null){
                        smallSet = new HashSet<Character>();
                    }
                    smallSet.add(board[i][j]);
                    smallMap.put(key,smallSet);
                }else{
                    if(row < 0 && col < 0){
                        row = i;
                        col = j;
                    }
                }
            }
        }
        solveSudokuRec(row, col, board, rowMap, colMap, smallMap, count);
    }
	
	private static void print(char[][] board) {
		// TODO Auto-generated method stub
		System.out.println("Sudoku does exist...");
		for(int i =0; i<board.length; i++){
			for(int j = 0; j< board[0].length; j++){
				System.out.print(board[i][j]+" - ");
			}
			System.out.println();
		}
	}
	
    public static void solveSudokuRec(int row, int col, char[][] board, Map<Integer,HashSet<Character>> rowMap,
    Map<Integer,HashSet<Character>> colMap,Map<Integer,HashSet<Character>> smallMap,
    AtomicInteger count) {
        if(row  < 0 || col < 0 || row >= 9 || col >= 9 || board[row][col] != '.'){
            return;
        }
        System.out.println("Count :="+count.get());
        if(count.get() == 80){
        	print(board);
            return;
        }
        
        for(int m = 0; m < 9; m++) {
        	for(int n = 0; n < 9; n++) {
        		if(board[m][n] == '.') {
        			
        		}
        	}
        }
        for(int i = 1; i <= 9 ; i++){
            if(isSudokuRuleSatisfied(row,col,i,rowMap,colMap,smallMap)){
                board[row][col] = Character.valueOf((char) (i+'0'));
                count.incrementAndGet();
                
                HashSet<Character> rowSet = rowMap.get(row);
                rowSet.add(board[row][col]);
                rowMap.put(i,rowSet);
                
                HashSet<Character> colSet = colMap.get(col);
                colSet.add(board[row][col]);
                colMap.put(i,colSet);
                
                HashSet<Character> smallSet = smallMap.get(getsmallSetKey(row, col));
                smallSet.add(board[row][col]);
                smallMap.put(i,smallSet);
                
                solveSudokuRec(row+1,col,board,rowMap,colMap,smallMap,count);
                solveSudokuRec(row-1,col,board,rowMap,colMap,smallMap,count);
                solveSudokuRec(row,col+1,board,rowMap,colMap,smallMap,count);
                solveSudokuRec(row,col-1,board,rowMap,colMap,smallMap,count);
                
                count.decrementAndGet();
                board[row][col] = '.';
                
                HashSet<Character> rowSetAfter = rowMap.get(row);
                rowSetAfter.remove(board[row][col]);
                rowMap.put(i,rowSetAfter);
                
                HashSet<Character> colSetAfter = colMap.get(col);
                colSetAfter.remove(board[row][col]);
                colMap.put(i,colSetAfter);
                
                HashSet<Character> smallSetAfter = smallMap.get(getsmallSetKey(row, col));
                smallSetAfter.remove(board[row][col]);
                smallMap.put(i,smallSetAfter);
                
            }
        }
    }
    public static boolean isSudokuRuleSatisfied(int row, int col, int number, Map<Integer,HashSet<Character>> rowMap,
    Map<Integer,HashSet<Character>> colMap,Map<Integer,HashSet<Character>> smallMap){
        if(rowMap.get(row).contains(number)){
            return false;
        }
        if(colMap.get(col).contains(number)){
            return false;
        }
        if(smallMap.get(getsmallSetKey(row,col)).contains(number)){
            return false;
        }
        return true;
    }
    public static int getsmallSetKey(int row, int col){
        int key = 0;
        if(row >= 0 && row <= 2 && col >= 0 && col <= 2){
            key = 0;
        }else if(row >= 3 && row <= 5 && col >= 0 && col <= 2){
            key = 1;
        }else if(row >= 6 && row <= 8 && col >= 0 && col <= 2){
            key = 2;
        }else if(row >= 0 && row <= 2 && col >= 3 && col <= 5){
            key = 3;
        }else if(row >= 3 && row <= 5 && col >= 3 && col <= 5){
            key = 4;
        }else if(row >= 6 && row <= 8 && col >= 3 && col <= 5){
            key = 5;
        }else if(row >= 0 && row <= 2 && col >= 6 && col <= 8){
            key = 6;
        }else if(row >= 3 && row <= 5 && col >= 6 && col <= 8){
            key = 7;
        }else if(row >= 6 && row <= 8 && col >= 6 && col <= 8){
            key = 8;
        }
        return key;
    }

}
