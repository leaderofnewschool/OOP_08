package models;

public class NextTurn {
    int turn=1;
    public void next_turn(){
        Well well = null;
        BakeryWorkshop bakeryWorkshop =null;
        MillWorkshop millWorkshop = null;
        IcecreamMakingWorkshop icecreamMakingWorkshop = null;
        TailoringWorkshop tailoringWorkshop = null;
        WeavingWorkshop weavingWorkshop = null;
        MilkPackagingWorkshop milkPackagingWorkshop = null;
        if (turn==1)
        {
            well = new Well();
            bakeryWorkshop = new BakeryWorkshop();
            millWorkshop = new MillWorkshop();
            icecreamMakingWorkshop = new IcecreamMakingWorkshop();
            tailoringWorkshop = new TailoringWorkshop();
            weavingWorkshop = new WeavingWorkshop();
            milkPackagingWorkshop = new MilkPackagingWorkshop();
            turn++;
        }
        for (int i = 0; i < ArrayLists.farmAnimalList.size(); i++) {
            ArrayLists.farmAnimalList.get(i).produce();
            ArrayLists.farmAnimalList.get(i).removeByWild();
            ArrayLists.farmAnimalList.get(i).hunger();
            ArrayLists.farmAnimalList.get(i).move();
        }
        for (int i = 0; i < ArrayLists.wildAnimalList.size(); i++) {
            ArrayLists.wildAnimalList.get(i).move();
        }
        for (int i = 0; i < ArrayLists.catList.size(); i++) {
            ArrayLists.catList.get(i).move();
            ArrayLists.catList.get(i).catchProduct();
            ArrayLists.catList.get(i).removeCatByWild();
        }
        for (int i = 0; i < ArrayLists.dogList.size(); i++) {
            ArrayLists.dogList.get(i).move();
            int removed_dog= ArrayLists.dogList.get(i).removeDogAndWild();
            if(removed_dog!=0)  ArrayLists.dogList.remove(i);
        }
        if(Request.isWell){
            well.fillWell();
        }
    }
}