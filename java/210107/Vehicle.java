package ch07;

public class Vehicle
{
  private int speed;
  private String dirction;

  public void setSpeed(int speed)
  {
    this.speed=speed;
  }

  public int getSpeed()
  {
    return speed;
  }

  public void turn(String dirction)
  {
    this.dirction=dirction;
  }

  public String getDirction()
  {
    return dirction;
  }
}
