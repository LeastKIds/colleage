package j210402.ch15;

import java.util.*;
import java.util.stream.IntStream;

public class Test {
    public static void main(String[] args)
    {
        
        test();

    }

    private static void test()
    {
        // List<Integer> list=new ArrayList<>();
        List<Integer> list=new LinkedList<>();
        IntStream.rangeClosed(1,10000).forEach(i ->
            list.add(i)
        );
        long startTime=System.currentTimeMillis();
        for(int i=0; i<100; i++)
            list.add(100,(i+1)*1000);
        long endTime=System.currentTimeMillis();

        System.out.println("elapsed time : " + (endTime-startTime));
    }
    
    private void test0()
    {
        // List<String> list=new ArrayList<>();
        List<String> list=new LinkedList<>();   // 사용자 입장에선 달라지는 것이 없다. 내부에서 달라질 뿐
        list.add("Milk");
        list.add("Bread");
        list.add("Butter");
        
        System.out.println(list);
        
        list.add(1,"Apple");
        System.out.println(list);

        list.set(2,"Grape");
        System.out.println(list);

        list.remove(3);
        System.out.println(list);

        for(int i=0; i<list.size(); i++)
            System.out.print(list.get(i) + " ");

        System.out.println();

        for(String s : list)
            System.out.print(s + " ");

        Iterator<String> iter=list.iterator();
        while(iter.hasNext())       // hasnext : 한 바퀴 안 돌았으면 true 다 돌면 false
        {
            iter.next();            // 다음 값을 가져옴
        }
    }
    
}
