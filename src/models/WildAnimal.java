package models;

import java.io.IOException;
import java.util.Date;

public class WildAnimal extends Animal {
    public boolean store = false;
    public boolean truck = false;
    boolean isCage=false;
    private WildAnimalType wildAnimalType;
    private int cageClick;
    int depotRunTime;
    int timeBetweenCage=0;
    boolean isAvailable=true;
    int cageLevel=0;
    int depotSize;

    public WildAnimal(WildAnimalType wildAnimalType){
        this.wildAnimalType=wildAnimalType;
        this.cageClick = wildAnimalType.getCageClick();
        this.depotRunTime=wildAnimalType.getDepotRunTime();
        this.depotSize=wildAnimalType.getDepotSize();
        ArrayLists.wildAnimalList.add(this);

        Date date = new Date();
        String s="Info: "+date+"\twild animal is created";
        try {
            LogFileWriter.logFileWriter(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public WildAnimalType getWildAnimalType() { return wildAnimalType; }

    public int quantity(String animal){
        int lion = 0;
        int bear = 0;
        int tiger = 0;
        for (int i = 0; i < ArrayLists.wildAnimalList.size(); i++) {
            if(ArrayLists.wildAnimalList.get(i).store){
                if(animal.equals("LION")) {
                    if(ArrayLists.wildAnimalList.get(i).getWildAnimalType().equals("LION"))
                        lion++;
                }
                else if(animal.equals("BEAR")) {
                    if(ArrayLists.wildAnimalList.get(i).getWildAnimalType().equals("BEAR"))
                        bear++;
                }
                else if(animal.equals("TIGER")) {
                    if(ArrayLists.wildAnimalList.get(i).getWildAnimalType().equals("TIGER"))
                        tiger++;
                }
            }
        }
        if(animal.equals("LION")) return lion;
        else if(animal.equals("BEAR")) return bear;
        else if(animal.equals("BUFFALO")) return tiger;
        return 0;
    }

    public void cageTime(){
        if(this.isCage){
            timeBetweenCage++;
            if (timeBetweenCage>1 && cageLevel!=0){
                cageLevel--;
            }
            else if(cageLevel==0)
                this.isCage=false;
            if(cageLevel==cageClick && Store.capacityLeft<depotSize){
                depotRunTime--;
                if(depotRunTime==0){
                    {
                        ArrayLists.wildAnimalList.remove(this);
                        isCage = false;
                        Date date = new Date();
                        String s = "Info: " + date + "\twild animal is removed ";
                        try {
                            LogFileWriter.logFileWriter(s);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
    public boolean isStore() {
        return store;
    }

    public int getCageClick() {
        return cageClick;
    }

    public boolean isTruck() {
        return truck;
    }

    public int getDepotRunTime() {
        return depotRunTime;
    }

    public boolean isAvailable() {
        return isAvailable;
    }



    public void setStore(boolean store) {
        this.store = store;
    }

    public void setWildAnimalType(WildAnimalType wildAnimalType) {
        this.wildAnimalType = wildAnimalType;
    }

    public void setCageClick(int cageClick) {
        this.cageClick = cageClick;
    }

    public void setTruck(boolean truck) {
        this.truck = truck;
    }

    public void setDepotRunTime(int depotRunTime) {
        this.depotRunTime = depotRunTime;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }


}