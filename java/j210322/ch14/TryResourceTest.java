package j210322.ch14;

import java.io.*;

public class TryResourceTest {

    public static void writeList()
    {
        // PrintWriter out= null;
        // try{
        //     out=new PrintWriter("./1/outfile.txt");
        //     for(int i=0; i<10; i++)
        //         out.println("배열 원소 " + i + " = " + i);

        //         // out.close();
        //         // System.out.println("파일을 닫았습니다.");
        // }catch(FileNotFoundException e)
        // {
        //     //System.out.println(e.getMessage());
        //     e.printStackTrace();
        // }finally
        // {
        //     if(out != null)
        //         out.close();
            
        //     System.out.println("그럼에도 파일을 닫았습니다.");
        // }
        // try(PrintWriter out=new PrintWriter("./j210322/ch14/outfile.txt"))
        // {
        //     for(int i=0; i<10; i++)
        //         out.println("배열원소 " + i + " = " + i);
        // }catch(FileNotFoundException e)
        // {
        //     e.printStackTrace();
        // }

        try (MyResource rc=new MyResource())
        {
            System.out.println(rc.getValue());
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    public static void main(String[] args)
    {
        writeList();
    }
    
}
