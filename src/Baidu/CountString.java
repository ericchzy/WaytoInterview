package Baidu;

import java.util.ArrayList;
import java.util.List;

class ListNode {
    public char value;
    public ListNode next = null;

    public ListNode() {
    }

    public ListNode(char value) {
        this.value = value;
    }
}

public class CountString {
    private static int countString(String str) {
        if (str == null || str.length() < 1) throw new RuntimeException("Invalid Input.");
        if (str.length() == 1) return 1;

        char[] charArray = str.toCharArray();
        List<String> result = new ArrayList<>();

        ListNode strList = new ListNode();

        ListNode head = strList;

        // 构建头尾相接的循环单链表
        for (int i = 0; i < str.length(); i++) {
            strList.next = new ListNode(str.charAt(i));
            strList = strList.next;
        }

        strList.next = head;
        strList = head;

        // head 位置设为 0
        for (int startPos = 0; startPos < str.length(); startPos++) {
            // 在循环单链表中读取 str.length() 个字符
            for (int i = 0; i < str.length(); i++) {
                charArray[i] = strList.value;
                strList = strList.next;

            }

            if (!result.contains(charArray.toString())) result.add(charArray.toString());

        }

        int resultLength = 0;
        for (String string : result) {
            resultLength++;
        }

        return resultLength;

    }
    public static void main(String[] args) {
        String str = "abab";

        System.out.println(countString(str));
    }
}
