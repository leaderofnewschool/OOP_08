package models;

public class NextTurn {
    public static BakeryWorkshop bakeryWorkshop = null;
    public static MillWorkshop millWorkshop = null;
    public static IcecreamMakingWorkshop icecreamMakingWorkshop = null;
    public static TailoringWorkshop tailoringWorkshop = null;
    public static WeavingWorkshop weavingWorkshop = null;
    public static MilkPackagingWorkshop milkPackagingWorkshop = null;
    int turn = 1;
    Well well = null;

    public void next_turn() {

        if (turn == 1) {
            well = new Well();
//            bakeryWorkshop = new BakeryWorkshop();
//            millWorkshop = new MillWorkshop();
//            icecreamMakingWorkshop = new IcecreamMakingWorkshop();
//            tailoringWorkshop = new TailoringWorkshop();
//            weavingWorkshop = new WeavingWorkshop();
//            milkPackagingWorkshop = new MilkPackagingWorkshop();
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
        if(Request.isWell) well.fillWell();
        if(Request.isBakery) bakeryWorkshop.bakeryProgress();
        if(Request.isTailoring) tailoringWorkshop.tailoringProgress();
        if(Request.isMill) millWorkshop.millMakingProgress();
        if(Request.isIceCream) icecreamMakingWorkshop.icecreamMakingProgress();
        if(Request.isMilk) milkPackagingWorkshop.milkPackagingProgress();
        if(Request.isWeaving) weavingWorkshop.weavingProgress();
    }
}
