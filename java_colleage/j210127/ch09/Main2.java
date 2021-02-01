package j210127.ch09;

import java.util.*;

public class Main2 implements Comparable{
    public static void main(String[] args)
    {
        // ArrayList<Integer> list=new ArrayList<>();
        // list.add(87);
        // list.add(25);
        // list.add(67);
        // list.add(43);
        // list.add(28);

        // System.out.println(list);

        // Collections.sort(list);     //  원소 타입인 Integer가 Comparable 인터페이스를 구현하고 있기 때문에 정렬이 되는 것.

        // System.out.println(list);

        ArrayList<String> list=new ArrayList<>();
        list.add("apple");
        list.add("Peach");
        list.add("melon");
        list.add("Phtato");
        list.add("banana");

        System.out.println(list);

        

        //Collections.sort(list);
        // Collections.sort(list, new Comparator<String>(){    // list 뒤에 오는 건 비교 방법 재정의

        //     @Override
        //     public int compare(String o1, String o2) {
        //         String s1=o1.toUpperCase();
        //         String s2=o2.toUpperCase();

        //         return s1.compareTo(s2);
        //     } 
            
        // });   

        // Collections.sort(list, 
        //     (String o1, String o2) -> {
        //     public int compare(String o1, String o2) {
        //             String s1=o1.toUpperCase();
        //             String s2=o2.toUpperCase();
    
        //             return s1.compareTo(s2);
                
        //     });

        // Collections.sort(list,
        //     (o1,o2) ->  {
        //         String s1=o1.toUpperCase();
        //         String s2=o2.toUpperCase();
        //         return s1.compareTo(s2);
        //     }    
        // );)

        System.out.println(list);
    }

    @Override
    public int compareTo(Object o) {
        // TODO Auto-generated method stub
        return 0;
    }
}
