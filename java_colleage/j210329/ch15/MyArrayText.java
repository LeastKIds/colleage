package j210329.ch15;

public class MyArrayText {
    public static void main(String[] args)
    {
        MyArrayList<Integer> list1=new MyArrayList<>();

        for(int i=1; i<=100; i++)
        {
            list1.add(i);
        }

        for(int i=0; i<list1.size(); i++)
            System.out.print(list1.get(i) + " ");

        
        list1.add(40,9);
    }
}
