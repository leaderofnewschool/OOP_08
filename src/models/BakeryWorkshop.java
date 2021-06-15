// FLOUR ----> BREAD
package models;

import java.util.ArrayList;

public class BakeryWorkshop extends Workshops{
   int counter=1;
   int timer=1;
   int quantity = 1;

   public BakeryWorkshop(){
      super(1,5, 250,"FLOUR","BREAD");
   }

   public void bakeryProgress() {
      isWorking = true;
      if (counter == 1) {
         for (int i = 0; i < ArrayLists.storeList.size(); i++) {
            if (ArrayLists.storeList.get(i).equals("FLOUR")) {
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
            SecondaryProducts secondaryProduct = new SecondaryProducts(SecondaryProductTypes.BREAD);
            ArrayLists.secondaryProductList.add(secondaryProduct);
            putProductInMap();
            secondaryProduct.x = outputProductX;
            secondaryProduct.y = outputProductY;
         }
         counter=1;
      }
      else counter++;
   }

}

