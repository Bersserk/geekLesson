package ru.geekbrains.lesson;

import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class Words {

    private final String nameInputText;
    private String[] allWords;

    public Words(String inputText) {
        this.nameInputText = inputText;
        getText();
    }


    void getListWords (){

    }




    private void getText() {
        String s = "";
        try (FileReader reader = new FileReader("src\\main\\java\\ru\\geekbrains\\lesson\\" + nameInputText + ".txt")) {
            // читаем посимвольно
            int c;
            while ((c = reader.read()) != -1) {
                s += String.valueOf((char) c);
            }

            Pattern pattern = Pattern.compile("\\s*(\\s|,|—|!|\\.)\\s*");
            allWords = pattern.split(s);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
