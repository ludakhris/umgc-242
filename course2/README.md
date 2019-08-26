# UMGC-242 - Course 2

## Section 2a: Review, Review, Review
What did we learn last time? Let's Review
- Classes vs Objects
- DRY Principal & KISS

#### Review Exercise 1: 
- https://www.jdoodle.com/online-java-compiler-ide/
- Create a class that represents a point on a graph, its data elements are: x and y coordinates.
- Create a class that represents a rectangle (which consists of one point plus a width and height).
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
    
    public static class Point {
        private int x = 0;
        private int y = 0;
        
        //constructor
        public Point(int a, int b) {
            x = a;
            y = b;
        }
        
        public int getX() {
            return x;
        }
        
        public int getY() {
            return y;
        }
    }
    
    public static class Rectangle {
        private int width = 0;
        private int height = 0;
        private Point origin;
    
        // four constructors
        public Rectangle() {
            origin = new Point(0, 0);
        }
        public Rectangle(Point p) {
            if (p == null) {
                throw new IllegalArgumentException();
            }
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
            origin = new Point(x, y);
        }
    
        // a method for computing the area of the rectangle
        public int getArea() {
			int area = width * height;
            return area;
        }

        public Point getOrigin() {
            return this.origin;
        }
    }
}
```
</details>

###### Dig Deeper
- Exception throwing
- Return keyword (simple and objects)
- This keyword
- Initialization
- Garbage Collection

## Section 2b: Packages & Enums
#### Packages
So far none of our classes have had packages, which isn't normal. Packages (which you'll normally see at the top of a file) help you define classes into a "package". In java packages are essentially just folders.

#### Enums
Enums are a special data type that allows you to define a list of valid values/constants.

Simple Example:
```java
public class Test {
    
    public enum UserStatus {
        PENDING,
        ACTIVE,
        INACTIVE,
        DELETED;
    }

    public static void main(String[] args) {
        
        UserStatus status = UserStatus.PENDING;
        if (HRUtils.isvalidEmployee()) {
            status = UserStatus.ACTIVE;
        }

        System.out.println(status);

    }

}
```
More complex example:

```java
public class EnumExample {
    
    public enum Operation {
        PLUS,
        MINUS,
        TIMES,
        DIVIDE;
    
        double calculate(double x, double y) {
            switch (this) {
                case PLUS:
                    return x + y;
                case MINUS:
                    return x - y;
                case TIMES:
                    return x * y;
                case DIVIDE:
                    return x / y;
                default:
                    throw new AssertionError("Unknown operations " + this);
            }
        }
    }

    public static void main(String[] args) {

        double result = Operation.PLUS.calculate(1, 2);
        System.out.println(result); //3.0

    }
}
```

## Section 2c: Inheritance & Interfaces

#### Inheritance
Inheritance is a way to define a hierarchy of objects which might be related and have them inherit behavior (again were trying to be DRY). 

Lets consider the following classes:

```java

public class InheritExample {
    
    public enum COLOR {
        YELLOW, RED, GREEN
    }
    
    public static class Pineapple {
        private COLOR fruitColor = COLOR.YELLOW;
        private int weight;
        public Pineapple(int weight) {
            this.weight = weight;
        }
        
        public String toString() {
            return "This is a pineapple that is " + fruitColor + " and weights " + weight + " lbs.";
        }
    }
    
    public static class Strawberry {
        private COLOR fruitColor = COLOR.RED;
        private int weight;
        public Strawberry(int weight) {
            this.weight = weight;
        }
        
        public String toString() {
            return "This is a strawberry that is " + fruitColor + " and weights " + weight + " lbs.";
        }
    }
    
    public static class Grape {
        private COLOR fruitColor = COLOR.GREEN;
        private int weight;
        public Grape(int weight) {
            this.weight = weight;
        }
        
        public String toString() {
            return "This is a grape that is " + fruitColor + " and weights " + weight + " lbs.";
        }
    }

    public static void main(String[] args) {
        Pineapple p = new Pineapple(4);
        Strawberry s = new Strawberry(1);
        Grape g = new Grape(2);
        System.out.println(p);
        System.out.println(s);
        System.out.println(g);
    }
}
```

How can we dry this out, using inheritance aka abstract (aka base) classes and then extend that class.

```java

public class InheritExample {
    
    public enum COLOR {
        YELLOW, RED, GREEN
    }
    
    public static class Fruit {
        private COLOR fruitColor;
        private int weight;
        public Fruit(COLOR color, int weight) {
            this.fruitColor = color;
            this.weight = weight;
        }
        
