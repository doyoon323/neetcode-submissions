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
    List<Integer> result = new ArrayList<>(); 
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root!=null) preorder(root);
        return result; 
    }

    public void preorder(TreeNode root){
        result.add(root.val);
        if(root.left!=null) preorder(root.left);
        if(root.right!=null) preorder(root.right);
    }

}