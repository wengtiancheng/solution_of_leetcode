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
import java.util.Map;




class Solution {
    //这里创建的是原节点和新节点的对应关系，我之前创建的是原节点和索引之间的关系
    Map<Node, Node> tmp = new HashMap<>();
    public Node copyRandomList(Node head) {
       if(head == null){
        return null;
       }
       if(!tmp.containsKey(head)){
        Node res = new Node(head.val);
        tmp.put(head, res);
        res.next = copyRandomList(head.next);
        res.random = copyRandomList(head.random);
       }
       return tmp.get(head);
        
    }
}
// @lc code=end

