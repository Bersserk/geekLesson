package ru.geekbrains.lesson;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static final String file1 = "src\\main\\java\\ru\\geekbrains\\lesson\\myFiles\\txt1";
    private static final String file2 = "src\\main\\java\\ru\\geekbrains\\lesson\\myFiles\\txt2";
    private static String fileResult = "src\\main\\java\\ru\\geekbrains\\lesson\\txtResult";
    private static String myFolder = "src\\main\\java\\ru\\geekbrains\\lesson\\myFiles";

    private static File tmp = new File(myFolder);
    private static File [] arrayListFiles = tmp.listFiles();
    private static FileReader reader;
    private static int c;

    public static void main(String[] args) throws IOException {


        joinFiles();
        String userText = setTextFromUser();
        readAndCheckUserText(userText, fileResult);

        System.out.print("Проверим в каких фалах есть такая цифра? (впишите '1' если да...): ");
        if(new Scanner(System.in).nextInt() == 1)
            searchWordInFiles(userText);
    }

    private static void readAndCheckUserText(String userText, String currentFile) throws IOException {
        char[] arrUserText = userText.toCharArray();
        reader = new FileReader(currentFile);
        int k = 0;
        while ((c = reader.read()) != -1) {

            if (k == userText.length() && c == 32) {
                System.out.println("В файле " + currentFile + " - есть такая цифра");
                break;
            }

            if (k < arrUserText.length && c == arrUserText[k]) {
                k++;
            } else {
                k = 0;
            }
        }

        if (c == -1) {
            System.out.println("В файле " + currentFile + " - нет такой цифры");
        }
    }

    private static void joinFiles() throws IOException {
        FileWriter writer = new FileWriter(fileResult, false);

        for (int i = 0; i < getCountFilesInFolder(); i++) {


            String file = arrayListFiles[i].getName();

            reader = new FileReader(myFolder + "\\" + file);
            while ((c = reader.read()) != -1) {
                writer.append((char) c);
            }

            writer.append("\n");
        }

        writer.close();
    }

    private static String setTextFromUser() {
        System.out.print("Угадаешь цифру, которая встречается во всех четырех файлах? Введите цифру ТЕКСТОМ от 0 до 9: ");
        String textUser = new Scanner(System.in).nextLine();
        return textUser;
    }

    private static void searchWordInFiles (String userText){

        if (tmp.isDirectory()){
            for (File item: tmp.listFiles()){
                try {
                    readAndCheckUserText(userText, item.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static int getCountFilesInFolder (){
        File tmp = new File(myFolder);
        int countFiles = 0;

        if (tmp.isDirectory()){
            for (File item: tmp.listFiles()){
                    countFiles++;
            }
        }

        return countFiles;
    }


}