        public String toString() {
            return "This is a " + this.getClass().getSimpleName() 
                + " that is " + fruitColor 
                + " and weights " + weight + " lbs.";
        }
    }
    
    public static class Pineapple extends Fruit {
        public Pineapple(int weight) {
            super(COLOR.YELLOW, weight);
        }
    }
    
    public static class Strawberry extends Fruit {
        public Strawberry(int weight) {
           super(COLOR.RED, weight);
        }
    }
    
    public static class Grape extends Fruit {
        public Grape(int weight) {
            super(COLOR.GREEN, weight);
        }
    }

    public static void main(String[] args) {
        Pineapple p = new Pineapple(4);
        Strawberry s = new Strawberry(1);
        Grape g = new Grape(2);
        System.out.println(p);
        System.out.println(s);
        System.out.println(g);
    }
}
```

Key takeaways here:
- "Is a" relationships - Grape is a Fruit 
    - Inherit using the extends keyword 
    - Use of super keyword
- "Has a" relationships - Fruit has a color - composition


#### Interfaces
An interface is a way for you to define a "contract" between your classes. 

Here's a situation, say you are in a position where you at working with a few companies to create a car and you have a device so you want to ensure that each car conforms and has certain operations. 

At a min we want each vehicle to have an accelerator, brake, etc.

```java

public class InheritExample {
    
    public interface Vehicle {
        void accelerate(int amount);
        void brake(int amount);
        String getMakeModel();
        int getCurrentSpeed();
    }
    
    public static class Sedan implements Vehicle {
        int currentSpeed = 0;
        String sedanDesc;
        
        public Sedan(String sedanDesc) {
            this.sedanDesc = sedanDesc;
        }
        
        public void accelerate(int amount) {
            this.currentSpeed += amount;
        }
            
        public void brake(int amount) {
            this.currentSpeed -= amount;
        }
        
        public String getMakeModel() {
            return this.sedanDesc;
        }
        
        public int getCurrentSpeed() {
            return this.currentSpeed;
        }
    }
    
    public static class Truck implements Vehicle {
        int currentSpeed = 0;
        String truckDesc;
        
        public Truck(String truckDesc) {
            this.truckDesc = truckDesc;
        }
        
        public void accelerate(int amount) {
            this.currentSpeed += amount;
        }
            
        public void brake(int amount) {
            this.currentSpeed -= (amount / 2);
        }
        
        public String getMakeModel() {
            return this.truckDesc;
        }
        
        public int getCurrentSpeed() {
            return this.currentSpeed;
        }
    }

    public static void main(String[] args) {
        Sedan s = new Sedan("Lexus LS");
        s.accelerate(75);
        s.brake(10);
        
        Truck t = new Truck("Ford F150");
        t.accelerate(75);
        t.brake(10);
        
        System.out.println(s.getMakeModel() + " - Current Speed: " 
            + s.getCurrentSpeed());
        System.out.println(t.getMakeModel() + " - Current Speed: " 
            + t.getCurrentSpeed());
    }
}
```

## Section 2d: Abstract Classes & Polymorphism

Ok so far we can extend classes, define contracts (interfaces) but what if we wanted a vehicle to inherit BOTH a contract and some default behavior. 

In other worlds our Trunk and Sedan both share some common methods, how to do we share those to DRY this code out. 

Introducing Abstract Classes -- Abstract classes are similar to interfaces but they can also have some default behavior and variables.

```java

public class InheritExample {
    
    public static abstract class Vehicle {
        int currentSpeed = 0;
        String desc;

        abstract void brake(int amount);
        
        public void accelerate(int amount) {
            this.currentSpeed += amount;
        }
        public String getMakeModel() {
            return this.desc;
        }
        public int getCurrentSpeed() {
            return this.currentSpeed;
        }
    }
    
    public static class Sedan extends Vehicle {
        public Sedan(String sedanDesc) {
            this.desc = sedanDesc;
        }
            
        public void brake(int amount) {
            this.currentSpeed -= amount;
        }
    }
    
    public static class Truck extends Vehicle {
        public Truck(String truckDesc) {
            this.desc = truckDesc;
        }
            
        public void brake(int amount) {
            this.currentSpeed -= (amount / 2);
        }
    }

