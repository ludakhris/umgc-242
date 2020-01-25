import exercise2.Point;

public class Rectangle {

    private int height;
    private int width;
    private Point point;
    private int area; 

    public Rectangle(Point p, int h, int w) {
        if (h == 0 || w == 0) {
            System.err.println("Dont pass me bad data!!!!");
            return;
        }
        this.point = p;
        this.width = w;
        this.height = h;
        this.area = h * w;
    }

    public Rectangle(Point p) {
        if (p == null) {
            System.err.println("Dont pass me bad data!!!!");
            return;
        }
        point = p;
    }

    public String toString() {
        return String.format("Point: %s, Height: %d, Width: %d", 
            this.point, this.height, this.width);
    }

    public int getArea() {
        return area;
    }

    public void moveRectangle(Point p) {
        this.point = p;
    }

    public Point getPoint() {
        return this.point;
    }

    public static void main (String[] args) {
        Point p = new Point(1,2);
        Rectangle o = new Rectangle(p, 1, 2);

        System.out.println(o.getArea());
    }
}