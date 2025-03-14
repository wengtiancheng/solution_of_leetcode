/*
 * @lc app=leetcode.cn id=148 lang=java
 *
 * [148] 排序链表
 */

// @lc code=start

import java.util.Arrays;
import java.util.Comparator;

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
       return mySort(head, null);
    }
    public ListNode mySort(ListNode head, ListNode tail){
        if(head == null){
            return null;
        }
        if(head.next == tail){
            head.next = null;
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast != tail){
            slow = slow.next;
            fast = fast.next;
            if(fast != tail){
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode left = mySort(head, mid);
        ListNode right = mySort(mid, tail);
        return merge(left, right);
        
    }
    public ListNode merge(ListNode left, ListNode right){
        ListNode dummy = new ListNode(-1);
        ListNode tmp = dummy, tmp1 = left, tmp2 = right;
        while(tmp1 != null && tmp2 != null){
            if(tmp1.val <= tmp2.val){
                tmp.next = tmp1;
                tmp1 = tmp1.next;
            }else{
                tmp.next = tmp2;
                tmp2 = tmp2.next;
            }
            tmp = tmp.next;

        }
        if(tmp1 != null){
            tmp.next = tmp1;
        }
        if(tmp2 != null){
            tmp.next = tmp2;
        }
        return dummy.next;
    }
}
// @lc code=end

