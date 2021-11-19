package week9;


public class ShapeDriver {
    public static void main(String[] args) {
        
    
    Rectangle r1 = new Rectangle(5, 3);
    Rectangle r2 = new Rectangle(6);

    Rectangle b1 = new Box(4, 4, 5); // <-- can do this but cannot od Box b1 = new Rectangle()
    b1.getArea();

    if (r1.isSquare()){
        System.out.println("R1 is a square");
    } else {
        System.out.println("R1 is not a square");
    }

    if (r2.isSquare()){
        System.out.println("R2 is a square");
    } else {
        System.out.println("R2 is not a square");
    }

    if (r1.equals(r2)){
        System.out.println("They are equal");
    } else {
        System.out.println("They are not equal");
    }

    System.out.println("R1 Area: " + r1.getArea());
    System.out.println("R2 Area: " + r1.getArea());
    System.out.println("R1 Perimeter : " + r1.getPerimeter());
    System.out.println("R2 Perimeter: " + r2.getPerimeter());

    System.out.println(r1);
    System.out.println(r2);
    }
}

