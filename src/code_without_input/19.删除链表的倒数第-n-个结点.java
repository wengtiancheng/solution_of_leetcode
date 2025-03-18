/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第 N 个结点
 */

// @lc code=start

import java.util.Stack;

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //使用双指针，先让一个节点比另外一个节点领先N - 1个节点，当快的节点到末尾的时候，慢的就指向要删除的
        //也可以让慢的先指向哑节点,让慢的指向要删除的前一个
        ListNode slow = new ListNode(-1, head);
        ListNode res = slow;
        ListNode fast = head;
        for(int i = 0; i < n; i++){
            fast = fast.next;
        }
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return res.next;
    }
}
// @lc code=end

