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
    private Map<Integer, Integer> inMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inMap = new HashMap<>();
        
        for (int i=0;i<inorder.length;i++) inMap.put(inorder[i], i);
        return helper(preorder, 0, preorder.length-1, 0, inorder.length-1);
    }

    private TreeNode helper(int[] preorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) return null;

        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        int inRootIdx = inMap.get(rootVal);
        int leftSize = inRootIdx-inStart;

        root.left = helper(preorder, preStart+1, preStart+leftSize, inStart, inRootIdx-1);
        root.right = helper(preorder, preStart+leftSize+1, preEnd, inRootIdx+1, inEnd);

        return root;
    }
}