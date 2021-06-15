package models;

public class Truck {
    private int travelTime=10;
    private final int TRUCK_CAPACITY=15;
    private int truckFill=0;
    private int truckCapacity_Left =TRUCK_CAPACITY-truckFill;
    public int timer=0;

    public void loadTruck(String type) {
        if (type.equalsIgnoreCase("CHIKEN") || type.equalsIgnoreCase("TURKEY") || type.equalsIgnoreCase("BUFFALO")) {
            for (int i = 0; i < ArrayLists.farmAnimalList.size(); i++) {
                if (ArrayLists.farmAnimalList.get(i).getFarmAnimalType().name().equalsIgnoreCase(type)){
                    if(ArrayLists.farmAnimalList.get(i).getFarmAnimalType().getAnimalDepotSize()<= truckCapacity_Left){
                        truckFill+=ArrayLists.farmAnimalList.get(i).getFarmAnimalType().getAnimalDepotSize();
                        ArrayLists.truckList.add(ArrayLists.farmAnimalList.get(i).getFarmAnimalType().name());
                        ArrayLists.farmAnimalList.get(i).isTruck=true;
                        ArrayLists.farmAnimalList.get(i).store=false;
                        break;
                    }
                }
            }
        }
        else for (int i = 0; i < ArrayLists.storeList.size(); i++) {
            if (ArrayLists.storeList.get(i).getType().equalsIgnoreCase(type)){
                if(ArrayLists.storeList.get(i).getDepotSize()<= truckCapacity_Left) {
                    truckFill+=ArrayLists.storeList.get(i).getDepotSize();
                    ArrayLists.truckList.add(ArrayLists.storeList.get(i).getType());
                    ArrayLists.storeList.get(i).setTruck(true);
                    break;
                }

            }

        }

    }

    public void unloadTruck(String type){
        for (int i = 0; i < ArrayLists.truckList.size(); i++) {
            if(ArrayLists.truckList.get(i).equals(type)){
                ArrayLists.truckList.remove(i);
                break;
            }
        }

        if (type.equalsIgnoreCase("CHIKEN") || type.equalsIgnoreCase("TURKEY") || type.equalsIgnoreCase("BUFFALO")){
            for (int i = 0; i < ArrayLists.farmAnimalList.size(); i++) {
                if(ArrayLists.farmAnimalList.get(i).getFarmAnimalType().name().equalsIgnoreCase(type)) {
                    if (ArrayLists.farmAnimalList.get(i).isTruck) {
                        ArrayLists.farmAnimalList.get(i).isTruck = false;
                        ArrayLists.farmAnimalList.get(i).store=true;
                        truckFill-=ArrayLists.farmAnimalList.get(i).getFarmAnimalType().getAnimalDepotSize();
                        break;
                    }
                }
            }
        }

        else for (int i = 0; i < ArrayLists.storeList.size(); i++) {
            if(ArrayLists.storeList.get(i).getType().equalsIgnoreCase(type) && ArrayLists.storeList.get(i).isTruck()){
                ArrayLists.storeList.get(i).setTruck(false);
                truckFill+=ArrayLists.storeList.get(i).getDepotSize();
                break;
            }
        }


    }

    public void truckGo(){
        if(timer==travelTime){
            // TODO: 6/14/21
            // coin;
            timer=0;
            ArrayLists.truckList.clear();
            truckFill=0;
            for (int i = 0; i < ArrayLists.farmAnimalList.size(); i++) {
                if(ArrayLists.farmAnimalList.get(i).isTruck)
                    ArrayLists.farmAnimalList.get(i).isTruck=false;
            }
            for (int i = 0; i < ArrayLists.storeList.size(); i++) {
                if(ArrayLists.storeList.get(i).isTruck())
                {
                    ArrayLists.storeList.remove(i);
                    i--;
                }
            }
            return;
        }
        else timer++;

    }

}
