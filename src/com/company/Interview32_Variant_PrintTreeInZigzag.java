package com.company;

import java.util.ArrayList;
import java.util.Stack;

public class Interview32_Variant_PrintTreeInZigzag {

    private static void printTreeInZigzag(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        int layer = 1;

        if (root == null) {
            System.out.println(list.toString());
            return;
        }

        //首先将根节点入栈
        stack1.push(root);

        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (layer % 2 != 0) {
                while (!stack1.isEmpty()) {
                    TreeNode t = stack1.pop();
                    list.add(t.val);

                    if (t.left != null) stack2.add(t.left);
                    if (t.right != null) stack2.add(t.right);
                }
                layer++;
            }
            if (layer % 2 == 0) {
                while (!stack2.isEmpty()) {
                    TreeNode t = stack2.pop();
                    list.add(t.val);

                    if (t.right != null) stack1.add(t.right);
                    if (t.left != null) stack1.add(t.left);
                }
                layer++;
            }
        }

        System.out.println(list.toString());
    }

/*  // 代码有错误： `list.add(tempList);` 只会将tempList的索引值加入到list里面,一旦调用tempList.clear()方法则清空，
    // 即最后List输出全部为空
    // 应该将tempList放到if语句里面
    public static ArrayList<ArrayList<Integer>> printTreeInZigzagV2(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> tempList = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        int layer = 1;

        if (pRoot == null) {
            return null;
        }

        //首先将根节点入栈
        stack1.push(pRoot);

        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (layer % 2 != 0) {
                tempList.clear();
                while (!stack1.isEmpty()) {
                    TreeNode t = stack1.pop();
                    tempList.add(t.val);

                    if (t.left != null) stack2.add(t.left);
                    if (t.right != null) stack2.add(t.right);
                }
                layer++;
                list.add(tempList);
            }
            if (layer % 2 == 0) {
                tempList.clear();
                while (!stack2.isEmpty()) {
                    TreeNode t = stack2.pop();
                    tempList.add(t.val);

                    if (t.right != null) stack1.add(t.right);
                    if (t.left != null) stack1.add(t.left);
                }
                layer++;
                list.add(tempList);
            }
        }

        return list;
    }*/



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
        printTreeInZigzag(root);

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
        printTreeInZigzag(root2);

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
        printTreeInZigzag(root3);

        // 1
        TreeNode root4 = new TreeNode();
        root4.val = 1;
        System.out.println("\n");
        printTreeInZigzag(root4);

        // null
        System.out.println("\n");
        printTreeInZigzag(null);
    }
}
