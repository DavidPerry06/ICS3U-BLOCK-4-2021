package week9;

public class Box extends Rectangle {
    /**
     * if you do not explicitly write a constructor then Java will inplicitly write one
     * for you that takes NO ARGUMENTS and calls the parent class's no argument constructor 
     */
    
     /* NO WORK
   public Box() {
       super(); //super refers to the parent class
   }
   */

   private int height;

   public Box(int l, int w, int h){
       /* 
       we do not get to directly accese the parent class's private attributes and methods
    length  = l;
    width = w;
    */
    // first statement of a constructor MUST be a call to the classes parent constructor 
    // if you do not explicitly do it then java will implicitly do it by calling the no arg parent constructor
    super(l,w); // have to call parents constructor in your constructor 
    height = h;
}

public Box(int side){
    super(side);
    height = side;
}

public int getArea(){

    return 2 * super.getArea() + 2 * getWidth() * height + 2 * getLength() * height;
}

public int getPerimeter(){
    return 2 * super.getPerimeter() + 4 * height;
}

public boolean equals(Object obj) {
    Rectangle b = (Rectangle) obj;
    if (obj == this)
    return true;
    if (obj instanceof Box) {
        return getLength() == b.getLength() && getWidth() == b.getWidth() && height == b.height;
    } else {
        return false;
    }
}


}
