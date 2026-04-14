class Solution {
    public TreeNode invertTree(TreeNode root) {
        // base case
        if (root == null) {
            return null;
        }

        // swap left and right
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // recurse for children
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}