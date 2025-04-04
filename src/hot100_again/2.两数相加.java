/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int add = 0;
        ListNode res = null;
        ListNode ptr = null;
        while(l1 != null || l2 != null){
            int n1 = l1 == null ? 0 : l1.val;
            int n2 = l2 == null ? 0 : l2.val;
            int sum = n1 + n2 + add;
            if(res == null){
                res = ptr = new ListNode(sum % 10);
            }else{
                
                ptr.next = new ListNode(sum % 10);
                ptr = ptr.next;
            }
            add = sum / 10;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        if(add != 0){
            ptr.next = new ListNode(add);
        }
        return res;
    }
}
// @lc code=end

