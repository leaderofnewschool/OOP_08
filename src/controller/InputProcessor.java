package controller;

import models.NextTurn;
import models.Request;

import java.util.Scanner;

public class InputProcessor {
    public static int turnCounter=0;
    int turn=0;
    public static String username;
    public static String password;
    public static int level = 0;
    public static int coin = 0;
    public static boolean game=false;
    public static boolean exit=false;
    String input="";
    String[] fragmentedInput=null;
    Scanner sc = new Scanner(System.in);
    LogIn logIn=new LogIn();
    Menu menu=new Menu();
    NextTurn nextTurn = new NextTurn();
    Request request = new Request();
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
            fragmentedInput=input.split("\\s+");
            if(fragmentedInput[0].startsWith("BUY")){
                request.buy(fragmentedInput[1]);
            }
            else if(fragmentedInput[0].equalsIgnoreCase("PICKUP")) {
                request.pickUp(Integer.parseInt(fragmentedInput[1]), Integer.parseInt(fragmentedInput[2]));
            }
            else if(fragmentedInput[0].equalsIgnoreCase("WELL")){
                request.well();
            }
            else if(fragmentedInput[0].equalsIgnoreCase("PLANT")){
                request.plant(Integer.parseInt(fragmentedInput[1]), Integer.parseInt(fragmentedInput[2]));
            }
            else if(fragmentedInput[0].equalsIgnoreCase("WORK")){
                request.work(fragmentedInput[1]);
            }
            else if(fragmentedInput[0].equalsIgnoreCase("CAGE")){
                request.cage(Integer.parseInt(fragmentedInput[1]), Integer.parseInt(fragmentedInput[2]));
            }
            else if(fragmentedInput[0].equalsIgnoreCase("TRUCK") && fragmentedInput[1].equalsIgnoreCase("LOAD")){
                request.truckLoad(fragmentedInput[2]);
            }
            else if(fragmentedInput[0].equalsIgnoreCase("TRUCK") && fragmentedInput[1].equalsIgnoreCase("UNLOAD")){
                request.truckUnload(fragmentedInput[2]);
            }
            else if(fragmentedInput[0].equalsIgnoreCase("TRUCK") && fragmentedInput[1].equalsIgnoreCase("GO")){
                request.truckGo();
            }
            else if(fragmentedInput[0].equalsIgnoreCase("BUILD")){
                request.build(fragmentedInput[1]);
            }
            else if(fragmentedInput[0].equalsIgnoreCase("UPGRADE")){
                request.upgrade(fragmentedInput[1]);
            }
            else if(fragmentedInput[0].equalsIgnoreCase("TURN")){
                request.turn(Integer.parseInt(fragmentedInput[1]));
                turn= Integer.parseInt(fragmentedInput[1]);
            }
            for (int i = 0; i < turn; i++) {
                nextTurn.next_turn();
            }





            }


    }
}
