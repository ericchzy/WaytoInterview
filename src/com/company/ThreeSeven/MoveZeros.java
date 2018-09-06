package com.company.ThreeSeven;

public class MoveZeros {
    /**
     * 将数字0移动到最后
     * @param nums 输入数组
     */
    public static void moveZeroes(int[] nums) {

        //将非0数字向前挪
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[cur] = nums[i];
                cur++;
            }
        }

        //后面的元素全部补0
        for (int i = cur; i < nums.length; i++) {
            nums[i] = 0;
        }

        for (int element :
                nums) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] test1 = new int[]{0, 1, 0, 3, 12};
        int[] test2 = new int[]{0, 0, 1, 3, 12};
        int[] test3 = new int[]{0};
        int[] test4 = new int[]{};

        moveZeroes(test1);
        moveZeroes(test2);
        moveZeroes(test3);
        moveZeroes(test4);
    }

}
