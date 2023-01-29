package com.debajoy.algo.algorithm.brainteaser;

public class NimGame {
    public static void main( String[] args )
    {
        System.out.println(canWinNim(4));
    }
    
    public static boolean canWinNim(int n) {
    	int sum = 0;
    	int you = 0;
    	return canWinNimRec(n,sum,you);     
    }

	private static boolean canWinNimRec(int n, int sum, int you) {
		// TODO Auto-generated method stub
		if(sum >= n){
			if(you%2 != 0){
				return true;
			}else{
				return false;
			}
		}
		boolean isTrue = false;
		for(int i = 3; i>= 1; i--){
			int sumIter = sum;
			isTrue = canWinNimRec(n, sum+i, you+1);
			if(isTrue || sumIter >= n){
				break;
			}
		}
		return isTrue;
	}
}

