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
    public void reorderList(ListNode head) {
        ListNode backward = head; 
        int n =0; 

        while(backward != null){
            backward = backward.next; 
            n++; 
        }
        backward = head;
        int i=0; 
        while(backward != null){
            if(i==n/2) break; 
            i++; 
            backward = backward.next; 
        }
        ListNode secondHalf = backward.next;
        backward.next = null;

        ListNode prev = null;
        backward = secondHalf;

        while (backward != null) {
            ListNode temp = backward.next;
            backward.next = prev;         
            prev = backward;              
            backward = temp;              
        }

        ListNode first = head;
        ListNode second = prev;

        while (second != null) {
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;

            first.next = second;
            second.next = firstNext;

            first = firstNext;
            second = secondNext;
        }
    }
}
