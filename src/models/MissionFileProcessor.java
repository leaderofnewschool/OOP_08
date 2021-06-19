package models;

import controller.InputProcessor;

public class MissionFileProcessor {
    public static boolean[] tasks = new boolean[MissionFileReader.read()[0].split("\\s+").length];

    public void file_coin() {
        String[] coin = MissionFileReader.read()[2].split("\\s+");
        InputProcessor.coin += Integer.parseInt(coin[1]);
    }

    public void new_farmAnimal() {
        String[] new_farmAnimals = MissionFileReader.read()[1].split("\\s+");
        for (int i = 2; i + 1 < new_farmAnimals.length; i += 2) {
            int quantity = Integer.parseInt(new_farmAnimals[i]);
            String animal_name = new_farmAnimals[i + 1];
            for (int j = 0; j < quantity; j++) {
                if (animal_name.equalsIgnoreCase("CHICKEN")) {
                    FarmAnimal farmAnimal = new FarmAnimal(FarmAnimalType.CHICKEN);
                } else if (animal_name.equalsIgnoreCase("BUFFALO")) {
                    FarmAnimal farmAnimal = new FarmAnimal(FarmAnimalType.BUFFALO);
                } else if (animal_name.equalsIgnoreCase("TURKEY")) {
                    FarmAnimal farmAnimal = new FarmAnimal(FarmAnimalType.TURKEY);
                }
            }
        }
    }


    public void new_wildAnimal() {
        String[] new_wildAnimals = MissionFileReader.read()[3].split("\\s+");
        for (int i = 2; i + 2 < new_wildAnimals.length; i += 3) {
            if (InputProcessor.turnCounter == Integer.parseInt(new_wildAnimals[i + 2])) {
                for (int j = 0; j < Integer.parseInt(new_wildAnimals[i]); j++) {
                    if (new_wildAnimals[i + 1].equalsIgnoreCase("lion")) {
                        WildAnimal wildAnimal = new WildAnimal(WildAnimalType.LION);
                    } else if (new_wildAnimals[i + 1].equalsIgnoreCase("bear")) {
                        WildAnimal wildAnimal = new WildAnimal(WildAnimalType.BEAR);
                    } else if (new_wildAnimals[i + 1].equalsIgnoreCase("tiger")) {
                        WildAnimal wildAnimal = new WildAnimal(WildAnimalType.TIGER);
                    }
                }
            }
        }
    }


    public void task() {
        String[] temp = MissionFileReader.read()[0].split("\\s+");
        for (int i = 1; i < temp.length; i += 2) {
            int quantity = Integer.parseInt(temp[i]);
            int inGame_quantity = isTask(temp[i + 1]);
            if (quantity <= inGame_quantity) {
                tasks[i] = true;
            }
        }
        IsWinning.isWinning(tasks);

    }

    public int isTask(String task) {
        int quantity = 0;
        if (task.equalsIgnoreCase("chicken") || task.equalsIgnoreCase("turkey") || task.equalsIgnoreCase("buffalo")) {
            quantity = FarmAnimal.quantity(task);
        } else if (task.equalsIgnoreCase("egg") || task.equalsIgnoreCase("feather") || task.equalsIgnoreCase("milk")) {
            quantity = AnimalProducts.quantity(task);
        } else if (task.equalsIgnoreCase("PACKET_MILK") || task.equalsIgnoreCase("cloth") || task.equalsIgnoreCase("flour")) {
            quantity = FirstProducts.quantity(task);
        } else if (task.equalsIgnoreCase("icecream") || task.equalsIgnoreCase("shirt") || task.equalsIgnoreCase("bread")) {
            quantity = SecondaryProducts.quantity(task);
        }
        return quantity;
    }
}
