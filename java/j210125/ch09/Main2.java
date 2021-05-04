package j210125.ch09;

import java.util.ArrayList;
import java.util.Collections;

public class Main2 {
    public static void main(String[] args)
    {
        /*
            Collection framework : 자료구조
                                    stack, queue, list, set, map, tree, ...

        */

        ArrayList<Integer> list=new ArrayList<>();
        list.add(3);
        list.add(10);
        list.add(30);
        list.add(4);

        // for(int n : list)
        //     System.out.println(n);

        // for(int i=0; i<list.size(); i++)
        //     System.out.println(list.get(i));
        
        System.out.println(list);

        Collections.sort(list);
        System.out.println("After sorting Ascending...");
        System.out.println(list);
        System.out.println("After sorting Descending...");
        Collections.reverse(list);
        System.out.println(list);

        ArrayList<String> strList=new ArrayList<>();
        strList.add("홍길동");
        strList.add("일지매");
        strList.add("성춘향");
        strList.add("박문수");
        strList.add("항단이");

        System.out.println(strList);

        Collections.sort(strList);
        System.out.println(strList);
    
        // int[] arr=new int[10];
        // arr[0]=10;
        // arr[1]=20;
        //  arr[2]="hong";
        
    }
    
}
