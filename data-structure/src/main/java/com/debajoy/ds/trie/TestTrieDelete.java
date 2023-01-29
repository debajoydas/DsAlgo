/**
 * 
 */
package com.debajoy.ds.trie;

import com.debajoy.ds.trie.Trie.TrieNode;

/**
 * @author Debajoy
 *
 */
public class TestTrieDelete {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String keys[] = {"any", "anrves", "hey", "he", 
                "by", "bye", "byke"}; 

		String output[] = {"Not present in trie", "Present in trie"}; 
		
		Trie trie = new Trie();
		trie.root = new TrieNode();
		
		int i; 
        for (i = 0; i < keys.length ; i++){
        	trie.insert(keys[i]);
        }
   //     trie.delete("bye");
        trie.deleteOptimized("bye");
        trie.deleteOptimized("by");
        trie.deleteOptimized("byke");
        trie.deleteOptimized("any");
        trie.displayALlElements();
                  
	}

}
