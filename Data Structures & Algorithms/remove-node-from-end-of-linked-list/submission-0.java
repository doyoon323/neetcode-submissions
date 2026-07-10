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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int c = 1;  
        ListNode h = head; 
        while(h.next !=null){
            h = h.next; 
            c++; 
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int steps = c - n; 
        h = dummy; 
        
        while (steps>0) {
            h = h.next; 
            steps--; 
        }
        h.next = h.next.next;
        return dummy.next;
    }
}
