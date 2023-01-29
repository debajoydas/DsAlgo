/**
 * 
 */
package com.debajoy.ds.segmenttree;

/**
 * @author Debajoy
 *
 */
public class TestSegmentTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1,2,3,4,5,6};
		SegementTreeUtil segmentTree = new SegementTreeUtil(array);
		System.out.println(segmentTree.getSumQuery(2, 4));
		System.out.println(segmentTree.getSumQuery(1, 3));
		segmentTree.updateArray(2, 10);
		System.out.println(segmentTree.getSumQuery(2, 4));
		System.out.println(segmentTree.getSumQuery(1, 3));
	}

}
