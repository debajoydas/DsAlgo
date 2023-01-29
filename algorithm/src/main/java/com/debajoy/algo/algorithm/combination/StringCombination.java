package com.debajoy.algo.algorithm.combination;

import java.util.Arrays;

public class StringCombination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "ABC"; 
        int n = str.length(); 
        StringCombination permutation = new StringCombination(); 
   //     permutation.permute(str, 0, n-1); 
	}

	private void permute(String str, int i, int j,char[] charArrays) {
		// TODO Auto-generated method stub
		
		if(str == null || str.length() == 0){
			return;
		}
		if(charArrays.length == str.length()){
			for (char c:charArrays) {
				System.out.println(c);
			}
		}
		char[] charArray = str.toCharArray(); 
		char[] charArrayTemp = new char[charArray.length];
		
		for(int index =0; index<str.length(); index++){
			char temp = charArray[i];
			charArrayTemp[index] = temp;
	//		str.charAt(index) = "O";
		}
		
		
	}

}
