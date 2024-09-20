

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class lc2181 {
    public ListNode mergeNodes(ListNode head) {
        int sum = 0;
        ListNode tmp = new ListNode();
        ListNode res = tmp;
        ListNode next = head.next;
        while(next != null){

            if(next.val != 0){
                sum += next.val;
                next = next.next;
            }else{
                tmp.val = sum;
                sum = 0;
                next = next.next;
                if(next != null){
                    tmp.next = new ListNode();
                    tmp = tmp.next;
                }
            }


        }

        return res;

    }
}