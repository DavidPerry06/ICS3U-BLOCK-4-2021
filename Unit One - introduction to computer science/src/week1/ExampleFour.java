package week1;

/**
 * Variables - used to store information / data / value
 * Primitive Data Types -> (int, anything that doesnt have a decimal / double, for anything that has decimal number / char, for characters or letters/ boolean, true or false)
 * Assignment / Assingment Operator - Assigns a value to a variable (=)
 */

public class ExampleFour {
    public static void main(String[] args) {
        int markOne = 75, markTwo = 80, markThree = 87;      // declared 3 integer variables and assinged them values in one line

        int average = (markOne + markTwo + markThree) / 3; 

        System.out.println("The average is: " + average); // string cancatanation (joining something to a string)
    }
    
}
