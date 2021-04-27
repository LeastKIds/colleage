package j210426.ch06;

public class Circle {
    private int radius;
    private Point center;

    public Circle(Point P, int r)
    {
        center = P;
        radius = r;
    }

    @Override
    public String toString()
    {
        return "Circle [radius=" + radius + ", center=" + center + "]";
    }
}
