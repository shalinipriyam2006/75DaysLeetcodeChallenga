class Solution {
    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode node, long min, long max) {
        // Base case
        if (node == null) return true;

        // Check current node value in range
        if (node.val <= min || node.val >= max) {
            return false;
        }

        // Left subtree → max becomes node.val
        // Right subtree → min becomes node.val
        return validate(node.left, min, node.val) &&
               validate(node.right, node.val, max);
    }
}