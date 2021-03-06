// FEATHER ---> CLOTH
package models;

import java.io.IOException;
import java.util.Date;

public class TailoringWorkshop extends Workshops{
    int counter=1;
    int timer=1;
    int quantity = 1;

    TailoringWorkshop (){
        super(1,5,250,"FEATHER", "CLOTH");
    }

    public void tailoringProgress() {
        isWorking = true;
        if (counter == 1) {
            for (int i = 0; i < ArrayLists.storeList.size(); i++) {
                if (ArrayLists.storeList.get(i).equals("FEATHER")) {
                    ArrayLists.storeList.remove(i);
                    i--;
                    quantity++;
                }
                if (quantity == level + 1) break;
            }
        }
        timer = manufactureTime / quantity;
        if (counter == timer) {
            for (int i = 0; i < quantity; i++) {
                FirstProducts firstProduct = new FirstProducts(FirstProductTypes.CLOTH);
                putProductInMap();
                firstProduct.x = outputProductX;
                firstProduct.y = outputProductY;
                Date date = new Date();
                String s="Info: "+date+"\t"+level+"\tcloth is ready";
                try {
                    LogFileWriter.logFileWriter(s);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            counter=1;
            Request.isTailoring=false;
        }
        else counter++;
    }

}
