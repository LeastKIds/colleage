package j210326.ch15;

import java.util.Arrays;

public class UtilTest {
    public static void main(String[] args)
    {
         Integer[] arr ={3,4,2,10,38,76,92,124,13,24};
        // Double[] arr={3.0,4.0,38.0,76.0};           //  Integer 가 아니고 Double이기 때문에 안 됨
        // String[] arr={"동해물과","백두산이","마르고","닳도록"};
        // Student[] arr={new Student("가",78), new Student("나",79), new Student("다",80)};

        // 제네릭을 사용하면 다 돌아감
        // System.out.println("배열의 값");
        // Util.println(arr);
        // System.out.println("최대값 : " + Util.getMax(arr));

        // Util.printValueOf5Times(12);

        Util.printSum2(Arrays.asList(arr));
        //Util.printSum3(arr);          //  List와 ArrayList는 아무 관계가 아님
    }
}
