package black_jack;

import java.util.ArrayList;

public class User extends Player {
    private String name;
    private int bank;
    private ArrayList<Spread> hand;
    private boolean broke;
    //Tracks overall winnings (negative and positive)
    private int winnings;
    //Singleton Deck instance so User and Dealer draw from the same pool of cards
    private Deck deck = Deck.getInstance();

    public User(String name, int bank) {
        this.name = name;
        this.bank = bank;
        this.hand = new ArrayList<>();
        this.broke = false;
        this.winnings = 0;
    }

    //same as newRound below, but with a default minimum bet amount
    public void newRound() {
        newRound(50);
    }

    //clears a user's hand of existing spreads and deals two cards into a new spread
    //with a bet amount set by the user
    public void newRound(int bet) {
        if(this.hand.size() > 0) this.hand.clear();

        Spread newSpread = new Spread(bet);
        setBank(-bet);

        newSpread.addCard(deck.shuffleDraw());
        newSpread.addCard(deck.shuffleDraw());

        this.hand.add(newSpread);
    }

    public String getName() {
        return this.name;
    }

    public int getBank() {
        return this.bank;
    }

    //For betting and buying back in
    public void setBank(int amount) {
        this.bank += amount;
    }

    public int getWinnings() {
        return this.winnings;
    }

    //Add pot for single spread to bank and winnings
    public void win(Spread spread) {
        this.winnings += spread.getBet();
        this.bank += spread.getBet() * 2;
    }

    public void blackJack(Spread spread) {
        this.winnings += (int) spread.getBet() * 1.5;
        this.bank += (int) spread.getBet() + spread.getBet() * 1.5;
    }

    //Subtract pot for single spread from bank and winnings
    public void lose(Spread spread) {
//        System.out.println(spread.getBet());
        this.winnings -= spread.getBet();
        if(this.bank <= 0) {
            this.broke = true;
        }
    }

    public void hit(Spread spread) {
        if(!spread.isStanding()) spread.addCard(deck.shuffleDraw());
        if(spread.getValue() > 21) spread.didBust();
    }

    public void stand(Spread spread) {
        spread.willStand();
    }

    public void split(Spread spread) {
        ArrayList<Card> tempSpread = spread.getSpread();
        //Checks the bank (can't split if you're broke), card count of the spread (you can only split as the first
        // action of a spread, and ensures both cards have the same face value (ie, '2' and '2' or 'Q' and 'Q')
        if(this.bank > 0 && tempSpread.size() == 2 && tempSpread.get(0).getFaceValue().equals(tempSpread.get(1).getFaceValue())) {
            //If all are true, it splits the spread into two new spreads, and hits for both so both have two cards
            Spread newSpread = spread.split();
            hit(spread);
            hit(newSpread);
            hand.add(newSpread);
        } else if(this.bank <= 0) {
            System.out.println("Not enough money!");
        }

    }

    public void doubleBet(Spread spread) {
        //Checks to see if there is enough money in the bank to double the bet
        //Then calls hit to get the final card and stand, so no more can be drawn for the spread
        if(this.bank <= 0) {
            System.out.println("Not enough money!");
            return;
        }
        this.bank -= spread.getBet();
        spread.doubleBet();
        hit(spread);
        spread.willStand();
    }

    public Spread getSpread(int index) {
        return this.hand.get(index);
    }

    public ArrayList<Spread> getSpread() {
        return this.hand;
    }
}
