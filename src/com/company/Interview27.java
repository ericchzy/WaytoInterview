package com.company;

import java.util.Stack;

public class Interview27 {
    public static void mirrorRecursively(TreeNode root) {
        if (root == null) {
            return;
        }

        //Swap two children nodes
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        if(root.left != null) {
            mirrorRecursively(root.left);
        }
        if(root.right != null){
            mirrorRecursively(root.right);
        }
    }

    public static void mirrorCyclically(TreeNode root) {
        if (root == null) {
            return;
        }

        //使用Stack结构将需要作镜像的界面压栈
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            if (node.left != null || node.right != null) {
                //Swap two children nodes
                TreeNode tmp = node.left;
                node.left = node.right;
                node.right = tmp;
            }

            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }

        }

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
        io.printTreeInorder(root);
        System.out.println();
        mirrorCyclically(root);
        io.printTreeInorder(root);
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
        io.printTreeInorder(root2);
        System.out.println();
        mirrorCyclically(root2);
        io.printTreeInorder(root2);

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
        io.printTreeInorder(root3);
        System.out.println();
        mirrorCyclically(root3);
        io.printTreeInorder(root3);
    }
}


/* Output:
5 6 7 8 9 10 11
11 10 9 8 7 6 5

9 7 5 3 1
1 3 5 7 9

0 2 4 6 8
8 6 4 2 0
*///:~