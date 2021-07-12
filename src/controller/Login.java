package controller;

import controller.InputProcessor;
import models.LogFileWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

 class Login {

    public void log(int level,int coin) {
        String insertCheck ="";
        String username = "";
        String password = "";
        String[] temp = new String[1000];
        boolean user = false;
        boolean pass = false;
        boolean check = false;
        Scanner scanner = new Scanner(System.in);


        int fileSize = 0;
        try {
            File file = new File(InputProcessor.path+"/users.txt");
            Scanner fileReader = new Scanner(file);
            while (fileReader.hasNextLine()) {
                temp[fileSize] = fileReader.nextLine();
                fileSize++;
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (!check) {
            System.out.println("if you already have an account insert log in else please sign up first");
            insertCheck = scanner.nextLine();
            if (insertCheck.equalsIgnoreCase("log in")) {
                user = false;
                pass = false;
                System.out.println("username:");
                username = scanner.nextLine();
                int i = 0;
                while (!user && username!="EXIT") {
                    for (i = 0; i < fileSize; i++) {
                        if (temp[i].equalsIgnoreCase("username: " + username)) {
                            user = true;
                            break;
                        }
                    }
                    if (!user) {
                        System.out.println("wrong username!! \nplease try again or for main menu please insert log out ");
                        username = scanner.nextLine();
                        if (username.equalsIgnoreCase("log out")) {
                            check = false;
                            break;
                        }

                    }

                }
                if (user) {
                    System.out.println("password: ");
                    password = scanner.nextLine();
                    while (!pass && password!="EXIT") {
                        if (temp[i + 1].equalsIgnoreCase("password: " + password)) {
                            pass = true;
                            check = true;

                            try {
                                FileWriter log = new FileWriter(InputProcessor.path+"/log.txt");
                                Date date = new Date();
                                log.write("creation date: "+date+"\nusername: "+username+"\npassword: "+password+"\nlast change date: "+date);
                                log.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }


                            try {
                                LogFileWriter.logFileWriter("Info: "+username+" entered the game");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            return;
                        } else {
                            Date date = new Date();
                            String s="Error: "+date+"\twrong password";
                            try{
                                LogFileWriter.logFileWriter(s);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            System.out.println("wrong password!! \nplease try again or for main menu please insert log out ");
                            password = scanner.nextLine();
                            if (password.equalsIgnoreCase("log out")) {
                                check = false;
                                user = false;
                                break;
                            }
                        }
                    }
                }
            }

            else if (insertCheck.equalsIgnoreCase("sign up")) {
                user=true;
                pass=true;
                int counter=0;

                while (user && username!="EXIT") {
                    System.out.println("username: ");
                    username=scanner.nextLine();
                    for (int i = 0; i < fileSize; i++) {
                        if (temp[i].equalsIgnoreCase("username: "+username))
                            counter++;
                    }

                    if(counter==0){
                        user=false;
                        check=true;
                    }
                    else{
                        Date date = new Date();
                        String s="Error: "+date+"\tthis username already exist";
                        try{
                            LogFileWriter.logFileWriter(s);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.println("this username is already available!!\nplease choose another username");
                        user=true;
                        counter=0;
                    }

                }
                    System.out.println("password: ");
                    password=scanner.nextLine();
                try {
                    FileWriter fileWriter = new FileWriter(InputProcessor.path+"/users.txt",true);
                    fileWriter.write("username: "+username+"\npassword: "+password+"\nlevel: "+level+"\ncoin: "+coin+"\n");
                    InputProcessor.username=username;
                    InputProcessor.password=password;
                    InputProcessor.coin=coin;
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }


                try {
                    FileWriter log = new FileWriter(InputProcessor.path+"/log.txt");
                    Date date = new Date();
                    log.write("creation date: "+date+"\nusername: "+username+"\npassword: "+password+"\nlast change date: "+date);
                    log.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }


                try {
                    LogFileWriter.logFileWriter("Info: "+username+" entered the game");
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
            else if(insertCheck.equalsIgnoreCase("exit")){
                InputProcessor.exit=true;
                return;
            }

            else {
                System.out.println("wrong command!");
            }
        }


    }
    }

