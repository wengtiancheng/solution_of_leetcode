/*
 * @lc app=leetcode.cn id=138 lang=java
 *
 * [138] 随机链表的复制
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;








class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }

        //原链表和新链表对应节点的映射关系
        Map<Node, Node> tmp = new HashMap<>();
        //第一次遍历，创建原节点和新节点的映射关系
        Node ptr = head;
        while(ptr != null){
            tmp.put(ptr, new Node(ptr.val));
            ptr = ptr.next;
        }
        //第二次遍历，创建新节点的next和random关系
        Node ptr_1 = head;
        while(ptr_1 != null){
            Node new_node = tmp.get(ptr_1);
            if(ptr_1.next != null){
                new_node.next = tmp.get(ptr_1.next);
            }
            if(ptr_1.random != null){
                new_node.random = tmp.get(ptr_1.random);
            }
            ptr_1 = ptr_1.next;
            
        }
        return tmp.get(head);

    }
}
// @lc code=end

