/*
 * @lc app=leetcode.cn id=208 lang=java
 *
 * [208] 实现 Trie (前缀树)
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;


class Trie {
    private Trie[] children;
    private boolean end;

    
    //这里不需要再存一个val,因为所有字母都是有顺序的，
    //trie在children中在什么位置，说明对应位置上的字母就存在
    public Trie() {
        children = new Trie[26];
        end = false;
    }
    
    public void insert(String word) {
        Trie ptr = this;
        char[] chs = word.toCharArray();
        for(char ch : chs){
            int index = ch - 'a';
            if(ptr.children[index] == null){
                ptr.children[index] = new Trie();
            }
            ptr = ptr.children[index];
        }
        ptr.end = true;
    }
    
    public boolean search(String word) {
        Trie ptr = this;
        char[] chs = word.toCharArray();
        for(char ch : chs){
            int index = ch - 'a';
            if(ptr.children[index] != null){
                ptr = ptr.children[index];
            }else{
                return false;
            }
        }
        if(!ptr.end){
            return false;
        }
        return true;
        
    }
    
    public boolean startsWith(String prefix) {
        Trie ptr = this;
        char[] chs = prefix.toCharArray();
        for(char ch : chs){
            int index = ch - 'a';
            if(ptr.children[index] != null){
                ptr = ptr.children[index];
            }else{
                return false;
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// @lc code=end

