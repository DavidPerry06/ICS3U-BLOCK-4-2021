package week4;

public class BayviewGlenPools {
    public static void main(String[] args) {
        final int length = 20;
        final int width = 8;
        final int shallowlength = 5;
        final int transition = 7;
        final int shallowheight = 3;
        final int deepheight = 8; 
        final int linerCost= 2;
        double volume = getVolume(length, width, shallowheight, shallowlength, transition, deepheight);
        double surfaceArea = getSurfaceArea(length, width, shallowheight, shallowlength, transition, deepheight);
        double ninetyPercentFull = volume * 0.9;
        double cost = surfaceArea * linerCost;
        
        System.out.println(ninetyPercentFull);
        System.out.println(cost);
    }

  


    private static double getVolume(double length, double width, double shallowheight, double shallowlength, double transition, double deepheight){
        double tlength = Math.sqrt((transition*transition)-((deepheight - shallowheight)*(deepheight - shallowheight))); 
        double deeplength = length - shallowlength - tlength;
        double tVolume = (tlength*(deepheight - shallowheight)*width)/2;
        double mVolume = (shallowheight*tlength*width) + tVolume;
        double dVolume = deepheight*deeplength*width;
        double sVolume = shallowheight*shallowlength*width;
        double volume = mVolume + dVolume + sVolume;

        return volume;
    }

    private static double getSurfaceArea(double length, double width, double shallowheight, double shallowlength, double transition, double deepheight){
        double tlength = Math.sqrt((transition*transition)-((deepheight - shallowheight)*(deepheight - shallowheight))); 
        double deeplength = length - shallowlength - tlength;
        double sWall = 2*(shallowlength * shallowheight);
        double sBackWall = width * shallowheight;
        double sFloor = shallowlength * width;
        double sTotal = sWall +sFloor + sBackWall;
        double dWall = 2*(deeplength * deepheight);
        double dBackWall = deepheight * width;
        double dFloor = deeplength * width;
        double dTotal = dWall + dBackWall + dFloor;
        double tWall = 2*((tlength * (deepheight - shallowheight))/2);
        double tFloor = transition * width;
        double mWall = 2*(shallowheight*tlength);
        double tTotal = tWall + tFloor + mWall;
        double surfaceArea = sTotal + dTotal + tTotal;
        return surfaceArea;

    }
}
