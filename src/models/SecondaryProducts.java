package models;

public class SecondaryProducts {
    int x;
    int y;
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
        for (int i = 0; i < ArrayLists.secondaryProductList.size(); i++) {
            if(ArrayLists.secondaryProductList.get(i).isAvailable){
                if(product.equals("BREAD")) {
                    if(ArrayLists.secondaryProductList.get(i).getSecondaryProductTypes().equals("BREAD"))
                        bread++;
                }
                else if(product.equals("SHIRT")) {
                    if(ArrayLists.secondaryProductList.get(i).getSecondaryProductTypes().equals("SHIRT"))
                        shirt++;
                }
                else if(product.equals("ICECREAM")) {
                    if(ArrayLists.secondaryProductList.get(i).getSecondaryProductTypes().equals("ICECREAM"))
                        icecream++;
                }
            }
        }
        if(product.equals("BREAD")) return bread;
        else if(product.equals("SHIRT")) return shirt;
        else if(product.equals("ICECREAM")) return icecream;
        return 0;
    }
}
