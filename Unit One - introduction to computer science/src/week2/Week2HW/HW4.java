package week2.Week2HW;
/**
 * Create a program that can be used to calculate the final velocity of a car given the initial velocity
 * the acceleration of the car and the time that has elapsed using the follwing equation (vf = vi + at)
 */
public class HW4 {
    public static void main(String[] args) {
        int Vi = 3;
        int A = 5;
        int T = 10;
        
        int Vf = Vi + (A * T);
        
        System.out.println("The final velocity is " + Vf + "m/s");

    }
}
