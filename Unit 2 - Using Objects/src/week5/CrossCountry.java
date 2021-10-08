package week5;

import java.util.Scanner;

public class CrossCountry {


    /**
     * initiates and closes the scanner, as well as calls the processRunner function
     */

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        processRunner(in);
        processRunner(in);
        processRunner(in);

        in.close();
    }

    /**
     * processRunner function initiates the variables and gets String inputs and assigned them to the corresponding variable
     * It then returns variables to the function substract time for the splits to be calculated
     * After that it then prints out a summary of all the information into the console
     * 
     * @param in
    */
    private static void processRunner(Scanner in) {
        String firstName, lastName;
        String mileOne, mileTwo, finish;
        String splitTwo, splitThree;

        System.out.print("Please input your first name: ");
        firstName = in.nextLine();
        System.out.print("Please input your last name: ");
        lastName = in.nextLine();
        System.out.print("Please input your first mile time(mm:ss.ddd): ");
        mileOne = in.nextLine();
        System.out.print("Please input your second mile time(mm:ss.ddd): ");
        mileTwo = in.nextLine();
        System.out.print("Please input your finish time(mm:ss.ddd): ");
        finish = in.nextLine();
       
        splitTwo = substractTime(mileTwo, mileOne);
        splitThree = substractTime(finish, mileTwo);

        System.out.println("Summary:");
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("First Mile: " + mileOne);
        System.out.println("Split 2: " + splitTwo);
        System.out.println("Split 3: " + splitThree);
        System.out.println("Finish Time: " + finish);
        
    }

    /**
     * This function initializes variables for the calculation of the times
     * It does this by sending information to the function convertToSeconds to do the first part of changing the string to a double back into a string
     * then it returns the double to the function converToTime to turn the int back into a string
     */

    private static String substractTime(String endTime, String startTime) {
        double endTimeInSeconds = convertToSeconds(endTime);
        double startTimeInSeconds = convertToSeconds(startTime);

        double diffInSeconds = endTimeInSeconds - startTimeInSeconds;
        
        return convertToTime(diffInSeconds);
    }
    /**
     * Turns the seconds into a (mm:ss.ddd) formulated string
     * it does this by modulusing the time to get the seconds and dividing it to get the minutes
     * It then returns the minutes and seconds into a (minutes:seconds.decimalseconds) style string to the main method
     * 
     */
    private static String convertToTime(double timeInSeconds) {
        int minutes = (int)(timeInSeconds/60);
        double seconds = timeInSeconds%60;
        
        return String.format("%d:%06.3f", minutes, seconds);
    }

    /**
     * Takes the string apart by seperating the front part of the string (the minutes) and the back end of the string (seconds and decimals) from the colon
     * It Converts the front and back of the string to doubles using the Parse method
     * It then multiplies the front end (the minutes) by 60 so that we can get the total seconds
     * We then can add the front and back that have been converted to seconds to get the total seconds
     * It then returns the sum in seconds of the front and back
     */

    private static double convertToSeconds(String time) {
        int index = time.indexOf(":");
        String front = time.substring(0,index);
        String back = time.substring(index + 1);
        double frontSeconds = Double.parseDouble(front);
        frontSeconds *= 60;
        double backSeconds = Double.parseDouble (back);
        
        return frontSeconds + backSeconds;
        
    }

    
}

