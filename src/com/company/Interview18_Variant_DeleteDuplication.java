package com.company;

import com.company.util.ListNode;
import com.company.util.io;

public class Interview18_Variant_DeleteDuplication {
    public static ListNode deleteDuplication(ListNode pHead)
    {
        /* Loop Version */
        if (pHead == null) {
            return null;
        }

//        // 只有一个结点
//        if (pHead.next == null) {
//            return pHead;
//        }

        // 临时的头结点
        ListNode root = new ListNode();
        root.next = pHead;
        // 记录前驱结点
        ListNode prev = root;
        // 记录当前处理的结点
        ListNode node = pHead;
        while (node != null && node.next != null) {
            // 有重复结点，与node值相同的结点都要删除
            if (node.value == node.next.value) {
                // 找到下一个不同值的节点，注意其有可能也是重复节点
                while (node.next != null && node.next.value == node.value) {
                    node = node.next;
                }
                // 指向下一个节点，prev.next也可能是重复结点
                // 所以prev不要移动到下一个结点
                prev.next = node.next;
            }
            // 相邻两个值不同，说明node不可删除，要保留
            else {
                prev.next = node;
                prev = prev.next;

            }
            node = node.next;
        }

        return root.next;

/*        *//* Recursive Version *//*
        if (pHead == null || pHead.next == null) {
            return pHead;
        }

        if (pHead != null && pHead.value == pHead.next.value) {
            ListNode pNode = pHead.next;
            while (pNode != null && pNode.value == pHead.value) {
                pNode = pNode.next;
            }
            return deleteDuplication(pNode);
        } else {
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }*/
    }

    public static void main(String[] args) {
        test01();
        test02();
        test03();
        test04();
        test05();
        test06();
        test07();
        test08();
        test09();
        test10();
    }

    // 1->2->3->3->4->4->5
    private static void test01() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(4);
        ListNode n7 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        ListNode result = deleteDuplication(n1);
        io.printList(result);
    }

    // 1->2->3->4->5->6->7
    private static void test02() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        ListNode result = deleteDuplication(n1);
        io.printList(result);
    }

    // 1->1->1->1->1->1->2
    private static void test03() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(1);
        ListNode n6 = new ListNode(1);
        ListNode n7 = new ListNode(2);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        ListNode result = deleteDuplication(n1);
        io.printList(result);
    }


    // 1->1->1->1->1->1->1
    private static void test04() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(1);
        ListNode n6 = new ListNode(1);
        ListNode n7 = new ListNode(1);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        ListNode result = deleteDuplication(n1);
        io.printList(result);
    }

    // 1->1->2->2->3->3->4->4
    private static void test05() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(3);
        ListNode n7 = new ListNode(4);
        ListNode n8 = new ListNode(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;

        ListNode result = deleteDuplication(n1);
        io.printList(result);
    }

    // 1->1->2->3->3->4->5->5
    private static void test06() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(4);
        ListNode n7 = new ListNode(5);
        ListNode n8 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;

        ListNode result = deleteDuplication(n1);
        io.printList(result);
    }

    // 1->1->2->2->3->3->4->5->5
    private static void test07() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(3);
        ListNode n7 = new ListNode(4);
        ListNode n8 = new ListNode(5);
        ListNode n9 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;

        ListNode result = deleteDuplication(n1);
        io.printList(result);
    }

    // 1->2
    private static void test08() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);

        n1.next = n2;

        ListNode result = deleteDuplication(n1);
        io.printList(result);
    }

    // 1
    private static void test09() {
        ListNode n1 = new ListNode(1);
        ListNode result = deleteDuplication(n1);
        io.printList(result);
    }

    // null
    private static void test10() {
        ListNode result = deleteDuplication(null);
        io.printList(result);
    }
}


/* Output:
1->2->5->null
1->2->3->4->5->6->7->null
2->null
null
null
2->4->null
4->null
1->2->null
1->null
null
 *///:~