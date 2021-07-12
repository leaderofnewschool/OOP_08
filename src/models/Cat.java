package models;

import com.sun.tools.javac.Main;
import controller.InputProcessor;

import java.io.IOException;
import java.util.Date;

public class Cat extends Animal {
    public static final int BUY_CAT_COST = 150;
    public boolean isAvailable = true;
    public  boolean isTargetedMove=false;
    public boolean isTargetedMove2=false;
    public Cat() {
        ArrayLists.catList.add(this);
    }

    public void catchProduct() {
        int min1X = 0;
        int min1Y = 0;
        int min2X = 0;
        int min2Y = 0;
        int min3X = 0;
        int min3Y = 0;
        int minX = 0;
        int minY = 0;
        String type;
        int i1 = 0;
        int i2 = 0;
        int i3 = 0;
        for (int i = 0; i < ArrayLists.animalProductList.size(); i++) {
            if (i == 0) {
                min1X = ArrayLists.animalProductList.get(i).x;
                min1Y = ArrayLists.animalProductList.get(i).x;
            } else {
                if (Animal.destination(min1X, min1Y, this.getX(), this.getY()) > Animal.destination(ArrayLists.animalProductList.get(i).x, ArrayLists.animalProductList.get(i).y, this.getX(), this.getY())) {
                    min1X = ArrayLists.animalProductList.get(i).x;
                    min1Y = ArrayLists.animalProductList.get(i).y;
                    i1 = i;
                    break;
                }
            }
        }
        for (int i = 0; i < ArrayLists.firstProductList.size(); i++) {
            if (i == 0) {
                min2X = ArrayLists.firstProductList.get(i).x;
                min2Y = ArrayLists.firstProductList.get(i).x;
            } else {
                if (Animal.destination(min2X, min2Y, this.getX(), this.getY()) > Animal.destination(ArrayLists.firstProductList.get(i).x, ArrayLists.firstProductList.get(i).y, this.getX(), this.getY())) {
                    min2X = ArrayLists.firstProductList.get(i).x;
                    min2Y = ArrayLists.firstProductList.get(i).y;
                    i2 = i;
                    break;
                }
            }
        }
        for (int i = 0; i < ArrayLists.secondaryProductList.size(); i++) {
            if (i == 0) {
                min3X = ArrayLists.secondaryProductList.get(i).x;
                min3Y = ArrayLists.secondaryProductList.get(i).x;
            } else {
                if (Animal.destination(min3X, min3Y, this.getX(), this.getY()) > Animal.destination(ArrayLists.secondaryProductList.get(i).x, ArrayLists.secondaryProductList.get(i).y, this.getX(), this.getY())) {
                    min3X = ArrayLists.secondaryProductList.get(i).x;
                    min3Y = ArrayLists.secondaryProductList.get(i).y;
                    i3 = i;
                    break;
                }
            }
        }
        minX = min1X;
        minY = min1Y;
        type = "animalProduct";
        if (Animal.destination(minX, minY, this.getX(), this.getY()) > Animal.destination(min2X, min2Y, this.getX(), this.getY())) {
            minX = min2X;
            minY = min2Y;
            type = "firstProduct";
        }
        if (Animal.destination(minX, minY, this.getX(), this.getY()) > Animal.destination(min3X, min3Y, this.getX(), this.getY())) {
            minX = min3X;
            minY = min3Y;
            type = "secondaryProduct";

        }
        if(minX!=0&&minY!=0)
        {
           targetedMove(this.getSpeed(),this, minX, minY);
            isTargetedMove=true;
            if (isArrived) {
                isTargetedMove=false;
                if (type.equals("animalProduct")) {
                    Store.store(i1,type);
                } else if (type.equals("firstProduct")) {
                    Store.store(i2,type);
                } else if (type.equals("secondaryProduct")) {
                    Store.store(i3,type);
                }
                Date date = new Date();
                String s="Info: "+date+"\tcat caught product";
                try {
                    LogFileWriter.logFileWriter(s);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        else isTargetedMove=false;

    }

    public void removeCatByWild() {
        for (int j = 0; j < ArrayLists.wildAnimalList.size(); j++) {
            if (this.isAvailable == true) {
                if (this.getX() == ArrayLists.wildAnimalList.get(j).getX() & this.getY() == ArrayLists.wildAnimalList.get(j).getY()) {
                    this.isAvailable = false;
                }
            }
        }
    }
}
