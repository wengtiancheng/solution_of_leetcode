/*
 * @lc app=leetcode.cn id=141 lang=java
 *
 * [141] 环形链表
 */

// @lc code=start

import java.util.HashSet;
import java.util.Set;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
       if(head == null || head.next == null){
        return false;
       }
       ListNode slow = head;
       ListNode fast =  head.next;
       while(fast != null){
        slow = slow.next;
        fast = fast.next;
        if(fast == null){
            return false;
        }
        fast = fast.next;
        if(fast == slow){
            return true;
        }
       }
       return false;
    }
}
// @lc code=end

