package j210125.ch09;

import java.util.*;

public class Main3 {
    public static void main(String[] args)
    {
        ArrayList<Studuent> list=new ArrayList<>();
        list.add(new Studuent(4,"홍길동",1));
        list.add(new Studuent(3,"일지매",2));
        list.add(new Studuent(2,"성춘향",3));
        list.add(new Studuent(1,"이몽룡",4));

        System.out.println(list);
        System.out.println("After sorting...");
        Collections.sort(list);
        System.out.println(list);
    }
}
