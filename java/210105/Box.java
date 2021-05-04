package ch06;

public class Box
{
  private int width;
  private int length;
  private int height;
  private int volume;

  public Box()
  {
    //this.width=0;
    //this.length=0;
  //  this.height=0;
  //  this.volume=0;

  this(2,2,2);
  }
  public Box(int width, int length, int heigth)
  {
    this.width=width;
    this.length=length;
    this.height=heigth;
    this.volume=width*length*heigth;
  }

  @Override
  public String toString()
  {
    return "width : " + width + " length : " + length + "height : " + height + " volume : " + volume;
  }

  public boolean isSameBox(Box box)
  {
    boolean result=false;
    if(this.width==box.width && this.length==box.length && this.height==box.height);
      result=true;
    return result;
  }


}
