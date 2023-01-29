/**
 * 
 */
package com.debajoy.algo.algorithm.dp.rev1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author Debajoy
 *
 */
public class HighwayBillboard {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int L = 20;
		int n = 5;
		Integer m[] = {6,7,12,14,15};
		Integer r[] = {5,8,5,3,1};
		int d = 5;
		System.out.println(getMaxRevenue(L,n,m,r,d));
		System.out.println(getMaxRevenueNSquare(L,n,m,r,d));
	}

	public static int getMaxRevenue(int l, int n, Integer[] m, Integer[] r, int d) {
		// TODO Auto-generated method stub
		int[] dp = new int[l+1];
		dp[0] = 0;
		int max = 0;
		Map<Integer,Integer> map = new HashMap<>();
		for(int i = 0; i < n ; i++){
			map.put(m[i], r[i]);
		}
		for(int i = 1; i <= l; i++){
			if(map.get(i) != null){
				int rev = 0;
				if(i-d-1 >=0){
					rev = dp[i-d-1]+map.get(i);
				}
				dp[i] = Math.max(rev, dp[i-1]);
			}else{
				dp[i] = dp[i-1];
			}
			max = Math.max(max, dp[i]);
		}
		return max;
	}
	
	public static int getMaxRevenueNSquare(int l, int n, Integer[] m, Integer[] r, int d) {
		Map<Integer,Integer> map = new TreeMap<>();
		int ans = 0;
		for(int i = 0; i < n ; i++){
			map.put(m[i], r[i]);
		}
		int[] dp = new int[n];
		for(int i = 0; i < n; i++){
			int max = 0;
			for(int j = 0; j < i; j++){
				if(m[i]-m[j] > d){
					max = Math.max(max, r[j]);
				}
			}
			dp[i] = max + r[i];
			ans = Math.max(ans, dp[i]);
		}
		return ans;
	}

}
