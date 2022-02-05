import com.sun.source.tree.DefaultCaseLabelTree;

import java.util.List;

public class Blackjack {
    final private List<Integer> values = List.of(11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 0);
    final private List<String> cards = List.of("ace", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "jack", "queen", "king", "other");

    /**
     * calculate the score of any card at all
     *
     * @param card the string representation of a card
     * @return the value of the card
     */
    public int parseCard(String card) {
        // Sorry but I am not typing a switch statement by hand, and that is what should be in README.md
        int index = cards.indexOf(card);
        return values.get(index);
    }

    /**
     * Checks if 2 cards have the combined value of 21.
     *
     * @param card1 is the first String representation of a card
     * @param card2 is the second String representation of a card
     * @return whether it's a blackjack or not.
     * @see <a href="https://en.wikipedia.org/wiki/Blackjack#Rules_of_play_at_casinos">Rules of Blackjack</a>
     */
    public boolean isBlackjack(String card1, String card2) {
        throw new UnsupportedOperationException("Please implement the Blackjack.isBlackjack method");
    }

    public String largeHand(boolean isBlackjack, int dealerScore) {
        throw new UnsupportedOperationException("Please implement the Blackjack.largeHand method");
    }

    public String smallHand(int handScore, int dealerScore) {
        throw new UnsupportedOperationException("Please implement the Blackjack.smallHand method");
    }

    // FirstTurn returns the semi-optimal decision for the first turn, given the cards of the player and the dealer.
    // This function is already implemented and does not need to be edited. It pulls the other functions together in a
    // complete decision tree for the first turn.
    public String firstTurn(String card1, String card2, String dealerCard) {
        int handScore = parseCard(card1) + parseCard(card2);
        int dealerScore = parseCard(dealerCard);

        if (20 < handScore) {
            return largeHand(isBlackjack(card1, card2), dealerScore);
        } else {
            return smallHand(handScore, dealerScore);
        }
    }
}
