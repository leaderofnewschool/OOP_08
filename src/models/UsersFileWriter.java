package models;

import controller.InputProcessor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UsersFileWriter {
    public static void usersFileWriter() {
        String[] users = new String[1000];
        String[] newUsers = new String[1000];
        int k=0;
        File file = new File(InputProcessor.path+"/users.txt");
        try {
            Scanner fileReader = new Scanner(file);
            while (fileReader.hasNextLine()) {
               users[k]=fileReader.nextLine();
               k++;
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < k; i+=4) {
            if(users[i].equals("username: "+ InputProcessor.username)){
                newUsers[i]="username: "+ InputProcessor.username;
                newUsers[i+1]="password: "+ InputProcessor.password;
                newUsers[i+2]="level: "+InputProcessor.level;
                newUsers[i+3]="coin: "+InputProcessor.coin;

            }
            else newUsers[i]=users[i];
        }
                    FileWriter fileWriter;
        {
            try {
                fileWriter = new FileWriter(InputProcessor.path+"/users.txt");
                for (int i = 0; i <k; i++) {
                    fileWriter.write(newUsers[i]+"\n");
                }
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
