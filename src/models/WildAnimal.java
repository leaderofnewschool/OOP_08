package models;

import java.io.IOException;
import java.util.Date;

public class WildAnimal extends Animal {
    public boolean store = false;
    private WildAnimalType wildAnimalType;
    private int cageClick;
    public boolean truck = false;
    boolean isAvailable=true;
    int cageLeft=0;

    public WildAnimal(WildAnimalType wildAnimalType){
        this.wildAnimalType=wildAnimalType;
        this.cageClick = wildAnimalType.getCageClick();
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


}