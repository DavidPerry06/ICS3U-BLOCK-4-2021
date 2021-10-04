package week4;

public class IfStatementExamples {
    public static void main(String[] args) {
        exampleOne();
        String letterGrade = getLetterGrade(78);
        exampleThree();
    }

    private static void exampleThree() {
        /**
         * >        (greater than)
         * <        (less than than)
         * ==       (is equal to)
         * >=       (Greater then or equal to the thing on the right side of the equal sign)
         * <=       (Less then or equal the thing on the right side of the equal sign)
         * !=       (not equal to)
         * || OR (x > 7 || (y > 7)      Either are can be true to be true
         * %% AND (x > 7 || (y > 7)     Both have to be true to be true
         * ! NOT !(x>7) x<=7            X has to be less than or equal to 7
         * 
         */
    }

    private static String getLetterGrade(int mark) {
        if (mark >= 90) {
            return "A+";
        } else if (mark >= 80) {
            return "A";
        } else if (mark >= 70) {                // else means that the thing above is false so look for the *Blank*
            return "B";
        } else if (mark >= 60) {
            return "C";
        } else if (mark >= 50) {
            return "D";
        } else {
            return "F";
        }

    }

    private static void exampleOne() {
        int x = 7;

        if (x % 2 == 0) {
            System.out.println(x + " is even.");
        } else {
            System.out.println(x + " is not even");
        }
        
    }
}
