package models;

import java.io.IOException;
import java.util.Date;

public class SecondaryProducts {
    int x;
    int y;
    int timeTillRemove=1;
    final int IN_MAP_RUN_TIME=6;
    boolean store = false;
    public boolean isAvailable=true;
    //public boolean truck = false;
    private SecondaryProductTypes secondaryProductTypes;

    public SecondaryProducts(SecondaryProductTypes secondaryProductTypes) {
        this.secondaryProductTypes = secondaryProductTypes;
        ArrayLists.secondaryProductList.add(this);
    }

    public SecondaryProductTypes getSecondaryProductTypes() {
        return secondaryProductTypes;
    }

    public void setSecondaryProductType(SecondaryProductTypes secondaryProductTypes) {
        this.secondaryProductTypes = secondaryProductTypes;
    }

    public static int quantity(String product){
        int bread=0;
        int shirt = 0;
        int icecream =0;
        for (int i = 0; i < ArrayLists.storeList.size(); i++) {
                if(product.equalsIgnoreCase("BREAD")) {
                    if(ArrayLists.storeList.get(i).getType().equals("BREAD"))
                        bread++;
                }
                else if(product.equalsIgnoreCase("SHIRT")) {
                    if(ArrayLists.storeList.get(i).getType().equals("SHIRT"))
                        shirt++;
                }
                else if(product.equalsIgnoreCase("ICECREAM")) {
                    if(ArrayLists.storeList.get(i).getType().equals("ICECREAM"))
                        icecream++;
                }
        }
        if(product.equalsIgnoreCase("BREAD")) return bread;
        else if(product.equalsIgnoreCase("SHIRT")) return shirt;
        else if(product.equalsIgnoreCase("ICECREAM")) return icecream;
        return 0;
    }

    public void removeByTime(){
        if(timeTillRemove==IN_MAP_RUN_TIME){
            timeTillRemove=1;
            for (int i = 0; i < ArrayLists.secondaryProductList.size(); i++) {
                if( ArrayLists.secondaryProductList.get(i).isAvailable &&  !ArrayLists.secondaryProductList.get(i).store && ArrayLists.secondaryProductList.get(i).x==this.x && ArrayLists.secondaryProductList.get(i).y==this.y){
                    ArrayLists.secondaryProductList.get(i).isAvailable=false;
                    Date date = new Date();
                    String s = "Info: " + date + "\t" +ArrayLists.secondaryProductList.get(i).secondaryProductTypes.name() + " was removed";
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
