/**
 * 
 */
package com.debajoy.ds.trie;

/**
 * @author Debajoy
 *
 */
public class Trie {

	public TrieNode getRoot() {
		return root;
	}

	public void setRoot(TrieNode root) {
		this.root = root;
	}

	TrieNode root;
	public static final int ALPHABET_SIZE = 26;
	static class TrieNode{
		
		TrieNode[] children = new TrieNode[ALPHABET_SIZE];
		boolean isWordEndsHere;
		char c;
		public TrieNode() {
			// TODO Auto-generated constructor stub
			this.isWordEndsHere = false;
			for(int i = 0; i<ALPHABET_SIZE; i++){
				children[i] = null; 
			}
		}
	}
	
	public void insert(String key){
		int level = key.length();
		TrieNode temp = root;
		for(int i = 0; i< level; i++){
			int index = key.charAt(i) - 'a';
			if(temp.children[index] == null){
				temp.children[index] = new TrieNode();
				temp = temp.children[index];
				temp.c = key.charAt(i);
			}else{
				temp = temp.children[index];
			}
		}
		temp.isWordEndsHere = true;
	}
	
	public boolean search(String key){
		int level = key.length();
		TrieNode temp = root;
		for(int i = 0; i< level ; i++){
			int index = key.charAt(i) - 'a';
			if(temp.children[index] == null){
				return false;
			}else{
				temp = temp.children[index];
			}
		}
		return ((temp != null) && (temp.isWordEndsHere));	
	}
	
	public void delete(String key){

		TrieNode temp = root;
		int index = 0;
		if(deleteRec(temp, key, index)){
			System.out.println("Deleted Successfully");
		}else{
			System.out.println("No Such element present in Trie");
		}
		System.out.println("----------");
	}

	private boolean deleteRec(TrieNode temp, String key, int level) {
		// TODO Auto-generated method stub
		
		if(temp.isWordEndsHere && (key.length() == level)){
			if(temp.children != null && temp.children.length > 0 && checkIfAllElementsInArrayNotNull(temp.children)){
				temp.isWordEndsHere = false;
			}else{
				temp = null;
			}
			return true;
		}
		int index = key.charAt(level)-'a';
		if(deleteRec(temp.children[index], key, level+1)){
			if(!temp.isWordEndsHere && (temp.children == null || (temp.children != null && temp.children.length <= 0) || (temp.children != null && temp.children.length > 0 && !checkIfAllElementsInArrayNotNull(temp.children)))){
				temp = null;
			}
			return true;
		}else{
			return false;
		}
	}

	private TrieNode deleteRecSpaceOptimized(TrieNode temp, String key, int level) {
		// TODO Auto-generated method stub
		
		if(temp.isWordEndsHere && (key.length() == level)){
			if(temp.children != null && temp.children.length > 0 && checkIfAllElementsInArrayNotNull(temp.children)){
				temp.isWordEndsHere = false;
			}else{
				temp = null;
			}
			return temp;
		}
		int index = key.charAt(level)-'a';
		TrieNode trieChild = deleteRecSpaceOptimized(temp.children[index], key, level+1);
		temp.children[index] = trieChild;
		
		if(trieChild == null){		
			if(!temp.isWordEndsHere && (temp.children == null || (temp.children != null && temp.children.length <= 0) || (temp.children != null && temp.children.length > 0 && !checkIfAllElementsInArrayNotNull(temp.children)))){
				temp = null;
			}
			return temp;
		}else{
			return temp;
		}
	}
	
	private boolean checkIfAllElementsInArrayNotNull(TrieNode[] children) {
		// TODO Auto-generated method stub
		boolean out = false;
		for(TrieNode node : children){
			if(node != null){
				out = true;
				break;
			}
		}
		return out;
	}

	public void deleteOptimized(String key) {
		// TODO Auto-generated method stub

		TrieNode temp = root;
		int index = 0;
		deleteRecSpaceOptimized(temp, key, index);
		System.out.println("Deleted Successfully");
	
	}
	
	public void displayALlElements(){
		TrieNode temp = root;
		StringBuilder sb = new StringBuilder("");
		displayALlElementsRec(temp, sb);
		
	}
	
	public void displayALlElementsRec(TrieNode temp, StringBuilder sb){		

			TrieNode[] children = temp.children;
			StringBuilder tempBuff = new StringBuilder(sb);

			for(int i = 0; i < children.length; i++){
				if(children[i] != null){
					char c = children[i].c;
					sb.append(c);
					if(children[i].isWordEndsHere){
						System.out.println(sb.toString());
					}
					if(!checkIfAllElementsInArrayNotNull(children[i].children)){
						sb = new StringBuilder(tempBuff);
						return;
					}else{
						displayALlElementsRec(children[i], sb);
					}
				}else{
					continue;
				}
			}
			sb = new StringBuilder(tempBuff);
	}
}
