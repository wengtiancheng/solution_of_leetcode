/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU 缓存
 */

// @lc code=start

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache{
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode() {}
        public DLinkedNode(int _key, int _value) {key = _key; value = _value;}
    }
    
    private int capacity;
    private int size;
    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        DLinkedNode res = cache.get(key);
        if(res != null){
            moveToHead(res);
            return res.value;
        }else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        DLinkedNode res = cache.get(key);
        if(res != null){
            res.value = value;
            moveToHead(res);
        }else{
            res = new DLinkedNode(key, value);
            cache.put(key, res);
            addToHead(res);
            size++;
            if(size > capacity){
                DLinkedNode remove = removeTail();
                cache.remove(remove.key);
                size--;
            }
        }
    }

    public void addToHead(DLinkedNode node){
        DLinkedNode prev = head;
        DLinkedNode next = head.next;
        prev.next = node;
        node.prev = prev;
        node.next = next;
        next.prev = node;
    }
    public void removeNode(DLinkedNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    public void moveToHead(DLinkedNode node){
        removeNode(node);
        addToHead(node);
    }

    private DLinkedNode removeTail(){
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }



}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

