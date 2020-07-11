package black_jack;

import static java.lang.Integer.parseInt;

public class Card {
    //Allows for only four choices for suit in Card,
    //and gives a human readable translation for Unicode face suit strings
    protected enum Suit {
        HEART("\u2661"), DIAMOND("\u2662"), SPADE("\u2664"), CLUB("\u2667");

        String ucVal;

        Suit(String ucVal) {
            this.ucVal = ucVal;
        }

        public String getUcVal() {
            return this.ucVal;
        }
    }
    private String faceValue;
    private Suit suit;
    private int gameValue;

    public Card(String faceValue, Suit suit) {
        this.faceValue = faceValue;
        this.suit = suit;

        //If an int cannot be parsed from a face value,
        //the card is a "Face card" and has a game value
        //of 10 ("J", "Q", "K") or 11 ("A")
        try {
            this.gameValue = parseInt(faceValue);
        } catch(Throwable e) {
            this.gameValue = faceValue.equals("A") ? 11 : 10;
        }

    }

    public String getFaceValue() {
        return faceValue;
    }

    public Suit getSuit() {
        return suit;
    }

    public int getGameValue() {
        return gameValue;
    }

    public void setGameValue(int gameValue) {
        //We only want Aces to be able to change value
        //and we only want Aces to be a 1 or 11
        if(!this.faceValue.equals("A")) {
            System.out.println("Only aces can change value");
            return;
        }
        if(gameValue != 1 && gameValue != 11) {
            System.out.println("Aces can only be 1 or 11");
            return;
        }
        this.gameValue = gameValue;
    }
}
