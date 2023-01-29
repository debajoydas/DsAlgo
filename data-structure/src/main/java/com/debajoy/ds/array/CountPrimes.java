/**
 * 
 */
package com.debajoy.ds.array;

/**
 * @author dasde
 *
 */
public class CountPrimes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 1000000000;
		System.out.println(countPrimes(n));
	}
    public static int countPrimes(int n) {
        if(n <= 1){
            return 0;
        }
        int countPrime = 0;
        boolean[] arr = new boolean[n+1];
        for(int i = 2; i*i < n; i++){
            if(!arr[i]){
                for(int j = i*i ; j <= n; j+=i){
                    arr[j] = true;
                }           
            }
        }
        for(int i = 2; i < n; i++){
            if(!arr[i]){
                countPrime++;         
            }
        }

        return countPrime;
    }
}
