/*
 * @lc app=leetcode.cn id=234 lang=java
 *
 * [234] 回文链表
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

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
    public boolean isPalindrome(ListNode head) {
        List<Integer> tmp = new ArrayList<>();
        int len = 0;
        while(head != null){
            tmp.add(head.val);
            head = head.next;
            len++;
        }
        int start = 0;
        int end = len - 1;
        while(start <= end){
            if(tmp.get(start) != tmp.get(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
        
        
    }
}
// @lc code=end

