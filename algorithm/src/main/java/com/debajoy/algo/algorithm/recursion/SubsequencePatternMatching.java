/**
 * 
 */
package com.debajoy.algo.algorithm.recursion;

/**
 * @author Debajoy
 *
 */
public class SubsequencePatternMatching {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findSPMCount("baxmx", "ax"));
	    System.out.println(findSPMCount("tomorrow", "tor"));
	    System.out.println(findSPMCount("", "tor"));
	    System.out.println(findSPMCount("tomorrow", ""));
	    System.out.println(findSPMCount("AX", "AX"));
	}

	private static int findSPMCount(String string, String pattern) {
		// TODO Auto-generated method stub
		if(string == null || (string != null && string.equals("")) || pattern == null || (pattern != null && pattern.equals(""))){
			return 0;
		}
		int stringIndex = 0;
		int patternIndex = 0;
		Integer[][] table = new Integer[string.length()][pattern.length()];
		return findSPMCountRecursion(table, string, pattern, stringIndex, patternIndex);
	}

	private static int findSPMCountRecursion(Integer[][] table, String string, String pattern, int stringIndex, int patternIndex) {
		// TODO Auto-generated method stub
		
		if(stringIndex >= string.length() && patternIndex < pattern.length()){
			return 0;
		}
		if(patternIndex == pattern.length()){
			return 1;
		}
		int count1 = 0;
		
		if(table[stringIndex][patternIndex] == null){
			if(string.charAt(stringIndex) == pattern.charAt(patternIndex)){
				count1 = findSPMCountRecursion(table, string, pattern, stringIndex+1, patternIndex+1);
			}
			int count2 = findSPMCountRecursion(table, string, pattern, stringIndex+1, patternIndex);
			table[stringIndex][patternIndex] = count1+count2;
		}
		return table[stringIndex][patternIndex];
	}

}
