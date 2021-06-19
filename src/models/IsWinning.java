package models;

import controller.InputProcessor;

public class IsWinning {
    public static void isWinning(boolean[] tasks){
        for (int i = 0; i < tasks.length; i++) {
            if (!tasks[i]) return;
        }
        System.out.println("you won :)");
        InputProcessor.game=false;
    }
}
