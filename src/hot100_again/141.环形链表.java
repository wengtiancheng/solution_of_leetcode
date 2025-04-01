/*
 * @lc app=leetcode.cn id=141 lang=java
 *
 * [141] 环形链表
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
    public boolean hasCycle(ListNode head) {
        //不重合部分的长度为m,环形部分的长度为n,快慢指针相遇时慢指针走了k步
        // 2k = m + n + k - m
        //不过目前好像是判断有没有
        //所以等到环形链表2的时候才需要复杂一点
        if(head == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
            if(fast != null){
                fast = fast.next;
            }
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}
// @lc code=end

