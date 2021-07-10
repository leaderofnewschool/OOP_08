package models;

import java.io.IOException;
import java.util.Date;

public class Grass {
    int x;
    int y;
    public boolean isAvailable = true;

    public Grass(int x, int y) {
        if (Well.getWaterLeft() != 0) {
            this.x = x;
            this.y = y;
            Well.useWell();
            ArrayLists.grassList.add(this);
            Date date = new Date();
            String s="Info: "+date+"\tgrass was successfully planted";
            try{
                LogFileWriter.logFileWriter(s);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("no water available");
            Date date = new Date();
            String s="Error: "+date+"\tno water available";
            try{
                LogFileWriter.logFileWriter(s);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

