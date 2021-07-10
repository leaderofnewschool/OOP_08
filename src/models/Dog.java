package models;

import java.io.IOException;
import java.util.Date;

public class Dog extends Animal {
    public static final int BUY_DOG_COST = 100;

    public Dog() {
        ArrayLists.dogList.add(this);
    }

    public int removeDogAndWild() {
        int temp = 0;
        for (int j = 0; j < ArrayLists.wildAnimalList.size(); j++) {
            if (this.getX() == ArrayLists.wildAnimalList.get(j).getX() & this.getY() == ArrayLists.wildAnimalList.get(j).getY()) {
                ArrayLists.wildAnimalList.remove(j);
                temp++;
                Date date = new Date();
                String s="Info: "+date+"\tdog removed wild animal";
                try {
                    LogFileWriter.logFileWriter(s);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
        return temp;
    }
}



