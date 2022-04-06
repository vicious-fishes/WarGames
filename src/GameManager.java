import java.util.List;
import java.util.Objects;

public class GameManager {
    public static GameManager instance = new GameManager();

    private GameManager() {}

    public void start() {
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");

        Deck deck = new Deck();
        Integer roundNumber = 0;
        List<Card> cards = deck.drawCards();

        while (!cards.isEmpty()) {
            roundNumber++;
            System.out.printf("Round %d\n", roundNumber);
            player1.setCardInHand(cards.get(0));
            player2.setCardInHand(cards.get(1));
            System.out.println();

            awardRoundWinner(player1, player2, roundNumber);
            System.out.println();

            System.out.println("Score");
            printScores(player1, player2);
            System.out.println();
            cards = deck.drawCards();
        }

        System.out.println("GAME OVER");
        System.out.println();
        System.out.println("FINAL SCORE");
        printScores(player1, player2);

        congratulateWinner(player1, player2);
    }

    private void awardRoundWinner(final Player player1, final Player player2, final Integer roundNumber) {
        Player winner = player1.getCardInHand().beats(player2.getCardInHand()) ? player1 : player2;
        winner.awardPoint();
        System.out.printf("%s wins Round %d!\n", winner.getName(), roundNumber);
    }

    private void printScores(final Player player1, final Player player2) {
        System.out.printf("%s: %d\n", player1.getName(), player1.getScore());
        System.out.printf("%s: %d\n", player2.getName(), player2.getScore());
    }

    private void congratulateWinner(final Player player1, final Player player2) {
        if(Objects.equals(player1.getScore(), player2.getScore())) {
            System.out.println("TIE GAME!");
            return;
        }
        Player winner = player1.getScore() > player2.getScore()? player1 : player2;

        System.out.printf("Congratulations, %s!", winner.getName());
    }
}