    public static void main(String[] args) {
        Sedan s = new Sedan("Lexus LS");
        s.accelerate(75);
        s.brake(10);
        
        Truck t = new Truck("Ford F150");
        t.accelerate(75);
        t.brake(10);
        
        System.out.println(s.getMakeModel() + " - Current Speed: " + s.getCurrentSpeed());
        System.out.println(t.getMakeModel() + " - Current Speed: " + t.getCurrentSpeed());
    }
}
```

#### Polymorphism
The book and the documentation have some better examples but polymorphism is really just a way to refer to objects using their base classes instead of their actual classes. 

So in ur last example the Sedan and Truck are both Vehicles, so I can refer to them as either if it suits my needs. Lets look at one example of that based on our last example
```java

import java.util.ArrayList;

public class InheritExample {
    
    public static abstract class Vehicle {
        int currentSpeed = 0;
        String desc;

        abstract void brake(int amount);
        
        public void accelerate(int amount) {
            this.currentSpeed += amount;
        }
        public String getMakeModel() {
            return this.desc;
        }
        public int getCurrentSpeed() {
            return this.currentSpeed;
        }
    }
    
    public static class Sedan extends Vehicle {
        public Sedan(String sedanDesc) {
            this.desc = sedanDesc;
        }
            
        public void brake(int amount) {
            this.currentSpeed -= amount;
        }
    }
    
    public static class Truck extends Vehicle {
        public Truck(String truckDesc) {
            this.desc = truckDesc;
        }
            
        public void brake(int amount) {
            this.currentSpeed -= (amount / 2);
        }
    }

    public static void main(String[] args) {
        ArrayList<Vehicle> allCars = new ArrayList<>();
        Sedan s = new Sedan("Lexus LS");
        s.accelerate(75);
        s.brake(10);
        allCars.add(s);
        
        Truck t = new Truck("Ford F150");
        t.accelerate(75);
        t.brake(10);
        allCars.add(t);
        
        Sedan s2 = new Sedan("Acura TL");
        s2.accelerate(90);
        s2.brake(5);
        allCars.add(s2);
        
        // Since I'm working on Vehicles I can do things to all of these objects
        for (Vehicle v: allCars) {
            System.out.println(v.getMakeModel() + " - Current Speed: " + v.getCurrentSpeed());
        }
    }
}
```

## Section 2e: Review of Access Modifiers
Now that we understand subclasses lets go back and review the access modifiers
| Modifier            	| Class 	| Package 	| Subclass 	| World 	|
|---------------------	|-------	|---------	|----------	|-------	|
| public              	|   Y   	|    Y    	|     Y    	|   Y   	|
| protected           	|   Y   	|    Y    	|     Y    	|   N   	|
| no modifier/package 	|   Y   	|    Y    	|     N    	|   N   	|
| private             	|   Y   	|    N    	|     N    	|   N   	|

#### Good Guidance
- Use private unless you have a good reason not too.
    - There is rarely a good reason for member/instance variables
- For variables there are lots of good reasons. 



## Section 2f: Exercises
####Exercise 1
For the following piece of code what gets printed?
```java
public class InheritExample {
    
    public static class ClassA {
        public void methodOne(int i) {
            System.out.println("A-1");
        }
        public void methodTwo(int i) {
            System.out.println("A-2");
        }
        public static void methodFour(int i) {
            System.out.println("A-4");
        }
    }
    
    public static class ClassB extends ClassA {
        public void methodOne(int i) {
            System.out.println("B-1");
        }
        public void methodTwo(int i) {
            System.out.println("B-2");
        }
        public static void methodFour(int i) {
            System.out.println("B-4");
        }
    }
    
    public static void main(String[] args) {

        ClassA one = new ClassA();
        one.methodTwo(1);
        
        ClassB two = new ClassB();
        two.methodOne(2);
        
        ClassA three = new ClassB();
        three.methodOne(3);
        
        ClassB.methodFour(4);
    }
}
```
<details>
  <summary>Solution</summary>

A-2
B-1
B-1
B-4
</details>

####Exercise 2
Lets review this next piece of code, how can we improve it?
```java

public class Card {
    private int rank;
    private int suit;

    public final static int DIAMONDS = 1;
    public final static int CLUBS = 2;
    public final static int HEARTS = 3;
    public final static int SPADES = 4;

    public final static int ACE = 1;
    public final static int DEUCE = 2;
    public final static int THREE = 3;
    public final static int FOUR = 4;
    public final static int FIVE = 5;
    public final static int SIX = 6;
    public final static int SEVEN = 7;
    public final static int EIGHT = 8;
    public final static int NINE = 9;
    public final static int TEN = 10;
    public final static int JACK = 11;
    public final static int QUEEN = 12;
    public final static int KING = 13;

    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    public static boolean isValidRank(int rank) {
        return ACE <= rank && rank <= KING;
    }

