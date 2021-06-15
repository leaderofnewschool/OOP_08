package models;
import java.util.*;

public class Workshops {

     int manufactureTime;
     int buildingPrice;
     int level;
     int outputProductX;
     int outputProductY;
     int workshopX;
     int workshopY;
     int productsInProgress;
     boolean isWorking=false;
     String entryProductType;
     String outputProductType;
     Random rnd;


    public void putProductInMap(){
        Random rnd = new Random();
        outputProductX=rnd.nextInt(6)+1;
        outputProductY=rnd.nextInt(6)+1;
 /*       if(outputProductType.equals("FLOUR") | outputProductType.equals("PACKET_MILK") | outputProductType.equals("CLOTH")){

        }
        else if(outputProductType.equals("BREAD") | outputProductType.equals("SHIRT") | outputProductType.equals("ICECREAM")){

        }*/
    }


    public Workshops(int level, int manufactureTime, int buildingPrice, String entryProductType, String outputProductType ) {
        this.level = level;
        this.manufactureTime = manufactureTime;
        this.buildingPrice = buildingPrice;
        this.entryProductType = entryProductType;
        this.outputProductType = outputProductType;
    }


}
