package models;

import java.io.IOException;
import java.util.Date;

public class FirstProducts {
    public boolean store = false;
    public boolean isAvailable = true;
    int x;
    int y;
    int timeTillRemove=1;
    final int IN_MAP_RUN_TIME=5;
    //public boolean truck = false;
    private FirstProductTypes firstProductTypes;

    public FirstProducts(FirstProductTypes firstProductTypes) {
        this.firstProductTypes = firstProductTypes;
        ArrayLists.firstProductList.add(this);
    }

    public static int quantity(String product) {
        int flour = 0;
        int packet_milk = 0;
        int cloth = 0;
        for (int i = 0; i < ArrayLists.storeList.size(); i++) {
                if (product.equalsIgnoreCase("FLOUR")) {
                    if (ArrayLists.storeList.get(i).getType().equals("FLOUR"))
                        flour++;
                } else if (product.equalsIgnoreCase("PACKET_MILK")) {
                    if (ArrayLists.storeList.get(i).getType().equals("PACKET_MILK"))
                        packet_milk++;
                } else if (product.equalsIgnoreCase("CLOTH")) {
                    if (ArrayLists.storeList.get(i).getType().equals("CLOTH"))
                        cloth++;
                }
        }
        if (product.equalsIgnoreCase("FLOUR")) return flour;
        else if (product.equalsIgnoreCase("PACKET_MILK")) return packet_milk;
        else if (product.equalsIgnoreCase("CLOTH")) return cloth;
        return 0;
    }

    public FirstProductTypes getFirstProductTypes() {
        return firstProductTypes;
    }

    public void setPrimitiveProductType(FirstProductTypes firstProductTypes) {
        this.firstProductTypes = firstProductTypes;
    }

    public void removeByTime(){
        if(timeTillRemove==IN_MAP_RUN_TIME){
            timeTillRemove=1;
            for (int i = 0; i < ArrayLists.firstProductList.size(); i++) {
                if( ArrayLists.firstProductList.get(i).isAvailable &&  !ArrayLists.firstProductList.get(i).store && ArrayLists.firstProductList.get(i).x==this.x && ArrayLists.firstProductList.get(i).y==this.y){
                    ArrayLists.firstProductList.get(i).isAvailable=false;
                    Date date = new Date();
                    String s = "Info: " + date + "\t" +ArrayLists.firstProductList.get(i).firstProductTypes.name() + " was removed";
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
}
