package ru.geekbrains.lesson;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

public class Words {

    private final String nameInputText;
    private String[] isArrayWordsFromFile;

    HashSet <String> listWords;
    Map<String, Integer> map;

    public Words(String inputText) {
        this.nameInputText = inputText;
        arrayWordsFromFile();
    }


    public void getListWords (){
        listWords = new HashSet<String>();

        for (String s: isArrayWordsFromFile){
            listWords.add(s);
        }

        System.out.println("Список уникальных слов, из которых состоит текст - " + listWords);
    }

    public void getNumberWordsFromList () {

        map = new HashMap<>();
        Iterator iterator = listWords.iterator();

        while(iterator.hasNext()){
            int countWords = 0;
            String currentWord = iterator.next().toString();

            for (String s: isArrayWordsFromFile){
                if (s.equals(currentWord)){
                    countWords++;
                }
            }
            map.put(currentWord, countWords);
        }
        System.out.println("Столько раз встречается каждое слово - " + map);
    }




    private void arrayWordsFromFile() {
        String s = "";
        try (FileReader reader = new FileReader("src\\main\\java\\ru\\geekbrains\\lesson\\" + nameInputText + ".txt")) {
            // читаем посимвольно
            int c;
            while ((c = reader.read()) != -1) {
                s += String.valueOf((char) c);
            }

            Pattern pattern = Pattern.compile("\\s*(\\s|,|—|!|\\.)\\s*");
            isArrayWordsFromFile = pattern.split(s.toLowerCase());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
