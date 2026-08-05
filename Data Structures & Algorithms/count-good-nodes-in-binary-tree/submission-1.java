/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int goodNodes(TreeNode root) {
        if(root==null) return 0;
        return numOfNode(root,root.val);
    }

    public int numOfNode(TreeNode node, int max){
        if(node==null) return 0;

        int total = 0;
        if(node.val>=max){
            max = node.val;
            total++; 
        }

        total+= numOfNode(node.left,max);
        total+=numOfNode(node.right,max);
        return total;
    }
}
