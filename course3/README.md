# UMGC-242 - Course 3 - More on Exceptions, Interfaces and Abstract Classes

## Section 3a: Review, Review, Review
What did we learn last time? Let's Review
- Enums
- Inheritance
- Interfaces
- Abstract Classes
- Unfinished Exercises from Last Time


#### Section 3b: More on Exceptions  
In previous classes we talked about two concepts, the call stack and exception propagation.

The call stack:

![Call Stack](https://docs.oracle.com/javase/tutorial/figures/essential/exceptions-callstack.gif)

Exception propagation:

![Exception propagation](https://docs.oracle.com/javase/tutorial/figures/essential/exceptions-errorOccurs.gif)

Lets review a code example:

```java
import java.util.Scanner;
import java.util.Random;
import java.lang.*;

public class MyClass {
    
    public static void main(String args[]) {

        // Prompt
        System.out.print("Choose a number between 1 and 10: ");
        
        // Have the computer pick a number between 1 and 10 
        int computerChoice = new Random().nextInt(10 - 0 + 1) + 0;
      
        // Get user input
        Scanner input = new Scanner(System.in);
    	int number = input.nextInt();
    	System.out.println("Confirmation: User entered " + number);
    	
    	// Check the users selection 
    	if (number > 10 || number < 1) {
    	    throw new IllegalArgumentException("Come on follow instructions");
    	}
    	
    	// Check if its a match
    	if (number == computerChoice) {
    	    System.out.println("You win!!!!!");
    	} else if ( number == (computerChoice + 1) || number == (computerChoice - 1)) {
    	    System.out.println("You were soooooo close!!!!!");
    	} else {
    	    System.out.println("You lost :-( The computer picked number: " + computerChoice);
    	}
    }
}
```

How can we dry this out?
<details>
  <summary>Exercise Solution:</summary>
  
```java
import java.util.Scanner;
import java.util.Random;
import java.lang.*;

public class Exercise1 {
    
    public static enum GAME_RESULT {
        WIN,
        LOST,
        ALMOST
    }
    
    public static class GameException extends Exception {
        public GameException(String error) {
            super(error);
        }
    }
    
    public static class Game {
        
        int computerChoice;
        int userChoice;
        
        int min;
        int max;
        
        public Game(int min, int max) {
            
            if (min > max || min < 0) {
                throw new IllegalArgumentException("Invalid min/max values for game");
            }

            this.min = min;
            this.max = max;
        }
        
        public void gameStart() throws GameException {
            // Prompt
            System.out.print("Choose a number between " + min + " and " + max + ": ");
            
            // Have the computer pick a number between 1 and 10 
            computerChoice = new Random().nextInt(max - min) + 0;
          
            // Get user input
            Scanner input = new Scanner(System.in);
        	userChoice = input.nextInt();
        	
        	// Check the users selection 
        	if (userChoice > max || userChoice < min) {
        	    throw new GameException("Come on follow instructions, enter a number between " + min + " and " + max);
        	}
    	
        	System.out.println("Confirmation: User entered " + userChoice);
        }
        
        public GAME_RESULT determineOutcome() {
            if (userChoice == computerChoice) {
        	    return GAME_RESULT.WIN;
        	} else if ( userChoice == (computerChoice + 1) || userChoice == (computerChoice - 1)) {
        	    return GAME_RESULT.ALMOST;
        	} else {
        	    return GAME_RESULT.LOST;
        	}
        }
        
        public int getComputerChoice() {
            return this.computerChoice;
        }
    }
    
    public static void main(String args[]) {
        
        Game g = new Game(1, 10);

        // Start game
        try {
            g.gameStart();
            
            // Check for winner
            GAME_RESULT result = g.determineOutcome();
            
            switch(result) {
                case WIN:
                    System.out.println("You win!!!!!");
                    break;
                case ALMOST:
                    System.out.println("You were soooooo close!!!!! The computer picked: " + g.getComputerChoice());
                    break;
                case LOST:
                    System.out.println("You lost :-( The computer picked number: " + g.getComputerChoice());
                    break;
            }
        } catch (GameException e) {
            System.err.println(e.getMessage());
        }
    }
}
```
</details>

#### Exception Types

Like all classes in Java exceptions aren't much different, lets look at the class hierarchy. 

![Exception propagation](http://www.tutorialspoint.com/java/images/exceptions1.jpg)

There really are a few flavors of exceptions all are subclasses/extensions of Throwable (aka meaning they can be thrown).
- Errors - Serious exceptions like memory issues
- Exception - All other are classified as:
  - Unchecked - They extend RuntimeException
  - Checked - All others

The distinction between the two are how you have to deal with them in our example. 

```java
public static void cat(File file) {
    RandomAccessFile input = null;
    String line = null;

    if (file == null) {
        throw new IllegalArgumentException("The file is null");
    }

    try {
        input = new RandomAccessFile(file, "r");
        while ((line = input.readLine()) != null) {
            System.out.println(line);
        }
        return;
    } catch(FileNotFoundException fnf) {
        System.err.format("File: %s not found%n", file);
    } catch(IOException e) {
        System.err.println(e.toString());
    } finally {
        if (input != null) {
            try {
                input.close();
            } catch(IOException io) {
            }
        }
    }
}

```

## Section 3c: Abstract Classes & Interfaces
We've covered these topics already so lets use them in a real example. 

Situation:
- You are managing a hotel. You need to create a system that allows you to track the guests in each room of the hotel, their occupancy etc. 

## References
Online Material for this week:
https://docs.oracle.com/javase/tutorial/essential/exceptions/index.html
http://www.tutorialspoint.com/java/java_exceptions.htm
https://docs.oracle.com/javase/tutorial/java/concepts/interface.html
https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html

Google Code Style: 
https://google.github.io/styleguide/javaguide.html

Online compile tool:
https://www.jdoodle.com/online-java-compiler-ide/

