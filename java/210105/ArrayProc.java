package ch06;

import java.util.Scanner;

public class ArrayProc
{
  Scanner input=new Scanner(System.in);

  public void getValues(int[] array)
  {
    for(int i=0; i<array.length; i++)
    {
      System.out.println("enter point");
      array[i]=input.nextInt();
    }
  }

  public double getAverage(int[] array)
  {
    double total =0;
    for(int i=0; i<array.length; i++)
      total +=array[i];
    return total/array.length;
  }

  public static void main(String[] args)
  {
    int[] scores=new int[5];

    ArrayProc ap=new ArrayProc();

    ap.getValues(scores);
    System.out.println("average : " + ap.getAverage(scores));
  }
}
