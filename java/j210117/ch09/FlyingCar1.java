package j210117.ch09;

interface Drivable
{
    void dirve();
}

interface Flyable
{
    void fly();
}

public class FlyingCar1 implements Drivable,Flyable{
    public void drive()
    {
        System.out.println("운전하고 있음");
    }
    public void fly()
    {
        System.out.println("하늘을 날고 있음");
    }

    public static void main(String[] args)
    {
        FlyingCar1 obj=new FlyingCar1();
        obj.drive();
        obj.fly();
    }

    @Override
    public void dirve() {
        // TODO Auto-generated method stub

    }
}
