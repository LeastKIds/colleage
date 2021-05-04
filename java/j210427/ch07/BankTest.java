package j210427.ch07;

public class BankTest {
    public static void main(String[] args)
    {
        BadBank b1=new BadBank();
        NormalBank b2=new NormalBank();
        GoodBank b3=new GoodBank();

        System.out.println("BadBank : " + b1.getIntegerestRte());
        System.out.println("NormalBank : " + b2.getIntegerestRte());
        System.out.println("GoodBank : " + b3.getIntegerestRte());
    }
}

class Bank
{
    double getIntegerestRte()
    {
        return 0.0;
    }
}

class BadBank extends Bank
{
    double getIntegerestRte()
    {
        return 10.0;
    }
}

class NormalBank extends Bank
{
    double getIntegerestRte()
    {
        return 5.0;
    }
}

class GoodBank extends Bank
{
    double getIntegerestRte()
    {
        return 3.0;
    }
}
