/**
 * 
 */
package com.debajoy.ds.segmenttree;

/**
 * @author Debajoy
 *
 */
public class SegementTreeUtil {
	
	private int[] segementArray;
	private int[] arr;
	
	public SegementTreeUtil(int[] array) {
		int arraySize = array.length;
		this.arr = array;
		this.segementArray = new int[2*arraySize];
		constructSegmentArray(array);
	}

	private void constructSegmentArray(int[] array) {
		// TODO Auto-generated method stub
		int n = array.length;
		constructSegmentArrayRec(0, 0 , n-1);
	}

	private int constructSegmentArrayRec(int si, int l, int r) {
		// TODO Auto-generated method stub
		if(si >= segementArray.length){
			return 0;
		}
		if(l == r){
			segementArray[si] = arr[l];
			return arr[l];
		}else{
			int mid = (l+r)/2;
			segementArray[si] = constructSegmentArrayRec(2*si+1, l, mid) + constructSegmentArrayRec(2*si+1, mid+1, r);
			return segementArray[si];
		}
	}
	
	public int getSumQuery(int left, int right){
		int n = arr.length;
		return getSumQueryFreomSegmentTree(0, left, right, 0, n-1);
	}
	
	private int getSumQueryFreomSegmentTree(int si, int left, int right, int lIdx, int rIdx) {
		// TODO Auto-generated method stub
		if(si >= segementArray.length){
			return 0;
		}
		if(right < lIdx || left > rIdx){
			return 0;
		}else if(left <= lIdx && right >= rIdx){
			return segementArray[si];
		}else{
			int mid = (lIdx+rIdx)/2;
			return getSumQueryFreomSegmentTree(2*si+1, left, right, lIdx, mid) +  getSumQueryFreomSegmentTree(2*si+2, left, right, mid+1, rIdx);
		}
	}

	public void updateArray(int index, int value){
		int diff = value-arr[index];
		arr[index] = value;
		int n = arr.length;
		updateSegmentTreeR(index, diff, 0, 0, n-1);
	}

	private boolean updateSegmentTreeR(int index, int diff, int si, int l, int r) {
		// TODO Auto-generated method stub
		if(si >= segementArray.length){
			return false;
		}
		if(arr[index] == segementArray[si]){
			int value = segementArray[si];
			segementArray[si] = segementArray[si]+diff;
			return true;
		}else{
			int mid = (l+r)/2;
			boolean leftFlag = updateSegmentTreeR(index, diff, 2*si+1, l, mid);
			boolean rightFlag = updateSegmentTreeR(index, diff, 2*si+2, mid, r);
			if(leftFlag || rightFlag){
				segementArray[si] = segementArray[si]+diff;
				return true;
			}else{
				return false;
			}
		}
	}
}
