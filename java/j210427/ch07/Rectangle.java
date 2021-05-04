package j210427.ch07;

public class Rectangle extends Shape{
    private int width;
    private int height;

    public int getWidth()
    {
        return width;
    }

    public void setWidth(int width)
    {
        this.width=width;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height=height;
    }

    double area()
    {
        return (double) width * height;
    }

    

    @Override
    public String toString()
    {
        
        return "(" + this.getX() + ", " + getY() + ") width : " + width + ", height : " + height;
    }
}
