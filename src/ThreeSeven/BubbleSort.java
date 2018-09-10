package ThreeSeven;

/**
 * 实现对数组（9，1，4，3，8）的冒泡排序
 */
public class BubbleSort {
    private static void BubbleSort(int[] arr) {
        if (arr.length == 0) {
            return;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{9, 1, 4, 3, 8};
        BubbleSort(arr);
        for (int element : arr) System.out.print(element + " ");
    }
}
