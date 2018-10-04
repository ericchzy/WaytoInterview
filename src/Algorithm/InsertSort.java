package Algorithm;

public class InsertSort {
    public static void sort(int[] arr) {
        if (arr == null || arr.length == 0) return;

        for (int i = 1; i < arr.length; i++) {
            int j = i;
            int target = arr[i];

            while (j > 0 && target < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }

            arr[j] = target;
        }
    }

    public static void main(String[] args) {
        System.out.println();
        int N = 20000;
        int[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        InsertSort.sort(arr);
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
        for (int element :
                arr) {
            System.out.print(element + " ");
        }
    }

    private static void test2() {
        int arr[] = {};
        SelectSort.sort(arr);
        System.out.println();
        for (int element :
                arr) {
            System.out.print(element + " ");
        }
    }

    private static void test3() {
        int arr[] = {2, 3, 4, 5, 6};
        SelectSort.sort(arr);
        System.out.println();
        for (int element :
                arr) {
            System.out.print(element + " ");
        }
    }


    private static void test4() {
        int arr[] = {6, 5, 4, 3, 2};
        SelectSort.sort(arr);
        System.out.println();
        for (int element :
                arr) {
            System.out.print(element + " ");
        }
    }
}
