/**
 * 
 */
package com.debajoy.algo.algorithm.math;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Debajoy
 *
 */
public class UglyNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(nthUglyNumber(4, 2, 3, 4));
	}

    public static int nthUglyNumber(int n, int a, int b, int c) {
    	int count = 0;
    	int output = 0;
    	Ugly[] uglyArr = {new Ugly(a, 1),new Ugly(b, 1),new Ugly(c, 1)};
    	
    	while(count < n){
    		sortArray(uglyArr);
    		if(output == uglyArr[0].v * uglyArr[0].factor){
    			uglyArr[0] = new Ugly(uglyArr[0].v, uglyArr[0].factor+1);	
    			continue;
    		}
    		output = uglyArr[0].v * uglyArr[0].factor;
    		uglyArr[0] = new Ugly(uglyArr[0].v, uglyArr[0].factor+1);	
    		count++;
    	}
    	return output;
    }
    
    private static void sortArray(Ugly[] uglyArr){
    	Arrays.sort(uglyArr, new Comparator<Ugly>() {
			@Override
			public int compare(Ugly o1, Ugly o2) {
				// TODO Auto-generated method stub
				return Integer.valueOf(o1.v*o1.factor).compareTo(Integer.valueOf(o2.v*o2.factor));
			}
		});
    }
}

class Ugly{
	int v;
	int factor;
	int mult;
	public Ugly(int v, int factor) {
		super();
		this.v = v;
		this.factor = factor;
		this.mult = this.v*this.factor;
	}
	public int getV() {
		return v;
	}
	public void setV(int v) {
		this.v = v;
	}
	public int getFactor() {
		return factor;
	}
	public void setFactor(int factor) {
		this.factor = factor;
	}
	public boolean isEqual(Ugly o1){
		return (this.mult == o1.mult);
	}
}
