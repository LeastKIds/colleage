package ch06;

public class Rectangle
{
  private int width;
  private int length;

  public Rectangle()
  {
    this(10,10);
  }
  public Rectangle(int width, int length)
  {
    this.width=width;
    this.length=length;
  }

  public boolean isSame(Rectangle rec)
  {
    boolean result=false;

    if(this.width==rec.width && this.length==rec.length)
      result=true;

    return result;
  }

  @Override
  public String toString()
  {
    return "width : " + width + ", length : " + length;
  }
}
