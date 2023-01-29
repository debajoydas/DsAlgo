/**
 * 
 */
package com.debajoy.ds.trie;

import com.debajoy.ds.trie.Trie.TrieNode;

/**
 * @author Debajoy
 *
 */
public class TestTrie {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String keys[] = {"the", "a", "there", "answer", "any", 
                "by", "bye", "their"}; 

		String output[] = {"Not present in trie", "Present in trie"}; 
		
		Trie trie = new Trie();
		trie.root = new TrieNode();
		
		int i; 
        for (i = 0; i < keys.length ; i++){
        	trie.insert(keys[i]);
        }
        if(trie.search("the")) 
            System.out.println("the --- " + output[1]); 
        else System.out.println("the --- " + output[0]); 
          
        if(trie.search("these")) 
            System.out.println("these --- " + output[1]); 
        else System.out.println("these --- " + output[0]); 
          
        if(trie.search("their")) 
            System.out.println("their --- " + output[1]); 
        else System.out.println("their --- " + output[0]); 
          
        if(trie.search("thaw")) 
            System.out.println("thaw --- " + output[1]); 
        else System.out.println("thaw --- " + output[0]); 
	}

}
