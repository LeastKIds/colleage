package 210108.ch07;

public class Rectangle extends Shape{
    private int width;
    private int height;

    public  Rectangle(int x, int y, int width, int height)
    {
        super(x,y);
        System.out.println("Rectangle() : " + width + ", " + height);
        this.width=width;
        this.height=height;
    }
    
}
