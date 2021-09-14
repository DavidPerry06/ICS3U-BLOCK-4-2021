package week2.Week2HW;
/**
 * create a program that obtains two integers, one for the amount a test is out of and another 
 * indicating waht a student received. Display what percentage the student reveibed on the test
 */
public class HW2 {
    public static void main(String[] args) {
    /** 
        int num = 5672;
        int num1 = num / 1000; //5
        int num4 = num % 10; // 2
        int num2 = num % 1000 / 100; // 5672 % 1000 = 672 / 100 = 6
        //alternative// num 2 = num / 100 % 10;
        int num3 = num % 100 / 10; //5672 % 100 = 72 / 10 = 7
        //alternative// num 3 = num / 100 % 10

        System.out.println(num1 + num2 + num3 + num4);
    */
        
        int maxScore = 100;
        int StudentScore = 87;

        int Score = (87 / 100) * 100;

        System.out.println("The Student Scored a" + Score);
       

    }
}
