package models;

public class InStore {
    private String type;
    private int price;
    private int depotSize;
    private boolean isTruck=false;
    public InStore(String type , int price, int depotSize){
        this.type = type;
        this.price = price;
        this.depotSize = depotSize;
    }

    @Override
    public String toString() {
        return "type='" + type + '\'' +
                ", price=" + price +
                ", depotSize=" + depotSize ;
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public boolean isTruck() {
        return isTruck;
    }

    public void setTruck(boolean truck) {
        isTruck = truck;
    }

    public int getDepotSize() {
        return depotSize;
    }
}
