/**
 * 
 */
package com.debajoy.ds.heap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Debajoy
 *
 */
public class UglyNumberII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(nthUglyNumber(18));
	}
	
    public static int nthUglyNumber(int n) {
    	Map<Integer,Boolean> map = new HashMap<Integer,Boolean>();
    	int result = 0;
    	int count = 1;
    	if(n == 1){
    		return n;
    	}else{
    		Pairs pair1 = new Pairs(2, 1);
    		Pairs pair2 = new Pairs(3, 1);
    		Pairs pair3 = new Pairs(5, 1);
    		Pairs smallest = pair1;
    		while(count < n){
    			while(isPrime(pair1.index) && (pair1.index != 1 && pair1.index != 2 && pair1.index != 3 && pair1.index != 5)){
    				pair1.increaseIndex();
    				continue;
    			}
    			while(isPrime(pair2.index) && (pair2.index != 1 && pair2.index != 2 && pair2.index != 3 && pair2.index != 5)){
    				pair2.increaseIndex();
    				continue;
    			}
    			while(isPrime(pair3.index) && (pair3.index != 1 && pair3.index != 2 && pair3.index != 3 && pair3.index != 5)){
    				pair3.increaseIndex();
    				continue;
    			}
    			smallest = getMinPair(pair3, getMinPair(pair1, pair2));
    			result = smallest.value;
    			if(!map.containsKey(result)){
    				count++;
    				System.out.println("Count :->"+count+ " ; Result ->"+result);
    			}
    			map.put(result,true);
    			smallest.increaseIndex();
    		}
    		return result; 
    	}
    }
    
    private static boolean isPrime(int n){ 
        if (n <= 1){
        	return false;
        }
             
        for (int i = 2; i < n; i++) {
        	if (n % i == 0){
        		return false;
        	}
        }
        return true; 
    } 
    
    private static Pairs getMinPair(Pairs p1, Pairs p2){
    	if(p1.value > p2.value){
    		return p2;
    	}else{
    		return p1;
    	}
    }

}

class Pairs{	
	int data;
	int index;
	int value;
	public Pairs(int data, int index) {
		super();
		this.data = data;
		this.index = index;
		this.value = data*index;
	}
	public void increaseIndex(){
		this.index++;
		this.value = this.data*this.index;
	}
}
