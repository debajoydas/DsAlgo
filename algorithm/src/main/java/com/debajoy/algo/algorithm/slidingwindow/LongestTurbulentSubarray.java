package com.debajoy.algo.algorithm.slidingwindow;

public class LongestTurbulentSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {100,100,100};
		System.out.println(maxTurbulenceSize(A));
	}

	private static int maxTurbulenceSize(int[] arr) {
		// TODO Auto-generated method stub
		int rotate = -1;
		int left = 0;
		int right = 0;
		int maxLength = 0;
		
		if(arr == null){
			return 0;
		}else if(arr.length == 1){
			return 1;
		}else if(arr.length == 2){
			if(arr[0] == arr[1]){
				return 1;
			}else{
				return 2;
			}	
		}else{
			while(right < arr.length-1){
				if(rotate == -1){
					if(arr[right+1] > arr[right]){
						rotate = 1;
						maxLength = Math.max(maxLength, right-left+2);
						right++;
					}else if(arr[right+1] < arr[right]){
						rotate = 0;
						maxLength = Math.max(maxLength, right-left+2);
						right++;
					}else{
						maxLength = Math.max(maxLength, right-left+1);
						right++;
						left = right;
						rotate = -1;				
					}
				}else if(rotate == 0){
					if(arr[right+1] > arr[right]){
						rotate = 1;
						maxLength = Math.max(maxLength, right-left+2);
						right++;
					}else if(arr[right+1] < arr[right]){
						rotate = -1;
						left = right;
					}else{
						right++;
						left = right;
						rotate = -1;
					}
				}else if(rotate == 1){
					if(arr[right+1] < arr[right]){
						rotate = 0;
						maxLength = Math.max(maxLength, right-left+2);
						right++;
					}else if(arr[right+1] > arr[right]){
						rotate = -1;
						left = right;	
					}else{
						right++;
						left = right;
						rotate = -1;
					}
				}
			}
		}
		return maxLength;
	}
}
