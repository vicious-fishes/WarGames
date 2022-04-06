public class Player {
    private final String name;
    private Card cardInHand;
    private Integer score;

    public Player(final String name) {
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return this.name;
    }

    public void setCardInHand(final Card card) {
        this.cardInHand = card;
        System.out.printf("%s draws %s.\n", name, card.toString());
    }

    public Card getCardInHand() {
        return this.cardInHand;
    }

    public Integer getScore() {
        return this.score;
    }

    public void awardPoint() {
        score++;
    }
}
