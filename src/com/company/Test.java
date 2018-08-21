package com.company;

//import com.company.util.TestUtil;
//import com.company.TestUtil;

public class Test {
    public static void main(String[] args)  {
//        String str=null;
//        str.concat("abc");
//        str.concat("123");
//        System.out.println(str);

        String string = "";
        char[] charArray = string.toCharArray();
        System.out.println(charArray);

        String a = "abc";
        String b = "ab" + "c";
        String c = "ab";
        String d = c + "c";
        System.out.println("Test1: " + a==b); // 没有打印前面的字符串
        System.out.println(a==b);
        System.out.println("Test3: " + a.equals(b));
        System.out.println("Test4: " + a==d); // 没有打印前面的字符串
        System.out.println(a==d);

        /**
         * false
         * true
         * Test3: true
         * false
         * false
         */

        int i = '1' + '2' + '3';
        System.out.println(i);

        /**
         * 150 because ASCII value for
         * character 1,2,3 are 49,50,51 which return 150 when doing the addition.
         */


    }


}
