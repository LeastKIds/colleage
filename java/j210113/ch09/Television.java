package j210113.ch09;

public class Television implements RemoteControl{
    boolean onOff=false;
    public void turnOn()
    {
        onOff=true;
    }
    public void turnOff()
    {
        onOff=false;
    }
}
