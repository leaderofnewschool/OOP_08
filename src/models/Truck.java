package models;

import controller.InputProcessor;

import java.util.Locale;

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
          inTruckPrice();
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

    public void inTruckPrice(){
        for (int i = 0; i < ArrayLists.truckList.size(); i++) {
            switch (ArrayLists.truckList.get(i).toLowerCase()){
                case "chicken":
                    InputProcessor.coin+=(FarmAnimalType.CHICKEN.getBuyCost()/2);
                    break;
                case "turkey":
                    InputProcessor.coin+=(FarmAnimalType.TURKEY.getBuyCost()/2);
                    break;
                case "buffalo":
                    InputProcessor.coin+=(FarmAnimalType.BUFFALO.getBuyCost()/2);
                    break;
                case "lion":
                    InputProcessor.coin+=WildAnimalType.LION.getSellCost();
                    break;
                case "tiger":
                    InputProcessor.coin+=WildAnimalType.TIGER.getSellCost();
                    break;
                case "bear":
                    InputProcessor.coin+=WildAnimalType.BEAR.getSellCost();
                    break;
                case "egg":
                    InputProcessor.coin+=AnimalProductTypes.EGG.getSaleCost();
                    break;
                case "milk":
                    InputProcessor.coin+=AnimalProductTypes.MILK.getSaleCost();
                    break;
                case "feather":
                    InputProcessor.coin+=AnimalProductTypes.FEATHER.getSaleCost();
                    break;
                case "flour":
                    InputProcessor.coin+=FirstProductTypes.FLOUR.getSaleCost();
                    break;
                case "packet_milk":
                    InputProcessor.coin+=FirstProductTypes.PACKET_MILK.getSaleCost();
                    break;
                case "cloth":
                    InputProcessor.coin+=FirstProductTypes.CLOTH.getSaleCost();
                    break;
                case "shirt":
                    InputProcessor.coin+=SecondaryProductTypes.SHIRT.getSaleCost();
                    break;
                case "bread":
                    InputProcessor.coin+=SecondaryProductTypes.BREAD.getSaleCost();
                    break;
                case "icecream":
                    InputProcessor.coin+=SecondaryProductTypes.ICECREAM.getSaleCost();
                    break;
                default:
                    break;
            }
        }
    }

}
