package com.company;

public class BinarySearch {
    public int binarySearch(int[] arr, int start, int end, int expectedNum) {
        if (arr == null) return -1;

        if (start <= arr.length - 1 && end >= 0 && start <= end) {
            int mid = (start + end) >> 1;
            if (arr[mid] == expectedNum) return mid;
            if (arr[mid] > expectedNum) return binarySearch(arr, start, mid - 1, expectedNum);
            if (arr[mid] < expectedNum) return binarySearch(arr, mid + 1, end, expectedNum);
        }

        return -1;
    }

    public int binarySearchIterativeVersion(int[] arr, int start, int end, int expectedNum) {
        if (arr == null) return -1;

        while (start <= arr.length - 1 && end >= 0 && start <= end) {
            int mid = (start + end) >> 1;
            if (arr[mid] == expectedNum) return mid;
            if (arr[mid] > expectedNum) end = mid - 1;
            if (arr[mid] < expectedNum) start = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch ob = new BinarySearch();
        int arr[] = {2,3,4,10,40};
        int n = arr.length;
        int x = 10;
        int result = ob.binarySearchIterativeVersion(arr,0,n-1,x);
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index " +
                    result);
    }
}

/* Output:
Element found at index 3
*///:~
