import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Deck {
    private final List<Card> cards;
    private final Random random = new Random();

    public Deck() {
        this.cards = Arrays.stream(Suit.values())
                .flatMap(suit -> Arrays.stream(Value.values())
                        .map(value -> new Card(value, suit)))
                .collect(Collectors.toList());

        if(cards.size() != 52) {
            throw new RuntimeException("The new deck contains the wrong number of cards. This is a bug");
        }
    }

    public List<Card> drawCards() {
        return Stream.of(getRandomCard(), getRandomCard())
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private Card getRandomCard() {
        if(cards.isEmpty()) {
            return null;
        }
        if(cards.size() == 1) return cards.remove(0);
        int position = random.nextInt(cards.size() - 1);
        return cards.remove(position);
    }
}
