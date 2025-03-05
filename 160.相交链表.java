/*
 * @lc app=leetcode.cn id=160 lang=java
 *
 * [160] 相交链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        if(a == b){
            return a;
        }
        while(a != b){
            if(a != null){
                a = a.next;
            }else{
                a = headB;
            }
            if(b != null){
                b = b.next;
            }else{
                b = headA;
            }
            if(a == b){
                return a;
            }
        }
        return null;
        
    }
    
}
// @lc code=end

