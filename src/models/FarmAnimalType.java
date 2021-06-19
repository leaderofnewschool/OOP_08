package models;

public enum FarmAnimalType {
    CHICKEN(1, 2, 2, 100, 5),
    TURKEY(1, 2, 3, 200, 10),
    BUFFALO(1, 2, 5, 400, 20);

    private final int speed;
    private final int hungryMovingSpeed;
    private final int productionPeriod;
    private final int buyCost;
    private final int animalDepotSize;


    FarmAnimalType(int speed, int hungryMovingSpeed, int productionPeriod, int buyCost, int animalDepotSize) {
        this.speed = speed;
        this.hungryMovingSpeed = hungryMovingSpeed;
        this.productionPeriod = productionPeriod;
        this.buyCost = buyCost;
        this.animalDepotSize = animalDepotSize;
    }

    public int getSpeed() {
        return speed;
    }

    public int getHungryMovingSpeed() {
        return hungryMovingSpeed;
    }

    public int getProductionPeriod() {
        return productionPeriod;
    }


    public int getBuyCost() {
        return buyCost;
    }

    public int getAnimalDepotSize() {
        return animalDepotSize;
    }
}
