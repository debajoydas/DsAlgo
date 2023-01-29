/**
 * 
 */
package com.debajoy.ds.disjointset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author Debajoy
 *
 */
public class StudentGroup {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i = 1; i<= T ; i++){
			String NR = br.readLine();
			String[] NRArr = NR.split("\\s");
			int N = Integer.parseInt(NRArr[0]);
			int R = Integer.parseInt(NRArr[1]);
			List<AB> listAB= new ArrayList<AB>();
			for(int j = 0; j < R; j++){
				String AB  = br.readLine();
				String[] ABArr = AB.split("\\s");
				int A = Integer.parseInt(ABArr[0]);
				int B = Integer.parseInt(ABArr[1]);
				listAB.add(new AB(A, B));
			}
			System.out.println("TestCase "+i+" : " +solution(N,R,listAB));
		}
							
	}

	private static String solution(int n, int r, List<AB> listAB) {
		// TODO Auto-generated method stub
		Set<Integer> set = new TreeSet();
		for(int i = 0; i< listAB.size(); i++){
			set.add(listAB.get(i).A);
			set.add(listAB.get(i).B);			
		}
		int[] arr = new int[set.size()];
		for(int i = 0; i< arr.length; i++){
			arr[i] = i;
		}
		for(AB ab : listAB){
			int a = ab.A-1; int b = ab.B-1;
			union(a, b, arr);
		}
		for(int i = 0; i < arr.length; i++){
			System.out.println(arr[i]+ " -> ");
		}
		return "Done!";
	}
	
	public static int find(int n, int[] arr){
		if(n == arr[n]){
			return n;
		}else{
			return find(arr[n], arr);
		}
	}
	public static void union(int a , int b, int[] arr){
		int a1 = find(a, arr);
		int b1 = find(b, arr);
		if(a1 == b1){
			return;
		}else{
			if(a < b){
				arr[b] = a1;
			}else if (b < a){
				arr[a] = b1;
			}
		}
	}

}

class AB{
	public AB(int a, int b) {
		super();
		A = a;
		B = b;
	}
	int A;
	int B;
}