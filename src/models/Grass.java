package models;

public class Grass {
    int x;
    int y;
    public boolean isAvailable=true;
    public Grass(int x,int y){
        if(Well.getWaterLeft()!=0)
        {
            this.x=x;
            this.y=y;
            Well.useWell();
            ArrayLists.grassList.add(this);
        }
    }
}

