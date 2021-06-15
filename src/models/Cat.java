package models;

import java.util.ArrayList;

public class Cat extends Animal{
    private final int BUY_CAT_COST=150;
    public boolean isAvailable=true;




    public Cat(){
        ArrayLists.catList.add(this);
    }

    public void catchProduct(){
        int min1X=0;
        int min1Y=0;
        int min2X=0;
        int min2Y=0;
        int min3X=0;
        int min3Y=0;
        int minX=0;
        int minY=0;
        String type;
        int i1=0;
        int i2=0;
        int i3=0;
        for (int i = 0; i < ArrayLists.animalProductList.size(); i++) {
            if(i==0){
                min1X=ArrayLists.animalProductList.get(i).x;
                min1Y=ArrayLists.animalProductList.get(i).x; }
            else{
                if(Animal.destination(min1X,min1Y,this.getX(),this.getY())>Animal.destination(ArrayLists.animalProductList.get(i).x,ArrayLists.animalProductList.get(i).y,this.getX(),this.getY())){
                    min1X=ArrayLists.animalProductList.get(i).x;
                    min1Y=ArrayLists.animalProductList.get(i).y;
                i1=i;
                break;}}}
        for (int i = 0; i < ArrayLists.firstProductList.size(); i++) {
            if(i==0){
                min2X=ArrayLists.firstProductList.get(i).x;
                min2Y=ArrayLists.firstProductList.get(i).x;}
            else{
                if(Animal.destination(min2X,min2Y,this.getX(),this.getY())>Animal.destination(ArrayLists.firstProductList.get(i).x,ArrayLists.firstProductList.get(i).y,this.getX(),this.getY())){
                    min2X=ArrayLists.firstProductList.get(i).x;
                    min2Y=ArrayLists.firstProductList.get(i).y;
                i2=i;
                break;}}}
        for (int i = 0; i < ArrayLists.secondaryProductList.size(); i++) {
            if(i==0){
                min3X=ArrayLists.secondaryProductList.get(i).x;
                min3Y=ArrayLists.secondaryProductList.get(i).x;}
            else{
                if(Animal.destination(min3X,min3Y,this.getX(),this.getY())>Animal.destination(ArrayLists.secondaryProductList.get(i).x,ArrayLists.secondaryProductList.get(i).y,this.getX(),this.getY())){
                    min3X=ArrayLists.secondaryProductList.get(i).x;
                    min3Y=ArrayLists.secondaryProductList.get(i).y;
                i3=i;
                break;}}}
        minX=min1X;
        minY=min1Y;
        type="animalProduct";
        if(Animal.destination(minX,minY,this.getX(),this.getY())>Animal.destination(min2X,min2Y,this.getX(),this.getY())){
            minX=min2X;
            minY=min2Y;
            type="firstProduct";
        }
        if(Animal.destination(minX,minY,this.getX(),this.getY())>Animal.destination(min3X,min3Y,this.getX(),this.getY())){
            minX=min3X;
            minY=min3Y;
            type="secondaryProduct";

        }
        Animal.targetedMove(this.getSpeed(),this.getX(),this.getY(),minX,minY);
        if(temp){
            if(type.equals("animalProduct")){
                Store store=new Store(i1,type);
            }
            else if(type.equals("firstProduct")){
                Store store=new Store(i2,type);
            }
            else if(type.equals("secondaryProduct")){
                Store store=new Store(i3,type);
            }
        }



    }

    public static void removeCatByWild(){
        for (int i = 0; i <ArrayLists.catList.size() ; i++) {
            for (int j = 0; j < ArrayLists.wildAnimalList.size(); j++) {
                if(ArrayLists.catList.get(i).isAvailable==true & ArrayLists.wildAnimalList.get(j).isAvailable==true)
                if(ArrayLists.catList.get(i).getX()==ArrayLists.wildAnimalList.get(j).getX()&ArrayLists.catList.get(i).getY()==ArrayLists.wildAnimalList.get(j).getY()){
                    ArrayLists.catList.get(i).isAvailable=false;
                }

            }

        }
    }





}
