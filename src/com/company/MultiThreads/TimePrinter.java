package com.company.MultiThreads;

import java.util.Date;

/**
 * 多线程的不同实现
 * 因为实现 Runnable 接口相比继承 Thread 类有如下优势：
 * <p>
 * 可以避免由于 Java 的单继承特性而带来的局限；
 * 增强程序的健壮性，代码能够被多个线程共享，代码与数据是独立的；
 * 适合多个相同程序代码的线程区处理同一资源的情况。
 */

/*
public class TimePrinter extends Thread {
    private int pauseTime;
    private String name;

    public TimePrinter(String name, int pauseTime) {
        this.name = name;
        this.pauseTime = pauseTime;
    }

    public void run() {
        while (true) {
            try {
                System.out.println(name + ":" + new Date(System.currentTimeMillis()));
                Thread.sleep(pauseTime);
            } catch (Exception e){
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        TimePrinter p1 = new TimePrinter("Fast Guy", 1000);
        TimePrinter p2 = new TimePrinter("Slow Guy", 3000);
        p1.start();
        p2.start();
    }
}
*/

public class TimePrinter implements Runnable {
    private int pauseTime;
    private String name;

    public TimePrinter(String name, int pauseTime) {
        this.name = name;
        this.pauseTime = pauseTime;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(name + ":" + new Date(System.currentTimeMillis()));
                Thread.sleep(pauseTime);
            } catch (Exception e){
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        Thread p1 = new Thread(new TimePrinter("Fast Guy", 1000));
        Thread p2 = new Thread(new TimePrinter("Slow Guy", 3000));
        p1.start();
        p2.start();
    }
}
