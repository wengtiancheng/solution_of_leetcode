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
        if (head == null || k <= 1) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        ListNode tail = head;
        ListNode prev = dummy;
        while(true){
            //这里定义的tail并不是每组链表的结束节点，而是下一组链表的起始节点
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
    /**
     * 
     * @param head 当前这一组链表的起始节点
     * @param tail 下一组链表的起始节点
     * @return 当前这一组链表的结束节点，也就是反转后当前这一组链表的起始节点
     */
    public ListNode reverse(ListNode head, ListNode tail){
        ListNode before = null;
        ListNode ptr = head;
        while(ptr != tail){
            ListNode next = ptr.next;
            ptr.next = before;
            before = ptr;
            ptr = next;
            
        }
        return before;
    }
}
// @lc code=end

