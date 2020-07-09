package black_jack;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Spread {
    ArrayList<Card> spread;
    boolean busted;
    int bet;

    public Spread(int bet) {
        this.spread = new ArrayList<>();
        busted = false;
        this.bet = bet;
    }

    public void addCard(Card card) {
        spread.add(card);
    }

    public int getValue() {
        //Calculate the value of the cards in the spread
        int value = spread.stream().mapToInt(c -> c.getGameValue()).reduce(0, (a, i) -> a + i);
        if(value > 21) {
            //Finds aces whose value is 11 in the spread
            ArrayList<Card> aces =
                    (ArrayList<Card>) spread.stream().filter(c -> c.getGameValue() == 11).collect(Collectors.toList());
            if(aces.size() > 0) {
                aces.get(0).setGameValue(1);
                //Recalculate value
                value = spread.stream().mapToInt(c -> c.getGameValue()).reduce(0, (a, i) -> a + i);
            } else {
                busted = true;
            }
        }
        return value;
    }

    public boolean isBusted() {
        return this.busted;
    }

    public Spread split() {
        Spread temp = new Spread(this.bet);
        temp.addCard(spread.remove(0));
        return temp;
    }

    public void doubleBet() {
        this.bet *= 2;
    }
}
