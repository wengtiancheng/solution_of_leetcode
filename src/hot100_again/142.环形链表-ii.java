/*
 * @lc app=leetcode.cn id=142 lang=java
 *
 * [142] 环形链表 II
 */

// @lc code=start
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
    public ListNode detectCycle(ListNode head) {
        //2 * (m + l) = m + k * n  + l
        // l = k * n - m
        // m = k * n - l
        //就是说两者相遇时再排一个指针从头部开始运动，最后会在环形的起始节点相遇
        if(head == null){
            return null;
        } 
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                break;
            }
        }
        if(fast == null || fast.next == null){
            return null;
        }
        ListNode ptr = head;
        while(ptr != slow){
            slow = slow.next;
            ptr = ptr.next;
        }
        return ptr;
        
    }
}
// @lc code=end

