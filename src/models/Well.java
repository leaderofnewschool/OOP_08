package models;

public class Well {
    private static final int capacity=5;
    private final int timeToFill=3;
    private static int waterLeft=capacity;
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

    public static void fillWell(){
        if(waterLeft==0&cnt!=3)
        {
            cnt++;
            System.out.println(1);
        }

            else if(waterLeft==0&cnt==3) {
                waterLeft=5;
                cnt=0;
            System.out.println(2);

            }
        System.out.println("finished");
    }

    public static int getCapacity() {
        return capacity;
    }

    public int getTimeToFill() {
        return timeToFill;
    }

    public static int getWaterLeft() {
        return waterLeft;
    }
}
