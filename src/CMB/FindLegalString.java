package CMB;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FindLegalString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        ArrayList<String> results = new ArrayList<>();
        printHelper(num, num, "", results);

        Collections.sort(results);
        for (int i = 0; i < results.size(); i++) {
            if (i < results.size() - 1) {
                System.out.print(results.get(i) + ",");
            } else {
                System.out.print(results.get(i));
            }
        }
    }

    private static void printHelper(int leftNum, int rightNum, String out, ArrayList<String> result) {
        if (leftNum < 0 || rightNum < 0 || rightNum < leftNum) return;
        if (leftNum == 0 && rightNum == 0) {
            result.add(out);
        }
        printHelper(leftNum - 1, rightNum, out + "(", result);
        printHelper(leftNum, rightNum - 1, out + ")", result);
    }
}
