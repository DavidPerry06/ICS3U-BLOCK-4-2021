package week3;

public class WrapperClassExamples {
    public static void main(String[] args) {
        Integer n = new Integer(7);
        Double d = new Double(3.4);


        Integer num = 7;    // auto-boxing
        int x = new Integer(7); //auto-unboxing

        int z = num.intValue();
        z = num;    //does the same thing as line above

        double f = d;   // does the same thing as the line below
        f = d.doubleValue();

        System.out.println(Integer.MAX_VALUE);  //static ownership is the class, non static ownership is the object
        System.out.println(Integer.MIN_VALUE);

        System.out.println(Long.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);


    }
}
