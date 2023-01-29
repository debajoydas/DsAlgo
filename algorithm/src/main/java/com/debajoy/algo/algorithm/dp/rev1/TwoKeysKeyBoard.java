/**
 * 
 */
package com.debajoy.algo.algorithm.dp.rev1;

/**
 * @author Debajoy
 *
 */
public class TwoKeysKeyBoard {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 20;
		

	}

	public static int minSteps(int n) {
		int ans = 0;
		for(int i = 2; i*i <= n;){
			if(n%i == 0){
				ans += i;
				n /= i;
			}else{
				i++;
			}
		}
		if(n != 1){
			ans += n;
		}
        return ans;
    }
}
