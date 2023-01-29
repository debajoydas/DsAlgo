/**
 * 
 */
package com.debajoy.algo.algorithm.greedy;

import javax.sql.rowset.serial.SerialStruct;

/**
 * @author Debajoy
 *
 */
public class LargestNumberWithSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int N = 3;
		int sum = 26;
		System.out.println(largestNumber(N, sum));

	}
	
    public static String largestNumber(int n, int sum){
    	StringBuilder s = new StringBuilder("");
    	int divideer = sum/9;
    	int remaining = sum%9;
    	int totalMinDigitOfNumber = 0;
    	if(sum < 9){
    		totalMinDigitOfNumber = 1; 
    	}else{
    		if(remaining > 0){
    			totalMinDigitOfNumber = divideer+1;
    		}else{
    			totalMinDigitOfNumber = divideer;
    		}
    	}
    	if(totalMinDigitOfNumber > n){
    		return "-1";
    	}else{
    		while(divideer > 0){
    			s.append("9");
    			divideer--;
    			n--;
    		}
    		while(n > 0){
    			if(remaining > 0){
    				s.append(String.valueOf(remaining));
    				remaining = 0;
    			}else{
    				s.append("0");
    			}
    			n--;
    		}
    	}
    	return s.toString();
    }
}
