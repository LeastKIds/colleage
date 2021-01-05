package ch06;

public class Main
{
  public static void main(String[] args)
  {
    television tv1=new television(5,20,true);
    television tv2=new television(1,30,false);

    tv1.print();
    tv2.print();
  }
}
