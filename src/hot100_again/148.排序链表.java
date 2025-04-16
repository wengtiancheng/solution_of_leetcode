/*
 * @lc app=leetcode.cn id=148 lang=java
 *
 * [148] 排序链表
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null){
            return null;
        }
        List<ListNode> tmp = new ArrayList<>();
        ListNode ptr = head;
        while(ptr != null){
            tmp.add(ptr);
            ptr = ptr.next;
        }
        Collections.sort(tmp, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode a, ListNode b){
                return a.val - b.val;
            }
        });
        ListNode dummy = new ListNode(-1);
        ptr = dummy;
        for(ListNode node : tmp){
            ptr.next = node;
            ptr = ptr.next;
        }
        ptr.next = null;
        return dummy.next;

    }
}
// @lc code=end

