package Algorithm;

import java.util.Arrays;

public class CountSort {
    public static void sort(int[] arr) {
        if (arr == null || arr.length == 0) return;

        int max = max(arr);
        int[] count = new int[max + 1];
        Arrays.fill(count, 0);
        for (int ele : arr) {
            count[ele]++;
        }

        int k = 0;
        for (int i = 0; i <= max; i++) {
            for (int j = 0; j < count[i]; j++) {
                arr[k++] = i;
            }
        }
    }

    private static int max(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int ele : arr) {
            if (ele > max) max = ele;
        }

        return max;
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();

        System.out.println();
        int N = 10000;
        int[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        CountSort.sort(arr);
        SortTestHelper.printArray(arr);

    }

    private static void test1() {
        int arr[] = {5, 3, 8, 6, 4};
        CountSort.sort(arr);
        System.out.println();
        System.out.println(Arrays.toString(arr));
    }

    private static void test2() {
        int arr[] = {};
        CountSort.sort(arr);
        System.out.println();
        System.out.println(Arrays.toString(arr));
    }

    private static void test3() {
        int arr[] = {2, 3, 4, 5, 6};
        CountSort.sort(arr);
        System.out.println();
        System.out.println(Arrays.toString(arr));
    }


    private static void test4() {
        int arr[] = {6, 5, 4, 3, 2};
        CountSort.sort(arr);
        System.out.println();
        System.out.println(Arrays.toString(arr));
    }
}
