package Game4399;

import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = sc.nextInt();
        }
        int expectedNum = sc.nextInt();
        binarySearch(arr, 0, length - 1, expectedNum);
    }

    private static void binarySearch(int[] arr, int start, int end, int expectedNum) {

        if (start >= 0 && end <= arr.length - 1 && start < end) {
            int index = (start + end) >> 1;

            if (arr[index] > expectedNum) binarySearch(arr, start, index - 1, expectedNum);
            if (arr[index] < expectedNum) binarySearch(arr, index + 1, end, expectedNum);
            else {
                int index_bak = index - 1;
                int result = 0; //offset

                //backward
                while(arr[index++] == expectedNum) {
                    if (index == arr.length) {
                        result++;
                        break;
                    }
                    result++;
                }

                while(arr[index_bak--] == expectedNum) {
                    if (index_bak == -1) {
                        result++;
                        break;
                    }
                    result++;
                }
                System.out.println(result);
            }
        }
    }
}
