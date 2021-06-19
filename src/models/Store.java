package models;

public class Store {
    private final int CAPACITY=30;
    private int usedCapacity=0;
    private int capacityLeft=CAPACITY-usedCapacity;
    int x=0;
    int y=0;


    public Store(int x , int y){
      this.x=x;
      this.y=y;
      checkArrayLists();
    }

    public Store(int i){
      storeCheck(i,"wildAnimal");
    }

    public Store(int i,String type){
        storeCheck(i ,type);
    }

    public void show(){
        for (int i = 0; i < ArrayLists.farmAnimalList.size(); i++) {
            if(ArrayLists.farmAnimalList.get(i).isAvailable){
                //baraye truck depot mikhahim va depot e store 0 ast
                System.out.println(ArrayLists.farmAnimalList.get(i).getFarmAnimalType().name()+"   "+ArrayLists.farmAnimalList.get(i).getFarmAnimalType().getBuyCost()/2+"   "+ ArrayLists.farmAnimalList.get(i).getFarmAnimalType().getAnimalDepotSize());
            }
            for (int i1 = 0; i1 < ArrayLists.storeList.size(); i1++) {
                System.out.println(ArrayLists.storeList.get(i));
            }
        }
    }
    public void checkArrayLists(){
        for (int i = 0; i < ArrayLists.animalProductList.size(); i++) {
            if(ArrayLists.animalProductList.get(i).x==this.x & ArrayLists.animalProductList.get(i).y==this.y & ArrayLists.animalProductList.get(i).isAvailable){
                storeCheck(i,"animalProduct");
                return;
            }
        }
        for (int i = 0; i < ArrayLists.firstProductList.size(); i++) {
            if(ArrayLists.firstProductList.get(i).x==this.x & ArrayLists.firstProductList.get(i).y==this.y & ArrayLists.firstProductList.get(i).isAvailable){
                storeCheck(i,"firstProduct");
                return ;
            }
        }
        for (int i = 0; i < ArrayLists.secondaryProductList.size(); i++) {
            if(ArrayLists.secondaryProductList.get(i).x==this.x & ArrayLists.secondaryProductList.get(i).y==this.y & ArrayLists.secondaryProductList.get(i).isAvailable){
                storeCheck(i,"secondaryProduct");
                return;
            }
        }


    }

    public void storeCheck(int i ,String type){
        if(type.equals("animalProduct")){
            if(capacityLeft>ArrayLists.animalProductList.get(i).getAnimalProductTypes().getDepotSize()){
                usedCapacity+=ArrayLists.animalProductList.get(i).getAnimalProductTypes().getDepotSize();
                ArrayLists.animalProductList.get(i).isAvailable=false;
                ArrayLists.animalProductList.get(i).store=true;
                InStore inStore = new InStore(ArrayLists.animalProductList.get(i).getAnimalProductTypes().name(),ArrayLists.animalProductList.get(i).getAnimalProductTypes().getSaleCost(),ArrayLists.animalProductList.get(i).getAnimalProductTypes().getDepotSize());
                ArrayLists.storeList.add(inStore);
            }
            else System.out.println("not enough space available");
        }
        else if(type.equals("firstProduct")){
            if(capacityLeft>ArrayLists.firstProductList.get(i).getFirstProductTypes().getDepotSize()){
                usedCapacity+=ArrayLists.firstProductList.get(i).getFirstProductTypes().getDepotSize();
                ArrayLists.firstProductList.get(i).isAvailable=false;
                ArrayLists.firstProductList.get(i).store=true;
                InStore inStore = new InStore(ArrayLists.firstProductList.get(i).getFirstProductTypes().name(),ArrayLists.firstProductList.get(i).getFirstProductTypes().getSaleCost(),ArrayLists.firstProductList.get(i).getFirstProductTypes().getDepotSize());
                ArrayLists.storeList.add(inStore);
            }
            else System.out.println("not enough space available");
        }
        else if(type.equals("secondaryProduct")){
            if(capacityLeft>ArrayLists.secondaryProductList.get(i).getSecondaryProductTypes().getDepotSize()){
                usedCapacity+=ArrayLists.secondaryProductList.get(i).getSecondaryProductTypes().getDepotSize();
                ArrayLists.secondaryProductList.get(i).isAvailable=false;
                ArrayLists.secondaryProductList.get(i).store=true;
                InStore inStore = new InStore(ArrayLists.secondaryProductList.get(i).getSecondaryProductTypes().name(),ArrayLists.secondaryProductList.get(i).getSecondaryProductTypes().getSaleCost(),ArrayLists.secondaryProductList.get(i).getSecondaryProductTypes().getDepotSize());
                ArrayLists.storeList.add(inStore);
            }
            else System.out.println("not enough space available");
        }
        else if(type.equals("wildAnimal")){
            if(capacityLeft>ArrayLists.wildAnimalList.get(i).getWildAnimalType().getDepotSize()){
                usedCapacity+=ArrayLists.wildAnimalList.get(i).getWildAnimalType().getDepotSize();
                ArrayLists.wildAnimalList.get(i).isAvailable=false;
                ArrayLists.wildAnimalList.get(i).store=true;
                InStore inStore = new InStore(ArrayLists.wildAnimalList.get(i).getWildAnimalType().name(),ArrayLists.wildAnimalList.get(i).getWildAnimalType().getSellCost(),ArrayLists.wildAnimalList.get(i).getWildAnimalType().getDepotSize());
                ArrayLists.storeList.add(inStore);
            }
            else System.out.println("not enough space available");
        }

    }


    public int getCapacityLeft() {
        return capacityLeft;
    }

    public int getCAPACITY() {
        return CAPACITY;
    }
}
