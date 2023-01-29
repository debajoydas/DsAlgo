/**
 * 
 */
package com.debajoy.ds.array;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author dasde
 *
 */
public class WordSearchII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = {{'a','b','c'},{'a','e','d'},{'a','f','g'}};
		String[] words = {"eaabcdgfa"};
		System.out.println(findWords(board, words));
	}

    public static List<String> findWords(char[][] board, String[] words) {
        List<String> list = new ArrayList<String>();
        for(String word : words){
            char firstChar = word.charAt(0);
            AtomicBoolean flag = new AtomicBoolean(false);
            for(int i = 0; i < board.length; i++){
                if(flag.get()){
                    break;
                }
                for(int j = 0; j < board[0].length; j++){
                    if(board[i][j] == firstChar){
                    	boolean[][] isVisited = new boolean[board.length][board[0].length];
                        findWordsHelper(i,j,0,word,board,list,flag,isVisited);
                        if(flag.get()){
                            break;
                        }
                    }
                }
            }
        }
        return list;
    }

    public static void findWordsHelper(int row, int col, int idx, String word, char[][] board, 
    		List<String> list,AtomicBoolean flag,  boolean[][] isVisited){
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length 
        		|| idx < 0 || idx >= word.length() || isVisited[row][col]){
            return;
        }
        if(idx == 7) {
        	System.out.println(idx);	
        }
        if(word.charAt(idx) != board[row][col]){
            return;
        }
        isVisited[row][col] = true;
        if(idx == word.length()-1){
            flag.set(true);
            list.add(word);
        }
        findWordsHelper(row+1,col,idx+1,word,board,list,flag,isVisited);
        findWordsHelper(row-1,col,idx+1,word,board,list,flag,isVisited);
        findWordsHelper(row,col+1,idx+1,word,board,list,flag,isVisited);
        findWordsHelper(row,col-1,idx+1,word,board,list,flag,isVisited);
        isVisited[row][col] = false;
    }
}
