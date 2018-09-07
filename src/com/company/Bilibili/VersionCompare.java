package com.company.Bilibili;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class VersionCompare {


    /*请完成下面这个函数，实现题目要求r的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static long compareVersionNumber(String[] versions) {
        String[] versionArray1 = versions[0].split("\\.");
        String[] versionArray2 = versions[1].split("\\.");
        int idx = 0;
        int minLength = Math.min(versionArray1.length, versionArray2.length); //取最小长度值
        long diff = 0;
        while (idx < minLength
                && (diff = versionArray1[idx].length() - versionArray2[idx].length()) == 0//先比较长度
                && (diff = versionArray1[idx].compareTo(versionArray2[idx])) == 0) { //再比较字符
            ++idx;
        }
        //如果已经分出大小，则直接返回，如果未分出大小，则再比较位数，有子版本的为大；
        diff = (diff != 0) ? diff : versionArray1.length - versionArray2.length;
        return diff;

        //符合题目要求的输出
//        if (diff > 0) return 1;
//        else if (diff < 0) return -1;
//        else return versionArray1.length - versionArray2.length;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String string = in.nextLine();
        long res;
        String[] versions = string.split("\\ ");

        res = compareVersionNumber(versions);
        System.out.println(String.valueOf(res));

    }
}
