package black_jack;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Menu {
    private User user;
    private Dealer dealer = new Dealer();
    private Scanner sc = new Scanner(System.in);
    private boolean inRound = true;
    private boolean inAction = true;

    public void welcomeMenu() {
        String[] items = {
                "Welcome to Black Jack Simulator!",
                "Please start by entering your name below:"
        };

        String name;
        int bank;

        prompt(items);

        name = sc.nextLine();

        prompt("Please enter the amount of money you'd like to play with:");

        bank = getAmount();
        getSelection();

        this.user = new User(name, bank);

        while(inRound) {
            roundMenu();
        }
    }

    public void roundMenu() {
        String[] items = {
                "Hello, " + user.getName() + "!",
                "Current bank amount: $" + this.user.getBank(),
                //displays the negative winnings surrounded with parenthesis
                "Current winnings: $" + (this.user.getWinnings() < 0 ? "(" + -this.user.getWinnings() + ")" :
                        this.user.getWinnings()),
                "Place a bet amount for this hand:"
        };

        int bet;

        prompt(items);
        bet = getAmount();
        getSelection();

        this.user.newRound(bet);
        this.dealer.newRound();

        //checks for black jack on the user
        if(this.user.getSpread(0).isBlackJack()) {
            System.out.println("You got BlackJack!");
            user.blackJack(this.user.getSpread(0));
            return;
        }

        //checks for black jack on the dealer
        if(this.dealer.getSpread().isBlackJack()) {
            System.out.println("Dealer got BlackJack!");
            user.lose(user.getSpread(0));
            return;
        }

        //if no black jacks, proceed with the hand
        actionMenu();

        //after hand, if there's no money in the user bank
        //ask if the user wants to buy back in or leave
        if(user.getBank() <= 0) buyBack();

    }

    public void actionMenu() {
        String[] items = {
                "What would you like to do?",
                "[H]it",
                "[S]tay"
        };

        String selection;

        //manual loop through each spread to determine action in each
        //manual for loop used in case new spread is added during action
        //on an existing spread
        for(int i = 0; i < this.user.getSpread().size(); i++) {
            Spread s = this.user.getSpread().get(i);
            //continue action on a spread if it's not busted, or if the user
            //hasn't decided to stand on it
            while(!s.isStanding() && !s.isBusted()) {
                prompt("Dealer hand: " + this.dealer.getSpread().toString());
                prompt("Current action: " + s.toString());
                prompt(items);
                //only display double and split if it's the begging of the action for the spread
                if(s.getSpread().size() == 2) {
                    prompt("[D]ouble");
                    //only display split if both cards have the same face value
                    if(s.getSpread().get(0).getFaceValue().equals(s.getSpread().get(1).getFaceValue()))
                        prompt("[Sp]lit");
                }
                prompt("[Q]uit");

                selection = getSelection();

                switch(selection) {
                    case "h":
                    case "hit":
                        user.hit(s);
                        break;
                    case "sp":
                    case "split":
                        //if the user somehow typed for a split without it being listed as an option
                        //do nothing and let them know the selection was invalid
                        //makes sure there are two cards and they match
                        if(s.getSpread().size() != 2 || !s.getSpread().get(0).getFaceValue().equals(s.getSpread().get(1).getFaceValue())) {
                            System.out.println("Invalid selection!");
                            break;
                        }
                        user.split(s);
                        break;
                    case "d":
                    case "double":
                        //same as for split
                        if(s.getSpread().size() != 2) {
                            System.out.println("Invalid selection!");
                            break;
                        }
                        user.doubleBet(s);
                        break;
                    case "s":
                    case "stand":
                        user.stand(s);
                        break;
                    case "q":
                    case "quit":
                        this.inRound = false;
                        return;
                    default:
                        System.out.println("Invalid selection!");
                        break;
                }

                if(s.isBusted()) {
                    System.out.println("Busted!");
                    this.user.lose(s);
                }
            }
        }

        //dealer continues to hit until they get to 17 or higher
        while(this.dealer.getSpread().getValue() < 17) {
            this.dealer.hit();
            //checks if the dealer busted, user wins if true
            if(this.dealer.getSpread().isBusted()) {
                System.out.println("Dealer busted!");
                for(Spread s: this.user.getSpread()) {
                    if(!s.isBusted()) {
                        this.user.win(s);
                        System.out.println("You win!");
                    }
                }
                return;
            }
        }

        //step through spreads in the user's hand and compares it to dealer's hand
        //if one spread beats the dealer or ties, it wins
        //if one doesn't, it looses
        for(Spread s: this.user.getSpread()) {
            prompt("Dealer hand: " + this.dealer.getSpread().toString());
            prompt("Current action: " + s.toString());
            if(s.getValue() >= this.dealer.getSpread().getValue() && !s.isBusted() ) {
                System.out.println("You win!");
                user.win(s);
                return;
            } else {
                System.out.println("You lose!");
                user.lose(s);
                return;
            }
        }

        System.out.println("New round should start");
    }

    public void buyBack() {
        String[] items = {
                "We noticed you're out of cash!",
                "Please enter an amount to buy back in",
                "Or type [Q]uit to leave"
        };

        String selection;

        prompt(items);

        selection = getSelection();

        //if/else used here instead of switch because there are only two conditions to worry about
        //but one condition is an integer input, and a switch wouldn't be good for that
        if(selection.equals("quit") || selection.equals("q")) {
            this.inAction = false;
            this.inRound = false;
            return;
        } else {
            this.user.setBank(getAmount(selection));
        }
    }

    public String getSelection() {
        return sc.nextLine().toLowerCase();
    }

    //runs a loop to get a valid integer input from the user
    public int getAmount() {
        int amount = 0;

        while(true)
        try {
            amount = sc.nextInt();
            break;
        } catch(Throwable e) {
            System.out.println("That's not a number!");
            System.out.println("Please enter a valid number:");
            sc.nextLine();
        }

        return amount;
    }

    //if passed in string can't parse to int, calls no-param getAmount
    //to run input loop to get valid amount
    public int getAmount(String str) {
        int amount = 0;

        try {
            amount = parseInt(str);
        } catch(Throwable e) {
            System.out.println("That's not a number!");
            System.out.println("Please enter a valid number:");
            amount = getAmount();
        }

        return amount;
    }

    public void prompt(String item) {
        System.out.println(item);
    }

    public void prompt(String[] items) {
        for(String item: items) {
            prompt(item);
        }
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.welcomeMenu();
    }
}
