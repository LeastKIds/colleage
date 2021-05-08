package ch06;

public class MyArray
{
  private int[] arr=new int[5];
  private int length=5;

  public void put(int idx, int value) { arr[idx]=value; }

  public int get(int idx) { return arr[idx];  }
}
