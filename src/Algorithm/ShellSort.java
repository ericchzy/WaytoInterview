package Algorithm;

public class ShellSort {
    public static void sort(int[] arr) {
        if (arr == null || arr.length == 0) return;

        int d = arr.length / 2;
        while (d >= 1) {
            shellInsert(arr, d);
            d = d >> 1;
        }
    }

    private static void shellInsert(int[] arr, int d) {
        for (int i = d; i < arr.length; i++) {
            int j = i - d;
            int temp = arr[i];

            while (j >= 0 && arr[j] > temp) {
                arr[j + d] = arr[j];
                j -= d;
            }

            if (j != i - d) arr[j + d] = temp;
        }
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();

        System.out.println();
        int N = 10000;
        int[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        ShellSort.sort(arr);
        SortTestHelper.printArray(arr);

    }

    private static void test1() {
        int arr[] = {5, 3, 8, 6, 4};
        ShellSort.sort(arr);
        System.out.println();
        for (int element :
                arr) {
            System.out.print(element + " ");
        }
    }

    private static void test2() {
        int arr[] = {};
        ShellSort.sort(arr);
        System.out.println();
        for (int element : arr) {
            System.out.print(element + " ");
        }
    }

    private static void test3() {
        int arr[] = {2, 3, 4, 5, 6};
        ShellSort.sort(arr);
        System.out.println();
        for (int element :
                arr) {
            System.out.print(element + " ");
        }
    }


    private static void test4() {
        int arr[] = {6, 5, 4, 3, 2};
        ShellSort.sort(arr);
        System.out.println();
        for (int element : arr) {
            System.out.print(element + " ");
        }
    }
}
