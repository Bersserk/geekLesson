package ru.geekbrains.lesson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static final String file1 = "src\\main\\java\\ru\\geekbrains\\lesson\\txt1";
    private static final String file2 = "src\\main\\java\\ru\\geekbrains\\lesson\\txt2";
    private static String fileResult = "src\\main\\java\\ru\\geekbrains\\lesson\\txtResult";

    private static FileReader reader;
    private static int c;

    public static void main(String[] args) throws IOException {

        joinFiles();
        String userText = setTextFromUser();
        char[] arrUserText = userText.toCharArray();
        readAndCheckUserText(userText, arrUserText);
    }

    private static void readAndCheckUserText(String userText, char[] arrUserText) throws IOException {
        reader = new FileReader(fileResult);
        int k = 0;
        while ((c = reader.read()) != -1) {

            if (k == userText.length() && c == 32) {
                System.out.println("есть такое слово");
                break;
            }

            if (k < arrUserText.length && c == arrUserText[k]) {
                k++;
            } else {
                k = 0;
            }
        }

        if (c == -1) {
            System.out.println("такого слова нет");
        }
    }

    private static void joinFiles() throws IOException {
        FileWriter writer = new FileWriter(fileResult, false);

        for (int i = 0; i < 2; i++) {
            String file = (i == 0) ? file1 : file2;

            reader = new FileReader(file);
            while ((c = reader.read()) != -1) {
                writer.append((char) c);
            }

            writer.append("\n");
        }

        writer.close();
    }

    private static String setTextFromUser() {
        System.out.print("Введите искомое слово: ");
        String textUser = new Scanner(System.in).nextLine();
        return textUser;
    }
}
