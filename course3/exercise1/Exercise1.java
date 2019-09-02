import java.util.Scanner;
import java.util.Random;
import java.lang.*;

public class Exercise1 {
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