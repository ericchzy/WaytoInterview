package com.company;

public class Interview11 {
    public static ListNode findKthToTail(ListNode head,int k) {
        ListNode pNext = null;
        ListNode node = head;

        if(head == null) {
            return null;
        }
        if(k < 0) {
            while(k-- !=0) {
                node = node.next;
            }
        }

        int length = 0;
        while(node != null) {
            length++;
            node = node.next;
        }
        if(k > length) {
            return null;
        }

        int index = length - k;
        node = head;
        while(index-- != 0) {
            node = node.next;
        }

        return node;
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
