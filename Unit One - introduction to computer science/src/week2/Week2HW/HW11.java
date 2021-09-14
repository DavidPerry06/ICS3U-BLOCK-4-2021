package week2.Week2HW;

public class HW11 {
    public static void main(String[] args) {
        double x = 5.5;
        double y = 3.0;
        double z = -2.0;
        int i = 5;
        int j = 4;
        int k = 3;

        int a = (i -(i -(i - (i - j))));
        int aS = i - (i - j);

        System.out.println(a);
        System.out.println("The Answer for A is " + aS);

        double c = ((x-y) - (y - x) - (x - y) - (y - x));
        double cS = 2*(x-y);

        System.out.println(c);
        System.out.println("The Answer for C is " + cS);

        int fA = (i - j)/k;
        int fB = i * j;
        int f = (fA + fB);
        

        System.out.println("f is " + f);
        
        double hA = (double) i + j;
        double h = ((double) i + j / k);
        double hS = (hA / k);

        System.out.println(h);
        System.out.println("h is " + hS);


        double iA = x / k;
        double I = ((int) x / k - x /k);
        double iS = ((int)iA - iA);

        System.out.println(I);
        System.out.println("i is " + iS);

        /**
        double jA = (double)i / j;
        double J = ((double)i / j - (double) (i / j));
        double jS = ((double)jA - (double)jA);
        
        System.out.println(J);
        System.out.println("j is " + jS);
        */

        



        


    }
}
