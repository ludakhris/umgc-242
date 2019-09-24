# UMGC-242 - Course 6 - I/O & Recursion, Project 3

## Section 6a: Finish preivious exercise

## Section 6b: Recursion

Well we've already discussed I/O and Exception Handiling already but the rest of todays class will be about recurission.

I preface this by saying that Recursion is a fairly hard problem to wrap your heard around. It really is more of a way of thinking about how to apporach a really complex problem.

So what is recursion? Lets look at an example. Can you tell me what happens in the following code:

```java
public class MyClass {
  public int myRecursiveMethod ()  
  {  
    int aVariable = myRecursiveMethod();  
  }

  public static void main(String[] args) {
    new MyClass().myRecursiveMethod();
  }
}
```

Recursion, simply put is, any code that you write that happen to call itself. 

Lets look at a better example:
```java
public class MyClass {
  public int myRecursiveMethod (int aVariable)  
  {  
    System.out.println(aVariable);  
    aVariable--;  
    if (aVariable == 0)  
      return 0;  
    return myRecursiveMethod(aVariable);  
  } 

  public static void main(String[] args) {
    new MyClass().myRecursiveMethod(5);
  }
}
```

What does the output look like?

In general recursive solutions to problems always have a similar structure:
There are really only two things any recursive code needs to ensure that it will work properly:There are really only two things any recursive code needs to ensure that it will work properly:
- A defined ending point.
- A constant progression towards ending.
- A terminating condition.

Can you identify what these are in our previous example?

## Section 6b: Recursive Problem

Scenario:

I want you to create a system that will let the user type in a sentence and you will print out the reverse of that sentence?

<details>
  <summary>Exercise Solution:</summary>
  
```java
//Reverse.java
import java.util.*;
class Reverse {
   public static void recursiveReverse(Scanner in)  {
      String word = in.next();
      if (in.hasNext())  
         recursiveReverse(in);
      System.out.print(word + " ");
   }
   public static void main(String args[]) {
      Scanner stdin = new Scanner(System.in);
      recursiveReverse(stdin);
   }
}
```
</details>

## Section 6b: Harder Recursive Problem

Source: https://www.topcoder.com/community/competitive-programming/tutorials/an-introduction-to-recursion-part-1/


## References
Online Material for this week:
https://learn.umuc.edu/d2l/le/content/426317/viewContent/15690298/View
http://howtoprogramwithjava.com/java-recursion/

Google Code Style: 
https://google.github.io/styleguide/javaguide.html

Online compile tool:
https://www.jdoodle.com/online-java-compiler-ide/

