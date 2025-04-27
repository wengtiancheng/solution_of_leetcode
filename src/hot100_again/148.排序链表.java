/*
 * @lc app=leetcode.cn id=148 lang=java
 *
 * [148] 排序链表
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
    public ListNode sortList(ListNode head) {
        if(head == null){
            return head;
        }
        int length = 0;
        ListNode node = head;
        //求出链表的总长度
        while(node != null){
            node = node.next;
            length++;
        }
        ListNode dummy = new ListNode(-1, head);
        for(int subLength = 1; subLength < length; subLength *= 2){
            //合并后链表的前驱节点
            ListNode prev = dummy;
            ListNode curr = dummy.next;
            while(curr != null){
                //分割链表为两个子链表
                ListNode head1 = curr;
                //找到第一个子链表的尾部
                for(int i = 1; i < subLength && curr.next != null; i++){
                    curr = curr.next;
                }
                //找到第二子链表的头部
                ListNode head2 = curr.next;
                //切断两个子链表之间的连接
                curr.next = null;
                //移动到第二个子链表的头部
                curr = head2;
                //找到第二个子链表的尾部
                for(int i = 1; i < subLength && curr != null; i++){
                    curr = curr.next;
                }

                ListNode next = null;
                if(curr != null){
                    next = curr.next;
                    curr.next = null;
                }

                ListNode merged = merge(head1, head2);
                prev.next = merged;
                while(prev.next != null){
                    prev = prev.next;
                }
                curr = next;
            }
        }
        return dummy.next;
    }

    public ListNode merge(ListNode head1, ListNode head2){
        ListNode dummy = new ListNode(-1);
        ListNode tmp = dummy, tmp1 = head1, tmp2 = head2;
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
        }else if(tmp2 != null){
            tmp.next = tmp2;
        }
        return dummy.next;
    }
}
// @lc code=end

