package j210427.ch07;

public class RectangleTest {
    public static void main(String[] args)
    {
        Rectangle r1=new Rectangle();
        Rectangle r2=new Rectangle();

        r1.setX(5);
        r1.setY(3);
        r1.setWidth(10);
        r1.setHeight(10);

        r2.setX(8);
        r2.setY(9);
        r2.setWidth(10);
        r2.setHeight(20);

        System.out.println(r1.print());
        System.out.println(r1);
        
        System.out.println(r2.print());
        System.out.println(r2);
    }
}
