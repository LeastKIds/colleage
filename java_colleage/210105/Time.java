package ch06;

public class Time
{
  private int hour;
  private int minute;
  private int second;

  @Override
  public String toString()
  {
    return String.format("%02d:%02d:%02d",hour,minute,second);
  }

  public Time()
  {
    this(0,0,0);
  }

  public Time(int hour, int minute, int second)
  {
    if(hour>=0 && hour<=24)
      this.hour=hour;
    else
      this.hour=0;
    if(minute>=0 && minute <=60)
      this.minute=minute;
    else
      this.minute=0;
    if(second>=0 && second<=60)
      this.second=second;
    else
      this.second=0;
  }




}
