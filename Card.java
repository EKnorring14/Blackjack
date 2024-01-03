
class Card {
    private final String suit;
    private final String rank;

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }

    public int getValue() {
        switch (rank) {
            case "2", "3", "4", "5", "6", "7", "8", "9", "10" -> {
                return Integer.parseInt(rank);
            }
            case "J", "Q", "K" -> {
                return 10;
            }
            case "A" -> {
                return 11; // For simplicity, we'll use 11 for Ace here.
            }
            default -> {
                return 0; // Should not reach here.
            }
        }
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}