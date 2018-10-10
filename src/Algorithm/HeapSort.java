package Algorithm;

import java.util.Arrays;

public class HeapSort {
    public static void sort(int[] arr) {
        if (arr == null || arr.length == 0) return;

        for (int i = arr.length / 2; i >= 0; i--) {
            heapAdjust(arr, i, arr.length - 1);
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            swap(arr, 0, i);
            heapAdjust(arr, 0, i - 1);
        }

    }

    private static void heapAdjust(int[] arr, int start, int end) {
        int temp = arr[start];

        for (int i = 2 * start + 1; i <= end; i *= 2) {
            //注意 i < end
            if (i < end && arr[i] < arr[i+1]) i++;
            if (temp >= arr[i]) break;
            arr[start] = arr[i];
            start = i;
        }

        arr[start] = temp;
    }

    public static void swap(int[] arr, int i, int j) {
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
        int N = 10000;
        int[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        HeapSort.sort(arr);
        SortTestHelper.printArray(arr);

    }

    private static void test1() {
        int arr[] = {5, 3, 8, 6, 4};
        HeapSort.sort(arr);
        System.out.println();
        System.out.println(Arrays.toString(arr));
    }

    private static void test2() {
        int arr[] = {};
        HeapSort.sort(arr);
        System.out.println();
        System.out.println(Arrays.toString(arr));
    }

    private static void test3() {
        int arr[] = {2, 3, 4, 5, 6};
        HeapSort.sort(arr);
        System.out.println();
        System.out.println(Arrays.toString(arr));
    }


    private static void test4() {
        int arr[] = {6, 5, 4, 3, 2};
        HeapSort.sort(arr);
        System.out.println();
        System.out.println(Arrays.toString(arr));
    }
}
