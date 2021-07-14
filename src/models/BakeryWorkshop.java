// FLOUR ----> BREAD
package models;

import java.io.IOException;
import java.util.Date;

public class BakeryWorkshop extends Workshops {
    int counter = 1;
    int timer = 1;
    int quantity = 1;

    public static int buildingPrice = 250;
    public BakeryWorkshop() {
        super(1, 5, "FLOUR", "BREAD");
    }

    public void bakeryProgress() {
        isWorking = true;
        if (counter == 1) {
            for (int i = 0; i < ArrayLists.storeList.size(); i++) {
                if (ArrayLists.storeList.get(i).getType().equalsIgnoreCase("FLOUR")) {
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
                SecondaryProducts secondaryProduct = new SecondaryProducts(SecondaryProductTypes.BREAD);
                putProductInMap();
                secondaryProduct.x = outputProductX;
                secondaryProduct.y = outputProductY;
            }
            Date date = new Date();
            String s="Info: "+date+"\t"+level+"\tbread is ready";
            try {
                LogFileWriter.logFileWriter(s);
            } catch (IOException e) {
                e.printStackTrace();
            }
            counter = 1;
            Request.isBakery = false;
        } else counter++;
    }

}

