package models;

public enum WildAnimalType {
    LION(15 , 300 , 3 , 5 , 1),
    BEAR(15 , 400 , 4 , 5 , 1),
    TIGER(15 , 500 , 4 , 5 , 2);

    private final int depotSize;
    private final int sellCost;
    private final int cageClick;
    private final int depotRunTime;
    private final int speed;

    WildAnimalType(int depotSize, int sellCost, int cageClick,int depotRunTime,int speed) {
        this.depotSize = depotSize;
        this.sellCost = sellCost;
        this.cageClick = cageClick;
        this.depotRunTime = depotRunTime;
        this.speed=speed;
    }

    public int getDepotSize() {
        return depotSize;
    }
    public int getSellCost() {
        return sellCost;
    }
    public int getCageClick() {
        return cageClick;
    }
    public int getDepotRunTime() {return depotRunTime;}
    public int getSpeed() { return speed;}
}
