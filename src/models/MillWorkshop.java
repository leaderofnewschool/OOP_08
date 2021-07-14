// EGG ---> FLOUR
package models;

import java.io.IOException;
import java.util.Date;

public class MillWorkshop extends Workshops {
    int counter = 1;
    int timer = 1;
    int quantity = 1;
    public static int buildingPrice = 150;
    MillWorkshop() {
        super(1, 4, "EGG", "FLOUR");
    }

    public void millMakingProgress() {
        isWorking = true;
        if (counter == 1) {
            for (int i = 0; i < ArrayLists.storeList.size(); i++) {
                if (ArrayLists.storeList.get(i).getType().equalsIgnoreCase("EGG")) {
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
                FirstProducts firstProduct = new FirstProducts(FirstProductTypes.FLOUR);
                putProductInMap();
                firstProduct.x = outputProductX;
                firstProduct.y = outputProductY;
                Date date = new Date();
                String s="Info: "+date+"\t"+level+"\tflour is ready";
                try {
                    LogFileWriter.logFileWriter(s);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            counter = 1;
            Request.isMill = false;
        } else {
            counter++;
        }

    }

}
