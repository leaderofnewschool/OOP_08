package models;

import java.util.ArrayList;

public class AnimalProducts {
    int x;
    int y;
    public boolean store = false;
    public boolean isAvailable=true;
    //public boolean truck = false;
    int speed;
    private AnimalProductTypes animalProductTypes;

    public AnimalProducts(AnimalProductTypes animalProductTypes,int x,int y) {
        this.x=x;
        this.y=y;
        this.animalProductTypes = animalProductTypes;
        ArrayLists.animalProductList.add(this);
    }

    public AnimalProductTypes getAnimalProductTypes() {
        return animalProductTypes;
    }

    public void setAnimalProductTypes(AnimalProductTypes animalProductTypes) {
        this.animalProductTypes = animalProductTypes;
    }

    public static int quantity(String product){
        int egg=0;
        int feather = 0;
        int milk =0;
        for (int i = 0; i < ArrayLists.animalProductList.size(); i++) {
            if(ArrayLists.animalProductList.get(i).isAvailable){
                if(product.equals("EGG")) {
                    if(ArrayLists.animalProductList.get(i).getAnimalProductTypes().equals("EGG"))
                        egg++;
                }
                else if(product.equals("FEATHER")) {
                    if(ArrayLists.animalProductList.get(i).getAnimalProductTypes().equals("FEATHER"))
                        feather++;
                }
                else if(product.equals("MILK")) {
                    if(ArrayLists.animalProductList.get(i).getAnimalProductTypes().equals("MILK"))
                        milk++;
                }
            }
        }
        if(product.equals("EGG")) return egg;
        else if(product.equals("FEATHER")) return feather;
        else if(product.equals("MILK")) return milk;
        return 0;
    }
}
