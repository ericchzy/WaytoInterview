package com.company;

//import com.company.util.TestUtil;
//import com.company.TestUtil;

import com.company.util.io;

import java.util.*;

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


        /**
         * HashMap遍历效率技巧：
         * 1> 通过keySet来遍历效率低下，对于keySet其实是遍历了2次，一次是转为iterator，一次就是从HashMap中取出key所对于的value
         * 2> 通过entrySet来遍历效率较高
         */


        System.out.println("-----");
        Map map = new HashMap();
        map.put("key1","lisi1");
        map.put("key2","lisi2");
        map.put("key3","lisi3");
        map.put("key4","lisi4");

        // 使用keySet遍历
        Iterator keyIterator = map.keySet().iterator();
        while (keyIterator.hasNext()) {
            Object key = keyIterator.next();
            System.out.println(map.get(key));
        }
        //将map集合中的映射关系取出，存入到set集合
        Iterator it = map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry e =(Map.Entry) it.next();
            System.out.println("键"+e.getKey () + "的值为" + e.getValue());
        }

        /**
         * 自定义类型作为Map的键
         */
        System.out.println("-----");
        HashMap<Person, String> personMap = new HashMap<>();

        personMap.put(new Person("001"), "findingsea");
        personMap.put(new Person("002"), "linyin");
        personMap.put(new Person("003"), "henrylin");
        personMap.put(new Person("003"), "findingsealy");

        System.out.println(personMap.toString());

        System.out.println(personMap.get(new Person("001")));
        System.out.println(personMap.get(new Person("002")));
        System.out.println(personMap.get(new Person("003")));


        /**
         * String.hashCode()
         */

        System.out.println("findingsea".hashCode());
        System.out.println("findingsea".hashCode());
        System.out.println(new String("findingsea").hashCode());
        System.out.println(new String("findingsea").hashCode());

        /**
         * thread.run()还是当作普通方法的方式调用，程序还是要顺序执行，要等待run方法体执行完毕后，才可继续执行下面的代码
         * thread.start()才是将线程体放入到线程等待序列之中等待线程调度程序运行
         */
        System.out.println("-----");
        Runner1 runner1 = new Runner1();
        Runner2 runner2 = new Runner2();
//		Thread(Runnable target) 分配新的 Thread 对象。
        Thread thread1 = new Thread(runner1);
        Thread thread2 = new Thread(runner2);
//		thread1.start();
//		thread2.start();
        thread1.run();
        thread2.run();

        System.out.println("-----");
        Integer[] arr = new Integer[]{1,2,3,4,5};
        Arrays.sort(arr, Collections.reverseOrder());
        System.out.println(Arrays.toString(arr));
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


    static class Runner1 implements Runnable { // 实现了Runnable接口，jdk就知道这个类是一个线程
        public void run() {
            for (int i = 0; i < 2; i++) {
                System.out.println("进入Runner1运行状态——————————" + i);
            }
        }
    }

    static class Runner2 implements Runnable { // 实现了Runnable接口，jdk就知道这个类是一个线程
        public void run() {
            for (int i = 0; i < 2; i++) {
                System.out.println("进入Runner2运行状态==========" + i);
            }
        }
    }
}

class Person {
    private String id;

    public Person(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (id != null ? !id.equals(person.id) : person.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}

