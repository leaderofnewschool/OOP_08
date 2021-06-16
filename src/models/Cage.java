package models;

public class Cage {
    public static int cageTimer;
    public static int cageTimer2=WildAnimalType.LION.getDepotRunTime();
    public int cageLevel=0;
    int x;
    int y;
    int i;

    public void cageBuilder1(int x, int y){
        for ( i = 0; i < ArrayLists.wildAnimalList.size(); i++) {
            if(ArrayLists.wildAnimalList.get(i).isAvailable){
               if(ArrayLists.wildAnimalList.get(i).getX()==x & ArrayLists.wildAnimalList.get(i).getY()==y){
                   cageBuilder2(ArrayLists.wildAnimalList.get(i),i);
                   return;
               }
            }
        }
    }
    public void cageBuilder2(WildAnimal wildAnimal, int i){
        if (cageTimer2==0) {
            wildAnimal.isAvailable = false;
            return;
        }
        if(cageTimer==2 & cageLevel!=wildAnimal.getWildAnimalType().getCageClick() & cageLevel!=0)
            cageLevel--;
        else if(cageTimer<2 & cageLevel!=wildAnimal.getWildAnimalType().getCageClick())
            cageLevel++;
        if(cageLevel==wildAnimal.getWildAnimalType().getCageClick()){
            Store store= new Store(i);
        }
        cageTimer2--;

    }
}
