package j210326.ch15;

public class MyBox <T>{
    T value;

    public void setValue(T value)
    {
        this.value=value;
    }

    public T getValue()
    {
        return value;
    }
}
