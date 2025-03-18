package hot100.lc23;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class ListNode{
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val){ 
        this.val = val;
        this.next = null;
    }
}

public class lc23 {

    class CustomComparator implements Comparator<ListNode>{
        @Override
        public int compare(ListNode node1, ListNode node2) {
            return Integer.compare(node1.val, node2.val);
        }

    }
    PriorityQueue<ListNode> queue = new PriorityQueue<>(new CustomComparator());
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        for(ListNode node : lists){
            if(node != null){
                queue.offer(node);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode tail =  dummy;
        while(!queue.isEmpty()){
            ListNode node = queue.poll();
            tail.next = node;
            tail = tail.next;
            if(node.next != null){
                queue.offer(node.next);
            }
        }
        return dummy.next;
    }
    
        public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        List<int[]> arg = new ArrayList<>();
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            if(line.isEmpty()){
                break;
            }
            String[] values = line.split(" ");
            int[] row = new int[values.length];
            for(int i = 0; i < values.length; i++){
                row[i] = Integer.parseInt(values[i]);
            }
            arg.add(row);
        }
        int[][] input = arg.toArray(new int[0][]); 
        System.out.println("this is a23");
        sc.close();
    }
}

