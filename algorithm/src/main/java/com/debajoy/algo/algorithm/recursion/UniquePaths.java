/**
 * 
 */
package com.debajoy.algo.algorithm.recursion;

/**
 * @author Debajoy
 *
 */
public class UniquePaths {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(uniquePaths(52,9));
	}

    public static int uniquePaths(int m, int n) {
        return recUniquePaths(0,0,m,n);
    }

	private static int recUniquePaths(int i, int j, int m, int n) {
		// TODO Auto-generated method stub
		if(i >= (m-1)){
			return 1;
		}else if(j >= (n-1)){
			return 1;
		}else{
			return recUniquePaths(i+1, j, m, n)+recUniquePaths(i, j+1, m, n);
		}
	}
}
