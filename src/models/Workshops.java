package models;

import java.util.Random;

public class Workshops {

     int manufactureTime;
     public static int buildingPrice;
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


    public Workshops(int level, int manufactureTime, int buildingPrice, String entryProductType, String outputProductType ) {
        this.level = level;
        this.manufactureTime = manufactureTime;
        this.buildingPrice = buildingPrice;
        this.entryProductType = entryProductType;
        this.outputProductType = outputProductType;
    }


    public void putProductInMap(){
        Random rnd = new Random();
        outputProductX=rnd.nextInt(6)+1;
        outputProductY=rnd.nextInt(6)+1;
    }


}
