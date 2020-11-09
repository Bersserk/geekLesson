package ru.geekbrains.lesson;

import java.io.*;
import java.util.Scanner;

public class Main {

    private static final String rootPath = "src\\main\\java\\ru\\geekbrains\\lesson\\";
    private static String myFolder = rootPath + "myFiles";
    private static int countFilesInFolder;

    public static void main(String[] args) throws IOException {

        countFilesInFolder = getCountFilesInFolder();

        while (true) {
            notice("Выберите действие:\nОбъединить файлы - 1\nНайти слово - 2\nВыход - 3");
            int i = new Scanner(System.in).nextInt();
            if (i == 1) {
                notice("Список файлов:");
                printListFilesInFolder(isListFilesInFolder(myFolder));
                notice("Сколько файлов хотите склеить?");
                int numberFilesToCombine = new Scanner(System.in).nextInt();
                notice("Сколько файлов хотите склеить?");
                int[] numbersFilesForCombine = new int[numberFilesToCombine];
                notice("Файлы будут объедены в порядке вашего выбора!!!");
                for (int j = 0; j < numberFilesToCombine; j++) {
                    notice("Введите порядковый номер файла");
                    numbersFilesForCombine[j] = new Scanner(System.in).nextInt();
                }
                joinFiles(numbersFilesForCombine);
                System.out.println("Файл с результатом находится в одном каталоге с Main.java, под именем txtResult");
                break;

            } else if (i == 2) {

                notice("В качестве проверки поиска во всех файлах, будем искать в виде небольшой игры");
                String userText = setTextFromUser(); // запрашиваем у пользователя слово

                for (int j = 0; j < countFilesInFolder; j++) {
                    boolean b = searchWordInFiles(userText, getTextFromFiles(isListFilesInFolder(myFolder)[j]));
                    if (b)
                        notice("В файле " + isListFilesInFolder(myFolder)[j].substring(rootPath.length()) +
                                " есть такое слово");
                    else
                        notice("В файле " + isListFilesInFolder(myFolder)[j].substring(rootPath.length()) +
                                " такого слова нет");
                }
                break;
            } else if (i == 3) {
                notice("До свидания!!!");
                break;
            }
        }
    }

    private static void joinFiles(int[] setListNumberFilesForCombine) throws IOException {
        FileWriter writer = new FileWriter(rootPath + "\\txtResult", false);

        for (int j = 0; j < setListNumberFilesForCombine.length; j++) {

            String file = isListFilesInFolder(myFolder)[setListNumberFilesForCombine[j] - 1];
            FileReader reader = new FileReader(file);
            int c;
            while ((c = reader.read()) != -1) {
                writer.append((char) c);
            }
            writer.append("\n");
        }
        writer.close();
    }

    private static int getCountFilesInFolder() {
        File tmp = new File(myFolder);
        int countFiles = 0;

        if (tmp.isDirectory()) {
            for (File item : tmp.listFiles()) {
                countFiles++;
            }
        }

        return countFiles;
    }

    private static String getTextFromFiles(String setPathFiles) throws FileNotFoundException {

        String inputText = null;
        String outputText = null;

        BufferedReader br = new BufferedReader(new FileReader(setPathFiles));

        while (true) {
            try {
                if (((inputText = br.readLine()) == null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (outputText == null)
                outputText = inputText;
            else
                outputText += " " + inputText;
        }

        return outputText;
    }

    private static String[] isListFilesInFolder(String folder) {
        File tmp = new File(folder);
        String[] isListFiles = new String[tmp.listFiles().length];

        if (tmp.isDirectory()) {
            if (folder.isEmpty())
                notice("В данном каталоге нет файлов");

            int i = 0;
            for (File item : tmp.listFiles()) {
                isListFiles[i] = String.valueOf(item);
                i++;
            }
        }

        return isListFiles;
    }

    private static void printListFilesInFolder(String[] setListFilesInFolder) {
        int i = 1;
        for (String item : setListFilesInFolder) {
            notice(i + ".  " + item);
            i++;
        }
    }

    private static boolean searchWordInFiles(String userText, String currentText) {
        int k = 0;
        boolean foundText = false;
        while (k < currentText.length()) {
            foundText = currentText.regionMatches(true, k, userText, 0, userText.length());
            if (foundText)
                break;
            else
                k++;
        }
        return foundText;
    }

    private static void notice(String setTextForMessage) {
        System.out.println(setTextForMessage);
    }

    private static String setTextFromUser() {
        System.out.print("Угадаешь цифру, которая встречается во всех четырех файлах? Введите цифру ТЕКСТОМ от 0 до 9: ");
        String textUser = new Scanner(System.in).nextLine().toLowerCase();
        return textUser;
    }


}
