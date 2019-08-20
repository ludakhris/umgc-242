# UMGC-242

## Course Organization, Q&A
- Course Overview
- Tutorials + Quizzes + Projects
- Learning how to learn languages

Question and Answer Time
- How many folks have programmed in Java before? 
- Whats your experience level 1-10?
- Goals for the course?
- Do I need to read the material?
- Do I need to take notes? 
- Why are discussions important?
- What tools should I be using? 

## Section 1a: Classes and Objects
This is often a really challenging concpet for students. 
What is a class vs an object? 
> (Blueprint vs Instance Analogy)


## Section 1b: Inheritance & Polymorphism
e
## Section 1c: Abstract Classes & Interfaces

## Section 1d: Packages & Enums

## Section 1e: Dry vs Wet Principles
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
        }else{
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

## Section 1f: Kiss Principles
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

## References
https://docs.oracle.com/javase/tutorial/java/javaOO/index.html
https://docs.oracle.com/javase/tutorial/java/concepts/index.html
https://learn.umuc.edu/d2l/le/content/426317/viewContent/15690270/View
