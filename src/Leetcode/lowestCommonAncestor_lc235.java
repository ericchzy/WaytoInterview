package Leetcode;

import com.company.util.TreeNode;

public class lowestCommonAncestor_lc235 {
    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;

        if (!contains(root, q) || !contains(root, p)) return null;

        if (p.val > root.val && q.val > root.val)  {
            return lowestCommonAncestor(root.right, p, q);
        }
        if (p.val < root.val && q.val < root.val)  {
            return lowestCommonAncestor(root.left, p, q);
        }
        else {
            return root;
        }
    }

    private static boolean contains(TreeNode root, TreeNode node) {
        if (node.val > root.val) return contains(root.right, node);
        if (node.val < root.val) return contains(root.left, node);
        else return true;
    }

    public static void main(String[] args) {

    }
}
