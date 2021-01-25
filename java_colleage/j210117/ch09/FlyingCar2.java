package j210117.ch09;

interface Flyable
{
    void fly();
}

class Car
{
    int speed;
    void setSpeed(int speed)
    {
        this.speed=speed;
    }

}

public class FlyingCar2 extends Car implements Flyable{
    public void fly()
    {
        System.out.println("하늘을 날고 있음");
    }

    public static void main(String[] args)
    {
        FlyingCar2 obj=new FlyingCar2();
        obj.setSpeed(30);
        obj.fly();
    }
    
}
