package week2;

public class StudentExample{
    
    public static void main(String[] args) {
        Student Fred = new Student("Fred", "654321", 10);
        Student max = new Student("Max", "123456", 10);
        Student muriel = fred;
        muriel.increaseGrade();

        fred = null;
        //fred.displayName(); // java throws a NullPointerException
    }
}