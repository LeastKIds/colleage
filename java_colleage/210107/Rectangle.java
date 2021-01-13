package ch07;

public class Rectangle extends Shape
{
  private int width;
  private int height;

  public void setWidth(int width) { this.width=width; }
  public int getWidth() { return width; }
  public void setHeight(int height) { this.height=height; }
  public int getHeight()  {return height; }

  public double area()  { return width*height;  }
  public void draw()  { System.out.println(this.getX() + ","+this.getY() + "  width : " + width + ", height : " + height);  }
}
