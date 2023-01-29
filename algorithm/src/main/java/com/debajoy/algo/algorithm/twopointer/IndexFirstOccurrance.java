/**
 * 
 */
package com.debajoy.algo.algorithm.twopointer;

/**
 * @author Debajoy
 *
 */
public class IndexFirstOccurrance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String haystack = "abc";
		String needle = "c";
		System.out.println(strStr(haystack, needle));
	}

    public static int strStr(String haystack, String needle) {
    	int l1 = haystack.length();
        int l2 = needle.length();
        int output = -1;
        if(l2 > l1){
            return output;
        }else if(l2 == l1){
            return haystack.equals(needle) ? 0 : output;
        }
        for(int i = 0; i <= (l1-l2); i++){
            if(haystack.substring(i,i+l2).equals(needle)){
                return i;
            }
        }
        return output;
    }
}
