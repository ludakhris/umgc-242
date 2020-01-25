package exercise2;

public class Point {

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void movePoint(int newX, int newY) {
        this.x = newX;
        this.y = newY;
    }

    @Override
    public String toString() {
        String FORMAT = "X: %d, Y: %d";
        return String.format(FORMAT, this.x, this.y);
    }

    public static void main (String[] args) {
        Point o = new Point(1,2);

        System.out.println(o);
    }
}