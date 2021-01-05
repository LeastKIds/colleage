package ch06;

public class Main7
{
  public static void main(String[] args)
  {
    Rectangle rec1=new Rectangle(20,30);
    Rectangle rec2=new Rectangle();

    if(rec1.isSame(rec2))
      System.out.println("same");
    else
      System.out.println("difference");

    System.out.println("rec1 : " + rec1);
    System.out.println("rec2 : " + rec2);
  }
}
