/**
 * 
 */
package com.debajoy.algo.algorithm.dp.practice;

/**
 * @author Debajoy
 *
 */
public class CountSubsequences {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abcabc";
		System.out.println(getCountSubSequence(str));
	}
	
	private static int getCountSubSequence(String str){
		int a = 0;
		int ab = 0;
		int abc = 0;
		
		for(int i = 0; i< str.length(); i++){
			if(str.charAt(i) == 'a'){
				a = 2*a + 1;
			}else if(str.charAt(i) == 'b'){
				ab = 2*ab + a;
			}else if(str.charAt(i) == 'c'){
				abc = 2*abc + ab;
			}
		}
		return abc;
	}

}
