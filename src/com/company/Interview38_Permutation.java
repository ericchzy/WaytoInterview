package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Interview38_Permutation {
/*
    public static void permutation(char[] str, int low, int high) {
        if (high < 0) {  //单个字符无法输出
            return;
        }
        if (high == low) {
            System.out.println(str);
        } else {
            for (int i = low; i <= high; i++) {
                swap(str, low, i);
                permutation(str, low + 1, high);
                swap(str, i, low);
            }
        }
    }

    private static void swap(char[] str, int left, int right) {
        char tmp = str[left];
        str[left] = str[right];
        str[right] = tmp;
    }

    public static void main(String[] args) {
        char[] charArray1 = {'a', 'b', 'c'};
        char[] charArray2 = {};
        char[] charArray3 = {'a'};

        System.out.println(charArray1.length);
        permutation(charArray1, 0 , charArray1.length-1);

        System.out.println(charArray2.length);
        permutation(charArray2, 0 , charArray2.length-1);

        System.out.println(charArray3.length);
        permutation(charArray3, 0 , charArray3.length-1);
    }
*/

    public static void main(String[] args) {
        System.out.println(Permutation("").toString());
    }
    public static ArrayList<String> Permutation(String str) {
        List<String> res = new ArrayList<>();
        if (str != null && str.length() > 0) {
            PermutationHelper(str.toCharArray(), 0, res);
            Collections.sort(res);
        }
        return (ArrayList<String>) res;
    }

    public static void PermutationHelper(char[] cs, int i, List<String> list) {
        if (i == cs.length - 1) {
            String val = String.valueOf(cs);
            if (!list.contains(val))
                list.add(val);
        } else {
            for (int j = i; j < cs.length; j++) {
                swap(cs, i, j);
                PermutationHelper(cs, i + 1, list);
                swap(cs, i, j);
            }
        }
    }


    public static void swap(char[] cs, int i, int j) {
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }
}
