package controller;

import java.util.Scanner;

public class InputProcessor {
    public static int turnCounter=0;
    LogIn logIn=new LogIn();
    Menu menu=new Menu();
    Scanner sc = new Scanner(System.in);
    String input="";
    public static String username;
    public static String password;
    public static int level = 0;
    public static int coin = 0;
    public static boolean game=false;
    public static boolean exit=false;
    public void run(){
        while (!game) {
            logIn.log(level, coin);
            menu.menu();
        }
        if(exit) return;

        while(!input.equalsIgnoreCase("exit")) {
            if(exit) return;
            System.out.println("enter your command");
            input = sc.nextLine();
        }

    }
}
