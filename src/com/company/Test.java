package com.company;

//import com.company.util.TestUtil;
//import com.company.TestUtil;

public class Test {
    public static void main(String[] args)  {
//        SimilarString str=null;
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
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println("----");
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

        System.out.println("-----");
        int i = '1' + '2' + '3';
        System.out.println(i);

        /**
         * 150 because ASCII value for
         * character 1,2,3 are 49,50,51 which return 150 when doing the addition.
         */

        System.out.println("-----");
        System.out.println("is" + 100 + 5);
        System.out.println("is" + (100 + 5));
        System.out.println(100 + 5 + "is");
        System.out.println(100 + "is" + 5); //这个应该也是自动包装了

        /**
         * 字符串大小问题
         */
        System.out.println("-----");
        System.out.println("'ABCD' compare to 'DCBA': " + "ABCD".compareTo("DCBA"));

        /**
         * try-catch-finally问题
         */

        System.out.println("-----");
        System.out.println(test());
        System.out.println();
        System.out.println(getVal("10"));
        System.out.println(getVal(null));
        System.out.println(getVal("x"));
        System.out.println(getVal("-2"));

        /**
         * Object对象方法问题
         */
        Object object = new Object();

        /**
         * Initialize array
         */
        boolean[] visited = new boolean[3 * 4];

        System.out.println("-----");
        for (boolean bool : visited) {
            System.out.print(bool + " ");
        }

        System.out.println();
        System.out.println("-----");
        System.out.println(14^3);

    }

    public static int test() {
        try {
            return 0;
        }
        finally {
            System.out.println("finally trumps return.");
        }
    }

    public static int getVal(String str) {
        int val = 0;
        try {
            val = Integer.parseInt(str);
            return val;
        } catch (NumberFormatException e) {
            return val;
        }
        finally {
            val = -1;
        }
    }
}
