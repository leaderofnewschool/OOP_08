package models;

import java.io.IOException;
import java.util.Date;

public class FarmAnimal extends Animal {
    private int timeTillFill;
    private int productionPeriod;
    public boolean isAvailable = true;
    public boolean store = false;
    int produce_timer = 0;
    public boolean isTruck = false;
    private FarmAnimalType farmAnimalType;
    int speed;
    private int live = 10;
    public boolean isTargetedMove=false;
    public boolean isTargetedMove2=false;


    public FarmAnimal(FarmAnimalType farmAnimalType) {
        this.farmAnimalType = farmAnimalType;
        this.productionPeriod = farmAnimalType.getProductionPeriod();
        this.speed = farmAnimalType.getSpeed();
        ArrayLists.farmAnimalList.add(this);
        Date date = new Date();
        String s = "Info: " + date + "\t" + this.getFarmAnimalType().name() + " was successfully purchased";
        try {
            LogFileWriter.logFileWriter(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  void eatGrass(FarmAnimal farmAnimal) {
        int minX = 0;
        int minY = 0;
        int j = 0;
        for (int i = 0; i < ArrayLists.grassList.size(); i++) {
            if (i == 0 && ArrayLists.grassList.get(i).isAvailable) {
                minX = ArrayLists.grassList.get(i).x;
                minY = ArrayLists.grassList.get(i).x;
            } else {
                if(ArrayLists.grassList.get(i).isAvailable)
                if (destination(minX, minY, farmAnimal.getX(), farmAnimal.getY()) > destination(ArrayLists.grassList.get(i).x, ArrayLists.grassList.get(i).y, farmAnimal.getX(), farmAnimal.getY())) {
                    minX = ArrayLists.grassList.get(i).x;
                    minY = ArrayLists.grassList.get(i).y;
                    j = i;
                }
            }
        }
        if(minX!=0&&minY!=0)
        {
            targetedMove(farmAnimal.getSpeed(),farmAnimal, minX, minY);
            isTargetedMove=true;
            if(isArrived) {
                isTargetedMove=false;
                live=10;
                ArrayLists.grassList.get(j).isAvailable=false;

            }
            else live--;

        }
        else{
            live--;
            isTargetedMove=false;
        }
    }

    public static void produceFromAnimal(FarmAnimal farmAnimal) {
        if (farmAnimal.farmAnimalType.equals("CHIKEN")) {
            AnimalProducts animalProducts = new AnimalProducts(AnimalProductTypes.EGG, farmAnimal.getX(), farmAnimal.getY());
        } else if (farmAnimal.farmAnimalType.equals("TURKEY")) {
            AnimalProducts animalProducts = new AnimalProducts(AnimalProductTypes.FEATHER, farmAnimal.getX(), farmAnimal.getY());
        } else if (farmAnimal.farmAnimalType.equals("BUFFALO")) {
            AnimalProducts animalProducts = new AnimalProducts(AnimalProductTypes.MILK, farmAnimal.getX(), farmAnimal.getY());
        }


    }

    public static int quantity(String product) {
        int chiken = 0;
        int turkey = 0;
        int buffalo = 0;
        for (int i = 0; i < ArrayLists.farmAnimalList.size(); i++) {
            if (ArrayLists.farmAnimalList.get(i).isAvailable) {
                if (product.equals("CHIKEN")) {
                    if (ArrayLists.farmAnimalList.get(i).getFarmAnimalType().equals("CHIKEN"))
                        chiken++;
                } else if (product.equals("TURKEY")) {
                    if (ArrayLists.farmAnimalList.get(i).getFarmAnimalType().equals("TURKEY"))
                        turkey++;
                } else if (product.equals("BUFFALO")) {
                    if (ArrayLists.farmAnimalList.get(i).getFarmAnimalType().equals("BUFFALO"))
                        buffalo++;
                }
            }
        }
        if (product.equals("CHIKEN")) return chiken;
        else if (product.equals("TURKEY")) return turkey;
        else if (product.equals("BUFFALO")) return buffalo;
        return 0;
    }

    private boolean isHungry() {
        if (live <= 6)
            return true;
        return false;
    }

    public void removeByWild() {
        for (int j = 0; j < ArrayLists.wildAnimalList.size(); j++) {
            if (this.isAvailable == true && this.getX() == ArrayLists.wildAnimalList.get(j).getX() && this.getY() == ArrayLists.wildAnimalList.get(j).getY()) {
                this.isAvailable = false;
                this.store = false;
            }
        }
    }

    public void produce() {
        if (this.farmAnimalType.getProductionPeriod() == produce_timer) {
            produce_timer = 0;
            produceFromAnimal(this);
        } else produce_timer++;

    }

    public void hunger() {
        if (!this.isHungry()) {
            {
                this.live--;
            }
        } else {
            eatGrass(this);
        }
        if (this.live == 0) this.isAvailable = false;

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

