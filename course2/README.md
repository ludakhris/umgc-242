# UMGC-242 - Course 1

Exercise 1: 
- https://www.jdoodle.com/online-java-compiler/
- Create a class that represents a point on a graph, its data elements are: x and y coordinates.
- Create a class that represents a rectange (which conssts of one point plus a width and height).
- Add method that will compute the rectangles area (length * height).
- Create a main method that creates a rectangle object and prints its area.
<details>
  <summary>Exercise Solution:</summary>
  
```java
public class Exercise1 {
    public static void main(String[] args) {
        System.out.println(new Rectangle(7,5).getArea());
		
		// Does my rectangle still exist?
    }
    
    public class Point {
        public int x = 0;
        public int y = 0;
        //constructor
        public Point(int a, int b) {
            x = a;
            y = b;
        }
    }
    
    public class Rectangle {
        public int width = 0;
        public int height = 0;
        public Point origin;
    
        // four constructors
        public Rectangle() {
            origin = new Point(0, 0);
        }
        public Rectangle(Point p) {
            origin = p;
        }
        public Rectangle(int w, int h) {
            origin = new Point(0, 0);
            width = w;
            height = h;
        }
        public Rectangle(Point p, int w, int h) {
            origin = p;
            width = w;
            height = h;
        }
    
        // a method for moving the rectangle
        public void move(int x, int y) {
            origin.x = x;
            origin.y = y;
        }
    
        // a method for computing the area of the rectangle
        public int getArea() {
			int area = width * height;
            return area;
        }
    }
}
```
</details>
