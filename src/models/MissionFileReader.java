package models;

import controller.InputProcessor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MissionFileReader {


    public static String[] read() {

        String[] mission=null;
        try {

            File file = new File(InputProcessor.path+"/missions.txt");
            Scanner scanner=new Scanner(file);
             mission = new String[5];
            while (scanner.hasNextLine()){
                if(scanner.nextLine().equalsIgnoreCase("level: "+ InputProcessor.level)){
                    for (int i = 0; i < mission.length; i++) {
                        mission[i]=scanner.nextLine();
                    }
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return mission;
    }

}
