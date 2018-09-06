package com.company;

import java.util.Stack;

public class Interview30_MinFuncStack {

    public static class MinFuncStack<T extends Comparable<T>> {
        private Stack<T> dataStack;
        private Stack<T> auxStack;

        public MinFuncStack() {
            this.dataStack = new Stack<>();
            this.auxStack= new Stack<>();
        }

        public void push(T node) {
            if (node == null) {
                throw new RuntimeException("Node can't be null");
            }

            dataStack.add(node);
            if (auxStack.isEmpty() || node.compareTo(auxStack.peek()) <= 0) {
                auxStack.push(node);
            } else {
                auxStack.push(auxStack.peek());
            }
        }

        public T pop() {
            if (dataStack.isEmpty()) {
                throw new RuntimeException("No Element in stack.");
            }
            auxStack.pop();
            return dataStack.pop();

        }

        public T top() {
            return dataStack.peek();
        }

        public T min() {
            return auxStack.peek();
        }
    }

    public static void main(String[] args) {
        MinFuncStack<Integer> stack = new MinFuncStack<>();
        stack.push(3);
        System.out.println(stack.min() == 3);
        System.out.println("Current TOP: " + stack.top());
        stack.push(4);
        System.out.println(stack.min() == 3);
        System.out.println("Current TOP: " + stack.top());
        stack.push(2);
        System.out.println(stack.min() == 2);
        System.out.println("Current TOP: " + stack.top());
        stack.push(1);
        System.out.println(stack.min() == 1);
        System.out.println("Current TOP: " + stack.top());
        stack.pop();
        System.out.println(stack.min() == 2);
        System.out.println("Current TOP: " + stack.top());
        stack.pop();
        System.out.println(stack.min() == 3);
        System.out.println("Current TOP: " + stack.top());
        stack.push(0);
        System.out.println(stack.min() == 0);
        System.out.println("Current TOP: " + stack.top());
    }
}

/* Output:
true
Current TOP: 3
true
Current TOP: 4
true
Current TOP: 2
true
Current TOP: 1
true
Current TOP: 2
true
Current TOP: 4
true
Current TOP: 0
*///:~
