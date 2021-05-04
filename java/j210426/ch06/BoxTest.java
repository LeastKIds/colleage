package j210426.ch06;

public class BoxTest {
    public static void main(String[] args)
    {
        Box b;
        b = new Box(20,20,30);
        System.out.println("상자의 부피 " + b.getVolume() + "입니다.");
    }
}
