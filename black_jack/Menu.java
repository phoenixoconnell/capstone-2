package black_jack;

import java.util.Scanner;
import java.util.stream.Collectors;

public class Menu {
    private User user;
    private Dealer dealer = new Dealer();
    private Scanner sc = new Scanner(System.in);
    private boolean inMenu = true;

    public void welcomeMenu() {
        String[] items = {
                "Welcome to Black Jack Simulator!",
                "Please start by entering your name below:"
        };

        String name;
        int bank;

        prompt(items);

        name = getSelection();

        prompt("Please enter the amount of money you'd like to play with:");

        bank = getAmount();
        getSelection();

        this.user = new User(name, bank);

        roundMenu();
    }

    public void roundMenu() {
        String[] items = {
                "Hello, " + user.getName() + "!",
                "Place a bet amount for this hand:"
        };
        String dealerHand;
        String[] playerHand;

        int bet;

        prompt(items);
        bet = getAmount();
        getSelection();

        this.user.newRound(bet);
        this.dealer.newRound();

        dealerHand = this.dealer.getSpread().toString();
        playerHand =
                (String[]) this.user.getSpread().stream().map(s -> s.toString()).collect(Collectors.toList()).toArray();

        prompt(dealerHand);
        prompt("");
        prompt("Your hand");
        prompt(playerHand);
        prompt("What would you like to do?:");
        //needs the rest of the functionality
    }

//    public void roundMenu() {
//        this.user.new
//        String dealerHand = this.dealer.getSpread().toString();
//
//        prompt("Dealer hand: " + dealerHand);
//
//        this.user.getSpread().stream().forEach(s -> prompt());
//    }

    public String getSelection() {
        return sc.nextLine();
    }

    public int getAmount() {
        return sc.nextInt();
    }

    public void prompt(String item) {
        System.out.println(item);
    }

    public void prompt(String[] items) {
        for(String item: items) {
            prompt(item);
        }
    }
}
