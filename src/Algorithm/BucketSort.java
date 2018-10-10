package Algorithm;

import java.util.*;

public class BucketSort {
    public static void sort(int[] arr) {
        if (arr == null || arr.length == 0) return;

        int bucketNums = 10;
        List<List<Integer>> buckets = new ArrayList<>();

        for (int i = 0; i < bucketNums; i++) {
            buckets.add(new LinkedList<Integer>());
        }

        for (int anArr : arr) {
            buckets.get(map(anArr)).add(anArr);
        }

        for (List<Integer> bucket : buckets) {
            if (bucket != null) Collections.sort(bucket);
        }

        int k = 0;
        for (int i = 0; i < bucketNums; i++) {
            for (Integer ele :
                    buckets.get(i)) {
                arr[k++] = ele;
            }
        }

    }

    private static int map(int x) {
        return x / 10;
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();

        System.out.println();
        int N = 50;
        int[] arr = SortTestHelper.generateRandomArray(N, 0, 99);
        BucketSort.sort(arr);
        SortTestHelper.printArray(arr);

    }

    private static void test1() {
        int arr[] = {5, 3, 8, 6, 4};
        BucketSort.sort(arr);
        System.out.println();
        System.out.println(Arrays.toString(arr));
    }

    private static void test2() {
        int arr[] = {};
        BucketSort.sort(arr);
        System.out.println();
        System.out.println(Arrays.toString(arr));
    }

    private static void test3() {
        int arr[] = {2, 3, 4, 5, 6};
        BucketSort.sort(arr);
        System.out.println();
        System.out.println(Arrays.toString(arr));
    }


    private static void test4() {
        int arr[] = {6, 5, 4, 3, 2};
        BucketSort.sort(arr);
        System.out.println();
        System.out.println(Arrays.toString(arr));
    }
}
