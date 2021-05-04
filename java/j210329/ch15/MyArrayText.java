package j210329.ch15;

public class MyArrayText {
    public static void main(String[] args)
    {
        MyArrayList<Integer> list1=new MyArrayList<>();

        for(int i=1; i<=100; i++)
        {
            list1.add(i);
        }

        // list1.showArray();  // 배열을 보여주는 메소드

        
        // list1.add(999,20);     // 중간에 삽입하는 메소드

        // list1.showArray();

        list1.remove(10);

        list1.showArray();      // 중간에 삭제하는 메소드


    }
}
