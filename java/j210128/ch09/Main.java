package j210128.ch09;

import static java.lang.Math.*;
public class Main {
    public static void main(String[] args)
    {
        double theta=3.0;
        double result=cos(Math.PI * theta);     //  cos는 정적 메소드이기 때문에 굳이 Math.cos를 붙이지 않아도 된다.
        test(result);

    }

    public static void test(double val)
    {
        System.out.println(val);
    }
}

class Main2
{
    //  public 클래스는 하나만.
}
