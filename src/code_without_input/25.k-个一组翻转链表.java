/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
 */

// @lc code=start
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k <= 1){
            return head;
        }
        
        ListNode tail = head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        
        while(true){
            int count = 0;
            while(count < k && tail != null){
                tail = tail.next;
                count++;
            }
            if(count == k){
                ListNode res = reverse(head, tail);
                prev.next = res;
                prev = head;
                head = tail;
            }else{
                prev.next = head;
                break;
            }
            
        }
        return dummy.next;
        
        
    }
    public ListNode reverse(ListNode begin, ListNode end){
        ListNode cur = begin;
        ListNode prev = null;
        while(cur != end){
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return prev;
    }
}
// @lc code=end

