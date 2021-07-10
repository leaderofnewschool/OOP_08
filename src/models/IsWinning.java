package models;

import controller.InputProcessor;

import java.io.FileWriter;
import java.io.IOException;

public class IsWinning {
    public static void isWinning(boolean[] tasks) {
        for (int i = 0; i < tasks.length; i++) {
            if (!tasks[i]) return;
        }
        System.out.println("you won :)");
        InputProcessor.level++;
        InputProcessor.game = false;
        try {
            FileWriter fileWriter = new FileWriter(InputProcessor.path+"/log.txt");
            fileWriter.write("");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
