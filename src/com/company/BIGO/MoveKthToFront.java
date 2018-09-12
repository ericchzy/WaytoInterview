package com.company.BIGO;

import com.company.util.ListNode;

public class MoveKthToFront {
    private static ListNode moveKthToFront(ListNode head, int k) {
        if (head == null || k < 0) return null;

        ListNode forwardNode = head;
        ListNode backwardNode = head;

        // forwardNode forward k-1 step
        // and mind the k may smaller than the length of the list
        for (int i = 0; i < k; i++)
            if(forwardNode.next != null)forwardNode = forwardNode.next;
            else return null;

        while (forwardNode.next != null) {
            forwardNode = forwardNode.next;
            backwardNode = backwardNode.next;
        }

        forwardNode.next = head;
        ListNode resultList = backwardNode.next;
        backwardNode.next = null;

        return resultList;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode();
        head.value = 1;
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.print("List is : ");
        printList(head);

        // test1
        int k1 = 2;
        System.out.print("After move " + k1 + "th from back to front, " + "List is : ");
        printList(moveKthToFront(head, k1));

        // test2
        int k2 = 10;
        System.out.print("After move " + k2 + "th from back to front, " + "List is : ");
        printList(moveKthToFront(head, k2));

        // test3
        int k3 = 2;
        ListNode nullList = null;
        System.out.print("After move " + k3 + "th from back to front, " + "List is : ");
        printList(moveKthToFront(nullList, k3));

    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.value + "->");
            head = head.next;
        }
        System.out.println("null");
    }
}

/* Output:
List is : 1->2->3->4->5->null
After move 2th from back to front, List is : 4->5->1->2->3->null
After move 10th from back to front, List is : null
After move 2th from back to front, List is : null
 *///:~