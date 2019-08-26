# UMGC-242 - Course 1

## Section 1a: Classes and Objects
This is often a really challenging concept for students. What is a class vs an object? 

```java
public class Car {
    public static void main(String args[]) {
        
      Car myCar = new Car(2010, "Ford", "Mustang");
      Car yourCar = new Car(2012, "Toyota", "Prius");

      System.out.println(myCar);
      System.out.println(yourCar);
      System.out.println(yourCar.getAge());
    }
    
    private int year;
    private String make;
    private String model;
    
    public Car(int year, String make, String model) {
        this.year = year;
        this.make = make;
        this.model = model;
    }
    
    public String toString() {
        return this.year + " " + this.make + " " + this.model;
    }
    
    public int getAge() {
        int age = 2019 - this.year;
        printIfOld(age);
        return age;
    }
	
	private void printIfOld(int age) {
		if (age > 5) {
            System.out.println("You car is OLD!!!");
        }
    }
}
```

Ok now that we sort of get it lets make it a bit more formalized. 

Classes provide: (aka the blueprint)
- Modularity
- Information Hiding
- Code Re-Use
- Class definitions have a name, modifier and variables and methods.
- Variables have a modifier, name and possibly a defined value.
- Methods have a modifier, name, return type, params and possibly exceptions thrown.

Objects provide: (aka the instance)
- Declaration
- Instantiation
- Initialization
> In other words: name of variable, object type and data elements.

Object vs Class wrap up:
- Does my rectangle still exist? Why?
- What is the scope of the variable area? Why?
- Should rectangle have public variables? Why?
- Is there anything else we should improve?

Scope & Lifetime:
Two new terms.
- Scope - is the region or section of code where a variable can be accessed.
- Lifetime - how long does a variable/object exist.

Everything has them and lets talk briefly about how java tracks and cleans things up for us. 

## Section 1b: Dry vs Wet Principles
In general these are some of the most well known good software design principals. If you aren't already familiar then theres a good chance you have already probably been doing some of it. 

(Clothes analogy)
> Everyone knows that dry stuff is lighter and easier to maintain, manipulate, and store. You wouldn’t want to keep wet cloths in your suitcase — it would create unpleasant smell and increase the weight of your bag. In short, it’d be really bad.

When it comes to programming, DRY and WET practices can be taken the same way — you’d want to avoid the WET ones. DRY and WET are actually acronyms:
- DRY - Don't Repeat Yourself
- WET - Write Everything Twice

These are basic principles of software development aimed at reducing repetition of information, improving readability and reducing bugs.

To avoid violating the DRY principle, divide your system into pieces. Divide your code and logic into smaller reusable units and use that code by calling it where you want. Don't write lengthy methods, but divide logic and try to use the existing piece in your method.

Benefits:
- Maintainability
- Reduces the chances of bugs
- Readability
- Reusability
- Cost
- Testing

Disadvantages:
- Over-dried code may be more complex and thus harder to read.
- Over-dried code may takes a bit longer to write.
- Over-dried code can be ugly. 
> You should not dry your cloths too much, they can start to burn.

WET Example: 

```java
package uber;

import java.util.Date;

public class Uber {
    public static void main(String args[]) {
        System.out.println("I'm so ready to go...lets call an UBER!");
        new Uber().callUber();
    }
    
    public void callUber() {
        if (!uberDay()) {
            uberMidnight();
        }
    }
    
    private boolean uberDay() {
        Date dt = new Date();
        int hours = dt.getHours();
        if(UberUtils.driverIsAround() && (hours > 5 && hours < 21)){
        	System.out.println("driver will be around in 3 mins");
        	return true;
        } else {
        	System.out.println("sorry there no available driver around you");
        }
        return false;
    }
    
    private boolean uberMidnight() {
        Date dt = new Date();
        int hours = dt.getHours();
        if(UberUtils.driverIsAround() && (hours > 21 && hours < 5)){
        	System.out.println("driver will be around in 3 mins but u don not want to go out now");
        	return true;
        } else {
        	System.out.println("sorry there no available driver around you");
        }
        return false;
    }
}
```

