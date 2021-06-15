package controller;

import controller.Login;
import controller.Menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InputProcessor {
    Login logIn=new Login();
    Menu menu=new Menu();
    Scanner sc = new Scanner(System.in);
    String input="";
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