
import java.util.Scanner;

class BlackjackGame {
    private final Deck deck;
    private final Player player;
    private final Player dealer;

    public BlackjackGame() {
        deck = new Deck();
        player = new Player("Player");
        dealer = new Player("Dealer");
    }

    public void startGame() {
        // Deal initial cards
        player.addCardToHand(deck.dealCard());
        dealer.addCardToHand(deck.dealCard());
        player.addCardToHand(deck.dealCard());
        dealer.addCardToHand(deck.dealCard());

        // Player's turn
        playPlayerTurn();

        // Dealer's turn
        playDealerTurn();

        // Determine the winner
        determineWinner();
    }

    private void playPlayerTurn() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(player);
            System.out.println("Do you want to hit (h) or stand (s)?");
            String choice = scanner.nextLine().toLowerCase();

            if ("h".equals(choice)) {
                player.addCardToHand(deck.dealCard());
                if (player.calculateHandValue() > 21) {
                    System.out.println("Bust! You went over 21. Dealer wins!");
                    return;
                }
            } else if ("s".equals(choice)) {
                System.out.println("You chose to stand.");
                return;
            } else {
                System.out.println("Invalid choice. Please enter 'h' or 's'.");
            }
        }
    }

    private void playDealerTurn() {
        System.out.println("\nDealer's turn:");
        while (dealer.calculateHandValue() < 17) {
            dealer.addCardToHand(deck.dealCard());
        }
        System.out.println(dealer);
    }

    private void determineWinner() {
        int playerValue = player.calculateHandValue();
        int dealerValue = dealer.calculateHandValue();

        System.out.println("\nGame Over!");
        System.out.println(player);
        System.out.println(dealer);

        if (playerValue > 21) {
            System.out.println("Bust! You went over 21. Dealer wins!");
        } else if (dealerValue > 21) {
            System.out.println("Dealer busts! You win!");
        } else if (playerValue > dealerValue) {
            System.out.println("You win!");
        } else if (dealerValue > playerValue) {
            System.out.println("Dealer wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }
}