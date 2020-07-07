package black_jack;

import static java.lang.Integer.parseInt;

public class Card {
    private String faceValue;
    private String suit;
    private int gameValue;

    public Card(String faceValue, String suit) {
        this.faceValue = faceValue;
        this.suit = suit;

        try {
            this.gameValue = parseInt(faceValue);
        } catch(Throwable e) {
            System.out.println("Face card detected");
            this.gameValue = faceValue.equals("A") ? 11 : 10;
        }

    }

    public String getFaceValue() {
        return faceValue;
    }

    public String getSuit() {
        return suit;
    }

    public int getGameValue() {
        return gameValue;
    }

    public void setGameValue(int gameValue) {
        if(!this.faceValue.equals("A")) {
            System.out.println("Only aces can change value");
            return;
        }
        if(gameValue != 1 || gameValue != 11) {
            System.out.println("Aces can only be 1 or 11");
            return;
        }
        this.gameValue = gameValue;
    }
}
