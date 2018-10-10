package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class RadixSort {
    public static void sort(int[] arr) {
        if (arr == null || arr.length == 0) return;

        int maxBit = getMaxBit(arr);

        //注意这里的起止数字
        for (int i = 1; i <= maxBit; i++) {
            List<List<Integer>> buf = distribute(arr, i);
            collect(arr, buf);
        }
    }

    private static List<List<Integer>> distribute(int[] arr, int iBit) {
        List<List<Integer>> buf = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            buf.add(new LinkedList<>());
        }

        for (int anArr : arr) {
            buf.get(getNBit(anArr, iBit)).add(anArr);
        }
        return buf;
    }

    private static void collect(int[] arr, List<List<Integer>> bufs) {
        int k = 0;

        for (List<Integer> buf : bufs) {
            if (buf != null) {
                for (Integer ele : buf) {
                    arr[k++] = ele;
                }
            }
        }
    }


    /**
     * 获取数组元素的最大位数
     * @param arr the array
     * @return max bit
     */
    private static int getMaxBit(int[] arr) {
        int max = Integer.MIN_VALUE;
        for(int ele : arr) {
            int len = String.valueOf(ele).length();
            if(len > max)
                max = len;
        }
        return max;
    }


    /**
     * 如果元素长度足够则返回第n位的数字
     * @param x
     * @param n
     * @return
     */
    private static int getNBit(int x, int n) {
        String s = String.valueOf(x);
        if (s.length() < n) return 0;
        else return s.charAt(s.length() - n) - '0';
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();

        System.out.println();
        int N = 10000;
        int[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        RadixSort.sort(arr);
        SortTestHelper.printArray(arr);

    }

    private static void test1() {
        int arr[] = {5, 3, 8, 6, 4};
        RadixSort.sort(arr);
        System.out.println();
        System.out.println(Arrays.toString(arr));
    }

    private static void test2() {
        int arr[] = {};
        RadixSort.sort(arr);
        System.out.println();
        System.out.println(Arrays.toString(arr));
    }

    private static void test3() {
        int arr[] = {2, 3, 4, 5, 6};
        RadixSort.sort(arr);
        System.out.println();
        System.out.println(Arrays.toString(arr));
    }


    private static void test4() {
        int arr[] = {6, 5, 4, 3, 2};
        RadixSort.sort(arr);
        System.out.println();
        System.out.println(Arrays.toString(arr));
    }
}
