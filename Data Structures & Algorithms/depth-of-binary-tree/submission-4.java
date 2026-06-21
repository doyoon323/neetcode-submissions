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


//optimization -> without defining new function 
class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null) return 0; 
        return dfs(root,1);
    }

    public int dfs(TreeNode root, int sum){
        int l=sum,r=sum; 

        if(root.left !=null) l = dfs(root.left,sum+1);
        if(root.right != null) r = dfs(root.right,sum+1);

        return l>r?l:r; 
    }
}