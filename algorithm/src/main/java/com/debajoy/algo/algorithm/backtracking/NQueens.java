/**
 * 
 */
package com.debajoy.algo.algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dasde
 *
 */
public class NQueens {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		List<List<String>> answer = solveNQueens(n);
		display(answer);

	}
	
    private static void display(List<List<String>> answer) {
		// TODO Auto-generated method stub
		for(List<String> list : answer) {
			System.out.println("*****");
			for(String str : list) {
				System.out.println(str);
			}			
		}
	}

	public static List<List<String>> solveNQueens(int n) {
        List<List<String>> answer = new ArrayList<List<String>>();
        boolean[] rowSet = new boolean[n];
        boolean[] colSet = new boolean[n];
        boolean[] fwdDSet = new boolean[2*n-1];
        boolean[] backDSet = new boolean[2*n-1];
        int[][] arr = new int[n][n];
        solveNQueensHelper(0,0,n,rowSet,colSet,fwdDSet,backDSet,arr,answer);
        return answer;
    }

    public static void solveNQueensHelper(int i, int j, int n, boolean[] rowSet, boolean[] colSet,
    boolean[] fwdDSet,boolean[] backDSet,int[][] arr,List<List<String>> answer) {
        if(i < 0 || j < 0 || i > n || j >= n){
            return;
        }
        if(i == n){
            List<String> listString = new ArrayList<String>();
            for(int x = 0; x < n; x++){
                StringBuilder sb = new  StringBuilder();
                for(int y = 0; y < n; y++){
                    if(arr[x][y] != 1){
                        sb.append(".");
                    }else{
                        sb.append("Q");
                    }                 
                }
                listString.add(sb.toString());
            }
            answer.add(listString);
            return;
        }
        for(int s = 0; s < n; s++){
            int fwdIdx = (n-i+s-1);
            int backIdx = (s+i);
            if(!rowSet[i] && !colSet[s] && !fwdDSet[fwdIdx] && !backDSet[backIdx]){
                arr[i][s] = 1;
                rowSet[i] = true;
                colSet[s] = true;
                fwdDSet[fwdIdx] = true;
                backDSet[backIdx] = true;
                solveNQueensHelper(i+1,s,n,rowSet,colSet,fwdDSet,backDSet,arr,answer);
                backDSet[backIdx] = false;
                fwdDSet[fwdIdx] = false;
                colSet[s] = false;
                rowSet[i] = false;
                arr[i][s] = 0;
            }
        }

    }

}
