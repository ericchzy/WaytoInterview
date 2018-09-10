package com.company;

import java.util.List;

import static com.company.io.printList;

public class Interview18_DeleteNode {


    /**
     * 给定单向链表的头指针和一个结点指针，定义一个函数在0(1)时间删除该结点,
     * 【注意1：这个方法和文本上的不一样，书上的没有返回值，这个因为JAVA引用传递的原因，
     * 如果删除的结点是头结点，如果不采用返回值的方式，那么头结点永远删除不了】
     * 【注意2：输入的待删除结点必须是待链表中的结点，否则会引起错误，这个条件由用户进行保证】
     *
     * @param head        链表表的头
     * @param toBeDeleted 待删除的结点
     * @return 删除后的头结点
     */
    private static ListNode deleteInO1(ListNode head, ListNode toBeDeleted) {
        if (head == null || toBeDeleted == null) {
            return head;
        }
        //首先进行尾节点的判断
        //若不是，则将下一个节点的值复制到需要删除的节点上，然后再删除下一个节点
        if (head == toBeDeleted) return head;

        if (toBeDeleted.next == null) {
            ListNode tmpNode = head;
            while (tmpNode.next != toBeDeleted) {
                tmpNode = tmpNode.next;
            }
            tmpNode.next = null;
        }

        else {
            toBeDeleted.value = toBeDeleted.next.value;
            toBeDeleted.next = toBeDeleted.next.next;
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

        ListNode middle = head.next.next.next.next = new ListNode();
        head.next.next.next.next.value = 5;

        head.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.value = 6;

        head.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.value = 7;

        head.next.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.next.value = 8;

        ListNode last = head.next.next.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.next.next.value = 9;

        head = deleteInO1(head, null); // 删除的结点为空
        printList(head);
        ListNode node = new ListNode();
        node.value = 12;

        head = deleteInO1(head, head); // 删除头结点
        printList(head);
        head = deleteInO1(head, last); // 删除尾结点
        printList(head);
        head = deleteInO1(head, middle); // 删除中间结点
        printList(head);

        head = deleteInO1(head, node); // 删除的结点不在链表中
        printList(head);
    }
}
