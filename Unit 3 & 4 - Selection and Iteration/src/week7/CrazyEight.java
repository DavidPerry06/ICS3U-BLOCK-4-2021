package week7;


import java.util.Scanner;


public class CrazyEight {
   private static final int NUM_SUITS = 4;
   private static final String HEARTS = "H";
   private static final String DIAMONDS = "D";
   private static final String CLUBS = "C";
   private static final String SPADES = "S";
   private static final int CARDS_PER_SUIT = 13;
   private static final String ACE = "A";
   private static final String JACK = "J";
   private static final String QUEEN = "Q";
   private static final String KING = "K";
   private static final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
   private static final String VALUES = "2345678910A-JQK";
   
   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
   
      int playerPoints = 0, c1Points = 0, c2Points = 0;

      while(!gameOver(playerPoints, c1Points, c2Points)){
         String result = playRound(in, playerPoints, c1Points, c2Points);
         int firstDash = result.indexOf("-");
         int secondDash = result.indexOf("-", firstDash + 1);
         playerPoints += Integer.parseInt(result.substring(0, firstDash));
         c1Points += Integer.parseInt(result.substring(firstDash + 1, secondDash));
         c2Points += Integer.parseInt(result.substring(secondDash + 1));
      }
      System.out.println("The final score is: " + playerPoints + " - " + c1Points + " - " + c2Points);
      String winner = findWinner(playerPoints, c1Points, c2Points);
      System.out.println("The result of this game is: " + winner);
   
        
   }
   /**
    * This method finds the minimun between the three parameters: playerPoints, c1Points and c2Points. 
    * depending on which one is the smallest, a different message is returned.
    * Parameter int playerPoints is the amount of points that the player has 
    * Parameter int c1Points is the amount of points that computer one has
    * Parameter int c2Points is the amount of points that computer 2 has
    * It then returns the winner to the main method to print out
    */
    private static String findWinner(int playerPoints, int c1Points, int c2Points){
       int minimum = Math.min(Math.min(playerPoints, c1Points), c2Points);
       if(minimum == playerPoints){
          return "PLAYER WINS!";
       } else if (minimum == c1Points){
          return "COMPUTER ONE WINS!";
       } else if (minimum == c2Points){
          return "COMPUTER TWO WINS!";
       } else {
          return "TIE!";
       }
       }

       /**
        * this method repeats the processors that play the cards and asks for inputs from the user
        * it also initializes the decks and prints what is going on during the round and the score after the round ends
        * it returns the points/scoreboard to the main method to be sent to findWinner 
        */
    private static String playRound(Scanner in, int playerPoints, int c1Points, int c2Points) {
        String playerHand = dealCards();
        String c1Hand = dealCards();
        String c2Hand = dealCards();

        String topCard = drawTopCard();
        

         while(playerHand.length() >1 && c1Hand.length() > 1 && c2Hand.length() > 1){
            
            
            System.out.println("Your hand is: " + playerHand);
            System.out.println("The top card is: " + topCard);
            System.out.println("\n-----------------------------------------------------------\n");

            String temp = processPlayer(playerHand, topCard, in);
            playerHand = temp.substring(0,temp.indexOf("-"));
            topCard = temp.substring(temp.indexOf("-") + 1);
            playerHand = playerHand.trim();

            if(playerHand.length()<=1){
               break;
            }
            
            String c1Temp = processComputer(c1Hand, topCard, playerHand, c2Hand);
            c1Hand = c1Temp.substring(0, c1Temp.indexOf("-"));
            c1Hand = c1Hand.trim();
            String c1VisibleHand = getComputerHand(c1Hand);
            c1VisibleHand = c1VisibleHand.trim();
            topCard = c1Temp.substring(c1Temp.indexOf("-") + 1);
            
            
           if(c1Hand.length()<=1){
               break;
            }


            System.out.println("\n-----------------------------------------------------------\n");
            System.out.println("ComputerOne has played, Their deck is now: [ " + c1VisibleHand +" ]");
            System.out.println("The top card is now [ " + topCard +" ]");
            System.out.println("\n-----------------------------------------------------------\n");

            String c2Temp = processComputer(c2Hand, topCard, playerHand, c1Hand);
            c2Hand = c2Temp.substring(0, c2Temp.indexOf("-"));
            c2Hand = c2Hand.trim();
            String c2VisibleHand = getComputerHand(c2Hand);
            c2VisibleHand = c2VisibleHand.trim();
            topCard = c2Temp.substring(c2Temp.indexOf("-") + 1);
            
            
            
            

            System.out.println("ComputerTwo has Played, Their deck is now [ " + c2VisibleHand+" ]");
            System.out.println("The top card is now [ " + topCard +" ]");
            System.out.println("\n-----------------------------------------------------------\n");
            
         }
        
         if(playerHand.length()==0){
            System.out.println("PLAYER WINS THIS ROUND");
            
         } else if (c1Hand.length() == 0){
            System.out.println("COMPUTER ONE WINS THIS ROUND");
         } else {
            System.out.println("COMPUTER TWO WINS THIS ROUND");
         }

            String score = getHandValue(playerHand, playerPoints) + "-" + getHandValue(c1Hand, c1Points) + "-" + getHandValue(c2Hand, c2Points);
            int firstDash = score.indexOf("-");
            int secondDash = score.indexOf("-", firstDash + 1);
            playerPoints += Integer.parseInt(score.substring(0, firstDash));
            c1Points += Integer.parseInt(score.substring(firstDash + 1, secondDash));
            c2Points += Integer.parseInt(score.substring(secondDash + 1));
            System.out.println("Current score:");
            System.out.println(playerPoints + " - " + c1Points + " - " + c2Points);
            System.out.println("\n-----------------------------------------------------------\n");
            return score;

         

    }
    
    /**
     * This method uses the logic in the rules for how the computer places to place a card, discard it from their deck or draw a new card
     * @param cHand1 is a String that is used to hold the main computers hand
     * @param topCard is a String to hold the top Card of the stack, so that the computer knows what it can play
     * @param playerHand is a String to hold the opponent "player's" hand
     * @param cHand2 is a String to hold the opponent computer's hand
     * @return: this method returns the main hand(cHand1) and the topcard in one string to the playRound method 
     */
    private static String processComputer(String cHand1, String topCard, String playerHand, String cHand2) {
      int faceIndex = cHand1.indexOf(topCard.substring(0,topCard.length()-1));
      int suitIndex = cHand1.indexOf(topCard.substring(topCard.length()-1));
      if (playerHand.length()<=3 || cHand2.length()<=3){
         if(faceIndex >=0){
            topCard = cHand1.substring(faceIndex, cHand1.indexOf(" ", faceIndex));
            cHand1 = cHand1.replace(topCard, "");
            cHand1 = cHand1.replace("  ", " ");
         } else if (cHand1.indexOf("8")>=0){
           String temp = getEightSuit(topCard);
            topCard = "8" + temp;
            cHand1 = cHand1.replaceFirst(cHand1.substring(cHand1.indexOf("8"), cHand1.indexOf("8") + 2), "");
            cHand1 = cHand1.replace("  ", " ");
         } else if (suitIndex >=0){
            if (cHand1.substring(suitIndex - 1, suitIndex).equals("0")){
               topCard = cHand1.substring(suitIndex - 2, suitIndex + 1);
               cHand1 = cHand1.replace(topCard, "");
               cHand1 = cHand1.replace("  ", " ");
               } else {
               topCard = cHand1.substring(suitIndex - 1, suitIndex + 1);
               cHand1 = cHand1.replace(topCard, "");
               cHand1 = cHand1.replace("  ", " ");
               }
         } else {
            cHand1 = drawComputerCard(cHand1, topCard);
         }
      } else if (suitIndex >=0 && !(cHand1.substring(suitIndex - 1, suitIndex).equals("8"))){
         if (cHand1.substring(suitIndex - 1, suitIndex).equals("0")){
         topCard = cHand1.substring(suitIndex - 2, suitIndex + 1);
         cHand1 = cHand1.replace(topCard, "");
         cHand1 = cHand1.replace("  ", " ");
         } else {
         topCard = cHand1.substring(suitIndex - 1, suitIndex + 1);
         cHand1 = cHand1.replace(topCard, "");
         cHand1 = cHand1.replace("  ", " ");
         }
      } else if(faceIndex >=0){
         try{
         topCard = cHand1.substring(faceIndex, cHand1.indexOf(" ", faceIndex));
         } catch (Exception ex){
            topCard = cHand1.substring(faceIndex);
         }
         cHand1 = cHand1.replace(topCard, "");
         cHand1 = cHand1.replace("  ", " ");
      } else if (cHand1.indexOf("8")>=0){
         String temp = matchEightSuit(topCard, cHand1);
         topCard = "8" + temp;
         cHand1 = cHand1.replaceFirst(cHand1.substring(cHand1.indexOf("8"), cHand1.indexOf("8") + 2), "");
         cHand1 = cHand1.replace("  ", " ");
      } else {
         cHand1 = drawComputerCard(cHand1, topCard);
      }
      cHand1.trim();
      
      return cHand1 + "-" + topCard;    
      

    }
   
    /**
     * this method finds how many XX's need to be displayed to the player to show how many cards the computers have
     * @param cHand is a String that holds any computers' cards 
     * @return: it returns to the playRound method to be printed out
     */
    private static String getComputerHand(String cHand){
       String temp = "";
       String visibleHand = "";
       for (int i = 0; i < cHand.length(); i++){
          temp = cHand.substring(i, i + 1);
          if (temp.equals(" ")){
            visibleHand += " XX";
          } 
       }
       visibleHand += " XX";
       return visibleHand;
    }
    /**
     * This method randomly picks a suit for the computer to play when they place down an eight when an opponent has one card left, that isnt the suit the topCard is.
     * @param topCard is a String to hold the top card on the stack
     * @return: this method returns temp which holds the selected suit
     */
    private static String getEightSuit(String topCard){
      String temp = "";
      int num = (int)Math.random()*3;
      if (topCard.substring(topCard.length()-1).equals("H")){
         if (num == 0){
            temp = "S";
         } else if (num == 1){
            temp = "D";
         } else {
            temp = "C";
         }
      } else if (topCard.substring(topCard.length()-1).equals("S")){
         if (num == 0){
            temp = "H";
         } else if (num == 1){
            temp = "D";
         } else {
            temp = "C";
         }
      } else if (topCard.substring(topCard.length()-1).equals("D")){
         if (num == 0){
            temp = "S";
         } else if (num == 1){
            temp = "H";
         } else {
            temp = "C";
         }
      } else {
         if (num == 0){
            temp = "S";
         } else if (num == 1){
            temp = "D";
         } else {
            temp = "H";
         }
      }
      return temp;
    }
    /**
     * this method makes the computer select a suit that is in their hand when they play an Eight
     * @param topCard is a String to hold the top card on the stack
     * @param cHand is a String that holds a computer's hand
     * @return it returns temp which contains the selected suit
     */
    private static String matchEightSuit(String topCard, String cHand){
      String temp = "";
      
      if (cHand.indexOf("H")>=0){
         temp = "H";
      } else if (cHand.indexOf("S")>=0){
         temp = "S";
      } else if (cHand.indexOf("D")>=0){
         temp = "D";
      } else if (cHand.indexOf("C")>=0){
         temp = "C";
      }

      
      return temp;
    }
    /**
     * this method makes sure that the card placed down by the player has a valid suit
     * @param placedCard is a String that contains the card placed down by the player
     * @return returns true or false depending on whether or not the suit is valid
     */
    private static boolean ValidSuit (String placedCard){
      return (placedCard.substring(placedCard.length() - 1).equals("D") || placedCard.substring(placedCard.length() - 1).equals("C") || placedCard.substring(placedCard.length() - 1).equals("H") || placedCard.substring(placedCard.length() - 1).equals("S"));
   }

   /**
    * this method asks for inputs from the user to place a card that is in their deck, it also tells them to draw when they dont have a valid card available
    * @param playerHand is a String that holds the "player's" hand
    * @param topCard is a String that holds the card on the top of the stack
    * @param in is the scanner that reads what the player inputs
    * @return returns the player's hand after placing a card as well as the new top card
    */
    private static String processPlayer(String playerHand, String topCard, Scanner in) {
      boolean validInput = false;
      
   
      while(!validInput){
         try{
         if(canPlay(playerHand, topCard)){
            System.out.println("Which card do you want to play?");
            String response = in.nextLine();
            System.out.println("\n-----------------------------------------------------------\n");
            String placedCard = response.toUpperCase();
            if(checkIfEight(placedCard)){
               if (placedCard.length() == 1){
               String suitOfEight = EightSuit(topCard, in);
               System.out.println("\n-----------------------------------------------------------\n");
               topCard = suitOfEight;
               String card = playerHand.substring(playerHand.indexOf(placedCard), playerHand.indexOf(placedCard) + 2);
               validInput = true;
               playerHand = removeCard(playerHand, card);
               } else if (placedCard.length() == 2){
               String suitOfEight = EightSuit(topCard, in);
               topCard = suitOfEight;
               validInput = true;
               playerHand = removeCard(playerHand, placedCard);
               }
            } else if((checkSuit(topCard, placedCard) || checkFace(topCard, placedCard)) && ValidSuit(placedCard) && placedCard.length() != 1){
               topCard = placedCard;
               validInput = true;
               playerHand = removeCard(playerHand, placedCard);
            } else {
               System.out.println("Please enter a valid card");
            }
         } else if (playerHand.indexOf(topCard) < 0){
            System.out.println("You need to draw a card, press the enter key to continue");
            String response = in.nextLine();
            String answer = response.toUpperCase();
            if (LETTERS.indexOf(answer) >= 0){
            String drawnCard = drawCard(playerHand, topCard);
            System.out.println("\n-----------------------------------------------------------\n");
            playerHand = " " + drawnCard;
            validInput = true;
            } else {
               System.out.println("Invalid input, please enter a letter key");
            }
         } else if (playerHand.length() == 0){
            validInput = true;
         }
         
      }catch(Exception ex){
        System.out.println("Invalid input");
      }
      }

      

      return playerHand + "-" + topCard;
      
    }

    /**
     * this method calculates the amount of points in a hand
     * @param hand is a String that holds the cards of the hand that was sent to this method
     * @param currentValue is a int that holds the previous points so that they get added and not reset
     * @return returns the amount of points in a String format
     */
    private static String getHandValue(String hand, int currentValue){
      int handValue = 0;
      
      if (hand.equals("")) {
         return Integer.toString(currentValue);
      }

      for (int i = 0; i < hand.length(); i++){
         String temp = hand.substring(i, i + 1);
         if (VALUES.indexOf(temp) >=0){
            if((VALUES.substring(VALUES.indexOf("-"))).indexOf(temp) >=0 || temp.equals("1")){
               handValue += 10;
            } else if (temp.equals("A")){
               handValue += 1;
            } else if (temp.equals("8")){
               handValue += 50;
            } else {
               handValue += Integer.parseInt(temp);
            }
            
         }
      }
      String stringValue = Integer.toString(handValue);
      return stringValue;
    }
    /**
     * this method recieves and input from the player which is what suit they want their eight to be when placed down
     * @param topCard is a String that holds the card on the top of the stack
     * @param in is a Scanner to read what the player inputs
     * @return: this method returns the new top card after the eight is placed down with its new suit
     */
    private static String EightSuit(String topCard, Scanner in){

      
      boolean validInput = false;
      try{
      while(!validInput){
         System.out.println("Which suit would you like to play ([H]earts, [S]pades, [D]iamonds, [C]lubs): ");
         String chooseSuit = in.nextLine().toUpperCase();
      if (chooseSuit.indexOf("H") == 0){
         topCard = "8H";
         validInput = true;
      } else if (chooseSuit.indexOf("S") == 0){
         topCard = "8S";
         validInput = true;
      } else if (chooseSuit.indexOf("D") == 0){
         topCard = "8D";
         validInput = true;
      } else if (chooseSuit.indexOf("C") == 0){
         topCard = "8C";
         validInput = true;
      } else {
         System.out.println("Invalid Input");
      }
     }
     return topCard;
    
   }catch(Exception ex){
      System.out.println("Invalid Input");
   }
   return topCard;
   }
   /**
    * this method finds when a player or computer's points reach 100, ending the game
    * @param playerPoints is a int that holds the amount of points the player has
    * @param c1Points is a int that holds the amount of points computer 1 has
    * @param c2Points is a int that holds the amount of points computer 2 has
    * @return true onces a persons points reach 100
    */
    private static boolean gameOver(int playerPoints, int c1Points, int c2Points) {
        return playerPoints >= 100 || c1Points >= 100 || c2Points >= 100;
    }

    /**
     * This method checks to see whether or not the inputed hand can play
     * @param hand is a String to store the hand sent to this method
     * @param topCard is a String to store the top card of the stack
     * @return true or false depending on whether or not the hand can play
     */
    private static boolean canPlay(String hand, String topCard){
      if(checkIfEight(hand) || hand.indexOf(topCard.substring(topCard.length() - 1)) >=0 || hand.indexOf(topCard.substring(0, topCard.length() - 1))>=0){
         return true;
      } else {
         return false;
      }
    }


 
   /**
    * This method crafts a card
    * @return: returns the card
    */
   private static String getCard() {
    String card = getFace() + getSuit();

    return card;
 }
   /**
    * This method gets a random suit and returns it
    */
 private static String getSuit() {
    int suit = (int) (Math.random() * NUM_SUITS);

    if (suit == 0)
       return HEARTS;
    else if (suit == 1)
       return DIAMONDS;
    else if (suit == 2)
       return CLUBS;
    else
       return SPADES;

 }
 /**
  * this method gets a random face value
  * @return: it returns the face value
  */
 private static String getFace() {
    int suit = (int) (Math.random() * CARDS_PER_SUIT);
    if (suit >= 2 && suit <= 10)
       return suit + "";
    else if (suit == 1)
       return ACE;
    else if (suit == 11)
       return JACK;
    else if (suit == 12)
       return QUEEN;
    else
       return KING;

 }
   /**
   * this method deals the inital cards at the start of a round
   * @return: it returns the cards generated
   */
   private static String dealCards(){
      String cards = "";
      for(int i = 0; i < 5; i++){
         cards += getCard() + " ";
         
      }
      return cards.trim();

   } 
   /**
    * this checks to see if the suit of the placed card matches the suit of the top Card
    * @param topCard is a String that holds the top Card of the stack
    * @param placedCard is a String that holds the card that the user has palced
    * @return: it then returns true or false depending on whether or not it is valid
    */
   private static boolean checkSuit(String topCard, String placedCard){
      if(placedCard.substring(placedCard.length() - 1).equals(topCard.substring(topCard.length() - 1))){
         return true;
      } else {
         return false;
      }
   }
   /**
    * this checks to see if the face value of the placed card matches the face value of the top Card
    * @param topCard is a String that holds the top Card of the stack
    * @param placedCard is a String that holds the card that the user has palced
    * @return: it then returns true or false depending on whether or not it is valid
    */
   private static boolean checkFace(String topCard, String placedCard){
      if(placedCard.substring(0,placedCard.length()-1).equals(topCard.substring(0, topCard.length() - 1))){
         return true;
      } else {
         return false;
      }
   }
   /**
    * removes the placed card from the hand that is sent to the method
    * @param hand is a String to hold the hand sent to the method
    * @param placedCard is a String to hold the card that was placed down
    * @return: this method returns the hand after removing the card from it and getting rid of extra spaces
    */
   private static String removeCard (String hand, String placedCard){
      String temp = hand.substring(hand.indexOf(placedCard), hand.indexOf(placedCard) + placedCard.length());
      hand = hand.replaceFirst(temp, "");
      hand = hand.replace("  ", " ");
      return hand.trim();
      
   }
   
   /**
    * Draws until the player gets a playable card or 5 cards have been drwan
    * @param hand is a String to hold the hand sent to the method
    * @param topCard is a String that holds the top Card of the stack
    * @return: this method returns the hand after the drawn cards have been added to it
    */
   private static String drawCard(String hand, String topCard){

      boolean validCard = false;
      int cardsDrawn = 0;
      
      while(!validCard && cardsDrawn <5){
         String cardDrawn = getCard();
         
         if((checkSuit(topCard, cardDrawn) || checkFace(topCard, cardDrawn) || checkIfEight(cardDrawn))){
            validCard = true;
            hand += " " + cardDrawn;
         } else {
            hand += " " + cardDrawn;
            cardsDrawn++;
         }
         System.out.println("You drew a " + cardDrawn);
      }
      return hand;
      
      
   }
   /**
    * this method draws a card for the top card that cannot be eight
    * @return: it then returns the top Card
    */
   private static String drawTopCard(){
   String face = getFace();
   String suit = getSuit();

   while(face.equals("8")){
      face = getFace();
      if(face.equals("8")){
      int num = (int)Math.random()*2 + 1;
      int num2 = (int)Math.random()*2 + 1;
      if (num == 1){
         if(num2 == 1){
            face = "9";
         } else {
            face = "10";
         }
      } else if (num == 2){
         if(num2 == 1){
            face = "7";
         } else {
            face = "6";
         }
      }

      
      }
   }
   String card = face + suit;
   return card;
}

   /**
    * this method draws cards for the computer until a playable one has been drawn, or until 5 cards have been drawn
    * @param cHand is a String to hold the hand sent to the method
    * @param topCard is a String that holds the top Card of the stack
    * @return: this method returns cHand after the drawn cards have been added to
    */
   private static String drawComputerCard(String cHand, String topCard){
      boolean validCard = false;
      int cardsDrawn = 0;
      
      
      while(!validCard && cardsDrawn <5){
         String cardDrawn = getCard();
         
         if((checkSuit(topCard, cardDrawn) || checkFace(topCard, cardDrawn) || checkIfEight(cardDrawn))){
            validCard = true;
            cHand += " " + cardDrawn;
         } else {
            cHand += " " + cardDrawn;
            cardsDrawn++;
         }
         
      }
      cHand.trim();
      System.out.println("The Computer had to draw cards");
      return cHand;
      
      
}

   /**
    * This method checks if the card drawn is an eight
    * @param cardDrawn is a String that holds the card that was drawn
    * @return: this method returns true or false based on whether or not the card is an 8
    */
   private static boolean checkIfEight(String cardDrawn){
      if (cardDrawn.indexOf("8") >= 0){
         return true;
      } else {
         return false;
      }
   }

}