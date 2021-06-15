package models;

import java.util.ArrayList;

public class FarmAnimal extends Animal{
    private int buyPrice;
    private int sellPrice;
    private int timeTillFill;
    private  int productionPeriod;
    private int live=10;
    public boolean isAvailable=true;
    public boolean store=false;
    public boolean isTruck = false;
    private FarmAnimalType farmAnimalType;
    int speed;


    public FarmAnimal(FarmAnimalType farmAnimalType){
        this.farmAnimalType=farmAnimalType;
        this.productionPeriod=farmAnimalType.getProductionPeriod();
        this.speed=farmAnimalType.getSpeed();
    }


    private boolean isHungry(){
        if(live<=5) return true;
        else return false;
    }

    public static void eatGrass(FarmAnimal farmAnimal){
        int minX=0;
        int minY=0;
        for (int i = 0; i <ArrayLists.grassList.size(); i++) {
            if(i==0){
                minX=ArrayLists.grassList.get(i).x;
                minY=ArrayLists.grassList.get(i).x;}
            else{
                if(destination(minX,minY,farmAnimal.getX(), farmAnimal.getY())>destination(ArrayLists.grassList.get(i).x,ArrayLists.grassList.get(i).y,farmAnimal.getX(), farmAnimal.getY())){
                    minX=ArrayLists.grassList.get(i).x;
                    minY=ArrayLists.grassList.get(i).y;}}}
        targetedMove(farmAnimal.getSpeed(), farmAnimal.getX(), farmAnimal.getY(),minX,minY);

    }

    public static void produceFromAnimal(FarmAnimal farmAnimal){
        if(farmAnimal.farmAnimalType.equals("CHIKEN")) {
            AnimalProducts animalProducts = new AnimalProducts(AnimalProductTypes.EGG,farmAnimal.getX(),farmAnimal.getY());
            ArrayLists.animalProductList.add(animalProducts);
        }
        else if(farmAnimal.farmAnimalType.equals("TURKEY")) {
            AnimalProducts animalProducts = new AnimalProducts(AnimalProductTypes.FEATHER,farmAnimal.getX(),farmAnimal.getY());
            ArrayLists.animalProductList.add(animalProducts);
        }
        else if(farmAnimal.farmAnimalType.equals("BUFFALO")) {
            AnimalProducts animalProducts = new AnimalProducts(AnimalProductTypes.MILK,farmAnimal.getX(),farmAnimal.getY());
            ArrayLists.animalProductList.add(animalProducts);
        }


    }

    public static void removeByWild(){
        for (int i = 0; i <ArrayLists.farmAnimalList.size() ; i++) {
            for (int j = 0; j < ArrayLists.wildAnimalList.size(); j++) {
                if( ArrayLists.farmAnimalList.get(i).isAvailable==true & ArrayLists.wildAnimalList.get(j).isAvailable==true)
                {
                    if(ArrayLists.farmAnimalList.get(i).getX()==ArrayLists.wildAnimalList.get(j).getX()&ArrayLists.farmAnimalList.get(i).getY()==ArrayLists.wildAnimalList.get(j).getY()){
                        ArrayLists.farmAnimalList.get(i).isAvailable=false;
                        ArrayLists.farmAnimalList.get(i).store=false;
                        ArrayLists.wildAnimalList.get(j).isAvailable=false;
                        ArrayLists.wildAnimalList.get(j).store=false;
                    }
                }

            }

        }
    }

    public static void removeForSell(){
        for (int i = 0; i < ArrayLists.farmAnimalList.size(); i++) {
            if(ArrayLists.farmAnimalList.get(i).isAvailable){
                ArrayLists.farmAnimalList.get(i).isAvailable=false;
                break;
            }
        }
    }

    public int quantity(String product){
        int chiken =0;
        int turkey = 0;
        int buffalo =0;
        for (int i = 0; i < ArrayLists.farmAnimalList.size(); i++) {
            if(ArrayLists.farmAnimalList.get(i).isAvailable){
                if(product.equals("CHIKEN")) {
                    if(ArrayLists.farmAnimalList.get(i).getFarmAnimalType().equals("CHIKEN"))
                        chiken++;
                }
                else if(product.equals("TURKEY")) {
                    if(ArrayLists.farmAnimalList.get(i).getFarmAnimalType().equals("TURKEY"))
                        turkey++;
                }
                else if(product.equals("BUFFALO")) {
                    if(ArrayLists.farmAnimalList.get(i).getFarmAnimalType().equals("BUFFALO"))
                        buffalo++;
                }
            }
        }
        if(product.equals("CHIKEN")) return chiken;
        else if(product.equals("TURKEY")) return turkey;
        else if(product.equals("BUFFALO")) return buffalo;
        return 0;
    }

    public static void nextStep(int cnt){
        for (int i = 0; i < ArrayLists.farmAnimalList.size(); i++) {
            if (ArrayLists.farmAnimalList.get(i).isAvailable) {
                if (ArrayLists.farmAnimalList.get(i).farmAnimalType.getProductionPeriod() == cnt) {
                    cnt = 0;
                    produceFromAnimal(ArrayLists.farmAnimalList.get(i));
                }
                else cnt++;
                if (!ArrayLists.farmAnimalList.get(i).isHungry()) {
                    ArrayLists.farmAnimalList.get(i). live--;
                }
                else  eatGrass(ArrayLists.farmAnimalList.get(i));
                if (ArrayLists.farmAnimalList.get(i).live == 0) ArrayLists.farmAnimalList.get(i).isAvailable = false;
            }
        }

    }

    public int getBuyPrice() {
        return buyPrice;
    }

    public int getSellPrice() {
        return sellPrice;
    }

    public int getTimeTillFill() {
        return timeTillFill;
    }

    public int getProductionPeriod() {
        return productionPeriod;
    }

    public int getLive() {
        return live;
    }

    public FarmAnimalType getFarmAnimalType() {
        return farmAnimalType;
    }
}

