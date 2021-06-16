//POCKET_MILK ----> ICECREAM
package models;

public class IcecreamMakingWorkshop extends Workshops{
    int counter=1;
    int timer=1;
    int quantity = 1;

    IcecreamMakingWorkshop(){
        super(1,7,550,"PACKET_MILK","ICECREAM");
    }

    public void icecreamMakingProgress() {
        isWorking = true;
        if (counter == 1) {
            for (int i = 0; i < ArrayLists.storeList.size(); i++) {
                if (ArrayLists.storeList.get(i).equals("POCJET_MILK")) {
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
                SecondaryProducts secondaryProduct = new SecondaryProducts(SecondaryProductTypes.ICECREAM);
                putProductInMap();
                secondaryProduct.x = outputProductX;
                secondaryProduct.y = outputProductY;
            }
            counter=1;
            Request.isIceCream=false;
        }
        else counter++;
    }
}
