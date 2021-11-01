package week7;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class CrazyEightNotes {
    public static void main(String[] args) {
        
        int playerPoints = 0, c1Points = 0, c2Points = 0;

        while(!gameOver(playerPoints, c1Points, c2Points)){
          String result = playRound();
          int firstDash = result.indexOf("-");
          int secondDash = result.indexOf("-", firstDash + 1);
          playerPoints += Integer.parseInt(result.substring(0, firstDash));
          c1Points += Integer.parseInt(result.substring(firstDash + 1, secondDash));
          c2Points += Integer.parseInt(result.substring(secondDash + 1));

          System.out.println(playerPoints + " " + c1Points + " " + c2Points);
        }
    }

    private static String playRound() {
        String playerHand = "";
        String c1Hand = "";
        String c2Hand = "";

        String topCard = "";

        /**
         * build hand like:
         * hand-topCard
         */
        String temp = processPlayer(playerHand, topCard);
        playerHand = temp.substring(0,temp.indexOf("-"));
        topCard = temp.substring(temp.indexOf("-") + 1);
        String c1Temp = processComputer(c1Hand, topCard, playerHand, c2Hand);
        c1Hand = c1Temp.substring(0, c1Temp.indexOf("-"));
        topCard = c1Temp.substring(c1Temp.indexOf("-") + 1);
        String c2Temp = processComputer(c2Hand, topCard, playerHand, c1Hand);
        c2Hand = c2Temp.substring(0, c2Temp.indexOf("-"));
        topCard = c2Temp.substring(c2Temp.indexOf("-") + 1);
        
        
        
        return "17-0-8";
    }

    private static String processComputer(String c1Hand, String topCard, String playerHand, String c2Hand) {
        return null;
    }

    private static String processPlayer(String playerHand, String topCard) {
        return null;
    }

    private static boolean gameOver(int playerPoints, int c1Points, int c2Points) {
        return playerPoints >= 100 || c1Points >= 100 || c2Points >= 100;
    }
}
