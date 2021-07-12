package models;

import java.io.IOException;
import java.util.Date;

public class Store {
    private static final int CAPACITY=30;
    private static int usedCapacity=0;
    public static int capacityLeft=CAPACITY-usedCapacity;




    public static void store(  int x , int y){
        checkArrayLists(x,y);
    }

    public static void store(int i){
        storeCheck(i,"wildAnimal");
    }

    public static void store(int i,String type){
        storeCheck(i ,type);
    }

    public static void checkArrayLists(int x, int y){
        for (int i = 0; i < ArrayLists.animalProductList.size(); i++) {
            if(ArrayLists.animalProductList.get(i).x==x & ArrayLists.animalProductList.get(i).y==y & ArrayLists.animalProductList.get(i).isAvailable){
                storeCheck(i,"animalProduct");
                return;
            }
        }
        for (int i = 0; i < ArrayLists.firstProductList.size(); i++) {
            if(ArrayLists.firstProductList.get(i).x==x & ArrayLists.firstProductList.get(i).y==y & ArrayLists.firstProductList.get(i).isAvailable){
                storeCheck(i,"firstProduct");
                return ;
            }
        }
        for (int i = 0; i < ArrayLists.secondaryProductList.size(); i++) {
            if(ArrayLists.secondaryProductList.get(i).x==x & ArrayLists.secondaryProductList.get(i).y==y & ArrayLists.secondaryProductList.get(i).isAvailable){
                storeCheck(i,"secondaryProduct");
                return;
            }
        }


    }

    public static void storeCheck(int i ,String type){
        if(type.equals("animalProduct")){
            if(capacityLeft>ArrayLists.animalProductList.get(i).getAnimalProductTypes().getDepotSize()){
                usedCapacity+=ArrayLists.animalProductList.get(i).getAnimalProductTypes().getDepotSize();
                ArrayLists.animalProductList.get(i).isAvailable=false;
                ArrayLists.animalProductList.get(i).store=true;
                InStore inStore = new InStore(ArrayLists.animalProductList.get(i).getAnimalProductTypes().name(),ArrayLists.animalProductList.get(i).getAnimalProductTypes().getSaleCost(),ArrayLists.animalProductList.get(i).getAnimalProductTypes().getDepotSize());
                ArrayLists.storeList.add(inStore);
            }
            else {
                Date date = new Date();
                String s="Error: "+date+"\t"+type+"not enough space available ";
                try{
                    LogFileWriter.logFileWriter(s);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        else if(type.equals("firstProduct")){
            if(capacityLeft>ArrayLists.firstProductList.get(i).getFirstProductTypes().getDepotSize()){
                usedCapacity+=ArrayLists.firstProductList.get(i).getFirstProductTypes().getDepotSize();
                ArrayLists.firstProductList.get(i).isAvailable=false;
                ArrayLists.firstProductList.get(i).store=true;
                InStore inStore = new InStore(ArrayLists.firstProductList.get(i).getFirstProductTypes().name(),ArrayLists.firstProductList.get(i).getFirstProductTypes().getSaleCost(),ArrayLists.firstProductList.get(i).getFirstProductTypes().getDepotSize());
                ArrayLists.storeList.add(inStore);
            }
            else {
                Date date = new Date();
                String s="Error: "+date+"\t"+type+"not enough space available ";
                try{
                    LogFileWriter.logFileWriter(s);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }        }
        else if(type.equals("secondaryProduct")){
            if(capacityLeft>ArrayLists.secondaryProductList.get(i).getSecondaryProductTypes().getDepotSize()){
                usedCapacity+=ArrayLists.secondaryProductList.get(i).getSecondaryProductTypes().getDepotSize();
                ArrayLists.secondaryProductList.get(i).isAvailable=false;
                ArrayLists.secondaryProductList.get(i).store=true;
                InStore inStore = new InStore(ArrayLists.secondaryProductList.get(i).getSecondaryProductTypes().name(),ArrayLists.secondaryProductList.get(i).getSecondaryProductTypes().getSaleCost(),ArrayLists.secondaryProductList.get(i).getSecondaryProductTypes().getDepotSize());
                ArrayLists.storeList.add(inStore);
            }
            else {
                Date date = new Date();
                String s="Error: "+date+"\t"+type+"not enough space available ";
                try{
                    LogFileWriter.logFileWriter(s);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }        }
        else if(type.equals("wildAnimal")){
            if(capacityLeft>ArrayLists.wildAnimalList.get(i).getWildAnimalType().getDepotSize()){
                usedCapacity+=ArrayLists.wildAnimalList.get(i).getWildAnimalType().getDepotSize();
                ArrayLists.wildAnimalList.get(i).isAvailable=false;
                ArrayLists.wildAnimalList.get(i).store=true;
                InStore inStore = new InStore(ArrayLists.wildAnimalList.get(i).getWildAnimalType().name(),ArrayLists.wildAnimalList.get(i).getWildAnimalType().getSellCost(),ArrayLists.wildAnimalList.get(i).getWildAnimalType().getDepotSize());
                ArrayLists.storeList.add(inStore);
            }
            else {
                Date date = new Date();
                String s="Error: "+date+"\t"+type+"not enough space available ";
                try{
                    LogFileWriter.logFileWriter(s);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }        }
    }

}
