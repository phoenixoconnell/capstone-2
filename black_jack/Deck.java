package black_jack;

import java.util.ArrayList;

public class Deck implements Dealable {
    private ArrayList<Card> deck;
    private boolean empty;

    Deck() {
        deck = new ArrayList<>();
        empty = true;
    }


    //gets a random card, removes it from the deck,
    //and returns it
    //marks the deck as empty if all the cards are drawn
    @Override
    public Card shuffleDraw() {
        Card card;
        int r = (int) (Math.random() * (deck.size()));
        card = this.deck.remove(r);

        if(deck.size() == 0) empty = true;
        return card;
    }

    @Override
    public void fillDeck() {
        int deckSize = 52 * 6;

        for(int i = 1; i <= deckSize; i++) {
            Card.Suit suit = null;
            String val;

            //Determines face value of the card
            //If % 10 - 13 == 0, it is a face card
            //otherwise it's a number card
            if(i % 13 == 10) val = "J";
            else if(i % 13 == 11) val = "Q";
            else if(i % 13 == 12) val = "K";
            else if(i % 13 == 0) val = "A";
            else val = "" + ((i % 13) + 1);

            //Determines the suit of the card in groups of 13
            if(((i - 1) / 13) % 4 == 0) suit = Card.Suit.HEART;
            if(((i - 1) / 13) % 4 == 1) suit = Card.Suit.DIAMOND;
            if(((i - 1) / 13) % 4 == 2) suit = Card.Suit.CLUB;
            if(((i - 1) / 13) % 4 == 3) suit = Card.Suit.SPADE;
            
            deck.add(new Card(val, suit));
        }
        empty = false;
    }

    public boolean isEmpty() {
        return empty;
    }

    //Test for Deck functionality
//    public static void main(String[] args) {
//        Deck deck = new Deck();
//        deck.fillDeck();
//
//        System.out.println("New deck ready!");
//        while(!deck.isEmpty()) {
//            Card card = deck.shuffleDraw();
//            System.out.println("Card: " + card.getFaceValue() + " of " + card.getSuit().getUcVal());
//        }
//        System.out.println("Deck is empty!");
//    }
}
