package com.company;

public class Interview10 {
    public static int JumpFloor(int target) {
        if(target <= 2) {
            return target;
        }

        int back = 0;
        int front = 1;
        while(target-- != 0) {
            front = back + front;
            back = front - back;
        }
        return front;
    }

    public static void main(String[] args) {
        System.out.println(JumpFloor(3));
        
    }

}
