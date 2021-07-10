package models;

import java.io.IOException;
import java.util.Date;

public class Cage {
    public static int cageTimer;
    public static int cageTimer2 = WildAnimalType.LION.getDepotRunTime();
    public int cageLevel = 0;
    int x;
    int y;
    int i;

    public void cageBuilder1(int x, int y) {
        for (i = 0; i < ArrayLists.wildAnimalList.size(); i++) {
            if (ArrayLists.wildAnimalList.get(i).getX() == x & ArrayLists.wildAnimalList.get(i).getY() == y) {
                cageBuilder2(ArrayLists.wildAnimalList.get(i), i);
                return;
            }
        }
    }

    public void cageBuilder2(WildAnimal wildAnimal, int i) {
        if (cageTimer2 == 0) {
            ArrayLists.wildAnimalList.remove(i);
            Date date = new Date();
            String s="Info: "+date+"\twild animal is removed ";
            try {
                LogFileWriter.logFileWriter(s);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }
        if (cageTimer == 2 & cageLevel != wildAnimal.getWildAnimalType().getCageClick() & cageLevel != 0)
            cageLevel--;
        else if (cageTimer < 2 & cageLevel != wildAnimal.getWildAnimalType().getCageClick())
            cageLevel++;
        if (cageLevel == wildAnimal.getWildAnimalType().getCageClick()) {
            Store store = new Store(i);
        }
        wildAnimal.cageLeft=cageLevel;
        cageTimer2--;

    }
}
