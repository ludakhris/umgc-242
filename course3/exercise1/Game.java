public class Game {
        
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