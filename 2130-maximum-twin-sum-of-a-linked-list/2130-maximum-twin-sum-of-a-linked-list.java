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
 import java.util.*;
class Solution {
    public int pairSum(ListNode head) {
        Deque<ListNode> dq = new ArrayDeque<>();
        for(ListNode node = head ; node != null ; node = node.next){
            dq.addLast(node);
        }
        int max = Integer.MIN_VALUE;
        while(!dq.isEmpty()){
            max = Math.max(max,dq.removeFirst().val + dq.removeLast().val);
        }
        return max;
    }
}