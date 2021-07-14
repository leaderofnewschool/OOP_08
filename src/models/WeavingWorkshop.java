// CLOTH ---> SHIRT
package models;

import java.io.IOException;
import java.util.Date;

public class WeavingWorkshop extends Workshops{
    int counter=1;
    int timer=1;
    int quantity = 1;
    public static int buildingPrice=250;
    WeavingWorkshop(){
        super(1,6, "CLOTH","SHIRT");
    }

    public void weavingProgress() {
        isWorking = true;
        if (counter == 1) {
            for (int i = 0; i < ArrayLists.storeList.size(); i++) {
                if (ArrayLists.storeList.get(i).getType().equalsIgnoreCase("CLOTH")) {
                    ArrayLists.storeList.remove(i);
                    i--;
                    quantity++;
                }
                if (quantity == level + 1) break;
            }
        }
        timer = manufactureTime / quantity;
        if (counter == timer) {
            for (int i = 1; i < quantity; i++) {
                SecondaryProducts secondaryProduct = new SecondaryProducts(SecondaryProductTypes.SHIRT);
                putProductInMap();
                secondaryProduct.x = outputProductX;
                secondaryProduct.y = outputProductY;
                Date date = new Date();
                String s="Info: "+date+"\t"+level+"\tshirt is ready";
                try {
                    LogFileWriter.logFileWriter(s);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            counter=1;
            Request.isWeaving=false;
        }
        else counter++;
    }
}