DRY Example:
```java
package uber;

import java.util.Date;

public class Uber {
    public static void main(String args[]) {
        System.out.println("I'm so ready to go...lets call an UBER!");
        new Uber().callUber();
    }
    
    public void callUber() {
        if (UberUtils.driverIsAround()) {
            boolean isDayTime = isDayTime();
            if (isDayTime) {
                uberDay();
            } else {
                uberMidnight();
            }
        } else {
            System.out.println("sorry there no available driver around you");
        }
    }
    
    private boolean isDayTime() {
        Date dt = new Date();
        int hours = dt.getHours();
        return (UberUtils.driverIsAround() && (hours > 5 && hours < 21));
    }
    
    private void uberDay() {
        System.out.println("driver will be around in 3 mins");
    }
    
    private boolean uberMidnight() {
        System.out.println("driver will be around in 3 mins but u don not want to go out now");
    }
}
```

## Section 1c: Kiss Principles
KISS stand for "Keep It Simple, Silly" (or whatever colorful S word you want to use there) and it is meant to be funny but also VERY true. 

Bottom line is code should be simple and clear, making it easy to understand. Complicated bits should have an easy to follow comment. 

Which one would you prefer? And could we do better?

```java
public String weekday1(int day) {
    switch (day) {
        case 1:
            return "Monday";
        case 2:
            return "Tuesday";
        case 3:
            return "Wednesday";
        case 4:
            return "Thursday";
        case 5:
            return "Friday";
        case 6:
            return "Saturday";
        case 7:
            return "Sunday";
        default:
            throw new InvalidOperationException("day must be in range 1 to 7");
    }
}
public String weekday2(int day) {
    if ((day < 1) || (day > 7)) throw new InvalidOperationException("day must be in range 1 to 7");
    string[] days = {
        "Monday",
        "Tuesday",
        "Wednesday",
        "Thursday",
        "Friday",
        "Saturday",
        "Sunday"
    };
    return days[day - 1];
}
```

## Section 1d: Exercises
1. Consider the following class:

```java
public class IdentifyMyParts {
    public static int x = 7; 
    public int y = 3; 
}
```
 1. What are the class variables?
 1. What are the instance variables?
 1. What is the output from the following code:
 ```java
public class Execise1 {
    public static int x = 2; 
    public int y = 3; 
	
	public static void main(String[] args) {
    	Execise1 a = new Execise1(); 
        Execise1 b = new Execise1(); 
        a.y = 10; 
        b.y = 5; 
        a.x = 1; 
        b.x = 2; 
        System.out.println("a.y = " + a.y); 
        System.out.println("b.y = " + b.y); 
        System.out.println("a.x = " + a.x); 
        System.out.println("b.x = " + b.x); 
        System.out.println("Execise1.x = " + Execise1.x);
    }
}
```
    <details>
    <summary>Solution</summary>

    ```java
    1a. X
    1b. Y
    1c. Output: 
    a.y = 10
    b.y = 5
    a.x = 2
    b.x = 2
    Execise1.x = 2
    ```
    </details>

1. Whats wrong with this program?
 ```java
public class SomethingIsWrong {
    public static void main(String[] args) {
        Rectangle myRect;
        myRect.width = 40;
        myRect.height = 50;
        System.out.println("myRect's area is " + myRect.area());
    }
}
```
2. How would we fix the program above?
    <details>
    <summary>Solution</summary>

     ```java
    public class SomethingIsRight {
        public static void main(String[] args) {
            Rectangle myRect = new Rectangle();
            myRect.width = 40;
            myRect.height = 50;
            System.out.println("myRect's area is " + myRect.area());
        }
    }
     ```
    </details>

## References
Online Material for this week:
https://docs.oracle.com/javase/tutorial/java/javaOO/index.html
https://docs.oracle.com/javase/tutorial/java/concepts/index.html
https://learn.umuc.edu/d2l/le/content/426317/viewContent/15690270/View

Google Code Style: 
https://google.github.io/styleguide/javaguide.html

Online compile tool:
https://www.jdoodle.com/online-java-compiler-ide/
