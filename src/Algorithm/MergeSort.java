package Algorithm;

public class MergeSort {
    public static void sort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) >> 1;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];

        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {
            if(arr[i] <= arr[j]) temp[k++] = arr[i++];
            else temp[k++] = arr[j++];
        }

        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        for (int l = 0; l < temp.length; l++) arr[left + l] = temp[l];
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();

        System.out.println();
        int N = 10000;
        int[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        MergeSort.sort(arr);
        SortTestHelper.printArray(arr);

    }

    private static void test1() {
        int arr[] = {5, 3, 8, 6, 4};
        MergeSort.sort(arr);
        System.out.println();
        for (int element :
                arr) {
            System.out.print(element + " ");
        }
    }

    private static void test2() {
        int arr[] = {};
        MergeSort.sort(arr);
        System.out.println();
        for (int element : arr) {
            System.out.print(element + " ");
        }
    }

    private static void test3() {
        int arr[] = {2, 3, 4, 5, 6};
        MergeSort.sort(arr);
        System.out.println();
        for (int element :
                arr) {
            System.out.print(element + " ");
        }
    }


    private static void test4() {
        int arr[] = {6, 5, 4, 3, 2};
        MergeSort.sort(arr);
        System.out.println();
        for (int element : arr) {
            System.out.print(element + " ");
        }
    }
}
