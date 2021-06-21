package models;

import controller.InputProcessor;

import java.io.IOException;
import java.util.Date;
import java.util.Locale;

public class Request {
    public static boolean isTruck = false;
    public static boolean isWell = false;
    public static boolean isBakery = false;
    public static boolean isMill = false;
    public static boolean isIceCream = false;
    public static boolean isTailoring = false;
    public static boolean isWeaving = false;
    public static boolean isMilk = false;
    int buildCnt1 = 0;
    int buildCnt2 = 0;
    int buildCnt3 = 0;
    int buildCnt4 = 0;
    int buildCnt5 = 0;
    int buildCnt6 = 0;

    Truck truck = new Truck();
    Cage cage = new Cage();

    public void buy(String animal_name) {
        if (animal_name.equalsIgnoreCase("dog")) {
            if (InputProcessor.coin >= Dog.BUY_DOG_COST) {
                Dog dog = new Dog();
                InputProcessor.coin -= Dog.BUY_DOG_COST;
                return;
            }
        } else if (animal_name.equalsIgnoreCase("cat")) {
            if (InputProcessor.coin >= Cat.BUY_CAT_COST) {
                Cat cat = new Cat();
                InputProcessor.coin -= Cat.BUY_CAT_COST;
                return;
            }
        } else if (animal_name.equalsIgnoreCase("CHICKEN")) {
            if (InputProcessor.coin >= FarmAnimalType.CHICKEN.getBuyCost()) {
                FarmAnimal farmAnimal = new FarmAnimal(FarmAnimalType.CHICKEN);
                InputProcessor.coin -= FarmAnimalType.CHICKEN.getBuyCost();
                return;
            }
        } else if (animal_name.equalsIgnoreCase("BUFFALO")) {
            if (InputProcessor.coin >= FarmAnimalType.BUFFALO.getBuyCost()) {
                FarmAnimal farmAnimal = new FarmAnimal(FarmAnimalType.BUFFALO);
                InputProcessor.coin -= FarmAnimalType.BUFFALO.getBuyCost();
                return;
            }
        } else if (animal_name.equalsIgnoreCase("TURKEY")) {
            if (InputProcessor.coin >= FarmAnimalType.TURKEY.getBuyCost()) {
                FarmAnimal farmAnimal = new FarmAnimal(FarmAnimalType.TURKEY);
                InputProcessor.coin -= FarmAnimalType.TURKEY.getBuyCost();
                return;
            }
        }
        Date date = new Date();
        String s="Error: "+date+"\tcoin is not enough";
        try {
            LogFileWriter.logFileWriter(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void build(String workshop_name) {
        switch (workshop_name.toLowerCase(Locale.ROOT)) {
            case "bakery":
                if (buildCnt1 == 0 && InputProcessor.coin>=BakeryWorkshop.buildingPrice) {
                    for (int i = 0; i < ArrayLists.firstProductList.size(); i++) {
                        if (ArrayLists.firstProductList.get(i).getFirstProductTypes().equals("FLOUR")) {
                            buildCnt1++;
                            break;
                        }
                    }
                    if (buildCnt1 != 0) {
                        NextTurn.bakeryWorkshop = new BakeryWorkshop();
                        InputProcessor.coin-=BakeryWorkshop.buildingPrice;
                        Date date = new Date();
                        String s="Info: "+date+"\tbuilt successfully";
                        try {
                            LogFileWriter.logFileWriter(s);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    else{
                        Date date = new Date();
                        String s="Error: "+date+"\tcoin is not enough";
                        try {
                            LogFileWriter.logFileWriter(s);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    Date date = new Date();
                    String s="Error: "+date+"\tthis workshop already exist";
                    try {
                        LogFileWriter.logFileWriter(s);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;


            case "icecreammaking":
                if (buildCnt2 == 0 && InputProcessor.coin>=IcecreamMakingWorkshop.buildingPrice) {
                    for (int i = 0; i < ArrayLists.firstProductList.size(); i++) {
                        if (ArrayLists.firstProductList.get(i).getFirstProductTypes().equals("PACKET_MILK")) {
                            buildCnt2++;
                            break;
                        }
                    }
                    if (buildCnt2 != 0) {
                        NextTurn.icecreamMakingWorkshop = new IcecreamMakingWorkshop();
                       InputProcessor.coin-=IcecreamMakingWorkshop.buildingPrice;
                        Date date = new Date();
                        String s="Info: "+date+"\tbuilt successfully";
                        try {
                            LogFileWriter.logFileWriter(s);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } else System.out.println("this workshop already exists");
                break;
            case "milkpackaging":
                if (buildCnt3 == 0 && InputProcessor.coin>=MillWorkshop.buildingPrice) {
                    for (int i = 0; i < ArrayLists.animalProductList.size(); i++) {
                        if (ArrayLists.animalProductList.get(i).getAnimalProductTypes().equals("MILK")) {
                            buildCnt3++;
                            break;
                        }
                    }
                    if (buildCnt3 != 0) {
                        NextTurn.milkPackagingWorkshop = new MilkPackagingWorkshop();
                        InputProcessor.coin-=MillWorkshop.buildingPrice;
                        Date date = new Date();
                        String s="Info: "+date+"\tbuilt successfully";
                        try {
                            LogFileWriter.logFileWriter(s);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    else{
                        Date date = new Date();
                        String s="Error: "+date+"\tcoin is not enough";
                        try {
                            LogFileWriter.logFileWriter(s);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    Date date = new Date();
                    String s="Error: "+date+"\tthis workshop already exist";
                    try {
                        LogFileWriter.logFileWriter(s);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;

            case "mill":
                if (buildCnt4 == 0 && InputProcessor.coin>=MillWorkshop.buildingPrice) {
                    for (int i = 0; i < ArrayLists.animalProductList.size(); i++) {
                        if (ArrayLists.animalProductList.get(i).getAnimalProductTypes().equals("EGG")) {
                            buildCnt4++;
                            break;
                        }
                    }
                    if (buildCnt4 != 0) {
                        NextTurn.millWorkshop = new MillWorkshop();
                        InputProcessor.coin-=MillWorkshop.buildingPrice;
                        Date date = new Date();
                        String s="Info: "+date+"\tbuilt successfully";
                        try {
                            LogFileWriter.logFileWriter(s);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    else{
                        Date date = new Date();
                        String s="Error: "+date+"\tcoin is not enough";
                        try {
                            LogFileWriter.logFileWriter(s);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    Date date = new Date();
                    String s="Error: "+date+"\tthis workshop already exist";
                    try {
                        LogFileWriter.logFileWriter(s);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;


            case "tailoring":
                if (buildCnt5 == 0 && InputProcessor.coin>=TailoringWorkshop.buildingPrice) {
                    for (int i = 0; i < ArrayLists.animalProductList.size(); i++) {
                        if (ArrayLists.animalProductList.get(i).getAnimalProductTypes().equals("FEATHER")) {
                            buildCnt5++;
                            break;
                        }
                    }
                    if (buildCnt5 != 0) {
                        NextTurn.tailoringWorkshop = new TailoringWorkshop();
                         InputProcessor.coin-=TailoringWorkshop.buildingPrice;
                        Date date = new Date();
                        String s="Info: "+date+"\tbuilt successfully";
                        try {
                            LogFileWriter.logFileWriter(s);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    else{
                        Date date = new Date();
                        String s="Error: "+date+"\tcoin is not enough";
                        try {
                            LogFileWriter.logFileWriter(s);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    Date date = new Date();
                    String s="Error: "+date+"\tthis workshop already exist";
                    try {
                        LogFileWriter.logFileWriter(s);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;


            case "weaving":
                if (buildCnt6 == 0 && InputProcessor.coin>=WeavingWorkshop.buildingPrice) {
                    for (int i = 0; i < ArrayLists.firstProductList.size(); i++) {
                        if (ArrayLists.firstProductList.get(i).getFirstProductTypes().equals("CLOTH")) {
                            buildCnt6++;
                            break;
                        }
                    }
                    if (buildCnt6 != 0) {
                        NextTurn.weavingWorkshop = new WeavingWorkshop();
                        InputProcessor.coin-=WeavingWorkshop.buildingPrice;
                        Date date = new Date();
                        String s="Info: "+date+"\tbuilt successfully";
                        try {
                            LogFileWriter.logFileWriter(s);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    else{
                        Date date = new Date();
                        String s="Error: "+date+"\tcoin is not enough";
                        try {
                            LogFileWriter.logFileWriter(s);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    Date date = new Date();
                    String s="Error: "+date+"\tthis workshop already exist";
                    try {
                        LogFileWriter.logFileWriter(s);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
            default:
                break;
        }
    }

    public void upgrade(String workshop_name) {
        switch (workshop_name.toLowerCase(Locale.ROOT)) {
            case "bakery":
                if (NextTurn.bakeryWorkshop.level != 2 && InputProcessor.coin>=BakeryWorkshop.buildingPrice+100) {
                    NextTurn.bakeryWorkshop.level++;
                    InputProcessor.coin-=(BakeryWorkshop.buildingPrice+100);
                    Date date = new Date();
                    String s="Error: "+date+"\tupgraded successfully";
                    try {
                        LogFileWriter.logFileWriter(s);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    Date date = new Date();
                    String s="Error: "+date+"\tupgrade was not successful";
                    try {
                        LogFileWriter.logFileWriter(s);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;

            case "icecreammaking":
                if (NextTurn.icecreamMakingWorkshop.level != 2 && InputProcessor.coin>=IcecreamMakingWorkshop.buildingPrice+100) {
                    NextTurn.icecreamMakingWorkshop.level++;
                    InputProcessor.coin-=(IcecreamMakingWorkshop.buildingPrice+100);
                    Date date = new Date();
                    String s="Error: "+date+"\tupgraded successfully";
                    try {
                        LogFileWriter.logFileWriter(s);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    Date date = new Date();
                    String s="Error: "+date+"\tupgrade was not successful";
                    try {
                        LogFileWriter.logFileWriter(s);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;

            case "milkpackaging":
                if (NextTurn.milkPackagingWorkshop.level != 2 && InputProcessor.coin>=MilkPackagingWorkshop.buildingPrice+100) {
                    NextTurn.milkPackagingWorkshop.level++;
                    InputProcessor.coin-=(MilkPackagingWorkshop.buildingPrice+100);
                    Date date = new Date();
                    String s="Error: "+date+"\tupgraded successfully";
                    try {
                        LogFileWriter.logFileWriter(s);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    Date date = new Date();
                    String s="Error: "+date+"\tupgrade was not successful";
                    try {
                        LogFileWriter.logFileWriter(s);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;

            case "mill":
                if (NextTurn.millWorkshop.level != 2 && InputProcessor.coin>=MillWorkshop.buildingPrice+100){
                    NextTurn.millWorkshop.level++;
                    InputProcessor.coin-=(MillWorkshop.buildingPrice+100);
                    Date date = new Date();
                    String s="Error: "+date+"\tupgraded successfully";
                    try {
                        LogFileWriter.logFileWriter(s);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    Date date = new Date();
                    String s="Error: "+date+"\tupgrade was not successful";
                    try {
                        LogFileWriter.logFileWriter(s);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } break;

            case "tailoring":
                if (NextTurn.tailoringWorkshop.level != 2 && InputProcessor.coin>=TailoringWorkshop.buildingPrice+100) {
                    NextTurn.tailoringWorkshop.level++;
                    InputProcessor.coin-=(TailoringWorkshop.buildingPrice+100);
                    Date date = new Date();
                    String s="Error: "+date+"\tupgraded successfully";
                    try {
                        LogFileWriter.logFileWriter(s);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    Date date = new Date();
                    String s="Error: "+date+"\tupgrade was not successful";
                    try {
                        LogFileWriter.logFileWriter(s);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }break;

            case "weaving":
                if (NextTurn.weavingWorkshop.level != 2 && InputProcessor.coin>=WeavingWorkshop.buildingPrice+100) {
                    NextTurn.weavingWorkshop.level++;
                    InputProcessor.coin-=(WeavingWorkshop.buildingPrice+100);
                    Date date = new Date();
                    String s="Error: "+date+"\tupgraded successfully";
                    try {
                        LogFileWriter.logFileWriter(s);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    Date date = new Date();
                    String s="Error: "+date+"\tupgrade was not successful";
                    try {
                        LogFileWriter.logFileWriter(s);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }break;

            default:
                break;
        }
    }

    public void pickUp(int x, int y) {
        Store store = new Store(x, y);
    }

    public void well() {
        isWell = true;
    }

    public void inquiry() throws IOException {
        HappeningsFile.happenings();
    }

    public void plant(int x, int y) {
        Grass grass = new Grass(x, y);
    }

    public void work(String workshop_name) {
        switch (workshop_name) {
            case "bakery":
                isBakery = true;
                break;
            case "mill":
                isMill = true;
                break;
            case "iceCream":
                isIceCream = true;
                break;
            case "tailoring":
                isTailoring = true;
                break;
            case "weaving":
                isWeaving = true;
                break;
            case "milkPackaging":
                isMilk = true;
                break;
            default:
                break;
        }
    }

    public void cage(int x, int y) {
        cage.cageBuilder1(x, y);
    }

    public void turn(int n) {
        InputProcessor.turnCounter = n;
    }

    public void truckLoad(String item_name) {
        truck.loadTruck(item_name);
    }

    public void truckUnload(String item_name) {
        truck.unloadTruck(item_name);
    }

    public void truckGo() {
        isTruck=true;
    }


}

