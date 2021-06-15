package models;

public class Dog extends Animal {
    private final int BUY_DOG_COST=100;
    public boolean isAvailable=true;
    public Dog() {
       ArrayLists.dogList.add(this);

    }
    public static void removeDogAndWild(){
        for (int i = 0; i <ArrayLists.dogList.size() ; i++) {
            for (int j = 0; j < ArrayLists.wildAnimalList.size(); j++) {
                if(ArrayLists.dogList.get(i).isAvailable==true & ArrayLists.wildAnimalList.get(j).isAvailable==true)
                {
                    if(ArrayLists.dogList.get(i).getX()==ArrayLists.wildAnimalList.get(j).getX()&ArrayLists.dogList.get(i).getY()==ArrayLists.wildAnimalList.get(j).getY()){
                        ArrayLists.dogList.get(i).isAvailable=false;
                        ArrayLists.wildAnimalList.get(j).isAvailable=false;
                    }
                }

            }

        }
    }

}

