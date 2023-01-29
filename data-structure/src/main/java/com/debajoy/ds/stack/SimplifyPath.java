/**
 * 
 */
package com.debajoy.ds.stack;

/**
 * @author Debajoy
 *
 */
public class SimplifyPath {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		System.out.println(simplifyPath("/a/./b/../../c////"));
//		System.out.println(simplifyPath("/a/../../b/../c//.//"));
//		System.out.println(simplifyPath("/../"));
//		System.out.println(simplifyPath("/home/"));
//		System.out.println(simplifyPath("/home//foo/"));
//		System.out.println(simplifyPath("/a/./b/../../c/"));
		System.out.println(simplifyPath("/a/../../b/../c//.//"));
		System.out.println(simplifyPath("/a//b////c/d//././/.."));
	}
	
    public static String simplifyPath(String path) {
		return isRule6Passed(isRule5Passed(isRule4Passed(isRule3Passed(isRule2Passed(isRule1Passed(path))))));
        
    }

	public static String isRule1Passed(String input){
		String pattern1 = "/./";
		String temp = input;
		while(input.length() > 0 && input.contains(pattern1)){
			input = input.replace(pattern1, "/");
		}
		if(input.length() <= 0){
			return temp;
		}
		return input;
	}
	public static String isRule2Passed(String input){
		String pattern1 = "/../";
		String pattern2 = "/..";
		String temp = input;
		while(input.length() > 0 && input.contains(pattern1)){
			int index = input.indexOf(pattern1);
			index -= 1;
			input = input.replaceFirst(pattern1, "");
			StringBuilder sb =  new StringBuilder(input);
			while(index >= 0 && sb.charAt(index) == '/'){
				sb.deleteCharAt(index);
				index -= 1;
			}
			if(index >= 0){
				sb.deleteCharAt(index);	
			}
			input = sb.toString();
		}
		while(input.length() > 0 && input.contains(pattern2)){
			int index = input.indexOf(pattern2);
			index -= 1;
			input = input.replaceFirst(pattern2, "");
			StringBuilder sb =  new StringBuilder(input);
			while(index >= 0 && sb.charAt(index) == '/'){
				sb.deleteCharAt(index);
				index -= 1;
			}
			if(index >= 0){
				sb.deleteCharAt(index);	
			}
			input = sb.toString();
		}
		if(input.length() <= 0){
			return temp;
		}
		return input;
	}
	public static String isRule3Passed(String input){
		String pattern = ".";
		String temp = input;
		while(input.length() > 0 && input.contains(pattern)){
			input = input.replace(pattern, "");
		}
		if(input.length() <= 0){
			return temp;
		}
		return input;
	}
	public static String isRule4Passed(String input){
		String pattern = "//";
		String temp = input;
		while(input.length() > 0 && input.contains(pattern)){
			input = input.replace(pattern, "/");
		}
		if(input.length() <= 0){
			return temp;
		}
		return input;
	}
	public static String isRule5Passed(String input){
		String temp = input;
		while(input.length() > 0 && input.charAt(input.length()-1) == '/'){
			input = input.substring(0,input.length()-1);
		}
		if(input.length() <= 0){
			return temp;
		}
		return input;
	}
	public static String isRule6Passed(String input){
		if(input.length() > 0 && input.charAt(0) != '/'){
			input = "/".concat(input);
		}
		return input;
	}
}
