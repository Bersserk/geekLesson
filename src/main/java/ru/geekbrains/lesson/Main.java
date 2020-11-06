package ru.geekbrains.lesson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    static char [] txt1 = new char[50];

    public static void main(String[] args) {

        try(FileReader reader = new FileReader("src\\main\\java\\ru\\geekbrains\\lesson\\txt1"))
        {
            // читаем посимвольно
            int c;
            int i = 0;
            while((c=reader.read())!=-1){


                txt1[i] = (char)c;
                //System.out.print((char)c);
                i++;
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

        for (char c: txt1) {
            System.out.print(c);
        }


        try(FileReader reader = new FileReader("src\\main\\java\\ru\\geekbrains\\lesson\\txt2"))
        {
            // читаем посимвольно
            int c;
            System.out.println();
            while((c=reader.read())!=-1){

                System.out.print((char)c);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

        /*
        try(FileWriter writer = new FileWriter("src\\main\\java\\ru\\geekbrains\\lesson\\txt3", true))
        {
            // запись всей строки
            String text = "Hello Gold!";
            writer.write(text);
            // запись по символам
            writer.append('\n');
            writer.append("src\main\java\ru\geekbrains\lesson\txt3");

            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

         */

    }
}
