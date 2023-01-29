/**
 * 
 */
package com.debajoy.ds.tree.segmentTree;

/**
 * @author Debajoy
 *
 */
public class SegmentTree {

	private Integer[] _segmentArray;
	
	public SegmentTree(int[] arr) {
		int _arrayLength = arr.length;
		int _segmentArrayHeight = (int) Math.ceil((Math.log(_arrayLength))/(Math.log(2)));
		int _segmentArraySize = (int) (Math.pow(2, _segmentArrayHeight+1)-1);
		System.out.println("Segment Array Height :=> "+_segmentArrayHeight);
		System.out.println("Segment Array Height :=> "+_segmentArraySize);
		this._segmentArray = new Integer[_segmentArraySize];
		constructSegmentTree(arr,_segmentArray,_arrayLength,_segmentArrayHeight,_segmentArraySize);
		displaySegmentArray(_segmentArray);
		
	}

	private void displaySegmentArray(Integer[] segmentArray) {
		// TODO Auto-generated method stub
		for(Integer i : segmentArray){
			System.out.print((i == null) ? "null->":i+"->");
		}
	}

	private void constructSegmentTree(int[] arr, Integer[] segmentArray, int _arrayLength, int _segmentArrayHeight, int _segmentArraySize) {
		// TODO Auto-generated method stub
		int _parentSegmentIndex = 0;
		constructSegmentTreeUtil(arr,segmentArray,0,_arrayLength-1,_parentSegmentIndex);
	}

	private Integer constructSegmentTreeUtil(int[] arr, Integer[] _segmentArray, int _start, int _end, int _parentSegmentIndex) {
		// TODO Auto-generated method stub
		if(_start > _end || _start >= arr.length || _start < 0 || _end >= arr.length || _end < 0){
			return 0;
		}
		if(_start == _end){
			_segmentArray[_parentSegmentIndex] = arr[_start];
			return _segmentArray[_parentSegmentIndex];
		}
		int _mid = (_start + _end)/2;
		int _left = constructSegmentTreeUtil(arr, _segmentArray, _start, _mid, 2*_parentSegmentIndex+1);
		int _right = constructSegmentTreeUtil(arr, _segmentArray, _mid+1, _end, 2*_parentSegmentIndex+2);
		_segmentArray[_parentSegmentIndex] = _left + _right;
		return _segmentArray[_parentSegmentIndex];
	}

	private int getSum(int[] arr, int _arrayLength, int queryStart, int queryEnd) {
		// TODO Auto-generated method stub
		System.out.println();
		return getSumUtility(arr, _arrayLength, 0, (_arrayLength-1), queryStart, queryEnd, 0);
	}
	
	private int getSumUtility(int[] arr, int _arrayLength, int _start, int _end, int queryStart, int queryEnd, int _parentSegmentIndex) {
		// TODO Auto-generated method stub
		if(_start > _end || _start >= arr.length || _start < 0 || _end >= arr.length || _end < 0){
			return 0;
		}
		if(queryStart <= _start && queryEnd >= _end){
			return _segmentArray[_parentSegmentIndex];
		}
		if(queryEnd < _start || queryStart > _end){
			return 0;
		}
		if(_start == _end){
			return 0;
		}
		int _mid = (_start + _end)/2;
		return getSumUtility(arr, _arrayLength, _start, _mid, queryStart, queryEnd, 2*_parentSegmentIndex+1)
				+ getSumUtility(arr, _arrayLength, _mid+1, _end, queryStart, queryEnd, 2*_parentSegmentIndex+2);
	}
	
	private void updateValue(int[] _arr, int _arrayLength, int _index, int _newValue) {
		// TODO Auto-generated method stub
		int _difference = _newValue - _arr[_index];
		_arr[_index] = _newValue;
		updateValueUtility(_arr, _arrayLength, _index, _difference, 0, _arrayLength-1, 0);
	}
	
	private void updateValueUtility(int[] arr, int _arrayLength, int _index, int _difference, int _start, int _end, int _parentSegmentIndex) {
		if(_start > _end || _start >= arr.length || _start < 0 || _end >= arr.length || _end < 0){
			return;
		}
		if(_index > _end || _index < _start){
			return;
		}
		if(_index >= _start && _index <= _end){
			_segmentArray[_parentSegmentIndex] += _difference;
		}
		if(_start == _end){
			return;
		}
		int _mid = (_start + _end) / 2;
		updateValueUtility(arr, _arrayLength, _index, _difference, _start, _mid, 2*_parentSegmentIndex+1);
		updateValueUtility(arr, _arrayLength, _index, _difference, _mid+1, _end, 2*_parentSegmentIndex+2);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,5,7,4,8,11,9,6};
		SegmentTree segmentTree = new SegmentTree(arr);
		int _rangeQueryStart = 1;
		int _rangeQueryEnd = 3;
		System.out.println("Sum of values in given range ("+_rangeQueryStart+","+_rangeQueryEnd+") := " +segmentTree.getSum(arr,arr.length, _rangeQueryStart, _rangeQueryEnd));
		segmentTree.updateValue(arr, arr.length, 1, 10);
		System.out.println("Sum of values in given range ("+_rangeQueryStart+","+_rangeQueryEnd+") := " +segmentTree.getSum(arr,arr.length, _rangeQueryStart, _rangeQueryEnd));
	}


}
