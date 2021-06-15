package models;

public enum FirstProductTypes {
    FLOUR(2 , 5 , 40),
    PACKET_MILK(2 , 5 , 60),
    CLOTH(2,5, 50);

    private final int depotSize;
    private final int saleCost;
    private final int inMapRunTime;


    FirstProductTypes (int depotSize, int inMapRunTime, int saleCost) {
        this.depotSize = depotSize;
        this.saleCost = saleCost;
        this.inMapRunTime = inMapRunTime;

    }

    public int getDepotSize() { return depotSize; }
    public int getInMapRunTime() { return inMapRunTime; }
    public int getSaleCost() { return saleCost; }

}
