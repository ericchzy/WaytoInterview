package com.company;

import java.util.ArrayList;

public class Interview07 {

    public static ArrayList<Integer> printTree(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<TreeNode> queue = new ArrayList<>();
        if (root == null) {
            return list;
        }
        queue.add(root);
        while (queue.size() != 0) {
            TreeNode temp = queue.remove(0);
            if (temp.left != null) queue.add(temp.left);
            if (temp.right != null) queue.add(temp.right);
            list.add(temp.val);
        }
        return list;
    }

    public static void main(String[] args) {

    }

}
