package week5;

import java.util.Scanner;

public class UsingScanner {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //exampleOne(in);
        exampleTwo(in);
        in.close();
    }

    public static void exampleOne(Scanner in){

        System.out.print("Please enter your name: ");
        String name = in.nextLine();

        System.out.println("Hello " + name);
        
    }

    public static void exampleTwo(Scanner in) {
        System.out.print("Please enter a number: ");
        //double num = in.nextDouble(); do not use this, as there are always people who do the wrong thing in your code
        double num = 0;

        boolean validInput = false;
      
        while(!validInput) {
        try{
            num = Double.parseDouble(in.nextLine());
            validInput = true;
        }catch(Exception ex){
            System.out.println("Invalid Input!!!!!! ENTER A DAMN NUMBER: ");
        }
        }
        double result = Math.pow(num,2);
        System.out.println(result);
        
    }
}
