package models;

public enum SecondaryProductTypes {
    BREAD(4 , 6 , 80),
    SHIRT(4 , 6 , 100),
    ICECREAM(4,6, 120);

    private final int depotSize;
    private final int saleCost;
    private final int inMapRunTime;


    SecondaryProductTypes(int depotSize, int inMapRunTime, int saleCost) {
        this.depotSize = depotSize;
        this.saleCost = saleCost;
        this.inMapRunTime = inMapRunTime;

    }

    public int getDepotSize() {
        return depotSize;
    }

    public int getInMapRunTime() { return inMapRunTime; }

    public int getSaleCost() {
        return saleCost;
    }
}
