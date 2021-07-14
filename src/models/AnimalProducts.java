package models;

import java.io.IOException;
import java.util.Date;

public class AnimalProducts {
    int x;
    int y;
    public boolean store = false;
    public boolean isAvailable = true;
    //public boolean truck = false;
    int timeTillRemove=1;
    final int IN_MAP_RUN_TIME=4;
    private AnimalProductTypes animalProductTypes;



    public AnimalProducts(AnimalProductTypes animalProductTypes, int x, int y) {
        this.x = x;
        this.y = y;
        this.animalProductTypes = animalProductTypes;
        ArrayLists.animalProductList.add(this);

    }

    public AnimalProductTypes getAnimalProductTypes() {
        return animalProductTypes;
    }

    public void setAnimalProductTypes(AnimalProductTypes animalProductTypes) {
        this.animalProductTypes = animalProductTypes;
    }


    public void removeByTime(){
        if(timeTillRemove==IN_MAP_RUN_TIME){
            timeTillRemove=1;
            for (int i = 0; i < ArrayLists.animalProductList.size(); i++) {
                if( ArrayLists.animalProductList.get(i).isAvailable &&  !ArrayLists.animalProductList.get(i).store && ArrayLists.animalProductList.get(i).x==this.x && ArrayLists.animalProductList.get(i).y==this.y){
                    ArrayLists.animalProductList.get(i).isAvailable=false;
                    Date date = new Date();
                    String s = "Info: " + date + "\t" +ArrayLists.animalProductList.get(i).animalProductTypes.name() + " was removed";
                    try {
                        LogFileWriter.logFileWriter(s);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return;
                }
            }
        }
        else{
            timeTillRemove++;
        }
    }

    public static int quantity(String product) {
        int egg = 0;
        int feather = 0;
        int milk = 0;
        for (int i = 0; i < ArrayLists.storeList.size(); i++) {
                if (product.equalsIgnoreCase("EGG")) {
                    if (ArrayLists.storeList.get(i).getType().equals("EGG"))
                        egg++;
                } else if (product.equalsIgnoreCase("FEATHER")) {
                    if (ArrayLists.storeList.get(i).getType().equals("FEATHER"))
                        feather++;
                } else if (product.equalsIgnoreCase("MILK")) {
                    if (ArrayLists.storeList.get(i).getType().equals("MILK"))
                        milk++;
                }
        }
        if (product.equalsIgnoreCase("EGG")) return egg;
        else if (product.equalsIgnoreCase("FEATHER")) return feather;
        else if (product.equalsIgnoreCase("MILK")) return milk;
        return 0;
    }
}
