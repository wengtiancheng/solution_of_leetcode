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
        int tmp = 0;
        ListNode res = new ListNode(-1);
        ListNode ptr = res;
        while(l1 != null && l2 != null){
            tmp = l1.val + l2.val + add;
            if(tmp >= 10){
                tmp -= 10;
                add = 1;
            }else{
                add = 0;
            }
            ptr.next = new ListNode(tmp);
            l1 = l1.next;
            l2 = l2.next;
            ptr = ptr.next;

        }
        while(l1 != null){
            tmp = l1.val + add;
            if(tmp >= 10){
                tmp -= 10;
                add = 1;
            }else{
                add = 0;
            }
            ptr.next = new ListNode(tmp);
            ptr = ptr.next;
            l1 = l1.next;
            
        }
        while(l2 != null){
            tmp = l2.val + add;
            if(tmp >= 10){
                tmp -= 10;
                add = 1;
            }else{
                add = 0;
            }
            ptr.next = new ListNode(tmp);
            ptr = ptr.next;
            l2 = l2.next;
            
        }
        if(add != 0){
            ptr.next = new ListNode(add);
        }
        return res.next;
    }
}
// @lc code=end

