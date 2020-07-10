package black_jack;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Spread {
    private ArrayList<Card> spread;
    private boolean busted;
    private int bet;
    private boolean stand;

    public Spread(int bet) {
        this.spread = new ArrayList<>();
        this.busted = false;
        this.bet = bet;
        this.stand = false;
    }

    public ArrayList<Card> getSpread() {
        return this.spread;
    }

    public void addCard(Card card) {
        if(!this.stand) spread.add(card);
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

    public int getBet() {
        return this.bet;
    }

    public void willStand() {
        this.stand = true;
    }

    public boolean isStanding() {
        return this.stand;
    }
}
