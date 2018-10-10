package Algorithm;

import java.util.Arrays;

public class BubbleSort {
    public static void sort(int[] arr) {
        if (arr == null || arr.length == 0) return;
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) swap(arr, j, j - 1);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();

        System.out.println();
        int N = 20000;
        int[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        BubbleSort.sort(arr);
        SortTestHelper.printArray(arr);
    }

    private static void test1() {
        int arr[] = {5, 3, 8, 6, 4};
        BubbleSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void test2() {
        int arr[] = {};
        BubbleSort.sort(arr);
        System.out.println();
        System.out.println(Arrays.toString(arr));
    }

    private static void test3() {
        int arr[] = {2, 3, 4, 5, 6};
        BubbleSort.sort(arr);
        System.out.println();
        System.out.println(Arrays.toString(arr));
    }


    private static void test4() {
        int arr[] = {6, 5, 4, 3, 2};
        BubbleSort.sort(arr);
        System.out.println();
        System.out.println(Arrays.toString(arr));
    }
}

/* Output:
3 4 5 6 8

2 3 4 5 6
2 3 4 5 6
*///:~