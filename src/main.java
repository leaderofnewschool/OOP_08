import models.*;

public class main {
    public static void main(String[] args){
        BakeryWorkshop bakeryWorkshop=new BakeryWorkshop();
        FirstProducts firstProducts= new FirstProducts(FirstProductTypes.FLOUR);
        InStore inStore = new InStore("FLOUR",10,10);
        ArrayLists.storeList.add(inStore);
        int i=0;
        while(i<6){
            bakeryWorkshop.bakeryProgress();
            i++;
        }
    }
}
