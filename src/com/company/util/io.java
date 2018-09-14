package com.company.util;

public class io {
    /* This funtcion is here just to test buildTree() */
    public static void printTreeInorder(TreeNode node)
    {
        if (node == null)
            return;

        /* first recur on left child */
        printTreeInorder(node.left);

        /* then print the data of node */
        System.out.print(node.val + " ");

        /* now recur on right child */
        printTreeInorder(node.right);
    }

    /* Given a binary tree, print its nodes according to the
    "bottom-up" postorder traversal. */
    public static void printTreePostorder(TreeNode node)
    {
        if (node == null)
            return;

        // first recur on left subtree
        printTreePostorder(node.left);

        // then recur on right subtree
        printTreePostorder(node.right);

        // now deal with the node
        System.out.print(node.val + " ");
    }
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.value + "->");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void printIntegerArray(int[] numArray) {
        for (int element : numArray) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
