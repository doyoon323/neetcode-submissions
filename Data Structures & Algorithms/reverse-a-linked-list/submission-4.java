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
    /* public ListNode reverseList(ListNode head) {
        if(head==null) return null; 
        ListNode prev = new ListNode(head.val, null);
        head = head.next; 

        while(head != null){
            prev = new ListNode(head.val,prev);
            head = head.next; 
        }
        return prev; 
    }*/

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while(head!=null){
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp; 
        }
        return prev; 
    }
}