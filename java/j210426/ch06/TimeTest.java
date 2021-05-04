package j210426.ch06;

public class TimeTest {
    public static void main(String[] args)
    {
        Time time=new Time();
        System.out.println("기본 생성자 호출 후 시간 : " + time.toString());

        Time time2=new Time(13,27,6);
        System.out.println("두번째 생성자 호출 후 시간 : " + time2.toString());
    }
}
