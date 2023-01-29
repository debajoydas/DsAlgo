/*
 * 
 */
package com.debajoy.ds.array;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author dasde
 *
 */
public class WordSearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		String word = "ABCCED";
		System.out.println(exist(board, word));

	}
	   public static boolean exist(char[][] board, String word) {
	        AtomicBoolean flag = new AtomicBoolean(false);
	        boolean[][] isVisited = new boolean[board.length][board[0].length];
	        for(int i = 0; i < board.length; i++){
	            for(int j = 0; j < board[0].length; j++){
	                if(board[i][j] == word.charAt(0) && !flag.get()){
	                    existHelper(i,j,0,board,word,isVisited,flag);
	                }
	            }
	        }
	        return flag.get();
	    }

	    public static void existHelper(int i, int j , int idx, char[][] board, String word, boolean[][] isVisited,AtomicBoolean flag) {
	        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || idx < 0 || idx >= word.length()
	        || isVisited[i][j] || flag.get()){
	            return;
	        }
	        if(board[i][j] != word.charAt(idx)){
	            return;
	        }
	        if(idx == word.length()-1){
	            if(board[i][j] == word.charAt(idx)){
	                flag.set(true);
	                return;
	            }
	        }
	        isVisited[i][j] = true;
	        existHelper(i+1, j, idx+1, board,word,isVisited,flag);
	        existHelper(i-1, j, idx+1, board,word,isVisited,flag);
	        existHelper(i, j+1, idx+1, board,word,isVisited,flag);
	        existHelper(i, j-1, idx+1, board,word,isVisited,flag);
	        isVisited[i][j] = false;
	    }

}
