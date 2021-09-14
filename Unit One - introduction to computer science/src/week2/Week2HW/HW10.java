package week2.Week2HW;
/** Math.sqrt(x), where x is a value cna be used to calculate the square root. Given an equation
 * in the format from 7. Obtain the two roots, Given a, b and c. Use ( x = (-b +- (SqrR(b*b - 4ac)))/2)
 */
public class HW10 {
    public static void main(String[] args) {
        double a = 1.0;
        double b = 6.0;
        double c = 1.0;
                


        double root1 = (-b + Math.sqrt(b*b - 4.0*a*c))/2.0;
        double root2 = (-b - Math.sqrt(b*b - 4.0*a*c))/2.0;


        System.out.println("The Roots are " + root1 +" and " + root2);
    }
}
