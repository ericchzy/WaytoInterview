package Algorithm;

public class SelectSort {
    public static void sort(int[] arr) {
        if (arr == null || arr.length == 0) return;

        int minIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) minIndex = j;
            }

            if (arr[minIndex] < arr[i]) swap(arr, minIndex, i);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        System.out.println();
        int N = 20000;
        int[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SelectSort.sort(arr);
        SortTestHelper.printArray(arr);

        test1();
        test2();
        test3();
        test4();
    }

    private static void test1() {
        int arr[] = {5, 3, 8, 6, 4};
        SelectSort.sort(arr);
        System.out.println();
        for (int element : arr) {
            System.out.print(element + " ");
        }
    }

    private static void test2() {
        int arr[] = {};
        SelectSort.sort(arr);
        System.out.println();
        for (int element : arr) {
            System.out.print(element + " ");
        }
    }

    private static void test3() {
        int arr[] = {2, 3, 4, 5, 6};
        SelectSort.sort(arr);
        System.out.println();
        for (int element : arr) {
            System.out.print(element + " ");
        }
    }


    private static void test4() {
        int arr[] = {6, 5, 4, 3, 2};
        SelectSort.sort(arr);
        System.out.println();
        for (int element : arr) {
            System.out.print(element + " ");
        }
    }
}
