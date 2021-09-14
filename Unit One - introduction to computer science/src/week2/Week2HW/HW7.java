package week2.Week2HW;
/**Create a program that can sovle the equation y = a*x(SQR) + b*x + c */
public class HW7 {
    public static void main(String[] args) {
        double a = 3;
        double x = 5;
        double b = 6;
        double c = 8;

        double y = a*(x*x) + (b*x) + c;

        System.out.println("The answer is " + y);
    }
}
