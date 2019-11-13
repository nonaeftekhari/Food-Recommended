import java.io.*;
import java.util.*;

interface Location{
    void useCoord(double coordinate);
}

class GrabLocation implements Location{
    private double deviceLocation;

    public void useCoord(double coordinate){
        System.out.println("There are 4 restaurants near you");
    }
}

class InputLocation implements Location{
    private int zipCode;
    private double coordinate;

    public double convertToCoord() {
        coordinate = zipCode;
        return coordinate;
    }

    public void useCoord(double coordinate) {
        System.out.println("There are 3 restaurants near you");
    }
}

class LocationFactory {
    public Location getType(String type){
        if(type == null){
            return null;
        }

        if(type.equalsIgnoreCase("INPUT")){
            return new InputLocation();
        } else if(type.equalsIgnoreCase("GIVELOCATION")){
            return new GrabLocation();
        }
        return null;
    }
}

public class Test {
   public static void main(String[] args){
       LocationFactory locationFactory = new LocationFactory();
       Location location1 = locationFactory.getType("INPUT");
       location1.useCoord(3);
       Location location2 = locationFactory.getType("GIVELOCATION");
       location2.useCoord(4);

   }
}
