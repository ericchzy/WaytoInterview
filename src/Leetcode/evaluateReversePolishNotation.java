package Leetcode;

import java.util.Stack;

public class evaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        return evalRPNImpl(tokens);
    }

    private int evalRPNImpl(String[] tokens) {
        if (tokens == null || tokens.length == 0) return 0;

        Stack<Integer> stack = new Stack<>();

        for (String str : tokens){
            if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
                // 首先需要判断堆栈中有足够的操作数字
                if (stack.size() < 2) throw new RuntimeException("所给的操作数字不匹配");
                // 注意在遇到除法的时候出栈数字的前后顺序
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(calculate(str, num1, num2));
            } else {
                try {
                    stack.push(Integer.parseInt(str));
                } catch (Exception e) {
                    throw new NumberFormatException("给出的参数错误" + e.getMessage());
                }
            }
        }
        return stack.size() == 1 ? stack.pop() : 0;
    }

    private int calculate(String op, int f1, int f2) {
        if (op.equals("+")) {
            return f1 + f2;
        } else if (op.equals("-")) {
            return f1 - f2;
        } else if (op.equals("*")) {
            return f1 * f2;
        } else if (op.equals("/")) {
            // 需要注意 0 为除数的情况，以及除法中取整的情况
            if (f2 == 0) throw new NumberFormatException("除数为0的情况");
            return f1 / f2;
        }
        throw new IllegalArgumentException("计算机暂时不支持此运算符");
    }

    public static void main(String[] args) {
         String[] test1 = {"2", "1", "+", "3", "*"};
    }
}
