package Game4399;

import java.util.Scanner;
import java.util.Stack;

public class Matching {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(check(str));
    }

    private static boolean check(String str) {
        if (str.isEmpty()) return false;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(' || str.charAt(i) == '{') {
                stack.push(str.charAt(i));
            } else if (!stack.isEmpty() && stack.peek() == '{' && str.charAt(i) == '}') {
                stack.pop();
            } else if (!stack.isEmpty() && stack.peek() == '(' && str.charAt(i) == ')') {
                stack.pop();
            }
        }

        // 如果栈是空的，说明括号匹配
        return stack.isEmpty();
    }
}