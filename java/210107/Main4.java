package ch07;

public class Main4
{
  public static void main(String[] args)
  {
    Rectangle rec=new Rectangle();

    rec.setX(5);
    rec.setY(3);
    rec.setWidth(10);
    rec.setHeight(20);

    Rectangle rec2=new Rectangle();

    rec2.setX(8);
    rec2.setY(9);
    rec2.setWidth(10);
    rec2.setHeight(20);

    rec.print();
    rec.draw();
    rec2.print();
    rec2.draw();
  }
}
