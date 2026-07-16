class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int[] result = new int[1];
        inorder(root, 0, k, result);
        return result[0];
    }

    public int inorder(TreeNode root, int count, int k, int[] result) {
        if (root == null) return count;

        count = inorder(root.left, count, k, result);
        if (count>=k) return count;

        count++;
        if (count==k) {
            result[0]=root.val;
            return count;
        }
        return inorder(root.right, count, k, result);
    }
}