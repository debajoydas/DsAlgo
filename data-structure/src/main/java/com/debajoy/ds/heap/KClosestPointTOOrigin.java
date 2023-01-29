/**
 * 
 */
package com.debajoy.ds.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Debajoy
 *
 */
public class KClosestPointTOOrigin {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] points = {{1,3},{-2,2}};
		int K = 1;
		int[][] output = kClosest(points, K);
		for(int i = 0; i< output.length; i++){
			System.out.println("["+output[i][0]+"]"+"["+output[i][1]+"]");
		}

	}

	public static int[][] kClosest(int[][] points, int K) {
        int[][] output = new int[K][2];
        PriorityQueue<Sqrt> minQueue = new PriorityQueue<Sqrt>(new Comparator<Sqrt>() {

			@Override
			public int compare(Sqrt o1, Sqrt o2) {
				// TODO Auto-generated method stub
				return Double.valueOf(o1.value).compareTo(Double.valueOf(o2.value));
			}
		});
        for(int i = 0 ; i<points.length; i++ ){
        	Sqrt sqrt = new Sqrt(i, Math.sqrt(Double.valueOf(points[i][0]*points[i][0]) + Double.valueOf(points[i][1]*points[i][1])));
        	minQueue.add(sqrt);
        }
        int rowIndex = 0;
        while(K > 0 && minQueue.size() > 0){
        	Sqrt sqrt = minQueue.poll();
        	output[rowIndex][0] = points[sqrt.rowNo][0];
        	output[rowIndex][1] = points[sqrt.rowNo][1];
        	rowIndex++;
        	K--;   		
        }
        return output;
    }
}

class Sqrt{
	int rowNo;
	double value;
	public int getRowNo() {
		return rowNo;
	}
	public void setRowNo(int rowNo) {
		this.rowNo = rowNo;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public Sqrt(int rowNo, double value) {
		super();
		this.rowNo = rowNo;
		this.value = value;
	}
}