package ch06;

public class Main6
{
  public static void main(String[] args)
  {
    Box b1=new Box(10,10,20);
    Box b2=new Box(10,10,20);

    if(b1==b2)  //worng
      System.out.println("same box");
    else
      System.out.println("other box");

    if(b1.isSameBox(b2))
      System.out.println("same box");

  }
}
