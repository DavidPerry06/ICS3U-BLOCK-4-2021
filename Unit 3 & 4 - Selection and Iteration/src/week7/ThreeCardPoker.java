package week7;

import java.util.Scanner;

public class ThreeCardPoker {
    private static final double NUM_SUITS = 4;
    private static final String HEARTS = "H";
    private static final String DIAMONDS = "D";
    private static final String SPADES = "S";
    private static final String CLUBS = "C";
    private static final double NUM_CARDS_PER_SUITS = 13;
    private static final String ACE = "A";
    private static final String JACK = "J";
    private static final String QUEEN = "Q";
    private static final String KING = "K";
    private static final int PLAYER_WINS = 1;
    private static final int DEALER_WINS = 2;
    private static final int TIE = 3;
    private static final int STRAIGHT_FLUSH = 0;
    private static final int FLUSH = 0;
    private static final int STRAIGHT = 0;

    public static void main(String[] args) {
        int wallet = 500;
      Scanner in = new Scanner(System.in);

      boolean playAgain = true;
      while (playAgain) {
         wallet = playPokerHand(in, wallet, 50, 100);
         if (wallet >= 100)
            playAgain = playAgain(in);
         else {
            System.out.println("You don't have enough money to play again!");
            playAgain = false;
         }
      }
        
    }

    private static boolean fold(Scanner in){
        boolean validInput = false;
  
        while (!validInput) {
           System.out.println("Do you want to [F]old or [D]iscard)");
           String answer = in.nextLine().toUpperCase();
           if (answer.equals("FOLD") || answer.equals("F"))
              return true;
           else if (answer.equals("DISCARD") || answer.equals("D")) {
              return false;
           } else {
              System.out.println("Invalid Input: Fold or Discard only!");
           }
        }
  
        return false;
     }


    
    private static int playPokerHand(Scanner in, int wallet, int minBet, int maxBet) {
        int bet = getWager(in, 50, 100, wallet);
  
        String playerHand = "";
        String dealerHand = "";
        playerHand = getCard(playerHand) + " ";
        playerHand += getCard(playerHand) + " ";
        playerHand += getCard(playerHand) + " ";

        dealerHand = getCard(playerHand + dealerHand) + " ";
        dealerHand += getCard(playerHand + dealerHand) + " ";
        dealerHand += getCard(playerHand + dealerHand) + " ";


  
        System.out.println(playerHand);
        System.out.println("XX XX XX");

        if(fold(in)){
            wallet -= bet;
            return wallet;
        }
        return 6;
    }
/**
        bet += getWager(in, minBet, maxBet, wallet);
        playerHand = discard(in, playerHand);
        System.out.println("Player: " + playerHand);
        System.out.println("Dealer: " + playerHand);
        if (getWinner(playerHand, dealerHand) == PLAYER_WINS) {
           wallet += bet;
           System.out.println("Player Wins!!");
        } else if (getWinner(playerHand, dealerHand) == DEALER_WINS) {
           wallet -= bet;
           System.out.println("Dealer Wins!!");
        } else {
           System.out.println("TIE");
        }
        return wallet;
     }
    

     private static int getWinner(String playerHand, String dealerHand) {
        if(getHandValue(playerHand) > getHandValue(dealerHand)){
            return PLAYER_WINS;
        } else if (getHandValue(playerHand) < getHandValue(dealerHand)){
            return DEALER_WINS;
        } else if (getHighCard(playerHand) > getHighCard(dealerHand)){
            return PLAYER_WINS;
        } else if (getHighCard(playerHand) < getHighCard(dealerHand)){
            return DEALER_WINS;
        } else {
            return TIE;
        }
    }

    private static int getHighCard(String playerHand) {
        return 0;
    }

    private static int getHandValue(String playerHand) {
        if (isFlush(cards) && isStraight(cards)){
            return STRAIGHT_FLUSH;
        } else if (isFlush(cards)){
            return FLUSH;
        } else if (isStraight(cards)){
            return STRAIGHT;
        } else if (isThreeOfAKind(cards)){
            return THREE_OF_A_KIND;
        } else if (isPair(cards)){
            return PAIR;
        } else {
            return HIGH_CARD;
        }
    }
  */
    private static boolean playAgain(Scanner in) {
        boolean validInput = false;
  
        while (!validInput) {
           System.out.println("Do you want to play again ([Y]es / [N]o)");
           String answer = in.nextLine().toUpperCase();
           if (answer.equals("YES") || answer.equals("Y"))
              return true;
           else if (answer.equals("NO") || answer.equals("N")) {
              return false;
           } else {
              System.out.println("Invalid Input: Yes or No only!");
           }
        }
  
        return false;
     }

    
    private static String discard(Scanner in, String playerHand) {
        /**
         * prompt the user for how many cards they want to discard (0-3) - validate input
         * if 0 do nothing but return player hand
         * if 3 playerHand = ""; get 3 new cards (THAT HAVE NOT ALREADY BEEN USED)
         * if 1 or 2 -> prompt for which cards and replace them (2) => 3D JC validate their input.
         */

         boolean validInput = false;
         
        
                while (!validInput){
                try {
                    System.out.println("Please enter the number of cards you wish to discard (0 - 3)");
                    int numDiscard = Integer.parseInt(in.nextLine());
                if(numDiscard >= 4){
                    System.out.println("Invalid Input! Please pick a number between 0 and 3 inclusive");
                    } else {
                    if (numDiscard == 0){
                        validInput = true;
                        return playerHand;
                    } else if (numDiscard == 1){
                        System.out.println("Which card do you want to replace");
                        String replace = in.nextLine();
                        replace = replace.toUpperCase();
                        if(playerHand.indexOf(replace)<0){
                            System.out.println("Please enter a card in your hand");
                        } else {
                            playerHand = playerHand.replace(replace, getCard(playerHand));
                            validInput = true;
                            System.out.println("Your new hand is " + playerHand);
                        }             
                    } else if (numDiscard == 2){
                        System.out.println("Which card do you want to replace");
                            String replace = in.nextLine();
                            replace = replace.toUpperCase();
                            String cardOne = replace.substring(0, replace.indexOf(" "));
                            String cardTwo = replace.substring(replace.indexOf(" ") + 1);
                            
                        if (replace.length() >=5 && replace.length() <=7){
                            if(playerHand.indexOf(cardOne)<0 || playerHand.indexOf(cardTwo)<0){
                            System.out.println("Please enter a card in your hand");
                            } else {
                            validInput = true;
                            playerHand = playerHand.replace(cardOne, getCard(playerHand));
                            playerHand = playerHand.replace(cardTwo, getCard(playerHand));
                            System.out.println("Your new hand is " + playerHand);
                            return playerHand;
                            }  
                        }
                    } else if (numDiscard == 3){
                        String newDeck = " ";
                        
                        
                        String newCardOne = getCard(playerHand);
                        String newCardTwo = getCard(playerHand);
                        String newCardThree = getCard(playerHand);
                        
                        if (newCardOne.equals(newCardTwo)){
                            boolean same = true;
                            while(same){
                            if(newCardOne.equals(newCardTwo)){
                                newCardTwo = getCard(playerHand);
                            } else {
                                same = false;
                            }
                        }
                        }  
                        if (newCardTwo.equals(newCardThree)){
                            boolean same = true;
                            while(same){
                                if(newCardTwo.equals(newCardThree)){
                                    newCardThree = getCard(playerHand);
                                } else {
                                    same = false;
                                }
                            }
                        }
                        if (newCardOne.equals(newCardThree)){
                            boolean same = true;
                            while(same){
                            if(newCardOne.equals(newCardThree)){
                                newCardThree = getCard(playerHand);
                            } else {
                                same = false;
                            }
                        }
                    }
                    newDeck = newCardOne + newCardTwo + newCardThree;
                    playerHand = newDeck;
                    return playerHand;
                    }
                    }
            
                }catch(Exception ex){
                System.out.println("Invalid Input");
                }
                }
            
    
                
            
            return null;
    }

    

