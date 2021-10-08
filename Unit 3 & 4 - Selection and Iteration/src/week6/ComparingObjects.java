package week6;

public class ComparingObjects {
    public static void main(String[] args) {
        //  when we compare strings we NEVER EVER EVER use == in Java

        //  why? Coming Soon to a theatre near you!
        //  if we dont instantiate an object then the variable stores NULL
        //  otherwise the variable stores the address of the actual object

        //  Why?
        //  When you use == you are comparing what is stored in the variable
        //  Two objects can have the same attributes, but will have different addresses
        //  which is the address (location in memory where the object is stored)

        //  .equals method compares the sequence of teh cahracters in the two objects

        String s1 = new String("hello");
        String s2 = new String("hello");


        System.out.println(s1.equals(s2));

        String str1 = "ABCD";
        String str2 = "BCD";

        //System.out.println(str1.compareTo(str2));
        System.out.println("a".compareTo("g"));
    }
}
