package ch06;

public class Date
{
  private int year;
  private String month;
  private int day;

  public Date()
  {
    this(1900,1,1);
  }
  public Date(int year, String month, int day)
  {
    this.year=year;
    this.month=month;
    this.day=day;
  }

  public Date(year)
  {
    this.(year,1,1);
  }

  @Override
  public String toString()
  {
    return "date [ day = " + day + ", month = " + month + " day = " +day;
  }
}
