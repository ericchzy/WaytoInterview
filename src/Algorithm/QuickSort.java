package Algorithm;

public class QuickSort {
    private static int partition(int[] arr, int left, int right) {
        int pivotKey = arr[left];
//        int pivotPointer = left;

        while (left < right) {
            while (left < right && arr[right] >= pivotKey) right--;
            arr[left] = arr[right];
            while (left < right && arr[left] <= pivotKey) left++;
            arr[right] = arr[left];
//            swap(arr, left, right);
        }


        arr[left] = pivotKey;
//        swap(arr, pivotPointer, left);
        return left;
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;

        int pivotPos = partition(arr, left, right);
        quickSort(arr, left, pivotPos - 1);
        quickSort(arr, pivotPos + 1, right);

    }

    public static void sort(int[] arr) {
        if (arr == null || arr.length == 0) return;

        quickSort(arr, 0, arr.length - 1);
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
        int N = 10000;
        int[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        QuickSort.sort(arr);
        SortTestHelper.printArray(arr);

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
