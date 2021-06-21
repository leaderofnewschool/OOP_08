package models;

import java.io.IOException;
import java.util.Date;

public class Well {
    private static final int CAPCITY=5;
    private final int timeToFill=3;
    private static int waterLeft=CAPCITY;
    public static int cnt=1;
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
        if (waterLeft == 0 & cnt != 3) cnt++;
        else if (waterLeft == 0 & cnt == 3) {
            waterLeft = CAPCITY;
            cnt = 1;
            Request.isWell = false;
            Date date = new Date();
            String s="Info: "+date+"\twell was successfully filled";
            try{
                LogFileWriter.logFileWriter(s);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("well filled successfully");
        }
        if(waterLeft!=0){
            Date date = new Date();
            String s="Error: "+date+"\twell is not empty";
            try{
                LogFileWriter.logFileWriter(s);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static int getWaterLeft() {
        return waterLeft;
    }
}
