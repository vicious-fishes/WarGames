public class Card {
    private final Value value;
    private final Suit suit;

    public Card(final Value value, final Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    public boolean beats(final Card card) {
        return (this.value.compareTo(card.value) > 0) ||
                (this.value.compareTo(card.value) == 0 && this.suit.compareTo(card.suit) > 0);
    }

    public String toString() {
        return String.format("%s OF %s", value, suit);
    }
}
