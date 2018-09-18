package SF;

import java.util.Scanner;

public class CandyProblem {

    private static int getMinCandys(int [] a,int n)
    {
        int count=0;
        int [] b=new int[n];
        if(n<2)
        {
            return 1;
        }
        //每个小孩预先分一颗糖
        for(int i=0;i<n;i++)
        {
            b[i]=1;
        }

        //开始按权值分糖，位置i与i-1位置比较，i从1开始
        for(int j=1;j<n;j++)
        {
            //权重i等于i-1 ，在原来基础上保持不变
            if(a[j]==a[j-1])
            {
                b[j]=b[j]+b[j]-b[j-1];
            }
            //权重i大于i-1，在原来基础上b[j]比b[j-1]多1
            if((a[j]>a[j-1]) && (b[j]<=b[j-1]))
            {
                b[j]=b[j]+b[j]-b[j-1]+1;
            }
            //权重i小于于i-1，在原来基础上b[j-1]多1，并且进行i--扫描
            if((a[j]<a[j-1]) && (b[j]>=b[j-1]))
            //if(a[j]<a[j-1])
            {
                b[j-1]=b[j-1]+1;
                if(j>1)
                {
                    j-=2;  //因为for中要执行j++
                }
            }
        }

        for(int k=0;k<n;k++)
        {
            count+=b[k];
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        int _numbers_size = 0;
        _numbers_size = Integer.parseInt(in.nextLine().trim());
        int[] _numbers = new int[_numbers_size];
        int _numbers_item;
        for(int _numbers_i = 0; _numbers_i < _numbers_size; _numbers_i++) {
            _numbers_item = Integer.parseInt(in.nextLine().trim());
            _numbers[_numbers_i] = _numbers_item;
        }

        res = getMinCandys(_numbers, _numbers_size);
        System.out.println(String.valueOf(res));
    }
}
