package com.company.JvmExplore;

import java.util.ArrayList;
import java.util.List;

/**
 * -XX:PermSize=10M -XX:MaxPermSize=
 * Output:
 * Java HotSpot(TM) 64-Bit Server VM warning: Ignoring option PermSize; support was removed in 8.0
 * Java HotSpot(TM) 64-Bit Server VM warning: Ignoring option MaxPermSize; support was removed in 8.0
 */

/**
 * -Xms20m -Xmx20m
 */

public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        while (true) {
            list.add(" ".intern());
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
	at com.company.JvmExplore.RuntimeConstantPoolOOM.main(RuntimeConstantPoolOOM.java:16)
*///:~



