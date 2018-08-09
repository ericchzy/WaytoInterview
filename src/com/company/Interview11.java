package com.company;

public class Interview11 {
    public static ListNode findKthToTail(ListNode head,int k) {
        if (k < 1 || head == null) {
            return null;
        }

        ListNode pointer = head;

        //pointer is (k-1) prior to the head node
        while (--k != 0) {
            if (pointer.next != null) {
//                Notice whether the List is loop
//                pointer = head;
                pointer = pointer.next;
            } else {
                return null;
            }
        }
        while (pointer.next != null) {
            pointer = pointer.next;
            head = head.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode();
        head.value = 1;

        head.next = new ListNode();
        head.next.value = 2;

        head.next.next = new ListNode();
        head.next.next.value = 3;

        head.next.next.next = new ListNode();
        head.next.next.next.value = 4;

        head.next.next.next.next = new ListNode();
        head.next.next.next.next.value = 5;

        head.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.value = 6;

        head.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.value = 7;

        head.next.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.next.value = 8;

        head.next.next.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.next.next.value = 9;

        System.out.println(findKthToTail(head, 1).value); // 倒数第一个
        System.out.println(findKthToTail(head, 5).value); // 中间的一个
        System.out.println(findKthToTail(head, 9).value); // 倒数最后一个就是顺数第一个

        System.out.println(findKthToTail(head, 10));
    }
}
