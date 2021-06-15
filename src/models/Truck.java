package models;

public class Truck {
    private int travelTime=10;
    private  final  int TRUCKCAPACITY=15;

    private int TruckCapacity_Left=15;
    public int timer=0;

    public void loadTruck(String type) {
        if (type.equals("CHIKEN") || type.equals("TURKEY") || type.equals("BUFFALO")) {
            for (int i = 0; i < ArrayLists.farmAnimalList.size(); i++) {
                if (ArrayLists.farmAnimalList.get(i).getFarmAnimalType().name().equalsIgnoreCase(type)){
                    if(ArrayLists.farmAnimalList.get(i).getFarmAnimalType().getAnimalDepotSize()<=TruckCapacity_Left){
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
                if(ArrayLists.storeList.get(i).getDepotSize()<=TruckCapacity_Left)
                {
                    ArrayLists.truckList.add(ArrayLists.storeList.get(i).getType());
                    ArrayLists.storeList.get(i).setTruck(true);
                    break;
                }

            }

        }

    }

    public void unloadTruck(String type){
        for (int i = 0; i < ArrayLists.truckList.size(); i++) {
            if(ArrayLists.truckList.get(i).equalsIgnoreCase(type)){
                ArrayLists.truckList.remove(i);
                break;
            }
        }

        if (type.equals("CHIKEN") || type.equals("TURKEY") || type.equals("BUFFALO")){
            for (int i = 0; i < ArrayLists.farmAnimalList.size(); i++) {
                if(ArrayLists.farmAnimalList.get(i).getFarmAnimalType().name().equalsIgnoreCase(type)) {
                    if (ArrayLists.farmAnimalList.get(i).isTruck) {
                        ArrayLists.farmAnimalList.get(i).isTruck = false;
                        ArrayLists.farmAnimalList.get(i).store=true;
                        break;
                    }
                }
            }
        }

        else for (int i = 0; i < ArrayLists.storeList.size(); i++) {
            if(ArrayLists.storeList.get(i).getType().equalsIgnoreCase(type) && ArrayLists.storeList.get(i).isTruck()){
                ArrayLists.storeList.get(i).setTruck(false);
                break;
            }
        }


    }

    public void truckGo(){
        if(timer==travelTime){
            //coin;
            timer=0;
            ArrayLists.truckList.clear();
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
