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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        HashSet<Integer> set = new HashSet<>();
        TreeNode r = root; 

        while(!set.contains(p.val)){
            set.add(r.val);
            if(r.val > p.val) r=r.left;
            else r=r.right;
        }
        TreeNode lowest=root;  
        while(root!=null){
            if(set.contains(root.val)) lowest=root; 
            else break;

            if(root.val==q.val) break; 

            if(root.val > q.val) root=root.left;
            else root=root.right;
        }

        return lowest; 
    }
}
