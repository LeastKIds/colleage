import java.util.Scanner;

public class Ch05Lab
{
  public static void main(String[] args)
  {
    Scanner input=new Scanner(System.in);

    while(true)
    {
      System.out.println("enter character string");
      String str=input.nextLine();
      if(str.equals("quit"))
        break;

      if(str.startsWith("www"))
        System.out.println("www start");
      else
        System.out.println("worng");
    }
  }
}
