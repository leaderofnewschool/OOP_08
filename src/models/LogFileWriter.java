package models;

import controller.InputProcessor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class LogFileWriter {
    public static void logFileWriter(String input) throws IOException {
        File file = new File(InputProcessor.path+"/log.txt");
        Scanner fileReader = new Scanner(file);
        String[] string= new String[1000];
        int i=0;
        while(fileReader.hasNextLine()){
            string[i]=fileReader.nextLine();
            i++;
        }
        fileReader.close();
        String[] edited = new String[i];
        for (int j = 0; j <i ; j++) {
            if(j==3){
                Date date = new Date();
                edited[j]="last change date: "+date;
            }
            else edited[j]=string[j];
        }
        FileWriter fileCleaner = new FileWriter(InputProcessor.path+"/log.txt");
        fileCleaner.write("");
        fileCleaner.close();
        FileWriter fileWriter = new FileWriter(InputProcessor.path+"/log.txt");
        for (int j = 0; j < edited.length; j++) {
            fileWriter.write(edited[j]+"\n");
        }
        fileWriter.write(input+"\n");
        fileWriter.close();
    }
}
