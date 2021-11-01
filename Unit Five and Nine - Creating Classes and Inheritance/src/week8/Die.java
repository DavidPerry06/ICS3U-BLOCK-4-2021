package week8;

public class Die {
    // attributes Define the state of any instance of the class at any particular time
    private int numSides;   // private means that they are only accessible (visible) inside the class
    private int topSide;

    public static final int DEFAULT_SIDES = 6;

    /**
     * constructo has the same names as the class
     * Initializes the state of the class (attributes)
     * returns the Object (althought we do not say return)
     * 
     * If we do not EXPLICITLY create our own constructor JAVA will supply a 
     * NO ARGUMENT constructor that DOES NOT initializes the state of the class
     */
    public Die() {
        numSides = 6;
        roll();
    }

    public Die(int numSides){
        this.numSides = numSides;
        roll();
    }
    /**
     * accessor methods
     * @return
     */
    public int getTopSide() {
        return topSide;
    }
    /**
     * mutator method
     */
    public void roll() {
        topSide = (int) (Math.random() * numSides) + 1;
    }

    public boolean equals(Object obj) {
        if (obj == this)
        return true;
        if (obj instanceof Die) {
            return this.topSide == ((Die)obj).topSide;
        } else {
            return false;
        }
    }

    public String toString() {
        return "" + topSide;
    }

}
