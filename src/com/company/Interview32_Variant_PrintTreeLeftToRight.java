package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Interview32_Variant_PrintTreeLeftToRight {
    private static ArrayList<ArrayList<Integer>> printTreeLeftToRight(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> layerList = new ArrayList<>();
        Queue<TreeNode> layer = new LinkedList<>();

        if (pRoot == null) {
            return list;
        }

        //首先将根节点将加入队列
        layer.add(pRoot);
        int start = 0, end = 1;
        while (!layer.isEmpty()) {
            TreeNode current = layer.remove();
            layerList.add(current.val);
            start++;
            if (current.left != null) layer.add(current.left);
            if (current.right != null) layer.add(current.right);

            if (start == end) {
                start = 0;
                end = layer.size();
                list.add(layerList);
                layerList = new ArrayList<>();
            }

        }
        return list;
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
        System.out.println(printTreeLeftToRight(root));

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
        System.out.println(printTreeLeftToRight(root2));

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
        System.out.println(printTreeLeftToRight(root3));

        // 1
        TreeNode root4 = new TreeNode();
        root4.val = 1;
        System.out.println("\n");
        System.out.println(printTreeLeftToRight(root4));

        // null
        System.out.println("\n");
        System.out.println(printTreeLeftToRight(null));
    }
}
