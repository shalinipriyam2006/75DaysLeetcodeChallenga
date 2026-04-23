class Solution {
    int k;
    int result;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        inorder(root);
        return result;
    }

    private void inorder(TreeNode node) {
        if (node == null) return;

        inorder(node.left);

        if (--k == 0) {
            result = node.val;
            return;
        }

        inorder(node.right);
    }
}