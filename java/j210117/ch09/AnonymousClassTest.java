package j210117.ch09;

interface RemoteControl
{
    void turnOn();
    void turnOff();
}
public class AnonymousClassTest {
    public static void main(String[] args)
    {
        RemoteControl ac=new RemoteControl(){
            public void turnOn()
            {
                System.out.println("Tv turnOn()");
            }
            public void turnOff()
            {
                System.out.println("Tv turnOff()");
            }
        };

        ac.turnOn();
        ac.turnOff();
    }
}
