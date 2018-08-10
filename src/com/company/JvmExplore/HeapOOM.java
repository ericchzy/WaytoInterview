package com.company.JvmExplore;

import java.util.ArrayList;
import java.util.List;

public class HeapOOM {

    public static class OOMObject {

    }

    public static void main(String[] args) {
	// write your code here
        List<OOMObject> objects = new ArrayList<>();
        while (true) {
            objects.add(new OOMObject());
            System.out.println(System.currentTimeMillis());
        }
    }
}

/* Output:
Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
	at java.base/java.util.Arrays.copyOf(Arrays.java:3719)
	at java.base/java.util.Arrays.copyOf(Arrays.java:3688)
	at java.base/java.util.ArrayList.grow(ArrayList.java:237)
	at java.base/java.util.ArrayList.grow(ArrayList.java:242)
	at java.base/java.util.ArrayList.add(ArrayList.java:467)
	at java.base/java.util.ArrayList.add(ArrayList.java:480)
	at com.company.JvmExplore.HeapOOM.main(HeapOOM.java:16)
*///:~
