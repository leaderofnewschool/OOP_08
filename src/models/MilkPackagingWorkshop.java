// MILK ---> POCKET_MILK
package models;

public class MilkPackagingWorkshop extends Workshops{
    int counter=1;
    int timer=1;
    int quantity = 1;

    MilkPackagingWorkshop (){ super(1,6, 400,"MILK","POCKET_MILK"); }

    public void milkPackagingProgress() {
        isWorking = true;
        if (counter == 1) {
            for (int i = 0; i < ArrayLists.storeList.size(); i++) {
                if (ArrayLists.storeList.get(i).equals("MILK")) {
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
                FirstProducts firstProduct = new FirstProducts(FirstProductTypes.PACKET_MILK);
                putProductInMap();
                firstProduct.x = outputProductX;
                firstProduct.y = outputProductY;
            }
            counter=1;
            Request.isMilk=false;
        }
        else counter++;
    }

}