    public static boolean isValidSuit(int suit) {
        return DIAMONDS <= suit && suit <= SPADES;
    }

    public int hashCode() {
        return ((suit-1)*13)+rank;
    }

    public String toString() {
        return rankToString(this.rank) + " of "
               + suitToString(this.suit);
    }

    public static String rankToString(int rank) {
        switch (rank) {
            case ACE:
                return "Ace";
            case DEUCE:
                return "Deuce";
            case THREE:
                return "Three";
            case FOUR: 
                return "Four";
            case FIVE:
                return "Five";
            case SIX:
                return "Six";
            case SEVEN:
                return "Seven";
            case EIGHT:
                return "Eight";
            case NINE:
                return "Nine";
            case TEN:
                return "Ten";
            case JACK:
                return "Jack";
            case QUEEN:
                return "Queen";
            case KING:
                return "King";
            default:
                //Handle an illegal argument.  There are generally two ways
                //to handle invalid arguments, throwing an exception (see
                //the section on Handling Exceptions):
                throw new IllegalArgumentException("Invalid rank " + rank);
                //or
                //return null;
        }
    }

    public static String suitToString(int suit) {
        String result = "";
        switch (suit) {
            case DIAMONDS:
                return "Diamonds";
            case CLUBS:
                return "Clubs";
            case HEARTS:
                return "Hearts";
            case SPADES:
                return "Spades";
            default:
                throw new IllegalArgumentException("Invalid suit " + suit);
        }
    }

    public static void main(String... args) {
        new Card(ACE, DIAMONDS);
        new Card(KING, SPADES);
    }
}
```
<details>
  <summary>Solution</summary>

```java
public class Card {
    private RANK rank;
    private SUIT suit;

    static enum SUIT {
        DIAMONDS(1, "Diamonds"), CLUBS(2, "Clubs"), HEARTS(3, "Hearts"), SPADES(4, "Spades");
        private int value;
        private String display;
        private SUIT(int v, String display) {
            this.value = v;
            this.display = display;
        }
        public int getValue() {
            return value;
        }
        public String getDisplay() {
            return display;
        }
    }

    static enum RANK {
        ACE(1, "Ace"), DEUCE(2, "Deuce"), THREE(3, "Three"), FOUR(4, "Four"), 
        FIVE(5, "Five"), SIX(6, "Six"), SEVEN(7, "Seven"), 
        EIGHT(8, "Eight"), NINE(9, "Nine"), TEN(10, "Ten"), 
        JACK(11, "Jack"), QUEEN(12, "Queen"), KING(13, "King");
        private int value;
        private String display;
        private RANK(int v, String display) {
            this.value = v;
            this.display = display;
        }
        public int getValue() {
            return value;
        }
        public String getDisplay() {
            return display;
        }
    }

    public Card(RANK rank, SUIT suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public SUIT getSuit() {
        return suit;
    }

    public RANK getRank() {
        return rank;
    }

    public static boolean isValidRank(RANK rank) {
        return RANK.ACE.getValue() <= rank.getValue() 
        && rank.getValue() <= RANK.KING.getValue();
    }

    public static boolean isValidSuit(SUIT suit) {
        return SUIT.DIAMONDS.getValue() <= suit.getValue() 
            && suit.getValue() <= SUIT.SPADES.getValue();
    }

    public int hashCode() {
        return ((suit.getValue()-1)*13)+rank.getValue();
    }

    public String toString() {
        return rankToString(this.rank) + " of "
               + suitToString(this.suit);
    }

    public static String rankToString(RANK rank) {
        if (rank == null) {
            throw new IllegalArgumentException("Invalid rank " + rank);
        }
        return rank.getDisplay();
    }

    public static String suitToString(SUIT suit) {
        if (suit == null) {
            throw new IllegalArgumentException("Invalid suit " + suit);
        }
        return suit.getDisplay();
    }

    public static void main(String... args) {
        new Card(RANK.ACE, SUIT.DIAMONDS);
        new Card(RANK.KING, SUIT.SPADES);
    }
}
```
</details>

## Section 2g: Project Review
TBD

## References
Online Material for this week:
https://docs.oracle.com/javase/tutorial/java/concepts/inheritance.html
https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html
https://docs.oracle.com/javase/tutorial/java/IandI/subclasses.html


Google Code Style: 
https://google.github.io/styleguide/javaguide.html

Online compile tool:
https://www.jdoodle.com/online-java-compiler-ide/

