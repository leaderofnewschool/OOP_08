package models;

import java.util.Random;

public class Workshops {

     int manufactureTime;
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


    public Workshops(int level, int manufactureTime, String entryProductType, String outputProductType ) {
        this.level = level;
        this.manufactureTime = manufactureTime;
        this.entryProductType = entryProductType;
        this.outputProductType = outputProductType;
    }


    public void putProductInMap(){
        Random rnd = new Random();
        outputProductX=rnd.nextInt(6)+1;
        outputProductY=rnd.nextInt(6)+1;
    }


}
