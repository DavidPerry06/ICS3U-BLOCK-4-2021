package week2.Week2HW;
/**Write a program that given the number of pennies, nickles, dimes, quarters, loonies and toonies
 * calculates how much money the user has
 */
public class HW9 {
    public static void main(String[] args) {
        double p = 0.01;
        double n = 0.05;
        double d = 0.1;
        double q = 0.25;
        double l = 1;
        double t = 2;

        int Vp = 2;
        int Vn = 2;
        int Vd = 2;
        int Vq = 2;
        int Vl = 2;
        int Vt = 2;





        double Money = (p * Vp) + (n * Vn) + (q * Vq) + (l * Vl) + (t * Vt); 

        System.out.println("You have " + Money + "Dollars");


    }
}
