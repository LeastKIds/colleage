package j210326.ch15;

import java.util.*;
public class Util {
    public static <T extends Comparable<T>> T getMax(T[] arr)
    {
        T max=arr[0];
        for(int i=1; i<arr.length; i++)
            // if(max<arr[i])  max=arr[i];     // 문자열은 비교 불가이기 때문에 에러
            if(max.compareTo(arr[i])<0) max=arr[i];

        return max;
    }



    public static <T extends Comparable<T>> void println(T[] arr)
    {
        for(int i=0; i<arr.length; i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println("\n");
    }

    public static <T extends Number> void printValueOf5Times(T value)
    {
        Double result=value.doubleValue()*5;
        System.out.println(result);
    }

    public static <T extends Number> void printSum(List<T> list)
    {
        Double sum=0.0;
        for(T val : list) sum +=val.doubleValue();

        System.out.println("sum : " + sum);
    }

    // 와일드 카드
    public static void printSum2(List<? extends Number> list)   // ? 뭐가 올지 모르겠으나 최대 Number 가 온다
    {                                                           //   Number 아래 있는 것들은 모두 올 수 있음
        Double sum=0.0;
        for(Number val : list) sum +=val.doubleValue();

        System.out.println("sum : " + sum);
    }
        
}
