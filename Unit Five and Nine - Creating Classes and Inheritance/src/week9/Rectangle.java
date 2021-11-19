package week9;

public class Rectangle {
    private int length;
    private int width;


public Rectangle(int l, int w){
    length  = l;
    width = w;
}

public Rectangle(int side){
    length = side;
    width = side;
}

public int getArea(){
    return length * width;
}

public int getLength(){
    return length;
}

public int getWidth(){
    return width;
}

public int getPerimeter(){
    return 2*length + 2* width;
}

public boolean isSquare(){
    return length == width; 
}

public boolean equals(Object obj) {
    Rectangle r = (Rectangle) obj;
    if (obj == this)
    return true;
    if (obj instanceof Rectangle) {
        return length == r.length && width == r.width;
    } else {
        return false;
    }
}

public String toString() {
    return "Rectangle with width of " + width + " and length of " + length;
}



}