    private static String getCard(String usedCards) {
        String card = getFace() + getSuit();

        while (usedCards.indexOf(card)>=0){
            card = getFace() + getSuit();
        }
        return card;
    }

    private static String getSuit() {
        int suit = (int)(Math.random() * NUM_SUITS);

        if (suit == 0){
            return HEARTS;
        } else if (suit == 1){
            return DIAMONDS;
        } else if (suit == 2){
            return SPADES;
        } else {
            return CLUBS;
        }
    }

    private static String getFace() {
        int face = (int)(Math.random() * NUM_CARDS_PER_SUITS) + 1;
        if (face >= 2 && face <= 10){
            return "" + face;
        } else if (face == 1){
            return ACE;
        } else if (face == 11){
            return JACK;
        } else if (face == 12){
            return QUEEN;
        } else{
            return KING;
        }
    }

    private static int getWager(Scanner in, int minBet, int maxBet, int wallet) {
        boolean validInput = false;
        int bet = 0;

        while(validInput){
            System.out.print("Please enter a bet between [$" + minBet + " - $" + maxBet + "]: ");
            try {
            bet = Integer.parseInt(in.nextLine());

            if(bet > wallet){
                System.out.println("You only have $" + wallet);
            } else if (bet > maxBet || bet < minBet){
                System.out.println("Your bet must be between [$" + minBet + " - $" + maxBet + "]: ");
            } else {
                validInput = true;
            }
            }catch(Exception ex){
                System.out.println("Invalid Input");
            }
        }
        
        return bet;
    }
}
