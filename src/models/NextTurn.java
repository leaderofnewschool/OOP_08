package models;

public class NextTurn {
    public static BakeryWorkshop bakeryWorkshop = null;
    public static Truck truck = null;
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
            truck = new Truck();
            turn++;
        }
        MissionFileProcessor.new_wildAnimal();
        if(Request.isTruck) truck.truckGo();
        if(Request.isWell) well.fillWell();
        if(Request.isBakery) bakeryWorkshop.bakeryProgress();
        if(Request.isTailoring) tailoringWorkshop.tailoringProgress();
        if(Request.isMill) millWorkshop.millMakingProgress();
        if(Request.isIceCream) icecreamMakingWorkshop.icecreamMakingProgress();
        if(Request.isMilk) milkPackagingWorkshop.milkPackagingProgress();
        if(Request.isWeaving) weavingWorkshop.weavingProgress();
        for (int i = 0; i < ArrayLists.wildAnimalList.size(); i++) {
            ArrayLists.wildAnimalList.get(i).cageTime();
            ArrayLists.wildAnimalList.get(i).move();
        }
        for (int i = 0; i < ArrayLists.farmAnimalList.size(); i++) {
            ArrayLists.farmAnimalList.get(i).hunger();
            if (ArrayLists.farmAnimalList.get(i).isTargetedMove)   ArrayLists.farmAnimalList.get(i).isTargetedMove2=ArrayLists.farmAnimalList.get(i).isTargetedMove;

            if(ArrayLists.farmAnimalList.get(i).isArrived){

            }
            else if(!ArrayLists.farmAnimalList.get(i).isTargetedMove2 )
            {
                ArrayLists.farmAnimalList.get(i).move();
            }
            ArrayLists.farmAnimalList.get(i).isTargetedMove2=ArrayLists.farmAnimalList.get(i).isTargetedMove;
            ArrayLists.farmAnimalList.get(i).isArrived=false;
            ArrayLists.farmAnimalList.get(i).produce();
            ArrayLists.farmAnimalList.get(i).removeByWild();
        }
        for (int i = 0; i < ArrayLists.catList.size(); i++) {
            ArrayLists.catList.get(i).catchProduct();
            if (ArrayLists.catList.get(i).isTargetedMove)   ArrayLists.catList.get(i).isTargetedMove2=ArrayLists.catList.get(i).isTargetedMove;

            if(ArrayLists.catList.get(i).isArrived){

            }
            else if(!ArrayLists.catList.get(i).isTargetedMove2 )
                ArrayLists.catList.get(i).move();
            ArrayLists.catList.get(i).isTargetedMove2=ArrayLists.catList.get(i).isTargetedMove;
            ArrayLists.catList.get(i).isArrived=false;
            ArrayLists.catList.get(i).removeCatByWild();
        }
        for (int i = 0; i < ArrayLists.dogList.size(); i++) {
            ArrayLists.dogList.get(i).move();
            int removed_dog= ArrayLists.dogList.get(i).removeDogAndWild();
            if(removed_dog!=0)  ArrayLists.dogList.remove(i);
        }
        for (int i = 0; i < ArrayLists.animalProductList.size(); i++) {
            ArrayLists.animalProductList.get(i).removeByTime();
        }
        for (int i = 0; i < ArrayLists.firstProductList.size(); i++) {
            ArrayLists.firstProductList.get(i).removeByTime();
        }
        for (int i = 0; i < ArrayLists.secondaryProductList.size(); i++) {
            ArrayLists.secondaryProductList.get(i).removeByTime();
        }

    }
//    public void everyTurn(){
//        if(Request.isTruck) truck.truckGo();
//        if(Request.isWell) well.fillWell();
//        if(Request.isBakery) bakeryWorkshop.bakeryProgress();
//        if(Request.isTailoring) tailoringWorkshop.tailoringProgress();
//        if(Request.isMill) millWorkshop.millMakingProgress();
//        if(Request.isIceCream) icecreamMakingWorkshop.icecreamMakingProgress();
//        if(Request.isMilk) milkPackagingWorkshop.milkPackagingProgress();
//        if(Request.isWeaving) weavingWorkshop.weavingProgress();
//    }
}
