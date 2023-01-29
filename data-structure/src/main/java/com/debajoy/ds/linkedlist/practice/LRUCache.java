package com.debajoy.ds.linkedlist.practice;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    Node head;
    Node tail;
    int size;
    int capacity;
    Map<Integer,Node> map;
    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        map = new HashMap<Integer,Node>();
    }
    public int get(int key) {
        if(map.get(key) == null){
            return -1;
        }else{
            Node node = map.get(key);
            remove(node);
            insert(node.k,node.v);    
            return node.v;
        }
    }
        
    public void put(int key, int value) {
        if(map.get(key) == null){
            if(size >= capacity){
                removeLast();
                insert(key,value);
            }else{
                insert(key,value);
            }
        }else{
            Node node = map.get(key);
            remove(node);
            insert(key,value);
        }
    }
    public void removeLast(){
        if(tail != null){
            Node last = tail;
            Node prevLast = tail.prev;
            if(prevLast != null){
                prevLast.next = null;
            }
            tail = prevLast;
            if(size == 1 || size == 2){
            	head = tail;
            }
            map.remove(last.k);
            size--;
        }      
    }
    
    public void remove(Node node){
        Node nextNode = node.next;
        Node prevNode = node.prev;
        if(prevNode != null){
            prevNode.next = nextNode;
            map.put(prevNode.k, prevNode);
        }
        if(nextNode != null){
            nextNode.prev = prevNode;
            map.put(nextNode.k, nextNode);
        }
        if(prevNode != null && nextNode == null){
            tail = prevNode;
        }else if(prevNode == null && nextNode != null){
        	head = nextNode;
        }
        size--;
        map.remove(node.k);      
    }
    
    public void insert(int k , int v){
        Node node = new Node(k,v);
        Node temp = head;
        node.next = temp;
        if(temp != null){
        	temp.prev= node;
        	map.put(temp.k,temp);
        	if(size == 1){
        		tail = temp;
        	}
        }
        head = node;
        if(size == 0){
        	tail = node;
        }
        map.put(k,node);
        size++;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRUCache lruCache = new LRUCache(10);		
		lruCache.put(10,13);
		lruCache.display();
		lruCache.put(3,17);
		lruCache.display();
		lruCache.put(6,11);
		lruCache.display();
		lruCache.put(10,5);
		lruCache.display();
		lruCache.put(9,10);
		lruCache.display();
		System.out.println("Get by key:13 :=>"+lruCache.get(13));
		lruCache.display();
		lruCache.put(2, 19);
		lruCache.display();
		System.out.println("Get by key:2 :=>"+lruCache.get(2));
		lruCache.display();
		System.out.println("Get by key:3 :=>"+lruCache.get(3));
		lruCache.display();
		
		lruCache.put(5, 25);
		lruCache.display();
		System.out.println("Get by key:8 :=>"+lruCache.get(8));
		lruCache.display();
		lruCache.put(9, 22);
		lruCache.display();
		lruCache.put(5, 5);
		lruCache.display();
		lruCache.put(1, 30);
		lruCache.display();
		System.out.println("Get by key:11 :=>"+lruCache.get(11));
		lruCache.display();
		lruCache.put(9, 12);
		lruCache.display();
		System.out.println("Get by key:7 :=>"+lruCache.get(7));
		lruCache.display();
		System.out.println("Get by key:5 :=>"+lruCache.get(5));
		lruCache.display();
		System.out.println("Get by key:8 :=>"+lruCache.get(8));
		lruCache.display();
		System.out.println("Get by key:4 :=>"+lruCache.get(4));
		lruCache.display();
		
	}
	private void display() {
		// TODO Auto-generated method stub
		Node nodeH = head;
		Node nodeT = tail;
		System.out.println();
		while(nodeH != null){
			System.out.print("("+nodeH.k+","+nodeH.v+")->");
			nodeH = nodeH.next;
		}
		System.out.println();
		while(nodeT != null){
			System.out.print("("+nodeT.k+","+nodeT.v+")->");
			nodeT = nodeT.prev;
		}
		System.out.println();
		if(head != null && tail != null){
			System.out.println("Size :="+size+" | Head := ("+head.k+","+head.v+")"+" | Tail := ("+tail.k+","+tail.v+")");
		}else if(head != null && tail == null){
			System.out.println("Size :="+size+" | Head := ("+head.k+","+head.v+")"+" | Tail := (null)");
		}else if(head == null && tail != null){
			System.out.println("Size :="+size+" | Head := (null)"+" | Tail := ("+tail.k+","+tail.v+")");
		}else{
			System.out.println("Size :="+size);
		}
		System.out.println();
	}
}

class Node{
    int k;
    int v;
    Node next;
    Node prev;
    Node(int k, int v){
        this.k = k;
        this.v = v;
    }
}

