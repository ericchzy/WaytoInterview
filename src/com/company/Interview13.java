package com.company;

public class Interview13 {
    public static ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        /* Loop Version */
        ListNode mergedList = null;
        ListNode current = null;
        while (list1 != null && list2 != null) {
            if (list1.value < list2.value) {
                if (mergedList == null) {
                    // current 指向正在合并的 List
                    mergedList = current = list1;
                } else {
                    current.next = list1;
                    current = current.next;
                }
                list1 = list1.next;
            } else {
                if (mergedList == null) {
                    mergedList = current = list2;
                } else {
                    current.next = list2;
                    current = current.next;
                }
                list2 = list2.next;
            }
        }
        if (list1 == null) {
            current.next = list2;
        } else {
            current.next = list1;
        }

/*  Recursive Version
        if (list1.value < list2.value) {
            mergedList = list1;
            mergedList.next = Merge(list1.next, list2);
        } else {
            mergedList = list2;
            mergedList.next = Merge(list1, list2.next);
        }*/
        return mergedList;
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


        ListNode head2 = new ListNode();
        head2.value = 1;

        head2.next = new ListNode();
        head2.next.value = 3;

        head2.next.next = new ListNode();
        head2.next.next.value = 5;

        head2.next.next.next = new ListNode();
        head2.next.next.next.value = 6;

        head2.next.next.next.next = new ListNode();
        head2.next.next.next.next.value = 7;

//        head = merge(head, head2);
        head = Merge(head, head2);
        io.printList(head);

    }
}

/* Output:
1->1->2->3->3->4->5->5->6->7->null
*///:~




