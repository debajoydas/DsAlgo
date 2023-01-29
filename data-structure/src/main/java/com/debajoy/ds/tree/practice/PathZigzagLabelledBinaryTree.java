package com.debajoy.ds.tree.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * https://leetcode.com/problems/path-in-zigzag-labelled-binary-tree/description/
 */
public class PathZigzagLabelledBinaryTree {
	
	public static void main(String[] args) {
		int label = 14;
		System.out.println(pathInZigZagTree(label));
	}
	
    public static List<Integer> pathInZigZagTree(int label) {
        int level = 0;
        int sum = 0;
        while(sum < label){
            sum += Math.pow(2,level);
            level += 1;
        }
        level--;
        List<Integer> output = new ArrayList<Integer>();
        while(level > 0){
            output.add(label);
            label = getParent(label,level);
            level--;
        }
        output.add(1);
        Collections.reverse(output);
        return output;
    }
    public static int getStart(int level){
        return (int) (Math.pow(2,level));
    }
    public static int getEnd(int level){
        return (int) (Math.pow(2,(level+1))-1);
    }
    public static int getComplement(int start,int end, int data){
        return start+end-data;
    }
    public static int getParent(int number,int level){
        int start = getStart(level);
        int end = getEnd(level);
        int complement = getComplement(start,end,number);
        int parent = complement/2;
        return parent;
    }


}
