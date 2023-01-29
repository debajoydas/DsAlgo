/**
 * 
 */
package com.debajoy.ds.graph1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author dasde
 *
 */
public class CourseScheduleII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numCourses = 4;
		int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
		int[] arr = findOrder(numCourses, prerequisites);
		for(int i = 0; i < numCourses; i++) {
			System.out.println(arr[i]);
		}
	}

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> courses = new ArrayList<List<Integer>>();
        for(int i = 0; i < numCourses; i++){
            courses.add(new ArrayList<Integer>());
        }
        for(int[] arr : prerequisites){
            int node = arr[0];
            List<Integer> neighbours = courses.get(node);
            neighbours.add(arr[1]);
        }
        Stack<Integer> stack = new Stack<Integer>();

        if(isCyclic(numCourses,courses,stack)){
             int[] answer = new int[0];
             return answer;
        }
        int[] answer = new int[numCourses];
        int idx = numCourses-1;
        while(stack != null && stack.size() > 0 && idx >= 0){
            answer[idx] = stack.pop();
            idx--;
        }
        return answer;
    }

    public static boolean isCyclic(int numCourses,List<List<Integer>> courses,Stack<Integer> stack){
        boolean[] isVisited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];
        for(int i = 0; i < numCourses; i++){
            if(!isVisited[i]){
                if(isCyclicUtil(i,numCourses,courses,isVisited,recStack,stack)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCyclicUtil(int src, int numCourses,List<List<Integer>> courses, boolean[] isVisited ,boolean[] recStack,Stack<Integer> stack){
        if(recStack[src]){
            return true;
        }
        if(isVisited[src]){
            return false;
        }
        recStack[src] = true;
        isVisited[src] = true;
        List<Integer> neighbours = courses.get(src);
        for(Integer neighbour : neighbours){
            boolean flag = isCyclicUtil(neighbour,numCourses,courses,isVisited,recStack,stack);
            if(flag){
                return true;
            }
        }
        stack.push(src);
        recStack[src] = false;
        return false;
    }

}