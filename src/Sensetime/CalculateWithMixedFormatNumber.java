package Sensetime;

import java.util.ArrayList;
import java.util.Scanner;

public class CalculateWithMixedFormatNumber {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        String s = in.next();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.substring(i,i+1).equals("+")){
                list.add("+");
            }
            if(s.substring(i,i+1).equals("-")){
                list.add("-");
            }
        }
        //System.out.println(list);
        String sArr[] = s.split("\\+|\\-");
        //System.out.println(Arrays.toString(sArr));
        int a[] = new int[sArr.length];
        for (int i = 0; i < sArr.length; i++) {
            String str = sArr[i];
            if (str.substring(0,1).equals("0")){
                if (str.substring(1,2).equals("x")){
                    //十六进制
                    Integer x = Integer.parseInt(str.substring(2),16);//从第2个字符开始截取
                    a[i] = x;
                }else {
                    //八进制
                    Integer y = Integer.parseInt(str,8);//从第2个字符开始截取
                    a[i] = y;
                }
            }else{
                //十进制数
                a[i] = Integer.valueOf(str);
            }
        }
        //System.out.println(Arrays.toString(a));
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).equals("-")){
                a[i+1] = -a[i+1];
            }
        }
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        System.out.println(sum);
    }
}
