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

## Section 6c: Recursive Problem

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

## Section 6d: Harder Recursive Problem

![Org Chart](https://community.topcoder.com/i/education/hierarchy2.PNG)

Task:
- Write a function that will count the number of employees under any manager.

<details>
  <summary>Exercise Solution:</summary>
  
```java
PSEDUOCODE
public int countEmployeesUnder(String employeeName)
{
    declare variable counter
    counter = 0
    for each person in employeeDatabase
    {
        if(person.manager == employeeName)
        {
            counter = counter + 1
            counter = counter + countEmployeesUnder(person.name)
        }
    }
    return counter
}
```
</details>

## Section 6e: Project Review
- Make a simple UI
- Write both a recursive and iterative versions of functions that compute the sequence.
- Decide how you want to measure each methods "effectiveness" (intentionally nebulus)

## References
Online Material for this week:
https://learn.umuc.edu/d2l/le/content/426317/viewContent/15690298/View
http://howtoprogramwithjava.com/java-recursion/

Google Code Style: 
https://google.github.io/styleguide/javaguide.html

Online compile tool:
https://www.jdoodle.com/online-java-compiler-ide/

