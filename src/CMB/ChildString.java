package CMB;



import java.util.Scanner;

public class ChildString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        int maxLength = str.length() / 2;  //向下取整

        for (int i = maxLength; i > 0; i--) {
            //从字符串长度的一半开始查找子串
            if(str.replaceAll(str.substring(0, i), "").length() == 0) {
                System.out.print(str.substring(0, i));
            }
        }
        System.out.print("false");
    }

}
