package com.company;

import com.company.util.TreeNode;

public class Interview07_ReconstructBinaryTree {

/*    static int preIndex = 0; // wrong

    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        return buildTree(in, pre, 0, in.length-1);
    }

    private static TreeNode buildTree(int [] in, int [] pre, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }
        TreeNode treenode = new TreeNode(pre[preIndex++]);

        if(inStart == inEnd)
            return treenode;

        int inIndex = search(in, inStart, inEnd, treenode.val);
        treenode.left = buildTree(in, pre, inStart, inIndex - 1);
        treenode.right = buildTree(in, pre, inIndex + 1, inEnd);

        return treenode;
    }

    private static int search(int [] array, int start, int end, int value) {
        int i;
        for(i = start; i <= end; i++) {
            if(value == array[i]) {
                return i;
            }
        }
        return i;
    }*/

    public static TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        if (pre == null || in == null) {
            return null;
        }
        return reConBTree(pre,0,pre.length-1,in,0,in.length-1);
    }
    public static TreeNode reConBTree(int [] pre,int preleft,int preright,int [] in,int inleft,int inright){
        if(preleft > preright || inleft> inright) //当到达边界条件时候返回null
            return null;

        //新建一个TreeNode
        TreeNode root = new TreeNode(pre[preleft]);
        //对中序数组进行输入边界的遍历
        for(int i = inleft; i<= inright; i++){
            if(pre[preleft] == in[i]){
                //重构左子树，注意边界条件
                root.left = reConBTree(pre,preleft+1,preleft+i-inleft,in,inleft,i-1);
                //重构右子树，注意边界条件
                root.right = reConBTree(pre,preleft+i+1-inleft,preright,in,i+1,inright);
            }
        }
        return root;
    }

    /* This funtcion is here just to test buildTree() */
    private static void printInorder(TreeNode node)
    {
        if (node == null)
            return;

        /* first recur on left child */
        printInorder(node.left);

        /* then print the data of node */
        System.out.print(node.val + " ");

        /* now recur on right child */
        printInorder(node.right);
    }

    /* Given a binary tree, print its nodes according to the
    "bottom-up" postorder traversal. */
    private static void printPostorder(TreeNode node)
    {
        if (node == null)
            return;

        // first recur on left subtree
        printPostorder(node.left);

        // then recur on right subtree
        printPostorder(node.right);

        // now deal with the node
        System.out.print(node.val + " ");
    }

    // 普通二叉树
    //              1
    //           /     \
    //          2       3
    //         /       / \
    //        4       5   6
    //         \         /
    //          7       8
    private static void test1() {
        int[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inorder = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode root = reConstructBinaryTree(preorder, inorder);
        printInorder(root);
    }

    // 所有结点都没有右子结点
    //            1
    //           /
    //          2
    //         /
    //        3
    //       /
    //      4
    //     /
    //    5
    private static void test2() {
        int[] preorder = {1, 2, 3, 4, 5};
        int[] inorder = {5, 4, 3, 2, 1};
        TreeNode root = reConstructBinaryTree(preorder, inorder);
        printInorder(root);
    }

    // 所有结点都没有左子结点
    //            1
    //             \
    //              2
    //               \
    //                3
    //                 \
    //                  4
    //                   \
    //                    5
    private static void test3() {
        int[] preorder = {1, 2, 3, 4, 5};
        int[] inorder = {1, 2, 3, 4, 5};
        TreeNode root = reConstructBinaryTree(preorder, inorder);
        printInorder(root);
    }

    // 树中只有一个结点
    private static void test4() {
        int[] preorder = {1};
        int[] inorder = {1};
        TreeNode root = reConstructBinaryTree(preorder, inorder);
        printInorder(root);
    }

    // 完全二叉树
    //              1
    //           /     \
    //          2       3
    //         / \     / \
    //        4   5   6   7
    private static void test5() {
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] inorder = {4, 2, 5, 1, 6, 3, 7};
        TreeNode root = reConstructBinaryTree(preorder, inorder);
        printInorder(root);
    }

    // 输入空指针
    private static void test6() {
        reConstructBinaryTree(null, null);
    }

    // 输入的两个序列不匹配
    private static void test7() {
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] inorder = {4, 2, 8, 1, 6, 3, 7};
        TreeNode root = reConstructBinaryTree(preorder, inorder);
        printInorder(root);
    }



    public static void main(String[] args) {
        test1();
        System.out.println();
        test2();
        System.out.println();
        test3();
        System.out.println();
        test4();
        System.out.println();
        test5();
        System.out.println();
        test6();
        System.out.println();
        test7();
    }

}
