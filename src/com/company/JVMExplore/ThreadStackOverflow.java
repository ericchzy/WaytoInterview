package com.company.JVMExplore;

public class ThreadStackOverflow {

    private void wontStopMethod() {
        while (true) {
            System.out.println(System.currentTimeMillis());
        }
    }

    public void createThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    wontStopMethod();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) {
        ThreadStackOverflow threadStackOverflow = new ThreadStackOverflow();
        threadStackOverflow.createThread();
    }
}

/* Output:
Exception in thread "main" java.lang.OutOfMemoryError: unable to create native thread: possibly out of memory or process/resource limits reached
	at java.base/java.lang.Thread.start0(Native Method)
	at java.base/java.lang.Thread.start(Thread.java:813)
	at com.company.JVMExplore.ThreadStackOverflow.createThread(ThreadStackOverflow.java:19)
	at com.company.JVMExplore.ThreadStackOverflow.main(ThreadStackOverflow.java:25)
*///:~