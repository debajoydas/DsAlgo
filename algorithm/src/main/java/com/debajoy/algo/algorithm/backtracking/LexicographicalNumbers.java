package com.debajoy.algo.algorithm.backtracking;

public class LexicographicalNumbers {
	public static void main(String[] args) {
		int n = 1000;
        for(int i = 1; i <= 9; i++){
            lexioGraphic(i,n);
        }
		
	}
	private static void lexioGraphic(int i, int n){
	    if(i > n){
	        return;
	    }
	    System.out.println(i);
	    for(int j = 0; j < 10;j++){
	        lexioGraphic(i*10+j,n);
	    }
	}
}
