package com.company.JVMExplore;

public class StackOverflowError {

    private static int stackLength = 1;

    public static void methodStackLeak() {
        stackLength++;
        methodStackLeak();
    }

    public static void main(String[] args) {
        StackOverflowError stackOverflowError = new StackOverflowError();
        try {
            stackOverflowError.methodStackLeak();
        } catch (Throwable throwable) {
            System.out.println("stackLength is: " + stackLength);
            throw throwable;
        }
    }
}

/* Output:
Exception in thread "main" java.lang.StackOverflowError
stackLength is: 33430
	at com.company.JVMExplore.StackOverflowError.methodStackLeak(StackOverflowError.java:9)
    at com.company.JVMExplore.StackOverflowError.methodStackLeak(StackOverflowError.java:9)
    ...
*///:~

