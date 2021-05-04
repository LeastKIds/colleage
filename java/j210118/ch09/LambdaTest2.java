package j210118.ch09;

interface MInterface
{
    public void calculate(int x, int y);
}
public class LambdaTest2 {
    public static void main(String[] args)
    {
        MInterface hello= (a,b) ->{
            int result=a*b;
            System.out.println("계산 결과는 : " + result);
        };

        hello.calculate(10,20);
    }
}
