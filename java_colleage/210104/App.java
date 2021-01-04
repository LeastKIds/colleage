public class App
{
  public static void main(String[] args)
  {
    System.out.println("Hello, World");

    String s1=new String("A barking dog");
    System.out.println(s1 + "의 길이는 : " + s1.length());

    String s3="동해물과 " + "백두산이";
    System.out.println(s3);
    String s4=s3.concat(" 마르고 닳도록...");
    System.out.println("s3 : " + s3);
    System.out.println("s4 : " + s4);

    String s5=s1.replace('b','B');
    System.out.println("s1 : " + s1);
    System.out.println("s5 : " + s5);

    //if(s1==s5)  error
    if(s1.equals(s5))
      { System.out.println("s1과 s5는 같습니다.");  }
    else  { System.out.println("s1과 s5는 다릅니다.");  }

    if(s1.equalsIgnoreCase(s5)) //대 소문자 구별 X
    { System.out.println("s1과 s5는 같습니다.");  }
    else  { System.out.println("s1과 s5는 다릅니다.");  }

    //int result = test2();
    //System.out.println(result);
    //Systen.out.println(test2());


    String s2 = "never bites";

    String s6=s1.substring(2);
    System.out.println(s6);

    String s7=s1.substring(2,9);  // beginIndex : inclusive, endIndex : exclusive
    System.out.println(s7);

    s5="123";
    //wrapper class
    //int -> Integer, byte -> Byte, long -> Long, ...
    int n2=Integer.parseInt(s5);
    System.out.println(n2+100);
    System.out.println(s5+100);
  }

  public void test() {}

  public static int test2()  { return 3; }
}
