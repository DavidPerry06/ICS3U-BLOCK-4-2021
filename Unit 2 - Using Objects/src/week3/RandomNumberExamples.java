package week3;

public class RandomNumberExamples {
 public static void main(String[] args) {
   /* for (int i=0; i <100; 1++){
    System.out.println(Math.random());
    }
   */
    double r = Math.random();
    System.out.println(r);


    int lower = -5; 
    int upper = 5;

    int rand = (int)(r*(upper - lower + 1)) + lower;

    String str = "Random Numbers";  //  change a random character in str to "x"

    int index = (int)(Math.random()*str.length()); //lowest index is 0 therefore we add nothing
    str = str.substring(0, index) + "x" + str.substring(index + 1);
    System.out.println(str);


 }   
}
