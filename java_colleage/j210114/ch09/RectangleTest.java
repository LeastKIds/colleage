package j210114.ch09;

public class RectangleTest {
    public static void main(String[] args)
    {
        Rectangle r1=new Rectangle(100,30);
        Rectangle r2=new Rectangle(200,10);
        int result=r1.compareTo(r2);
        if(result==1)
            System.out.println(r1 + "이 더 큽니다.");
        else if(result==-1)
            System.out.println(r2 + "이 더 큽니다.");
        else
            System.out.println("같습니다.");
    }
}
