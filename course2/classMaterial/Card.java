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