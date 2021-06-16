package models;

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
                break;
            }
        }
        return temp;
    }
}



