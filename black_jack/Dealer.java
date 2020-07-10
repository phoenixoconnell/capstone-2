package black_jack;

public class Dealer extends Player {
    private Spread hand;
    private Deck deck = Deck.getInstance();

    public Dealer() {
        this.hand = new Spread();

        hand.addCard(deck.shuffleDraw());
    }

    public void newRound() {
        this.hand = new Spread();

        this.hand.addCard(deck.shuffleDraw());
        this.hand.addCard(deck.shuffleDraw());
    }

    public void hit() {
        hit(this.hand);
    }

    public void hit(Spread spread) {
        spread.addCard(deck.shuffleDraw());
        if(spread.getValue() >= 17) spread.willStand();
    }

    public void stand() {
        stand(this.hand);
    }

    public void stand(Spread spread) {
        spread.willStand();
    }

    public Spread getSpread() {
        return this.hand;
    }
}
