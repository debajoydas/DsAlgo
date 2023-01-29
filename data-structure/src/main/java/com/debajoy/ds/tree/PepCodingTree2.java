package com.debajoy.ds.tree;

import java.io.*;
import java.util.*;

public class PepCodingTree2 {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  public static void display(Node node) {
    String str = node.data + " -> ";
    for (Node child : node.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (Node child : node.children) {
      display(child);
    }
  }

  public static Node construct(int[] arr) {
    Node root = null;

    Stack<Node> st = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) {
        st.pop();
      } else {
        Node t = new Node();
        t.data = arr[i];

        if (st.size() > 0) {
          st.peek().children.add(t);
        } else {
          root = t;
        }

        st.push(t);
      }
    }

    return root;
  }

   public static int calculateDiameter(Node node,int diameter){

       int first = -1;
       int second = -1;
       for(Node child : node.children){
           int ch = calculateDiameter(child,diameter);
           if(ch > first){
               second = first;
               first = ch;
           }else if(ch > second){
               second = ch;
           }
       }
       if(diameter < (first + second + 2)){
           diameter = first + second + 2;
       }
       return first+1;
   }
  

  public static void main(String[] args) throws Exception {
      
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }
    Node root = construct(arr);
    System.out.println(calculateDiameter(root,0));
  }

}






















