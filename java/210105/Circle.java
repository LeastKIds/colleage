package ch06;

public class Circle
{
  private Point center;
  private int radius;

  public Circle(Point center, int radius)
  {
    this.center=center;
    this.radius=radius;
  }

  @Override
  public String toString()
  {
    return "Circle [center=" +center + " , radius="+radius+"]";
  }
}
