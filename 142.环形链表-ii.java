/*
 * @lc app=leetcode.cn id=142 lang=java
 *
 * [142] 环形链表 II
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
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        
        // 通过快慢指针检测是否有环
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break; // 检测到有环，跳出循环
            }
        }
        
        // 如果没有环
        if (fast == null || fast.next == null) {
            return null;
        }
        
        // 找到环的入口
        ListNode ptr = head;
        while (ptr != slow) {
            slow = slow.next;
            ptr = ptr.next;
        }
        return ptr; // 返回环的入口
    }
}

// @lc code=end

