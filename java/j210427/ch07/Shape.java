package j210427.ch07;

public class Shape {
    private int x;
    private int y;

    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x=x;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int y)
    {
        this.y=y;
    }

    
    public String print()
    {
        return "x : " + x + ", y : "+y;
    }
}
