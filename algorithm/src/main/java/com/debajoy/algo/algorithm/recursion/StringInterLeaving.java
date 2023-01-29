/**
 * 
 */
package com.debajoy.algo.algorithm.recursion;

/**
 * @author Debajoy
 *
 */
public class StringInterLeaving {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findSI("abd", "cef", "abcdef"));
	    System.out.println(findSI("abd", "cef", "adcbef"));
	    System.out.println(findSI("abc", "def", "abdccf"));
	    System.out.println(findSI("abcdef", "mnop", "mnaobcdepf"));
	}

	private static boolean findSI(String m, String n, String p) {
		// TODO Auto-generated method stub
		if(m == null || n == null || p == null){
			return false;
		}
		if(m != null && n != null && p != null && (m.length()+n.length()) > p.length()){
			return false;
		}
		int mIndex = 0;
		int nIndex = 0;
		int pIndex = 0;
		
		return findRecursive(m,n,p,mIndex,nIndex,pIndex);
	}

	private static boolean findRecursive(String m, String n, String p, int mIndex, int nIndex, int pIndex) {
		// TODO Auto-generated method stub
		if(mIndex == m.length() && nIndex == n.length() && pIndex == p.length()){
			return true;
		}
		if(pIndex == p.length()){
			return false;
		}
		if(mIndex < m.length() && m.charAt(mIndex) == p.charAt(pIndex)){
			return findRecursive(m, n, p, mIndex+1, nIndex, pIndex+1);
		}else if(nIndex < n.length() && n.charAt(nIndex) == p.charAt(pIndex)){
			return findRecursive(m, n, p, mIndex, nIndex+1, pIndex+1);
		}else{
			return false;
		}
	}

}
