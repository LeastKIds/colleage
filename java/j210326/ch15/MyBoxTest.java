package j210326.ch15;

import javax.swing.JFrame;

public class MyBoxTest {
    public static void main(String[] args)
    {
        MyBox<String> box1=new MyBox<>();

        box1.setValue("value");
        // box1.setValue(100);      // <String> 이면 String 만 넣을 수 있다
        // box1.setValue(13.4);
        // //box1.setValue(new JFrame());        // 모든 형태가 들어 갈 수 있다

        openBox(box1);

        MyBox<Integer> box2=new MyBox<>();
        // box2.setValue("value");      // 무조건 Integer 값만 가능
        box2.setValue(100);
        System.out.println(box2.getValue());
    }

    private static void openBox(MyBox<String> box)
    {
        //Object obj = box.getValue();
        //Double d = (Double) box.getValue();   // String 이기 때문에 Double로는 못 넣는다
        String d=box.getValue();
        System.out.println(d);
    }
}
