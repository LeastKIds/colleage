package j210326.ch15;

import java.util.*;
public class UtilTest2 {
    public static void main(String[] args){
        Number n=Integer.valueOf(100);  // 문제 없음

        //ArrayList<Number> list=new ArrayList<Integer>;    //  왼쪽과 오른쪽이 아무 관계가 없다

        ArrayList<Integer> list=new ArrayList<Integer>();
        //process(list);        //  역시 불가. ArrayList<Number> 아래에는 ArrayList<Integer>가 들어 갈 수 없다.
        ArrayList<Double> list2=new ArrayList<Double>();
        //process(list2);       //  역시 불가.


        process(list);
        process(list2);

        //  generic을 쓰는 이유
        //  로직은 같고 내부적으로 사용하는 데이터의 타입만
        //  다른 경우에도, 하나의 클래스만 생성해서 사용할 수 있도록,
        //  하기 위해...
        //  실제로 사용할 데이터 타입은
        //  객체 생성 시에 type parameter로 받아서 처리,
        //  그리고, 명시적인 type casting도 안해도 되도록 하기 위해...
    }

    // public static void process(ArrayList<Number> list)
    public static void process(ArrayList<? extends Number> list)
    {
        //
    }

    
}
