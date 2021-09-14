package week2.Week2HW;
/**
 * Calculate the product of the 2nd and 4th digit of a 5 digit number
 */
public class HW3 {
    public static void main(String[] args) {
        int num = 23647;
        int num1 = num / 1000 % 10;
        int num2 = num % 100 / 10;

        System.out.println(num1 * num2);
    }
}
