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

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}
class Solution {
    private int preIndex = 0; // Index for preorder traversal
    private int postIndex = 0; // Index for postorder traversal
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return buildTree(preorder, postorder);
    }
    private TreeNode buildTree(int[] preorder, int[] postorder) {
        // Create the root node using the current element in preorder
        TreeNode root = new TreeNode(preorder[preIndex]);
        preIndex++;

        // If the current root value is not equal to the current postorder value,
        // recursively build the left subtree
        if (root.val != postorder[postIndex]) {
            root.left = buildTree(preorder, postorder);
        }

        // If the current root value is not equal to the current postorder value,
        // recursively build the right subtree
        if (root.val != postorder[postIndex]) {
            root.right = buildTree(preorder, postorder);
        }

        // Once both subtrees are built, increment the postIndex
        postIndex++;

        return root;
    }
}
