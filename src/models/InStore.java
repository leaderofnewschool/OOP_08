package models;

import java.io.IOException;
import java.util.Date;

public class InStore {
    private String type;
    private int price;
    private int depotSize;
    private boolean isTruck = false;

    public InStore(String type, int price, int depotSize) {
        this.type = type;
        this.price = price;
        this.depotSize = depotSize;
        Date date = new Date();
        String s="Info: "+date+"\t"+type+" was successfully stored";
        try{
            LogFileWriter.logFileWriter(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "type='" + type + '\'' +
                ", price=" + price +
                ", depotSize=" + depotSize;
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
