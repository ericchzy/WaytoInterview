package com.company;

import com.company.util.TreeNode;
import com.company.util.io;

public class Interview_Serialization {
    static int index = -1;

    public static String Serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();

        if (root == null) {
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val + ",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();

    }

    public static TreeNode Deserialize(String str){
        index++;

        String[] strr = str.split(",");
        TreeNode node = null;
        if (!strr[index].equals("#")) {
            node = new TreeNode(Integer.valueOf(strr[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }
        return node;
    }

    public static void ResetIndex() {
        index = -1;
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
        System.out.print(Serialize(root));
        System.out.println();
        io.printTreeInorder(Deserialize(Serialize(root)));
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
        System.out.print(Serialize(root2));
        System.out.println();
        String serialization_2 = Serialize(root2);
        ResetIndex();
        io.printTreeInorder(Deserialize(serialization_2));

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
        System.out.print(Serialize(root3));
        System.out.println();
        String serialization_3 = Serialize(root3);
        ResetIndex();
        io.printTreeInorder(Deserialize(serialization_3));
    }
}
