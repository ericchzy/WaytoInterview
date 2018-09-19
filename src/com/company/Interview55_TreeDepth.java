package com.company;

import com.company.util.TreeNode;

public class Interview55_TreeDepth {
    private static final int ALLOWED_IMBALANCE = 1;

    private static int treeDepth(TreeNode root) {
        if (root == null) return 0;

        int left = treeDepth(root.left);
        int right = treeDepth(root.right);

        return left > right ? left + 1 : right + 1;
    }

    private static boolean isBalanced(TreeNode root) {
        int[] depth = new int[]{0};
        return isBalancedCore(root, depth);
//        return isBalancedCore2(root);
    }

    private static boolean isBalancedCore(TreeNode root, int[] treeDepth) {
        if (root == null) {
            treeDepth[0] = 0;
            return true;
        }

        int[] left = new int[1];
        int[] right = new int[1];

        if (isBalancedCore(root.left, left) && isBalancedCore(root.right, right)) {
            int diff = left[0] - right[0];
            if (diff >= -1 && diff <= 1) {
                treeDepth[0] = 1 + (left[0] > right[0] ? left[0] : right[0]);
                return true;
            }
        }

        return false;
    }

    private static boolean isBalancedCore2(TreeNode root) {
        if (root == null) return true;
        else return !(Math.abs(treeDepth(root.right) - treeDepth(root.left)) > ALLOWED_IMBALANCE);
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
    }

    // 完全二叉树
    //             1
    //         /      \
    //        2        3
    //       /\       / \
    //      4  5     6   7

    private static void test1() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(1);
        TreeNode n6 = new TreeNode(1);
        TreeNode n7 = new TreeNode(1);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        System.out.println(treeDepth(n1));
        System.out.println(isBalanced(n1));
        System.out.println("----------------");

    }

    // 不是完全二叉树，但是平衡二叉树
    //             1
    //         /      \
    //        2        3
    //       /\         \
    //      4  5         6
    //        /
    //       7
    private static void test2() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(1);
        TreeNode n6 = new TreeNode(1);
        TreeNode n7 = new TreeNode(1);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n5.left = n7;
        n3.right = n6;


        System.out.println(treeDepth(n1));
        System.out.println(isBalanced(n1));
        System.out.println("----------------");
    }

    // 不是平衡二叉树
    //             1
    //         /      \
    //        2        3
    //       /\
    //      4  5
    //        /
    //       7
    private static void test3() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(1);
        TreeNode n6 = new TreeNode(1);
        TreeNode n7 = new TreeNode(1);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n5.left = n7;

        System.out.println(treeDepth(n1));
        System.out.println(isBalanced(n1));
        System.out.println("----------------");
    }

    //               1
    //              /
    //             2
    //            /
    //           3
    //          /
    //         4
    //        /
    //       5
    private static void test4() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(1);
        TreeNode n6 = new TreeNode(1);
        TreeNode n7 = new TreeNode(1);

        n1.left = n2;
        n2.left = n3;
        n3.left = n4;
        n4.left = n5;


        System.out.println(treeDepth(n1));
        System.out.println(isBalanced(n1));
        System.out.println("----------------");
    }

    // 1
    //  \
    //   2
    //    \
    //     3
    //      \
    //       4
    //        \
    //         5
    private static void test5() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(1);
        TreeNode n6 = new TreeNode(1);
        TreeNode n7 = new TreeNode(1);

        n1.right = n2;
        n2.right = n3;
        n3.right = n4;
        n4.right = n5;


        System.out.println(treeDepth(n1));
        System.out.println(isBalanced(n1));
        System.out.println("----------------");
    }

    private static void test6() {
        TreeNode n1 = null;
        System.out.println(treeDepth(n1));
        System.out.println(isBalanced(n1));
        System.out.println("----------------");
    }
}


/* Output:
3
true
----------------
4
true
----------------
4
false
----------------
5
false
----------------
5
false
----------------
0
true
----------------
 *///:~