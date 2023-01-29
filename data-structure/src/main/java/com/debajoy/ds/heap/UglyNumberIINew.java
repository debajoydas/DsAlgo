/**
 * 
 */
package com.debajoy.ds.heap;

/**
 * @author Debajoy
 *
 */
public class UglyNumberIINew {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number =  10;
		System.out.println(nthUglyNumber(number));
	}

	private static int nthUglyNumber(int n) {
		// TODO Auto-generated method stub
		int[] uglys = new int[n];
		uglys[0] = 1;
		int _2_P = 0;
		int _3_P = 0;
		int _5_P = 0;
		
		for(int i = 1; i < n; i++){
			int min = Integer.min(2*uglys[_2_P], Integer.min(3*uglys[_3_P], 5*uglys[_5_P]));
			uglys[i] = min;
			if(2*uglys[_2_P] == min){
				_2_P += 1;
			}
			if(3*uglys[_3_P] == min){
				_3_P += 1;
			}
			if(5*uglys[_5_P] == min){
				_5_P += 1;
			}
		}
		return uglys[n-1];
	}

}
