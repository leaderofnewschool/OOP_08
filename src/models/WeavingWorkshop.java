// CLOTH ---> SHIRT
package models;

public class WeavingWorkshop extends Workshops{
    int counter=1;
    int timer=1;
    int quantity = 1;

    WeavingWorkshop(){
        super(1,6,400,"CLOTH","SHIRT");
    }

    public void weavingProgress() {
        isWorking = true;
        if (counter == 1) {
            for (int i = 0; i < ArrayLists.storeList.size(); i++) {
                if (ArrayLists.storeList.get(i).equals("CLOTH")) {
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
                SecondaryProducts secondaryProduct = new SecondaryProducts(SecondaryProductTypes.SHIRT);
                putProductInMap();
                secondaryProduct.x = outputProductX;
                secondaryProduct.y = outputProductY;
            }
            counter=1;
            Request.isWeaving=false;
        }
        else counter++;
    }
}
