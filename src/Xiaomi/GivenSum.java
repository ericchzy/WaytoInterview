package Xiaomi;

import java.util.Scanner;

/**
 * 列举数组中任意元素和为定值的组合
 */
public class GivenSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int sum = in.nextInt();
        int[] value = new int[n];
        long[] dp = new long[sum + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            value[i] = in.nextInt();
            for (int j = sum; j >= 0; j--) {
                if (j >= value[i]) {
                    dp[j] += dp[j - value[i]];
                }
            }
        }
        System.out.println(dp[sum] > 0 ? "1" : "0");
    }
}

//public class GivenSum {
//    // Arrays.sort(arr);
//    private static int[] flag = new int[100];
//    private static int index = 0;// 记录当前
//    public static void numGroupAll(int[] arr, int start, int length, int sum) {
//        if (sum == 0) {
//            for (int j = 0; j < index; j++) {
//                System.out.print(flag[j]);
//            }
//            System.out.println();
//        }
//        else if(sum>0) {
//            for (int i = start; i < length; i++) {
//                flag[index++] = arr[i];
//                GivenSum.numGroupAll(arr, i + 1, length-1, sum - arr[i]);
//
//            }
//        }
//        index--;   //若sum<0  则表示该数不满足条件，需要index--, 因为之前假设该数满足条件 index++找该数下一个数
//    }
//
//    private static void numGroup(int[] arr, int start, int length, int sum) {
//        if (sum == 0) {
//            for (int j = 0; j < index; j++) {
//                System.out.print(flag[j]);
//            }
//            System.out.println();
////            System.out.print("1");
////            return;
////            System.exit(0);
//        }
//        else if(sum>0) {
//            for (int i = start; i < length; i++) {
//                int temp_sum = sum - arr[i];
//
//                if (temp_sum >= 0) {
//                    flag[index++] = arr[i];
//                    // System.out.println(index);
//                    GivenSum.numGroup(arr, i + 1, length - 1, sum - arr[i]);
//                } else    //因为后面的数比这个大，若此时temp_sum小于0，则后面的数更不满足条件，不用再进行循环
//                    break;
//            }
//        }
//        index--;
////        System.out.println(index);
//    }
//
//
//    public static void main(String[] args) {
////        int[] arr = {99, 199, 1999, 10000, 39, 1499};
////        int sum = 10238;
//
//        Scanner sc = new Scanner(System.in);
//        int length = sc.nextInt();
//
//        int[] arr = new int[length];
//        for (int i = 0; i < length; i++) {
//            arr[i] = sc.nextInt();
//        }
//        int sum = sc.nextInt();
//
//        //GivenSum.numGroupAll(arr, 0, arr.length, sum);//数组未排序
//
//        Arrays.sort(arr);  //对数组进行排序后的话，可以用numGroup方法
//
////        for (int element: arr) {
////            System.out.print(element + " ");
////        }
////        System.out.print("\nSum is " + sum);
//
//        GivenSum.numGroup(arr, 0, arr.length, sum);
//    }
//}
