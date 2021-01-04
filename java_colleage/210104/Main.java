package ch06;

public class Main
{
  public static void main(String[] args)
  {
    MyArray arr=new MyArray();

    arr.put(0,10);
    arr.put(1,20);
    arr.put(4,50);

    System.out.println(arr.get(1));
  }
}
