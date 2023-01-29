/**
 * 
 */
package com.debajoy.algo.algorithm.dp.rev1;

import java.util.List;
import java.util.Set;

/**
 * @author Debajoy
 *
 */
public class MinCostToCustAStick {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 7;
		int[] cuts = {3,4,5,1};
		System.out.println("Minimum Cost to Cut a Stick := "+minCost(n, cuts));
	}
	
	public static int minCost(int n, int[] cuts) {
		int l = 0; 
		int r = n;
		int cut = 0;
	//	minCostRec(l, r, cut, cuts, n);
        return 0;
    }

	private static int minCostRec(int l, int r, int[] cuts, int n, Set<Integer> set) {
		// TODO Auto-generated method stub
		
		int costMin= 0;
		for(int i = 0; i < cuts.length; i++){
			if(!set.contains(cuts[i])){
				set.add(cuts[i]);
				int costLeft = minCostRec(l, cuts[i], cuts, n, set);
				int costRight = minCostRec(cuts[i]+1, r, cuts, n, set);
				costMin = Math.min(costMin, costLeft+costRight);
				set.remove(cuts[i]);	
			}
		}
		return (r-l)+costMin;
	}

}
