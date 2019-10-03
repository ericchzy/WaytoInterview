package Leetcode;

import com.company.util.TreeNode;

public class minimumDepthOfBinaryTree {
    private static int findMinDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;

        if (root.left == null || root.right == null) {
            return Math.max(findMinDepth(root.left), findMinDepth(root.right)) + 1;
        }
        return Math.min(findMinDepth(root.left), findMinDepth(root.right)) + 1;
    }

    private static int findMinDepthAgain(TreeNode root) {
        if (root == null) return 0;

        if (root.left == null) return findMinDepth(root.right) + 1;
        if (root.right == null) return findMinDepth(root.left) + 1;

        return Math.min(findMinDepth(root.left), findMinDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        //       8
        //    /    \
        //   6     10
        //  / \   / \
        // 5   7 9  11
        TreeNode root = new TreeNode();
        root.val = 8;
        root.left = new TreeNode();
        root.left.val = 6;
        root.left.left = new TreeNode();
        root.left.left.val = 5;
        root.left.right = new TreeNode();
        root.left.right.val = 7;
        root.right = new TreeNode();
        root.right.val = 10;
        root.right.left = new TreeNode();
        root.right.left.val = 9;
        root.right.right = new TreeNode();
        root.right.right.val = 11;
        System.out.println("findMinDepth result is: " + findMinDepth(root));
        System.out.println("findMinDepthAgain result is: " + findMinDepthAgain(root));

        //         1
        //        /
        //       3
        //      /
        //     5
        //    /
        //   7
        //  /
        // 9
        TreeNode root2 = new TreeNode();
        root2.val = 1;
        root2.left = new TreeNode();
        root2.left.val = 3;
        root2.left.left = new TreeNode();
        root2.left.left.val = 5;
        root2.left.left.left = new TreeNode();
        root2.left.left.left.val = 7;
        root2.left.left.left.left = new TreeNode();
        root2.left.left.left.left.val = 9;
        System.out.println("\n");
        System.out.println("findMinDepth result is: " + findMinDepth(root2));
        System.out.println("findMinDepthAgain result is: " + findMinDepthAgain(root2));

        // 0
        //  \
        //   2
        //    \
        //     4
        //      \
        //       6
        //        \
        //         8
        TreeNode root3 = new TreeNode();
        root3.val = 0;
        root3.right = new TreeNode();
        root3.right.val = 2;
        root3.right.right = new TreeNode();
        root3.right.right.val = 4;
        root3.right.right.right = new TreeNode();
        root3.right.right.right.val = 6;
        root3.right.right.right.right = new TreeNode();
        root3.right.right.right.right.val = 8;
        System.out.println("\n");
        System.out.println("findMinDepth result is: " + findMinDepth(root3));
        System.out.println("findMinDepthAgain result is: " + findMinDepthAgain(root3));

        // 1
        TreeNode root4 = new TreeNode();
        root4.val = 1;
        System.out.println("\n");
        System.out.println("findMinDepth result is: " + findMinDepth(root4));
        System.out.println("findMinDepthAgain result is: " + findMinDepthAgain(root4));

        // null
        System.out.println("\n");
        System.out.println("findMinDepth result is: " + findMinDepth(null));
        System.out.println("findMinDepthAgain result is: " + findMinDepthAgain(null));
    }
}
