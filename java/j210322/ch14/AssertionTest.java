package j210322.ch14;

import java.util.Scanner;

public class AssertionTest {
    public static void main(String[] args)
    {
        try(Scanner input=new Scanner(System.in))
        {
            System.out.println("날짜를 입력하시오.");
            int date=input.nextInt();

            // assert(date <1 || date >31) throw new IllegalStateException(date+"");
            System.out.printf("입력된 날짜는 %d 입니다. \n" ,date);
            
        }catch (Exception e)
        {
            e.getMessage();
        }
    }
}
