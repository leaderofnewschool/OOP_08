package models;

import java.io.IOException;
import java.util.Date;

public class Cage {

    int x;
    int y;
    int i;

    public void cageBuilder1(int x, int y) {
        for (i = 0; i < ArrayLists.wildAnimalList.size(); i++) {
            if (ArrayLists.wildAnimalList.get(i).isAvailable() && ArrayLists.wildAnimalList.get(i).getX() == x & ArrayLists.wildAnimalList.get(i).getY() == y) {
                cageBuilder2(ArrayLists.wildAnimalList.get(i), i);
                return;
            }
        }
    }

    public void cageBuilder2(WildAnimal wildAnimal, int i) {
        wildAnimal.isCage=true;
        wildAnimal.timeBetweenCage=0;
        wildAnimal.depotRunTime=wildAnimal.getWildAnimalType().getDepotRunTime();
        if (wildAnimal.cageLevel != wildAnimal.getWildAnimalType().getCageClick())
        wildAnimal.cageLevel++;
        if (wildAnimal.cageLevel == wildAnimal.getWildAnimalType().getCageClick() && Store.capacityLeft>=wildAnimal.depotSize) {
            Store.store(i);
            wildAnimal.isCage=false;
        }
    }
}
