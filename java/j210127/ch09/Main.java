package j210127.ch09;

import java.util.*;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args)
    {
        /*
            Lamda expresstion : 이름이 없는 메소드
                                오직 하나의 추상 메소드만을 가지는 인터페이스의 구현.
        */

        // ArrayList<Integer> list=Arrays.asList();
        List<Integer> list=new ArrayList<>();
        for(int i=1; i<=7; i++) list.add(i);

        for(Integer i : list) System.out.println(i);

        //  기본형 int, double, float, ... => wrapper class : Integer, Double, Float, ...
        //  자바는 자동으로 auto boxing, unboxing 된다.

        // list.forEach(new Consumer<Integer>{

		// 	@Override
		// 	public void accept(Integer t) {
		// 		// TODO Auto-generated method stub
		// 		System.out.println(t + "입니다.");
		// 	}

        // });

        // list.forEach((Integer t) -> {System.out.println(t + "!!!");});

        // list.forEach(
        //     (t) -> {
        //         System.out.println(t + "###");
        //     }
        // );

        list.forEach(
            (t) -> System.out.println(t + "&&&")
        );
    }
}
