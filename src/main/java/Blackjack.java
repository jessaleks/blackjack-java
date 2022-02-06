import java.util.*;

public class Blackjack {
    // I would have used a Map here, though Java does not have a way to initialize a Map within a sane number of characters
    final private List<String> cards = List.of("ace", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "jack", "queen", "king", "other");
    final private List<Integer> values = List.of(11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 0);

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
        return parseCard(card1) + parseCard(card2) == 21;
    }

    // no clue what to do here; I don't understand blackjack at all nor have I ever played it
    // what does it mean to "have a figure"
    // what does it mean to stand, hit or split?

    /**
     * Implements the logic when you have a hand with a score of 20 or more.
     *
     * @param isBlackjack is whether the hand is a blackjack
     * @param dealerScore is the score of the dealer
     */
    public String largeHand(boolean isBlackjack, int dealerScore) {
        if (isBlackjack) {
            return dealerScore < 10 ? "W" : "S";
        } else {
            return "P";
        }

    }

    /**
     * Implements the logic when you have a hand with a score of less than 20.
     *
     * @param handScore   is the score of the hand
     * @param dealerScore is the score of the dealer
     * @return the optimal decision for the hand
     */
    public String smallHand(int handScore, int dealerScore) {
        if (handScore >= 17) {
            return "S";
        }

        if (handScore <= 11) {
            return "H";
        }

        // Since after these two first checks, we know for sure our score
        // is between 12 and 16, we only care about dealer's score now.
        return dealerScore <= 6 ? "S" : "H";
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
