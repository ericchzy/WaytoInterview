package com.company.JvmExplore;

import static java.lang.System.out;

public class ThreadSafetySynchronizedWay {
    public static void main(String[] args) throws InterruptedException {
        class Count{
            private int count=0;
            public synchronized void increment() {count++;}
            public int getCount() {return count;}

        }

        final Count counter=new Count();
        class CountingThread extends Thread {
            public void run() {
                for (int i=0; i<1000;i++ ) {
                    counter.increment();
                }
            }
        }

        CountingThread t1=new CountingThread();
        CountingThread t2=new CountingThread();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        out.println(counter.getCount());
    }
}
