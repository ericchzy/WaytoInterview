package com.company;

//WRONG: method spliceArray: ArrayIndexOutOfBoundsException -1
public class Interview33_SquenceOfBST {
    public static boolean VerifySquenceOfBST(int [] sequence) {
        boolean result;
        if(sequence == null || sequence.length <= 0) {
            return false;
        }

        int root = sequence[sequence.length - 1];
        int splitIndex = findSplitIndex(sequence, root); //

        //在分离之后我们需要判断左右子树是否有值不符合规则
        //Have a trouble here
        if (spliceArray(sequence, 0, splitIndex).length != 0) {
            for (int item : spliceArray(sequence, 0, splitIndex)) {
                if (item > root) {
                    return false;
                }
            }
        }

        if (spliceArray(sequence, splitIndex, sequence.length - 1).length != 0) {
            for (int item : spliceArray(sequence, splitIndex, sequence.length - 1)) {
                if (item < root) {
                    return false;
                }
            }
        }
        //Left subTree
        boolean left = true;
        if (splitIndex > 0) {
            left = VerifySquenceOfBST(spliceArray(sequence, 0, splitIndex));
        }
        //Right subTree
        boolean right = true;
        if (splitIndex < sequence.length - 1) {
            right = VerifySquenceOfBST(spliceArray(sequence, splitIndex, sequence.length - 1));
        }
        return (left && right);
    }

    private static int findSplitIndex(int [] sequence, int root) {
        for(int i = 0 ; i < sequence.length-1 ; i++) {
            if(sequence[i] > root) {
                return i;
            }
        }
        return -1;
    }

    private static int[] spliceArray(int[] sequence, int start, int end) {
        if (start > end) {
            return new int[]{};
        }

        int index = 0;
        //如果使用 sequence.length , 则过大则后面的值会使用0来填充从而影响上面（右子树是否有值不符合规则）的判断
        //使用 end - start 会出现java.lang.NegativeArraySizeException 错误
        int[] result = new int[end - start];

        for(int i = start ; i < end ; i++) {
            result[index++] = sequence[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] test = new int[]{4,8,6,12,16,14,10};
        System.out.println(VerifySquenceOfBST(test));
    }
}







