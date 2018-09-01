package com.company;

public class Interview67_StringtoInt {
    public static int stringToInt(String str) {
        boolean flag = false; // false for none
        boolean symbol = false; // false for positive
        double result = 0;
        if(str == null || str.length() < 1) {
            return 0;
        }

        str.trim();
        int index = str.length() - 1; // the current char in string
        int end = 0; // the end option was selected to ignore the flag bit
        int weight = 1; // the weight is the power of the current char in mathematics.

        if(str.charAt(0) == '-') {
            flag = true;
            symbol = true;
        } else if(str.charAt(0) == '+') {
            flag = true;
        }
        if(flag) { end = 1;}
        while (index >= end ) {
            if (!isDigit(str.charAt(index))) {
                return 0;
            }
            result += (str.charAt(index) - '0') * weight;
            weight *= 10;
            index--;

        }
        if (symbol) {
            result = -result;
        }

        if (result > Integer.MAX_VALUE){
            throw new NumberFormatException();
        } else if (result < Integer.MIN_VALUE) {//有问题
            throw new NumberFormatException();
        }

        return (int)result;
    }

    public static boolean isDigit(char input_char) {
        return (input_char > '0') && (input_char < '9');
    }

    public static int atoi(String str) {
        if (str == null || str.length() < 1)
            return 0;

        // trim white spaces
        str = str.trim();

        char flag = '+';

        // check negative or positive
        int i = 0;
        if (str.charAt(0) == '-') {
            flag = '-';
            i++;
        } else if (str.charAt(0) == '+') {
            i++;
        }
        // use double to store result
        double result = 0;

        // calculate value
        while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            result = result * 10 + (str.charAt(i) - '0');
            i++;
        }

        if (flag == '-')
            result = -result;

        // handle max and min
        if (result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        if (result < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        return (int) result;
    }


    public static void main(String[] args) {
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(0x8000_000L);
        System.out.println(stringToInt("123"));
        System.out.println(stringToInt("+123"));
        System.out.println(stringToInt("-123"));
        System.out.println(stringToInt("1a123"));
        System.out.println(stringToInt("+2147483647"));
        System.out.println(stringToInt("-2147483647"));
        System.out.println(stringToInt("-2147483648"));
//        System.out.println(stringToInt("+2147483648"));

    }
}

/* Output:
123
123
-123
0
2147483647
-2147483647
0  // WRONG
*///:~

