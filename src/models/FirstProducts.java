package models;

public class FirstProducts {
  int x;
  int y;
  public boolean store = false;
  public boolean isAvailable=true;
  //public boolean truck = false;
  private FirstProductTypes firstProductTypes;

  public FirstProducts(FirstProductTypes firstProductTypes) {
    this.firstProductTypes = firstProductTypes;
    ArrayLists.firstProductList.add(this);
  }

  public int quantity(String product){
    int flour=0;
    int packet_milk = 0;
    int cloth =0;
    for (int i = 0; i < ArrayLists.firstProductList.size(); i++) {
      if(ArrayLists.firstProductList.get(i).store){
        if(product.equals("FLOUR")) {
          if(ArrayLists.firstProductList.get(i).getFirstProductTypes().equals("FLOUR"))
            flour++;
        }
        else if(product.equals("PACKET_MILK")) {
          if(ArrayLists.firstProductList.get(i).getFirstProductTypes().equals("PACKET_MILK"))
            packet_milk++;
        }
        else if(product.equals("CLOTH")) {
          if(ArrayLists.firstProductList.get(i).getFirstProductTypes().equals("CLOTH"))
            cloth++;
        }
      }
    }
    if(product.equals("FLOUR")) return flour;
    else if(product.equals("PACKET_MILK")) return packet_milk;
    else if(product.equals("CLOTH")) return cloth;
    return 0;
  }

  public FirstProductTypes getFirstProductTypes() {
    return firstProductTypes;
  }

  public void setPrimitiveProductType(FirstProductTypes firstProductTypes) {
    this.firstProductTypes = firstProductTypes;
  }


}
