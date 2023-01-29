/**
 * 
 */
package com.debajoy.algo.algorithm.recursion;

/**
 * @author dasde
 *
 */
public class PowXandN {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double x = -1;
		int n = -2147483648;
		System.out.println(myPow(x, n));
	}
    public static double myPow(double x, int n) {
    	long nl = n;
        if(nl == 0){
            return 1.0;
        }else if(nl == 1){
            return x;
        }else if (nl < 0){
        	if(n <= Integer.MIN_VALUE) {
        		nl = Integer.MAX_VALUE;
        		x = x*x;
        	}else {
        		nl = -n;
        	}    	
            return myPow(1/x,(int)(nl));
        }else{
            return myPowHelper(x,(int)nl);
        }
    }

    public static double myPowHelper(double x, int n) {
        if(n == 0){
            return 1.0;
        }else if(n == 1){
            return x;
        }
        double result = 1.0;
        if(n%2 != 0){
            result = x*myPowHelper(x*x,n/2);
        }else{
            result = myPowHelper(x*x,n/2);
        }
        return result;
    }

}
