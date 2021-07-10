package models;

import controller.InputProcessor;

import java.io.FileWriter;
import java.io.IOException;

public class HappeningsFile {
    public static void happenings() throws IOException {
        int[][] grass = new int[6][6];
        for (int i = 1; i < 7; i++) {
            for (int j = 1; j < 7; j++) {
                for (int k = 0; k < ArrayLists.grassList.size(); k++) {
                    if (ArrayLists.grassList.get(k).isAvailable && ArrayLists.grassList.get(k).x == i && ArrayLists.grassList.get(k).y == j) {
                        grass[i-1][j-1]++;
                    }
                }
            }
        }
//        FileWriter fileCleaner = new FileWriter(InputProcessor.path+"/happenings.txt");
//        fileCleaner.write("");
//        fileCleaner.close();
        FileWriter fileWriter = new FileWriter(InputProcessor.path+"/happenings.txt");
        fileWriter.write(grass[0][0] + "\t" + grass[0][1] + "\t" + grass[0][2] + "\t" + grass[0][3] + "\t" + grass[0][4] + "\t" + grass[0][5]+"\n");
        fileWriter.write(grass[1][0] + "\t" + grass[1][1] + "\t" + grass[1][2] + "\t" + grass[1][3] + "\t" + grass[1][4] + "\t" + grass[1][5]+"\n");
        fileWriter.write(grass[2][0] + "\t" + grass[2][1] + "\t" + grass[2][2] + "\t" + grass[2][3] + "\t" + grass[2][4] + "\t" + grass[2][5]+"\n");
        fileWriter.write(grass[3][0] + "\t" + grass[3][1] + "\t" + grass[3][2] + "\t" + grass[3][3] + "\t" + grass[3][4] + "\t" + grass[3][5]+"\n");
        fileWriter.write(grass[4][0] + "\t" + grass[4][1] + "\t" + grass[4][2] + "\t" + grass[4][3] + "\t" + grass[4][4] + "\t" + grass[4][5]+"\n");
        fileWriter.write(grass[5][0] + "\t" + grass[5][1] + "\t" + grass[5][2] + "\t" + grass[5][3] + "\t" + grass[5][4] + "\t" + grass[5][5]+"\n");
        for (int i = 0; i < ArrayLists.farmAnimalList.size(); i++) {
            if (ArrayLists.farmAnimalList.get(i).isAvailable) {
                fileWriter.write(ArrayLists.farmAnimalList.get(i).getFarmAnimalType().name()+"\t"+ArrayLists.farmAnimalList.get(i).getLive()+"\t"+ArrayLists.farmAnimalList.get(i).getX()+"\t"+ArrayLists.farmAnimalList.get(i).getY()+"\n");
            }
        }
        for (int i = 0; i < ArrayLists.dogList.size(); i++) {
            fileWriter.write(ArrayLists.dogList.get(i).getX()+"\t"+ArrayLists.dogList.get(i).getY()+"\n");
        }
        for (int i = 0; i < ArrayLists.catList.size(); i++) {
            fileWriter.write(ArrayLists.catList.get(i).getX()+"\t"+ArrayLists.catList.get(i).getY()+"\n");
        }
        for (int i = 0; i <ArrayLists.wildAnimalList.size() ; i++) {
            if(ArrayLists.wildAnimalList.get(i).isAvailable){
                fileWriter.write(ArrayLists.wildAnimalList.get(i).getWildAnimalType().name()+"\t"+ArrayLists.wildAnimalList.get(i).cageLeft+"\t"+ArrayLists.wildAnimalList.get(i).getX()+"\t"+ArrayLists.wildAnimalList.get(i).getY()+"\n");            }
        }
        for (int i = 0; i <ArrayLists.animalProductList.size() ; i++) {
            if(ArrayLists.animalProductList.get(i).isAvailable){
                fileWriter.write(ArrayLists.animalProductList.get(i).getAnimalProductTypes().name()+"\t"+ArrayLists.animalProductList.get(i).x+"\t"+ArrayLists.animalProductList.get(i).y+"\n");
            }
        }
        for (int i = 0; i <ArrayLists.firstProductList.size() ; i++) {
            if(ArrayLists.firstProductList.get(i).isAvailable){
                fileWriter.write(ArrayLists.firstProductList.get(i).getFirstProductTypes().name()+"\t"+ArrayLists.firstProductList.get(i).x+"\t"+ArrayLists.firstProductList.get(i).y+"\n");
            }
        }
        for (int i = 0; i <ArrayLists.secondaryProductList.size() ; i++) {
            if(ArrayLists.secondaryProductList.get(i).isAvailable){
                fileWriter.write(ArrayLists.secondaryProductList.get(i).getSecondaryProductTypes().name()+"\t"+ArrayLists.secondaryProductList.get(i).x+"\t"+ArrayLists.secondaryProductList.get(i).y+"\n");
            }
        }
        String[] tasks=MissionFileProcessor.task();
        for (int i = 0; i < tasks.length-2; i+=3) {
            fileWriter.write(tasks[i]+": "+tasks[i+2]+"/"+tasks[i+1]+"\n");
        }
        fileWriter.close();

    }


}
