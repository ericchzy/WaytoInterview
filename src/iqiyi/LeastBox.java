package iqiyi;

import java.util.ArrayList;
import java.util.Scanner;

public class LeastBox {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int boxNum = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < boxNum; i++) {
            list.add(sc.nextInt());
        }
        list.sort((Integer o1, Integer o2) -> o1 - o2);

        if (list.isEmpty()){
            System.out.println("0");
            return;
        }

        int result = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).equals(list.get(i + 1))) result++;
        }
        System.out.println(result + 1);
    }
}
