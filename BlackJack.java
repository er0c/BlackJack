/*
 * Eric Nguyen
 * 11/18/2022
 * CSE 007
 * Takes methoods from other objects files like hand,deck, and card.
 * Uses thoose methods to deal cards to the user's hand and caluclate the value of thier hand.
 * tThe main will contoniue to prompt the user unitl they hit 21 black jack
 * the deck will be shuffled.
 */

import java.util.Scanner;

public class BlackJack{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String userInput = " ";
        int cards = 0;
        boolean valid = true;
        boolean gameOver = false;
        boolean rematch = false;
        
        Deck deck = new Deck();
        System.out.println("Unshuffled deck of cards: ");//prints out deck 
        deck.display();
        System.out.println("\n\nShuffeled deck of cards: ");//prints out deck 
        deck.shuffle();//shuffles deck 
        deck.display();

        do{
            Hand hand = new Hand(10);
            for(int index = 0; index < 2; index++){
                hand.addCard(deck.dealCard());
                cards++;
                if(cards == 52){//check # of cards left in deck
                    System.out.println("There are no more cards in the deck");
                    System.exit(0);
                }
            }
            do{// automatically make user hit if thier hand is less than 16
                hand.display();
                System.out.println("Your hand value is: " + hand.getValue()); 
                if(hand.getValue() < 16){
                    System.out.println("Hit!");
                    hand.addCard(deck.dealCard());
                    gameOver = false;
                    cards++;
                    if(cards == 52){//check # of cards left in deck
                        System.out.println("There are no more cards in the deck");
                        System.exit(0);
                    }
                } else{// check user hand if they won or bust
                    if(hand.getValue() == 21){
                        System.out.println("Blackjack! Winner!");
                        gameOver = true; 
                    } else if (hand.getValue() > 21){
                        System.out.println("Bust!");
                        gameOver = true;
                    } else {
                        do{
                            System.out.print("Would you like to stay or hit?(s/h)");//prompt user to hit or stand.
                            userInput = input.next();
                            if(userInput.equalsIgnoreCase("h")){
                                hand.addCard(deck.dealCard());
                                cards++;
                                if(cards == 52){
                                    System.out.println("There are no more cards in the deck");
                                    System.exit(0);
                                }
                                valid = true;
                                gameOver = false;
                            } else if (userInput.equalsIgnoreCase("s")){
                                valid = true;
                                if(hand.getValue() == 21){
                                    System.out.println("Blackjack! Winner!");
                                }
                                if(hand.getValue() > 21){
                                    System.out.println("Bust!");
                                }
                                if(hand.getValue() < 21){
                                    System.out.println("Loser (could've hit)");
                                }
                            } else {
                                System.out.println("Please enter valid option");
                                valid = false;
                                input.nextLine();
                            }
                        }while(valid = false);
                    }
                }
            }while(gameOver == false);
            valid = false;
            do{// prompt user for rematch
                System.out.println("Do you want to play again?(y/n)");
                userInput = input.next();
                if(userInput.equalsIgnoreCase("y")){
                    rematch = true;
                    valid = true;
                } else if(userInput.equalsIgnoreCase("n")){
                    System.out.println("Thanks for playing");
                    rematch = false;
                    valid = true;
                } else {
                    System.out.println("Please enter a valid option");
                    valid = false;
                }
            }while(valid == false);
        }while(rematch == true && cards < 52); 
    }
}