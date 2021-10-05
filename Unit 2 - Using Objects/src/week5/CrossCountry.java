package week5;

import java.util.Scanner;

public class CrossCountry {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        processRunner(in);
        processRunner(in);
        processRunner(in);

        in.close();
    }

    private static void processRunner(Scanner in) {
        String firstName, lastName;
        String mileOne, mileTwo, finish;
        String splitTwo, splitThree;

        System.out.print("Please input your first name: ");
        firstName = in.nextLine();
        System.out.print("Please input your last name: ");
        lastName = in.nextLine();
        System.out.print("Please input your first mile time: ");
        mileOne = in.nextLine();
        System.out.print("Please input your second mile time: ");
        mileTwo = in.nextLine();
        System.out.print("Please input your finish time: ");
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

    private static String substractTime(String endTime, String startTime) {
        double endTimeInSeconds = convertToSeconds(endTime);
        double startTimeInSeconds = convertToSeconds(startTime);

        double diffInSeconds = endTimeInSeconds - startTimeInSeconds;
        
        return convertToTime(diffInSeconds);
    }

    private static String convertToTime(double timeInSeconds) {
        int minutes = (int)(timeInSeconds/60);
        double seconds = timeInSeconds%60;
        
        return String.format("%d:%06.3f", minutes, seconds);
    }

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

