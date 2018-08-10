package com.company;

public class Interview13 {
    public static ListNode deleteDuplication(ListNode pHead)
    {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }

        /* Loop Version */
        ListNode root = new ListNode(-1);
        root.next = pHead;
        ListNode current = pHead;
        ListNode last = root;
        while (current != null && current.next != null) {
            if (current.value == current.next.value) {
                while (current.next != null && current.next.value == current.value) {
                    current = current.next;
                }
                last.next = current;
            } else {
                last = current;
                current = current.next;
            }
        }
        return root.next;

/*        *//* Recursive Version *//*
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
1->2->3->4->5->null
1->2->3->4->5->6->7->null
1->2->null
1->null
1->2->3->4->null
1->2->3->4->5->null
1->2->3->4->5->null
1->2->null
1->null
null
 *///:~