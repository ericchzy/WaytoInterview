package com.company;

public class Interview16 {
    static boolean gInvalidInput = false;

    public static double Power(double base, int exponent) {
        if(equal(base, 0.0) && (exponent < 0)) {
            gInvalidInput = true;
            return 0.0;
        }

        double result;

        if(exponent < 0) {
            int absExponent = (-exponent);
            result = PowWithUnsignedExp(base, absExponent);
            return 1/result;
        }
        result = PowWithUnsignedExp(base, exponent);

        return result;
    }

    private static double PowWithUnsignedExp(double base, int exponent) {
        if(exponent == 0) {
            return 1;
        }
        if(exponent == 1) {
            return base;
        }

        double result = PowWithUnsignedExp(base, exponent>>1);
        result *= result;

        //Deal with the last item when exponent is odd
        if((exponent & 0x1) == 1) {
            result *= base;
        }
        return result;
    }

    private static boolean equal(double num1, double num2) {
        return ((num1 - num2 < 1e-8) && (num2 - num1 < 1e-8));
    }

    public static void main(String[] args) {
        System.out.println(Power(-2, 3));
        System.out.println(Power(-2, -3));
        System.out.println(Power(0, -2));
        System.out.println(Power(1, 0));
    }
}
