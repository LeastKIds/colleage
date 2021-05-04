package j210325.ch15;

public class SimplePairTest {
    public static void main(String[] args)
    {
        SimplePair<String> pair=new SimplePair<String>("apple","tomato");
        System.out.println(pair.getFirst());
        System.out.println(pair.getSecond());

        pair.setFirst("사과");
        System.out.println(pair.getFirst());
        pair.setSecond("토마토");
        System.out.println(pair.getSecond());
    }
}
