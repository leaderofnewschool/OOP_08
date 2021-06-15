package controller;

import controller.InputProcessor;

import java.util.Scanner;

public class Menu {
    String input="";
    Scanner scanner = new Scanner(System.in);
    public void menu(){
        while(true){
            System.out.println("menu");
            input=scanner.nextLine();
            String[] temp=input.split("\\s");
            if(input.contains("START")){
                System.out.println(temp[0]);
                if(Integer.parseInt(temp[1])> InputProcessor.level+1){
                    System.out.println("this level is lock!");
                }
                else {
                    InputProcessor.game=true;
                    return;
                }
            }
            else if(input.equalsIgnoreCase("exit")){
                InputProcessor.exit=true;
                InputProcessor.game=true;
               return;
            }
            else if(input.equalsIgnoreCase("log out")){
                InputProcessor.game=false;
                return;
            }
            else {
                System.out.println("wrong command");
            }
        }
    }
}
