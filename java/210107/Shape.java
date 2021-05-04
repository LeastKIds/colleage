package ch07;

public class Shape
{
  private int x;
  private int y;

  public void setX(int x) { this.x=x; }
  public int getX() { return x; }
  public void setY(int y) { this.y=y; }
  public int getY() { return y; }
  
  public void print() { System.out.println("X : " + x + ", Y : " + y);  }
}
