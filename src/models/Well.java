package models;

public class Well {
    private static final int CAPCITY=5;
    private final int timeToFill=3;
    private static int waterLeft=CAPCITY;
    public static int cnt=0;
    public static void useWell(){
        if(waterLeft==0){
            System.out.println("no water available");
            return;
        }
        else {
            waterLeft--;
        }
    }

    public  static void fillWell(){
        if(waterLeft==0&cnt!=3) cnt++;
        else if(waterLeft==0&cnt==3) {
                waterLeft=CAPCITY;
                cnt=0;
                Request.isWell=false;
            }
        System.out.println("well filled successfully");
    }

    public static int getWaterLeft() {
        return waterLeft;
    }
}
