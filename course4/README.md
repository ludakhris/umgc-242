# UMGC-242 - Course 4 - Advanced Class Design, User Interfaces & Project Review

## Section 4a: Simple Hotel Management System
Situation:
- You are managing two hotels. 
- You need to create a system that allows you to simple track the number of rooms you have available and how many are occupied. This time you do not care about the guests information.
- Develop a simple system that will construct your two hotels, add several guests to each and then print out how many rooms are occupied. 


#### Section 4b: User Interfaces
The system we created in the previous section is useful! However it would be even better if we had a way to let the front desk guy interact with it, right? 

To do that we have to introduce one new topic User Interfaces

Lets review a code example:

```java
import javax.swing.*;
import java.awt.*;

public class GuiExample extends JFrame {
  public GuiExample () {
    this ("one");
  } // end no parameter constructor

  public GuiExample (String t) {
    setTitle (t);
    setSize (200,200);
    setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo (null);
    add (new JButton ("North " + t), BorderLayout.NORTH);
    add (new JButton ("East " + t), BorderLayout.EAST);
    add (new JButton ("West " + t), BorderLayout.WEST);
   
    validate ();
    pack ();
    setVisible (true);
  } // end String constructor

  public static void main (String args []) {
    GuiExample ga = new GuiExample ();
    GuiExample gb = new GuiExample ("two");
  } // end main

} // end class GuiExample
```

## Section 4c: A interactive hotel management system

Situation:
- Same situation as before but you want to extend you existing system with a user interface so that your front desk team can interact with it.

## Section 4d: Project Review
- Automobile class (makeAndModel/price, constructor, salesTax(), toString())
- Two subclasses: 
  - Electric (weightInPounds, constructor, salesTax(), toString())
  - Hybrid (mpg, constructor, salesTax(), toString())
- Develop a UI that allows you to specify the details about a car, compute the sales tax. 
  - After all the cars are entered it should allow you to display a report of all the cars (which should use the classes to string method). 

## References
Online Material for this week:
https://learn.umuc.edu/d2l/le/content/426317/viewContent/15690289/View
https://docs.oracle.com/javase/tutorial/uiswing/index.html

Google Code Style: 
https://google.github.io/styleguide/javaguide.html

Online compile tool:
https://www.jdoodle.com/online-java-compiler-ide/

