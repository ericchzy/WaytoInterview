package com.company;

import java.util.Stack;

public class Interview09_QueueWithTwoStacks {
    private static Stack<Integer> stack1 = new Stack<Integer>();
    private static Stack<Integer> stack2 = new Stack<Integer>();

    public static void push(int node) {
        stack1.add(node);
    }

    public static int pop() throws Exception {
        if(stack2.isEmpty()) {
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }

        if (stack2.isEmpty()) {
            throw new Exception("queue is empty");
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 3; i++) {
            push(i);
        }
        try {
            System.out.println(pop());
            System.out.println(pop());
        } catch (Exception e) {
            e.printStackTrace();
        }
        push(4);
        try {
            System.out.println(pop());
            System.out.println(pop());
        } catch (Exception e) {
            e.printStackTrace();
        }
        push(5);
        try {
            System.out.println(pop());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
